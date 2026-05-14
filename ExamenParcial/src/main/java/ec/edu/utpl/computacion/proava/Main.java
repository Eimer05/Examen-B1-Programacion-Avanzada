package ec.edu.utpl.computacion.proava;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class BuscadorFila implements Runnable {
        private final String[] fila;
        private final String palabraBuscada;
        private int conteoParcial;
        private final String nombreHilo;

        public BuscadorFila(String[] fila, String palabraBuscada, String nombreHilo) {
            this.fila = fila;
            this.palabraBuscada = palabraBuscada;
            this.nombreHilo = nombreHilo;
            this.conteoParcial = 0;
        }

        @Override
        public void run() {
            try {
                for (String elemento : fila) {
                    if (elemento != null && elemento.equalsIgnoreCase(palabraBuscada)) {
                        conteoParcial++;
                    }
                }
                System.out.println(nombreHilo + " finalizado. Encontrados: " + conteoParcial);
            } catch (Exception e) {
                System.out.println("Error en " + nombreHilo + ": " + e.getMessage());
            }
        }

        public int getConteoParcial() {
            return conteoParcial;
        }
    }

    public static void main(String[] args) {
        try {
            String[][] matriz = {
                    {"Java", "Python", "Java"}, {"C++", "Java", "Go"},
                    {"Java", "Rust", "Java"}
            };

            String palabraBuscada = "Java";

            System.out.println(palabraBuscada + "\"");

            List<Thread> hilos = new ArrayList<>();
            List<BuscadorFila> tareas = new ArrayList<>();

            for (int i = 0; i < matriz.length; i++) {
                BuscadorFila tarea = new BuscadorFila(matriz[i], palabraBuscada, "Hilo-" + i);
                tareas.add(tarea);

                Thread hilo = new Thread(tarea);
                hilos.add(hilo);
                hilo.start();
            }

            for (Thread hilo : hilos) {
                hilo.join();
            }

            int total = 0;
            for (BuscadorFila tarea : tareas) {
                total += tarea.getConteoParcial();
            }

            System.out.println("----------------------------------------------");
            System.out.println(palabraBuscada + "\" aparece " + total + " veces.");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

