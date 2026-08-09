package Eje7;

import java.util.Scanner;

public class TaTeTi {
    
    private static int numFila = 3;
    private static int numColumna = 3;
    private static int puntoJ1 = 1;
    private static int puntoJ2 = 5;
    private static int MaxJugadas = 9;
    
    private int[][] matriz;
    
    public TaTeTi(){
        matriz = new int[numFila][numColumna];
        for (int i = 0; i < numFila; i++) {
            for (int j = 0; j < numColumna; j++) {
                matriz[i][j] = 0;
            }
        }
    }
    
    public void jugar(){
        Scanner teclado = new Scanner(System.in);
        boolean resultado = false;
        int fila = 0;
        int columna = 0;
        int jugadas = 0;

        mostrarMatriz();
        //Usar 0/1/2 para marcar fila o colmna
        
        do{ 
 
       boolean marcado = false;
           do{
            try{
        System.out.println("\n Juagador 1 Ingrese Fila: ");
        fila = Integer.parseInt(teclado.nextLine());
        System.out.println("\n Juagador 1 Ingrese Columna: ");
        columna = Integer.parseInt(teclado.nextLine());
        
        marcarCasilla(fila, columna, puntoJ1);
        marcado = true;
        
        }catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage() + ". Intente de nuevo.");
         }
          }while(!marcado);
          
          mostrarMatriz();
          resultado = revisarResultado();
          jugadas++;
          
          if(resultado){
              System.out.println("\n Juagador 1 GANA \n");
          }else if(jugadas < MaxJugadas){
              
          marcado = false;
          do{
            try{
             System.out.println("\n Juagador 2 Ingrese Fila: ");
             fila = Integer.parseInt(teclado.nextLine());
             System.out.println("\n Juagador 2 Ingrese Columna: ");
             columna = Integer.parseInt(teclado.nextLine());
        
           marcarCasilla(fila, columna, puntoJ2);
           marcado = true;
        
        }catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage() + ". Intente de nuevo.");
         }
          }while(!marcado);
          
          mostrarMatriz();
          resultado = revisarResultado();
          jugadas++;
          
          if(resultado){
              System.out.println("\n Juagador 2 GANA \n");
          }
          }
          
        }while(!resultado && jugadas < MaxJugadas);
        
        if(!resultado && jugadas == MaxJugadas){
            System.out.println("\n = EMPATE =");
        }
        
    }
    
    public void mostrarMatriz(){
        for (int i = 0; i < numFila; i++) {
            for (int j = 0; j < numColumna; j++) {
                System.out.printf(" | " + matriz[i][j] + " | ");
            }
                System.out.printf("\n");
            }
    }
    
    public void marcarCasilla(int fila, int columna, int jugador) {
    if(fila < 0 || fila > 2 || columna < 0 || columna > 2){
        throw new IllegalArgumentException("Numero de fila//columna invalido");
    }
    if (matriz[fila][columna] != 0) {
        throw new IllegalArgumentException("La casilla ya está ocupada");
    }
    matriz[fila][columna] = jugador;
}
    
    public boolean revisarResultado(){
    for (int i = 0; i < 3; i++) {

        if (matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][0] != 0) {
            return true;
        }

        if (matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i] && matriz[0][i] != 0) {
            return true;
        }
    }

    if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] != 0) {
        return true;
    }
    if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] != 0) {
        return true;
    }

    return false;
    }
    
    
}
