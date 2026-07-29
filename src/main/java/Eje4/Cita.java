package Eje4;

import java.util.ArrayList;
import java.util.Scanner;


public class Cita {
     private static int contRegistros = 0;
    
    private int numReg;
    private int dia;
    private int mes;
    private int hora;
    private Persona persona;

    public Cita(int dia, int mes, int hora, Persona persona) {
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
        this.persona = persona;
    }

    public Cita(){
        
        this.numReg = contRegistros++;
        
        Scanner teclado = new Scanner(System.in);
        this.persona = new Persona( );
        
        System.out.println("Que mes es la cita");
        int auxM = teclado.nextInt();
        if(auxM < 1 || auxM > 12){
            throw new IllegalArgumentException("El mes es invalido");
        }
        this.mes = auxM;
        
        System.out.println("Que dia es la cita: ");
        int auxD = teclado.nextInt();
        if(auxD < 1 || auxD > 31){
           throw new IllegalArgumentException("El dia es invalido");
        }
        this.dia = auxD;
        
        System.out.println("A que hora (general) es la cita: ");
        int auxH = teclado.nextInt();
        if(auxH < 0 || auxH > 23){
            throw new IllegalArgumentException("La hora es invalida");
        }
        this.hora = auxH;

    }
    
    public void mostrarCita(){
        persona.mostrarPersona();
        System.out.println("\nFecha: El " + dia + " de " + mes + " a las " + hora);
    }
}
