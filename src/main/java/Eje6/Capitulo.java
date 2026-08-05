package Eje6;

public abstract class Capitulo {
    private int numero;
    private String titulo;

    public Capitulo(int numero, String titulo) {
        if(numero <= 0){
            throw new IllegalArgumentException("El numero es inválido.");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El titulo del capitulo no puede estar vacio.");
        }
        this.numero = numero;
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    } 
    
}



