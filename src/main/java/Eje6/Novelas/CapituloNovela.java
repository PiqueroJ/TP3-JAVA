package Eje6.Novelas;

import Eje6.Capitulo;
import java.io.Serializable;

public class CapituloNovela extends Capitulo implements Serializable{
    private static final long serialVersionUID = 1L;

    public CapituloNovela(int numero, String titulo) {
        super(numero, titulo);
    }  
    
}
