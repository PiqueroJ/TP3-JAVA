package Eje6;

import java.io.Serializable;


public class Autor implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombre;

    public Autor(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        
        this.nombre = nombre;
    }
    
    
}
