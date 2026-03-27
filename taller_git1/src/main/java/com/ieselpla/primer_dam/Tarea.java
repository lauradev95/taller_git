package com.ieselpla.primer_dam;

/**
 * Representa una tarea en el gestor de tareas.
 * TODO: Añadir campo 'prioridad' (rama feature/prioridad)
 */
public class Tarea {

    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    public enum Prioridad{ALTA,MEDIA,BAJA};
    private Prioridad prioridad;

    public Tarea(int id, String titulo, String descripcion,Prioridad prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        String estado = completada ? "[✓]" : "[ ]";
        return estado + " [" + id + "] " + titulo + " (" + prioridad + ") - " + descripcion;
    }
}
