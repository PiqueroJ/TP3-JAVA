package Eje6.Tecnicos;

import Eje6.Capitulo;
import java.io.Serializable;
import java.util.List;

public class CapituloTecnico extends Capitulo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private List<String> materias; 

    public CapituloTecnico(int numero, String titulo, List<String> materias) {
        super(numero, titulo);
        if (materias == null || materias.isEmpty()) {
            throw new IllegalArgumentException("El capítulo debe tratar al menos una materia.");
        }
        this.materias = materias;
    }
    
    public List<String> getMaterias() {
        return materias;
    }
    
}