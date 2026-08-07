package Eje4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    
    private static final String ARCHIVO_AGENDA = "agenda.dat";

    private List<Persona> personas;

    public Agenda() {
        this.personas = new ArrayList();
    }
    
    public void menu(){
        Scanner teclado = new Scanner(System.in);
        int menu = -1;
        
        do{
            try{
                System.out.println("=== Agenda Menu ===");
                System.out.println("1. Registrar ");
                System.out.println("2. Eliminar ");
                System.out.println("3. Buscar Registro ");
                System.out.println("4. Mostrar Registros ");
                System.out.println("5. Guardar registros ");
                System.out.println("6. Recuperar Registros");
                System.out.println("7. Salir ");
                System.out.println("Opcion: ");
                menu = teclado.nextInt();
                
                if (menu < 1 || menu > 7) {
                    System.out.println("El numero ingresado es invalido");
                }
                
                 switch (menu){
                     case 1 -> registrar();
                     case 2 -> eliminar();
                     case 3 -> {Persona buscada = buscar();
                               buscada.mostrarPersona();}
                     case 4 -> mostrar();
                     case 5 -> guardarPersona();
                     case 6 -> cargarPersona();
                 }
                
            }catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine();
        } while(menu != 7);
    }
    
    public void registrar(){
        Scanner teclado = new Scanner(System.in);
        Persona per = IngresoPersona.leer(teclado);
        personas.add(per);
    }
    
    private void eliminar(){
        Persona buscada = buscar();
        if(buscada != null){
            personas.remove(buscada);
        }
    }
    
    public Persona buscar(){
        Scanner teclado = new Scanner(System.in);
        Persona buscada = null;
        int num = -1;
        
        do{
            try{
                System.out.println("Numero del registro buscado: ");
                num = teclado.nextInt();
                if (num < 1) {
                    System.out.println("El numero ingresado es invalido");
                }
            }catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine();
        }while (num < 1);
        
        if(personas.get(num-1) == null){
            System.out.println("No existe");
        }else{
            buscada = personas.get(num-1);
            buscada.mostrarPersona();
        }
        return buscada;
    }
    
    public void mostrar(){
        for(Persona pe : personas){
            pe.mostrarPersona();
            System.out.println("");
        }
    }
    
    
     public void guardarPersona() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_AGENDA))) {
        oos.writeObject(personas);
        System.out.println("Personas guardada correctamente.");
    } catch (IOException e) {
        System.out.println("Error al guardar las personas: " + e.getMessage());
    }
}

@SuppressWarnings("unchecked")
    public void cargarPersona() {
    File archivo = new File(ARCHIVO_AGENDA);
    if (!archivo.exists()) {
        System.out.println("No existe un archivo de agenda previo. Se inicia con catálogo vacío.");
        return;
    }
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
        personas = (List<Persona>) ois.readObject();
        System.out.println("Personas cargadas correctamente.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al cargar las personas: " + e.getMessage());
    }
}
    
    
    }
