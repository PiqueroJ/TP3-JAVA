package Eje4;

import java.util.Scanner;


public class Persona {
    
    private String nombre;
    private String apellido;
    private String telefonoLinea;
    private String telefonoMovil;
    private String telefonoTrabajo;
    private String email;
    private String conexion;

    public Persona(String nombre, String apellido, String telefonoLinea, String telefonoMovil, String telefonoTrabajo, String email, String conexion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonoLinea = telefonoLinea;
        this.telefonoMovil = telefonoMovil;
        this.telefonoTrabajo = telefonoTrabajo;
        this.email = email;
        this.conexion = conexion;
    }
    
    public Persona(){
      Scanner teclado = new Scanner(System.in);
      
        System.out.println("Ingrese el nombre: ");
        String nom = teclado.nextLine();
        if(nom == null || nom.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if(!nom.matches("[a-zA-Z ]+")){
            throw new IllegalArgumentException("El nombre no puede contener números.");
        }
        this.nombre = nom;
        
        System.out.println("Ingrese el apellido: ");
        String ape = teclado.nextLine();
        if(ape == null || ape.isEmpty()){
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        if(!ape.matches("[a-zA-Z ]+")){
            throw new IllegalArgumentException("El apellido no puede contener números.");
        }
        this.apellido = ape;
        
        System.out.println("Ingrese el telefono de linea: ");
        this.telefonoLinea = teclado.nextLine();
        
        System.out.println("Ingrese el telefono movil: ");
        String tel = teclado.nextLine();
        if(tel == null || tel.isEmpty()){
            throw new IllegalArgumentException("Hay que llenar este campo");
        }
        
        System.out.println("Ingrese el telefono de trabajo: ");
        this.telefonoTrabajo = teclado.nextLine();
        
        System.out.println("Ingrese el mail: ");
        String mailS = teclado.nextLine();
        if(mailS == null || mailS.isEmpty()){
            throw new IllegalArgumentException("El mail no puede estar vacío.");
        }
        
        System.out.println("De donde conoce a la persona: ");
        this.conexion = teclado.nextLine();
        
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
