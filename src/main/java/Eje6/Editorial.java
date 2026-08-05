package Eje6;

public class Editorial {
    
    private String nombre;
    
    public Editorial(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la editorial no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Editorial)) return false;
        Editorial that = (Editorial) o;
        return nombre.equalsIgnoreCase(that.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }
    
}
