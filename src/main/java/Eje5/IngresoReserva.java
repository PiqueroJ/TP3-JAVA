package Eje5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class IngresoReserva {

    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy");

    public static Reserva leer(Scanner teclado, ArrayList<Cliente> clientes, ArrayList<Auto> autos) {
        System.out.println("Ingreso de Reserva: ");

        Cliente cliente = seleccionarCliente(teclado, clientes);
        if (cliente == null) return null;

        Reserva reserva = null;
        while (reserva == null) {
            try {
                FORMATO_FECHA.setLenient(false);

                System.out.print("Ingrese fecha de inicio (dd/MM/yyyy): ");
                Date fechaInicio = FORMATO_FECHA.parse(teclado.nextLine());

                System.out.print("Ingrese fecha de fin (dd/MM/yyyy): ");
                Date fechaFin = FORMATO_FECHA.parse(teclado.nextLine());

                reserva = new Reserva(cliente, fechaInicio, fechaFin);

            } catch (ParseException e) {
                System.out.println("Error: formato de fecha inválido. Use dd/MM/yyyy.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
        }

        boolean agregarMas = true;
        while (agregarMas) {
            Auto auto = seleccionarAuto(teclado, autos);
            if (auto == null) break;

            try {
                System.out.print("Ingrese el precio del alquiler para ese auto: ");
                float precio = Float.parseFloat(teclado.nextLine());

                reserva.agregarAuto(auto, precio);

            } catch (NumberFormatException e) {
                System.out.println("Error: el precio debe ser un número.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }

            System.out.print("¿Desea agregar otro auto a la reserva? (s/n): ");
            String resp = teclado.nextLine();
            agregarMas = resp.equalsIgnoreCase("s");
        }

        return reserva;
    }

    private static Cliente seleccionarCliente(Scanner teclado, ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes cargados.");
            return null;
        }

        for (Cliente c : clientes) {
            System.out.println(c.getCodigo() + " - " + c.getNombre() + " " + c.getApellido());
        }

        while (true) {
            try {
                System.out.print("Ingrese el código del cliente: ");
                int codigo = Integer.parseInt(teclado.nextLine());

                for (Cliente c : clientes) {
                    if (c.getCodigo() == codigo) return c;
                }
                System.out.println("Cliente no encontrado. Intente nuevamente.");

            } catch (NumberFormatException e) {
                System.out.println("Error: el código debe ser un número.");
            }
        }
    }

    private static Auto seleccionarAuto(Scanner teclado, ArrayList<Auto> autos) {
        if (autos.isEmpty()) {
            System.out.println("No hay autos cargados.");
            return null;
        }

        for (Auto a : autos) {
            System.out.println(a.getMatricula() + " - " + a.getMarca() + " " + a.getModelo());
        }

        System.out.print("Ingrese la matrícula del auto (vacío para terminar): ");
        String matricula = teclado.nextLine();
        if (matricula.isBlank()) return null;

        for (Auto a : autos) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) return a;
        }

        System.out.println("Auto no encontrado.");
        return null;
    }
}