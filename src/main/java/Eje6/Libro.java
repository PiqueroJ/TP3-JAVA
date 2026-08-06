package Eje6;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

public abstract class Libro implements Serializable{
    private static final long serialVersionUID = 1L;

    private String titulo;
    private List<Autor> autores;
    private Editorial editorial;    
    private int anioEdicion;
    private String codigoISBN;
    private Formato formato;
    private List<Capitulo> capitulos;
    private int stock;

    public Libro(String titulo, List<Autor> autores, Editorial editorial, int anioEdicion,
                 String codigoISBN, Formato formato, List<Capitulo> capitulos) {

        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (autores == null || autores.isEmpty()) {
            throw new IllegalArgumentException("El libro debe tener al menos un autor.");
        }
        if (editorial == null) {                                    
            throw new IllegalArgumentException("La editorial no puede ser nula.");
        }
        if (anioEdicion < 1800 || anioEdicion > Year.now().getValue()) {
            throw new IllegalArgumentException("El año es inválido.");
        }
        if (codigoISBN == null || codigoISBN.isEmpty()) {
            throw new IllegalArgumentException("El código ISBN no puede estar vacío.");
        }
        if (formato == null) {
            throw new IllegalArgumentException("El formato no puede ser nulo.");
        }
        if (capitulos == null || capitulos.isEmpty()) {
            throw new IllegalArgumentException("El libro debe tener al menos un capítulo.");
        }

        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.codigoISBN = codigoISBN;
        this.formato = formato;
        this.capitulos = capitulos;
        this.stock = 0;
    }

    public Editorial getEditorial() {  
        return editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public Formato getFormato() {
        return formato;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public int getStock() {
        return stock;
    }

    public void venderUnidad() {
        if (stock <= 0) {
            throw new IllegalStateException("No hay stock disponible para vender este libro.");
        }
        stock--;
    }

    public void agregarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a agregar debe ser mayor a cero.");
        }
        stock += cantidad;
    }

   public void mostrarLibro(){
       System.out.println(titulo + "\n");
       for(Autor a: autores){
           System.out.println(a + "\n");
       }
       System.out.println("Editorial: " + editorial.getNombre() + "\n");
       System.out.println("Anio de publicacion: " + anioEdicion + "\n");
       System.out.println("ISBN: " + codigoISBN + "\n");
       System.out.println("Formato: " + formato + "\n");
       System.out.println("Stock: " + stock + "\n");
       System.out.println("Capitulos: " + capitulos.size() + "\n");
       
   }
    
    
    
}