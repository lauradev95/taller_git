package com.ieselpla.primer_dam;

import java.util.Scanner;

/**
 * Punto de entrada de la aplicación Gestor de Tareas.
 * Menú interactivo por consola.
 *
 * TODO (conflicto intencionado): ambos miembros de la pareja deberán
 * modificar el método mostrarMenu() en sus ramas, lo que generará
 * un conflicto de merge en el Bloque 3 del taller.
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        int opcion = -1;

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║     GESTOR DE TAREAS v1.0    ║");
        System.out.println("╚══════════════════════════════╝");

        while (opcion != 0) {
            mostrarMenu();
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("✘ Opción no válida. Introduce un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.println("Prioridad (1: ALTA, 2: MEDIA, 3: BAJA): ");
                    int opcionPrioridad = scanner.nextInt();
                    Tarea.Prioridad p = (opcionPrioridad == 1) ? Tarea.Prioridad.ALTA
                            : (opcionPrioridad == 2) ? Tarea.Prioridad.MEDIA : Tarea.Prioridad.BAJA;

                    gestor.añadirTarea(titulo, descripcion, p);

                    break;

                case 2:
                    gestor.listarTareas();
                    break;

                case 3:
                    System.out.print("ID de la tarea a completar: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        gestor.completarTarea(id);
                    } catch (NumberFormatException e) {
                        System.out.println("✘ ID no válido.");
                    }
                    break;

                case 4:
                    System.out.print("ID de la tarea a eliminar: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        gestor.eliminarTarea(id);
                    } catch (NumberFormatException e) {
                        System.out.println("✘ ID no válido.");
                    }
                    break;

                case 5:
                    gestor.listarPendientes();
                    break;

                case 6:
                    gestor.listarCompletadas();
                    break;

                case 7:
                    System.out.println("Guardar tareas en archivo");
                    gestor.guardarEnFichero();

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("✘ Opción no reconocida.");
            }
        }

        scanner.close();
    }

    /**
     * Imprime el menú de opciones.
     * ZONA DE CONFLICTO: Este método será modificado por ambos
     * miembros de la pareja en el Bloque 3 del taller.
     */
    private static void mostrarMenu() {
        System.out.println("\n=== OPCIONES DISPONIBLES ===");
        System.out.println("1. 📝 Nueva tarea");
        System.out.println("2. 📋 Listar tareas");
        System.out.println("3. ✅ Completar tarea");
        System.out.println("4. 🗑️ Eliminar tarea");
        System.out.println("5. 📌 Listar pendientes");
        System.out.println("6. 📌 Listar completadas");
        System.out.println("7. 💾 Guardar en archivo");
        System.out.println("0. 🚪 Salir");
    }
}
