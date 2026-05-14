package ec.edu.utpl.computacion.proava;

public class Main {

    public static void main(String[] args) {

        try {

            String[][] matriz = {
                    {"Java", "Python", "Java"},
                    {"C++", "Java", "Go"},
                    {"Java", "Rust", "Java"}
            };

            String palabraBuscada = "Java";

            System.out.println("Palabra buscada: " + palabraBuscada);
            System.out.println("----------------------------------");

            GestorBusqueda gestor =
                    new GestorBusqueda(matriz, palabraBuscada);

            int total = gestor.buscarPalabra();

            System.out.println("----------------------------------");
            System.out.println(
                    "La palabra \""
                            + palabraBuscada
                            + "\" aparece "
                            + total
                            + " veces."
            );

        } catch (IllegalArgumentException e) {

            System.err.println("Error de datos: " + e.getMessage());

        } catch (Exception e) {

            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
