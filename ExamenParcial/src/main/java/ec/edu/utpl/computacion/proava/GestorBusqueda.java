package ec.edu.utpl.computacion.proava;

import java.util.ArrayList;
import java.util.List;

public class GestorBusqueda {

    private final String[][] matriz;
    private final String palabraBuscada;

    public GestorBusqueda(String[][] matriz, String palabraBuscada) {

        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("La matriz está vacía");
        }

        if (palabraBuscada == null || palabraBuscada.isBlank()) {
            throw new IllegalArgumentException("La palabra buscada es inválida");
        }

        this.matriz = matriz;
        this.palabraBuscada = palabraBuscada;
    }

    public int buscarPalabra() {

        List<Thread> hilos = new ArrayList<>();
        List<BuscadorFila> tareas = new ArrayList<>();

        try {

            // Crear y ejecutar hilos
            for (int i = 0; i < matriz.length; i++) {

                BuscadorFila tarea =
                        new BuscadorFila(matriz[i], palabraBuscada);

                tareas.add(tarea);

                Thread hilo =
                        new Thread(tarea, "Hilo-Fila-" + i);

                hilos.add(hilo);

                hilo.start();
            }

            // Esperar finalización de todos los hilos
            for (Thread hilo : hilos) {
                hilo.join();
            }

            // Consolidar resultados
            int total = 0;

            for (BuscadorFila tarea : tareas) {
                total += tarea.getConteoParcial();
            }

            return total;

        } catch (InterruptedException e) {

            System.err.println("La ejecución fue interrumpida");

            Thread.currentThread().interrupt();

            return 0;

        } catch (Exception e) {

            System.err.println("Error general: " + e.getMessage());

            return 0;
        }
    }
}