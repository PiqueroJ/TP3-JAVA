package Eje6;

import java.util.List;
import java.util.Scanner;

public class Libreria {
    
    private List<Libro> libros;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;

    public Libreria(List<Libro> libros, List<Cliente> clientes, List<Proveedor> proveedores) {
        if (libros == null || clientes == null || proveedores == null) {
        throw new IllegalArgumentException("Las listas no pueden ser nulas.");
    }
        this.libros = libros;
        this.clientes = clientes;
        this.proveedores = proveedores;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }
    
    
    public void agregarLibro(Libro libro){
        Scanner teclado = new Scanner(System.in);
        try{
            System.out.println("Ingrese el titulo del libro: ");
            String titulo = teclado.nextLine();
            
            //autor
            
            System.out.println("Ingrese el anio de edicion: ");
            int anio = Integer.parseInt(teclado.nextLine());
            
            System.out.println("Ingrese codigo ISBN del libro: ");
            String isbn = teclado.nextLine();
            
            System.out.println("Ingrese la Stock del libro: ");
            int stock = Integer.parseInt(teclado.nextLine());
            
        }catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
    }
    
    
}
