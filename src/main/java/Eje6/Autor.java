package Eje6;


public class Autor {
    
    private String nombre;

    public Autor(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        
        this.nombre = nombre;
    }
    
    
}
