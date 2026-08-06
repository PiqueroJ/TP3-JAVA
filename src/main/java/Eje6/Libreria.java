package Eje6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Eje6.Tecnicos.Tecnico;
import Eje6.Tecnicos.CategoriaTecnico;
import Eje6.Tecnicos.CapituloTecnico;

import Eje6.Novelas.Novela;
import Eje6.Novelas.CategoriaNovela;
import Eje6.Novelas.CapituloNovela;

import java.io.*;
import java.util.InputMismatchException;


public class Libreria {
    
    private List<Libro> libros;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;
    
    private static final String ARCHIVO_LIBROS = "libros.dat";

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
    
    
    public void agregarLibro() {
        Scanner teclado = new Scanner(System.in);
    try {
        System.out.println("Ingrese el título del libro: ");
        String titulo = teclado.nextLine();

        // Autores
        List<Autor> autores = new ArrayList<>();
        System.out.println("¿Cuántos autores tiene el libro? ");
        int cantAutores = Integer.parseInt(teclado.nextLine());
        for (int i = 0; i < cantAutores; i++) {
            System.out.println("Ingrese nombre del autor " + (i + 1) + ": ");
            String nombreAutor = teclado.nextLine();
            autores.add(new Autor(nombreAutor));
        }

        // Editorial
        System.out.println("Ingrese el nombre de la editorial: ");
        String nombreEditorial = teclado.nextLine();
        Editorial editorial = new Editorial(nombreEditorial);

        System.out.println("Ingrese el año de edición: ");
        int anio = Integer.parseInt(teclado.nextLine());

        System.out.println("Ingrese código ISBN del libro: ");
        String isbn = teclado.nextLine();

        // Formato
        System.out.println("Seleccione el formato:");
        System.out.println("1 - Tapa dura");
        System.out.println("2 - Edición económica");
        int opcionFormato = Integer.parseInt(teclado.nextLine());
        Formato formato = (opcionFormato == 1) ? Formato.Tapa_Dura : Formato.Edicion_Economica;

        // Tipo de libro
        System.out.println("¿Qué tipo de libro es?");
        System.out.println("1 - Técnico");
        System.out.println("2 - Novela");
        int tipoLibro = Integer.parseInt(teclado.nextLine());

        System.out.println("Ingrese cantidad de stock inicial: ");
        int stock = Integer.parseInt(teclado.nextLine());

        Libro libro;

        if (tipoLibro == 1) {
            libro = cargarTecnico(teclado, titulo, autores, editorial, anio, isbn, formato);
        } else {
            libro = cargarNovela(teclado, titulo, autores, editorial, anio, isbn, formato);
        }

        if (stock > 0) {
            libro.agregarStock(stock);
        }

        libros.add(libro);
        System.out.println("Libro agregado correctamente.");

    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
    }
}
    
