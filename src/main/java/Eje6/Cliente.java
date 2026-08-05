package Eje6;

public class Cliente {
    
    private String usuario; 

    public Cliente(String usuario) {
        if(usuario == null || usuario.isEmpty()){
            throw new IllegalArgumentException("El usuario no puede estar vacío.");
        }
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }
    
         @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente that = (Cliente) o;
        return usuario.equalsIgnoreCase(that.usuario);
    }

    @Override
    public int hashCode() {
        return usuario.toLowerCase().hashCode();
    }
    
    
}
