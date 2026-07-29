package Eje2;

/*¿Qué es un iterador? (iterator). 
Muestre cómo se usa, haciendo altas, bajas, recorridos y búsquedas en listas implementadas con ArrayList.*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
      ArrayList<String> alumnos = new ArrayList<>();  
      
        alumnos.add("Ana García");
        alumnos.add("Carlos Lopez");
        alumnos.add("María Martínez");
        alumnos.add("Juan Pérez");
        alumnos.add("Lucía Fernández");
        
        recorridoConIterator(alumnos);
        bajaConIterator(alumnos);
        darAlta(alumnos);
        recorridoConIterator(alumnos);
        busquedadConIterator(alumnos);
        
    }
    
    public static void recorridoConIterator(ArrayList<String> alumnos){
        System.out.println(" - Recorrido con ITERATOR - ");
        Iterator<String> iteradorRecorrido = alumnos.iterator();
        
        while(iteradorRecorrido.hasNext()){
            String alumno = iteradorRecorrido.next();
            System.out.println(" - " + alumno + " - \n");
        }
    }
    
    public static void busquedadConIterator(ArrayList<String> alumnos){
        System.out.println(" - Busquedad con ITERATOR - ");
        Scanner sc = new Scanner(System.in);
        String alu;
        System.out.println("Ingrese el nombre y apellido del alumno buscado: ");
        alu = sc.nextLine();
        
        boolean encontrado = false;
        
        Iterator<String> iteradorBusqueda = alumnos.iterator();
        
        while(iteradorBusqueda.hasNext()){
            String alumno = iteradorBusqueda.next();
            if(alumno.equalsIgnoreCase(alu)){
                encontrado = true;
            }
        }
        if(encontrado){
            System.out.println("\nAlumno/a " + alu + " encontrado/a");
        }else{
            System.out.println("\nAlumno/a " + alu + " no encontrado/a");
        }
        
    }
    
    public static void bajaConIterator(ArrayList<String> alumnos){
        String alu;
        Scanner sc = new Scanner(System.in);
        System.out.println("- Bajas con ITERATOR - ");
        System.out.println("ingrese el nombre del alumno que quiere eliminar: ");
        alu = sc.nextLine();
        
        Iterator<String> iteradorBaja = alumnos.iterator();
        
        while(iteradorBaja.hasNext()){
            String alumno = iteradorBaja.next();
            if(alumno.equals(alu)){
                iteradorBaja.remove();
            }
        }
        
        System.out.println("Carlos Lopez eliminado\n");
    }
    
    public static void darAlta(ArrayList<String> alumnos){
        System.out.println(" - Añadir dato - ");
        String alu;
        Scanner sc = new Scanner(System.in);
        System.out.println(" Ingrese el nombre del aluimno que quiera ingresar: ");
        alu = sc.nextLine();
        alumnos.add(alu);
    }
}
