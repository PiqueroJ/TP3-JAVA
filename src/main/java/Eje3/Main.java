package Eje3;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
     File f = new File("");
     Scanner sc = new Scanner(System.in);
     String st = "";
     String linea;
     boolean res = false;
     
     System.out.println("Ingrese el string que busca: ");
     try{
         st = sc.nextLine();
     }catch(InputMismatchException e){
         System.out.println("String invalido");
     }
     
     try( BufferedReader br = new BufferedReader(new FileReader("d:\\Users\\Usuario\\Documents\\Eje3.txt"))){   
         while((linea = br.readLine()) != null){
             if(linea.contains(st)){
                 res = true;
             }
         }
     }catch (IOException e) {
            System.out.println("Error en el archivo");
        }
     
        System.out.println(res ? " El String esta en el archivo " : " El String no esta en el archivo ");
     
    }   
}
