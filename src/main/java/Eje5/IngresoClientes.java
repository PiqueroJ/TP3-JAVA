package Eje5;

import java.util.Scanner;

public class IngresoClientes {
    public static Cliente leer(Scanner teclado) {
        System.out.println("Ingreso de Clientes: ");
        while (true) {
            try {
                System.out.print("Ingrese el DNI: ");
                int dni = Integer.parseInt(teclado.nextLine());

                System.out.print("Ingrese el nombre: ");
                String nombre = teclado.nextLine();

                System.out.print("Ingrese el apellido: ");
                String apellido = teclado.nextLine();

                System.out.print("Ingrese la dirección: ");
                String direccion = teclado.nextLine();

                System.out.print("Ingrese el teléfono: ");
                String telefono = teclado.nextLine();

                return new Cliente(dni, nombre, apellido, direccion, telefono);

            } catch (NumberFormatException e) {
                System.out.println("Error: el DNI debe ser un número. Intente nuevamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
        }
    }
}