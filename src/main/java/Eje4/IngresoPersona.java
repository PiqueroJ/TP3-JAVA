package Eje4;

import java.util.Scanner;

public class IngresoPersona {
    public static Persona leer(Scanner teclado){
        System.out.println("Cargue Persona: ");
        
        while(true){
            try{
          System.out.println("Ingrese el nombre: ");
        String nom = teclado.nextLine();

        System.out.println("Ingrese el apellido: ");
        String ape = teclado.nextLine();
        
        System.out.println("Ingrese el telefono de linea: ");
        String telL = teclado.nextLine();
        
        System.out.println("Ingrese el telefono movil: ");
        String telM = teclado.nextLine();
        
        System.out.println("Ingrese el telefono de trabajo: ");
        String telT = teclado.nextLine();
        
        System.out.println("Ingrese el mail: ");
        String mailS = teclado.nextLine();
          
        System.out.println("De donde conoce a la persona: ");
        String cone = teclado.nextLine();
        
        return new Persona(nom, ape, telL, telM, telT, mailS,cone);
            }catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
        }
    }
    
}
