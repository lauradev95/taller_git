package com.ieselpla.primer_dam;

import java.util.ArrayList;

/**
 * Gestiona una colección de tareas.
 * TODO (rama feature/filtrado): añadir métodos listarPendientes() y listarCompletadas()
 * TODO (rama feature/guardar-fichero): añadir método guardarEnFichero(String ruta)
 */
public class GestorTareas {

    private ArrayList<Tarea> tareas;
    private int proximoId;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.proximoId = 1;
    }

    /**
     * Añade una nueva tarea al gestor.
     */
    public void añadirTarea(String titulo, String descripcion) {
        Tarea nueva = new Tarea(proximoId, titulo, descripcion);
        tareas.add(nueva);
        proximoId++;
        System.out.println("✔ Tarea añadida con ID " + nueva.getId());
    }

    /**
     * Muestra todas las tareas por pantalla.
     */
    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }
        System.out.println("\n=== LISTA DE TAREAS ===");
        for (Tarea t : tareas) {
            System.out.println(t);
        }
        System.out.println("======================");
    }

    /**
     * Marca una tarea como completada dado su ID.
     * BUG: no valida si el ID existe antes de intentar marcarla.
     * Lanza NullPointerException si el ID no existe.
     */
    public void completarTarea(int id) {
        Tarea encontrada = buscarPorId(id);
        // ¿Ves el problema? Falta validar que 'encontrada' no sea null
        encontrada.setCompletada(true);
        System.out.println("✔ Tarea " + id + " marcada como completada.");
    }

    /**
     * Elimina una tarea dado su ID.
     * Devuelve true si se eliminó, false si no se encontró.
     */
    public boolean eliminarTarea(int id) {
        Tarea encontrada = buscarPorId(id);
        if (encontrada == null) {
            System.out.println("✘ No existe ninguna tarea con ID " + id);
            return false;
        }
        tareas.remove(encontrada);
        System.out.println("✔ Tarea " + id + " eliminada.");
        return true;
    }

    /**
     * Devuelve el número total de tareas.
     */
    public int contarTareas() {
        return tareas.size();
    }

    // -------------------------------------------------------
    // Método privado auxiliar
    // -------------------------------------------------------

    private Tarea buscarPorId(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null; // No encontrada
    }
}
