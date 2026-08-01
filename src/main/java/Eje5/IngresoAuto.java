package Eje5;

import java.util.Scanner;

public class IngresoAuto {
    public static Auto leer(Scanner teclado){
        System.out.println("Ingreso Auto: ");
        while(true){
            try{
                System.out.println("Ingrese la matricula: ");
                String matricula = teclado.nextLine();
                
                System.out.println("Ingrese marca: ");
                String marca = teclado.nextLine();
                
                System.out.println("Ingrese modelo: ");
                String modelo = teclado.nextLine();
                
                System.out.println("Ingrese color: ");
                String color = teclado.nextLine();
                
                System.out.println("Ingrese plazas: ");
                int plazas = Integer.parseInt(teclado.nextLine());
                
                return new Auto(matricula,marca,modelo,color,plazas);
            }catch (NumberFormatException e) {
                System.out.println("Error: las plazas deben ser un número. Intente nuevamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
        }
    }
    
}
