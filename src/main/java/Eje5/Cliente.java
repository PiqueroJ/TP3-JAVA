package Eje5;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static int contador = 0;

    private final int codigo;
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Cliente(int dni, String nombre, String apellido, String direccion, String telefono) {
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

        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codigo = contador++;
    }

    public int getCodigo() { return codigo; }
    public int getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }

    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    // Necesario para poder restaurar el contador al cargar desde archivo
    public static void ajustarContador(int ultimoCodigo) {
        if (ultimoCodigo >= contador) {
            contador = ultimoCodigo + 1;
        }
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "codigo= " + codigo +
                ", dni= " + dni +
                ", nombre= " + nombre + '\'' +
                ", apellido= " + apellido + '\'' +
                ", direccion= " + direccion + '\'' +
                ", telefono= " + telefono + '\'';
    }
}