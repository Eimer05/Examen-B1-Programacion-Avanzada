package ec.edu.utpl.computacion.proava;

public class BuscadorFila implements Runnable {

    private final String[] fila;
    private final String palabraBuscada;
    private int conteoParcial;

    public BuscadorFila(String[] fila, String palabraBuscada) {

        if (fila == null) {
            throw new IllegalArgumentException("La fila no puede ser null");
        }

        if (palabraBuscada == null || palabraBuscada.isBlank()) {
            throw new IllegalArgumentException("La palabra buscada es inválida");
        }

        this.fila = fila;
        this.palabraBuscada = palabraBuscada;
        this.conteoParcial = 0;
    }

    @Override
    public void run() {

        try {

            for (String elemento : fila) {

                if (elemento != null &&
                        elemento.equalsIgnoreCase(palabraBuscada)) {

                    conteoParcial++;
                }
            }

            System.out.println(
                    Thread.currentThread().getName()
                            + " terminó. Coincidencias: "
                            + conteoParcial
            );

        } catch (Exception e) {

            System.err.println(
                    "Error en "
                            + Thread.currentThread().getName()
                            + ": "
                            + e.getMessage()
            );
        }
    }

    public int getConteoParcial() {
        return conteoParcial;
    }
}