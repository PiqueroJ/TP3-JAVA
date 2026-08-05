package Eje6.Ingreso;

import Eje6.Autor;
import java.util.Scanner;

public class IngrseoAutor {
     public static Autor leer(Scanner teclado){
          while(true){
              try{
                  
                  System.out.println("Ingrese el nombre: ");
                  String nom = teclado.nextLine();
                  
                  return new Autor(nom);
              }catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
          }
     }
}
