package Eje5;

import java.util.ArrayList;
import java.util.Scanner;

/*Se desea diseñar un programa para registrar y persistir en archivos la información de las reservas de una empresa dedicada al alquiler de automóviles, teniendo en cuenta que:

De cada cliente se desean almacenar su DNI, nombre y apellido, dirección y teléfono. Además dos clientes se diferencian por un código único.

Un determinado cliente puede tener en un momento dado hechas varias reservas.

Una reserva la realiza un único cliente pero puede involucrar varios autos.

Es importante registrar la fecha de inicio y final de la reserva, el precio del alquiler de cada uno de los autos, el precio total de la reserva y un indicador de si el auto o los autos han sido entregados.

De cada auto se requiere la matricula, la marca, el modelo, el color y las plazas (cantidad de personas que puede transportar).*/

public class Main {
     public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Auto> autos = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();

        // ---------- Carga de clientes ----------
        System.out.println("===== CARGA DE CLIENTES =====");
        boolean seguir = true;
        while (seguir) {
            Cliente c = IngresoClientes.leer(teclado);
            clientes.add(c);
            System.out.println("Cliente cargado con código: " + c.getCodigo());

            System.out.print("¿Desea cargar otro cliente? (s/n): ");
            seguir = teclado.nextLine().equalsIgnoreCase("s");
        }

        // ---------- Carga de autos ----------
        System.out.println("\n===== CARGA DE AUTOS =====");
        seguir = true;
        while (seguir) {
            Auto a = IngresoAuto.leer(teclado);
            autos.add(a);
            System.out.println("Auto cargado: " + a.getMatricula());

            System.out.print("¿Desea cargar otro auto? (s/n): ");
            seguir = teclado.nextLine().equalsIgnoreCase("s");
        }

        // ---------- Carga de reservas ----------
        System.out.println("\n===== CARGA DE RESERVAS =====");
        seguir = true;
        while (seguir) {
            Reserva r = IngresoReserva.leer(teclado, clientes, autos);
            if (r != null) {
                reservas.add(r);
                System.out.println("Reserva cargada con código: " + r.getCodigo() +
                        " - Precio total: $" + r.getPrecioTotal());
            } else {
                System.out.println("No se pudo cargar la reserva.");
            }

            System.out.print("¿Desea cargar otra reserva? (s/n): ");
            seguir = teclado.nextLine().equalsIgnoreCase("s");
        }

        // ---------- Guardado en archivos de texto ----------
        Persistencia.guardar(clientes, autos, reservas);

        teclado.close();
    }
    }


