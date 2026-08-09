package Eje6;

import java.util.ArrayList;
import java.util.List;

/*Se desea diseñar un programa que registre, y persista en archivos, libros (técnicos y novelas) para una librería y permita buscarlos, venderlos y verificar su stock.

Las novelas se clasifican como de ciencia ficción, romance, misterio, juveniles y policiales. Los libros técnicos se clasifican como de ingeniería, ciencias naturales o ciencias sociales.

Cada libro tiene un título, uno o más autores, una editorial, un año de edición y formato (tapas duras o edición económica). 
Los libros tienen además un código ISBN y capítulos, los que tratan una o más materias (en los técnicos) o es una simple división (en las novelas).

La librería obtiene los libros por medio de proveedores que representan a una o más editoriales. De cada libro se tiene un stock (que puede ser cero). 
Al venderse un libro, el stock se actualiza. Si un cliente requiere un libro cuyo stock es cero, se puede realizar un encargo por parte del cliente. Esto significa que se pide el libro a un proveedor de la editorial del libro.*/

public class Main {
    public static void main(String[] args){
        Editorial planeta = new Editorial("Planeta");
        Editorial sudamericana = new Editorial("Sudamericana");
        Editorial pearson = new Editorial("Pearson");
        Editorial oceano = new Editorial("Océano");
        
        List<Proveedor> proveedores = new ArrayList<>();

        proveedores.add(new Proveedor(
                "Distribuidora Norte",
                new ArrayList<>(List.of(planeta, sudamericana))
        ));

        proveedores.add(new Proveedor(
                "Distribuidora Sur",
                new ArrayList<>(List.of(pearson))
        ));

        proveedores.add(new Proveedor(
                "Editorial Directa",
                new ArrayList<>(List.of(oceano))
        ));
        
        //Listas iniciales vacias
        List<Libro> libros = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        //Creo la libreria
        Libreria libreria = new Libreria(libros, clientes, proveedores);

        //Deserializacion
        libreria.cargarLibros();
       
        //Clientes
        libreria.agregarCliente();
        
        //Menu Libro
        libreria.menu();

        //Serializacion
        libreria.guardarLibros();
        
    }
}
