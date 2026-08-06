package Eje6.Novelas;

import Eje6.Autor;
import Eje6.Capitulo;
import Eje6.Editorial;
import Eje6.Formato;
import Eje6.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Novela extends Libro implements Serializable{
    private static final long serialVersionUID = 1L;

    private CategoriaNovela categoria;

    public Novela(String titulo, List<Autor> autores, Editorial editorial, int anioEdicion,
                  String codigoISBN, Formato formato, List<CapituloNovela> capitulos,
                  CategoriaNovela categoria) {

        super(titulo, autores, editorial, anioEdicion, codigoISBN, formato, new ArrayList<Capitulo>(capitulos));

        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula.");
        }
        this.categoria = categoria;
    }

    public CategoriaNovela getCategoria() {
        return categoria;
    }
    
    
}