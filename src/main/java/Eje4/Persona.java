package Eje4;

import java.util.Scanner;
import java.io.Serializable;

public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String apellido;
    private String telefonoLinea;
    private String telefonoMovil;
    private String telefonoTrabajo;
    private String email;
    private String conexion;

    public Persona(String nombre, String apellido, String telefonoLinea, String telefonoMovil, String telefonoTrabajo, String email, String conexion) {
        
         if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (!nombre.matches("[a-zA-ZÀ-ÿ ]+")) {
            throw new IllegalArgumentException("El nombre no puede contener números.");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        if (!apellido.matches("[a-zA-ZÀ-ÿ ]+")) {
            throw new IllegalArgumentException("El apellido no puede contener números.");
        }
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("El mail no puede estar vacío.");
        }
         if(telefonoMovil == null || telefonoMovil.isEmpty()){
            throw new IllegalArgumentException("Hay que llenar este campo");
        }
        
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonoLinea = telefonoLinea;
        this.telefonoMovil = telefonoMovil;
        this.telefonoTrabajo = telefonoTrabajo;
        this.email = email;
        this.conexion = conexion;
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefonoLinea() {
        return telefonoLinea;
    }

    public void setTelefonoLinea(String telefonoLinea) {
        this.telefonoLinea = telefonoLinea;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

   public void mostrarPersona(){
       System.out.println("\n Nombre: " + nombre + "\n Apellido: " + apellido + 
               "\n Telefono de Linea: " + telefonoLinea + "\n Telefono Movil: " +  telefonoMovil + 
                "\n Telefono de Trabajo: " + telefonoTrabajo + 
                "\n Email: " + email + "\n Conexion: " + conexion);
   }
    
}
