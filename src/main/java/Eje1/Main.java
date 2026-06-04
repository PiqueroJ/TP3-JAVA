package Eje1;

import java.util.ArrayList;
import java.util.Scanner;

/*Usando ArayList escriba un programa que permita hacer altas, bajas, búsqueda y recorridos

a) en una lista de enteros

b) en una lista de objetos Alumno (cree la clase)*/

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList();
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);
        numeros.add(9);
        numeros.add(10);
        
        alumnos.add(new Alumno("Juan","Piquero",123456));
        alumnos.add(new Alumno("Pepe","Aguirre",654321));
        alumnos.add(new Alumno("Lucia","Ferreira",4567891));
        alumnos.add(new Alumno("Mercedes","Fieza",1357924));
        
        recorrerListaNumeros(numeros);
        buscarMin(numeros);
        buscarMax(numeros);
        buscarNumero(numeros);
        
        recorrerAlumnos(alumnos);
        buscarAlumno(alumnos);
        
    }
    
    public static void recorrerListaNumeros(ArrayList<Integer> numeros){
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }
    }
    
    public static void buscarMin(ArrayList<Integer> numeros){
        int min = 100000;
        for (int i = 0; i < numeros.size(); i++) {
            if(numeros.get(i) < min){
                min = numeros.get(i);
            }
        }
        System.out.println("\nEl numero minimo de la lista: " + min);
    }
    
    public static void buscarMax(ArrayList<Integer> numeros){
         int max = 0;
        for (int i = 0; i < numeros.size(); i++) {
            if(numeros.get(i) > max){
                max = numeros.get(i);
            }
        }
        System.out.println("\nEl numero maximo de la lista: " + max);
    }
    
    public static void recorrerAlumnos(ArrayList<Alumno> alumnos){
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println("\nNombre: " + alumnos.get(i).getNombre()
            + " \nApellido: " + alumnos.get(i).getApellido()
            + " \nLegajo: " + alumnos.get(i).getLegajo());
        }
    }
    
    public static void buscarNumero(ArrayList<Integer> numeros){
        Scanner sc = new Scanner(System.in);
        int num;
        int pos = -1;
        System.out.println("\nQue numero busca: ");
        num = sc.nextInt();
        for (int i = 0; i < numeros.size(); i++) {
            if(numeros.get(i) == num){
                pos = i;
            }
        }
        if(pos == -1){
            System.out.println("\nNumero no encontrado");
        }else{
            System.out.println("\nNumero: " + num + " Encontrado en la posicion: " + pos);
        }
    }
    
     public static void buscarAlumno(ArrayList<Alumno> alumnos){
         Scanner sc = new Scanner(System.in);
         int legajo;
         int pos = -1;
         System.out.println("Ingrese el legajo del estudiante buscado: ");
         legajo = sc.nextInt();
         for (int i = 0; i < alumnos.size(); i++) {
             if(alumnos.get(i).getLegajo() == legajo){
                 pos = i;
             }
         }
         if(pos == -1){
             System.out.println("Legajo no encontrado");
         }else{
             System.out.println("Estudiante: " + alumnos.get(pos).getNombre()
             + " " + alumnos.get(pos).getApellido() + 
              "\n Legajo: " + legajo + 
              "\nEncontrado en la posicion: " + pos);
         }
         
     }
}
