package Eje6;

import java.util.List;

public class Proveedor {
    
    private String nombre;
    private List<Editorial> editoriales;
    
    public Proveedor(String nombre, List<Editorial> editoriales) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del proveedor no puede estar vacío.");
        }
        if (editoriales == null || editoriales.isEmpty()) {
            throw new IllegalArgumentException("El proveedor debe representar al menos una editorial.");
        }
        this.nombre = nombre;
        this.editoriales = editoriales;
    }
    
    public String getNombre() {
        return nombre;
    }

    public List<Editorial> getEditoriales() {
        return editoriales;
    }

    public boolean representaA(Editorial editorial) {
        return editoriales.contains(editorial);
    }
    
}
