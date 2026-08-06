package Eje6.Tecnicos;

import Eje6.Autor;
import Eje6.Capitulo;
import Eje6.Editorial;
import Eje6.Formato;
import Eje6.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Libro implements Serializable{
    private static final long serialVersionUID = 1L;

    private CategoriaTecnico categoria;

    public Tecnico(String titulo, List<Autor> autores, Editorial editorial, int anioEdicion,
                   String codigoISBN, Formato formato, List<CapituloTecnico> capitulos,
                   CategoriaTecnico categoria) {

        super(titulo, autores, editorial, anioEdicion, codigoISBN, formato, new ArrayList<Capitulo>(capitulos));

        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula.");
        }
        this.categoria = categoria;
    }

    public CategoriaTecnico getCategoria() {
        return categoria;
    }
    
    
}