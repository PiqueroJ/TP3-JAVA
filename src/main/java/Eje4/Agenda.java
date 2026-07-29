package Eje4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Agenda {

    private ArrayList<Cita> citas;

    public Agenda() {
        this.citas = new ArrayList();
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
                     case 3 -> {Cita buscada = buscar();
                               buscada.mostrarCita();}
                     case 4 -> mostrar();
                     case 5 -> guardarRegistros();
                     case 6 -> recuperarRegistros();
                 }
                
            }catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine();
        } while(menu != 7);
    }
    
    public void registrar(){
        Cita cita = new Cita();
        citas.add(cita);
    }
    
    private void eliminar(){
        Cita buscada = buscar();
        if(buscada != null){
            citas.remove(buscada);
        }
    }
    
    public Cita buscar(){
        Scanner teclado = new Scanner(System.in);
        Cita buscada = null;
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
        
        if(citas.get(num-1) == null){
            System.out.println("No existe");
        }else{
            buscada = citas.get(num-1);
            buscada.mostrarCita();
        }
        return buscada;
    }
    
    public void mostrar(){
        for(Cita ci : citas){
            ci.mostrarCita();
            System.out.println("");
        }
    }
    
    //Serializacion
    public void guardarRegistros(){
        ObjectOutputStream ost = null;
         try {
            FileOutputStream f = new FileOutputStream("src/main/resources/citas.dat");
            ost = new ObjectOutputStream(f);
            ost.writeObject(citas);
            ost.flush();
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (ost != null) {
                try {
                    ost.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
    
    //Deserializacion
    public void recuperarRegistros(){
        ObjectInputStream ist = null;
        try {
            FileInputStream f = new FileInputStream("src/main/resources/citas.dat");
            ist = new ObjectInputStream(f);
            citas = (ArrayList<Cita>) ist.readObject();
            System.out.println(citas);
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            if (ist != null) {
                try {
                    ist.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
    
    
    }
