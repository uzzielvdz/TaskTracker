package com.uzzielvz.tasktracker;

public enum Status
{
    TODO("To do"),
    IN_PROGRESS("In progress"),
    DONE("Done");
    
    private final String descripcion;

    // Constructor del enum
    private Status(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para obtener la descripción asociada
    public String getDescripcion() {
        return descripcion;
    }
}
