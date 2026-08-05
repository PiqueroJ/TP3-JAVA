package Eje6.Tecnicos;

import Eje6.Capitulo;
import java.util.List;

public class CapituloTecnico extends Capitulo {
    private List<String> materias; 

    public CapituloTecnico(int numero, String titulo) {
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