     public void venderLibro(){      
             Scanner teclado = new Scanner(System.in);
             System.out.println("Ingrese el codigo ISBN del libro que se vendio: ");
             String isbnV = teclado.nextLine();
             
             Libro lib = buscarLibro(isbnV);
             
             if(lib == null){
                 System.out.println("No se encontro ese libro: ");
             }else{
              if (lib.getStock() > 0) {
        lib.venderUnidad();
        System.out.println("Venta realizada. Stock restante: " + lib.getStock());
    } else {
        System.out.println("No hay stock disponible.");
        System.out.println("¿Desea realizar un encargo? (S/N)");
        String respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("Se realizo un encargo al proveedo.");
        }
             }

     }
     }
     
     public Libro buscarLibro(String isbn){
         for(Libro lib : libros){
             if(lib.getCodigoISBN().equalsIgnoreCase(isbn)){
                 return lib;
             }
         }
         return null;
     }
    
    private Tecnico cargarTecnico(Scanner teclado, String titulo, List<Autor> autores,
                               Editorial editorial, int anio, String isbn, Formato formato) {

    System.out.println("¿Cuántos capítulos tiene el libro? ");
    int cantCapitulos = Integer.parseInt(teclado.nextLine());
    List<CapituloTecnico> capitulos = new ArrayList<>();

    for (int i = 1; i <= cantCapitulos; i++) {
        System.out.println("Título del capítulo " + i + ": ");
        String tituloCap = teclado.nextLine();

        System.out.println("¿Cuántas materias trata este capítulo? ");
        int cantMaterias = Integer.parseInt(teclado.nextLine());
        List<String> materias = new ArrayList<>();
        for (int j = 0; j < cantMaterias; j++) {
            System.out.println("Materia " + (j + 1) + ": ");
            materias.add(teclado.nextLine());
        }
        capitulos.add(new CapituloTecnico(i, tituloCap, materias));
    }

    System.out.println("Seleccione la categoría:");
    System.out.println("1 - Ingeniería");
    System.out.println("2 - Ciencias naturales");
    System.out.println("3 - Ciencias sociales");
    int opcionCategoria = Integer.parseInt(teclado.nextLine());
    CategoriaTecnico categoria = switch (opcionCategoria) {
        case 1 -> CategoriaTecnico.INGENIERIA;
        case 2 -> CategoriaTecnico.CIENCIAS_NATURALES;
        default -> CategoriaTecnico.CIENCIAS_SOCIALES;
    };

    return new Tecnico(titulo, autores, editorial, anio, isbn, formato, capitulos, categoria);
}
    
    private Novela cargarNovela(Scanner teclado, String titulo, List<Autor> autores,
                             Editorial editorial, int anio, String isbn, Formato formato) {

    System.out.println("¿Cuántos capítulos tiene el libro? ");
    int cantCapitulos = Integer.parseInt(teclado.nextLine());
    List<CapituloNovela> capitulos = new ArrayList<>();

    for (int i = 1; i <= cantCapitulos; i++) {
        System.out.println("Título del capítulo " + i + ": ");
        String tituloCap = teclado.nextLine();
        capitulos.add(new CapituloNovela(i, tituloCap));
    }

    System.out.println("Seleccione la categoría:");
    System.out.println("1 - Ciencia ficción");
    System.out.println("2 - Romance");
    System.out.println("3 - Misterio");
    System.out.println("4 - Juvenil");
    System.out.println("5 - Policial");
    int opcionCategoria = Integer.parseInt(teclado.nextLine());
    CategoriaNovela categoria = switch (opcionCategoria) {
        case 1 -> CategoriaNovela.CIENCIA_FICCION;
        case 2 -> CategoriaNovela.ROMANCE;
        case 3 -> CategoriaNovela.MISTERIO;
        case 4 -> CategoriaNovela.JUVENIL;
        default -> CategoriaNovela.POLICIAL;
    };

    return new Novela(titulo, autores, editorial, anio, isbn, formato, capitulos, categoria);
}
    
    public void guardarLibros() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_LIBROS))) {
        oos.writeObject(libros);
        System.out.println("Libros guardados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al guardar los libros: " + e.getMessage());
    }
}

@SuppressWarnings("unchecked")
    public void cargarLibros() {
    File archivo = new File(ARCHIVO_LIBROS);
    if (!archivo.exists()) {
        System.out.println("No existe un archivo de libros previo. Se inicia con catálogo vacío.");
        return;
    }
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
        libros = (List<Libro>) ois.readObject();
        System.out.println("Libros cargados correctamente.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al cargar los libros: " + e.getMessage());
    }
}
    
    public void agregarCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre de Usuario: ");
        String nom = teclado.nextLine();
        clientes.add(new Cliente(nom));
    }
    
    public void verStock(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el ISBN del libro buscado: ");
        String isbn = teclado.nextLine();
        Libro buscado = buscarLibro(isbn);
        if(buscado == null){
            System.out.println("No se encontro un libro con ese codigo");
        }else{
        int stock = buscado.getStock();
        System.out.println("El stock del libro: " + stock);
        }
        
    }
    
    public void mostrarLibro(Libro libro){
        System.out.println(libro);
   }

    public void menu(){
        Scanner teclado = new Scanner(System.in);
        int menuL = 0;
        
        do{
            try{
                System.out.println("===== Menu Libro =====");
                System.out.println("1. Registrar Libro");
                System.out.println("2. Buscar Libro");
                System.out.println("3. Vender Libro");
                System.out.println("4. Revisar Stock");
                System.out.println("5. Guardar Libros (Serialización)");
                System.out.println("6. Recuperar Libros (Deserialización)");
                System.out.println("7. Salir");
                System.out.print("Opción: ");
                menuL = Integer.parseInt(teclado.nextLine());
                
                if (menuL < 1 || menuL > 7) {
                System.out.println("El numero ingresado es invalido");
                }
                
                switch (menuL) {
                    case 1 ->
                        agregarLibro();
                    case 2 -> {
                        System.out.println("Ingrese el ISBN del libro buscado: ");
                        String isbn = teclado.nextLine();
                        Libro buscado = buscarLibro(isbn);
                        if(buscado == null){
                            System.out.println("No se encontro un libro con ese ISBN");
                        }else{
                           mostrarLibro(buscado);
                        } 
                    }
                    case 3 ->
                        venderLibro();
                    case 4 ->
                        verStock();
                    case 5 ->
                        guardarLibros();
                    case 6 ->
                        cargarLibros();
                }        
            }catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine();
        }while(menuL != 7);
        
    }
      
}
