package Eje5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Persistencia {

    private static final String ARCHIVO_CLIENTES = "clientes.txt";
    private static final String ARCHIVO_AUTOS = "autos.txt";
    private static final String ARCHIVO_RESERVAS = "reservas.txt";
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy");

    public static void guardar(ArrayList<Cliente> clientes, ArrayList<Auto> autos, ArrayList<Reserva> reservas) {
        guardarClientes(clientes);
        guardarAutos(autos);
        guardarReservas(reservas);
        System.out.println("Datos guardados correctamente.");
    }

    private static void guardarClientes(ArrayList<Cliente> clientes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_CLIENTES))) {
            for (Cliente c : clientes) {
                pw.println(c.getCodigo() + ";" + c.getDni() + ";" + c.getNombre() + ";" +
                        c.getApellido() + ";" + c.getDireccion() + ";" + c.getTelefono());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }

    private static void guardarAutos(ArrayList<Auto> autos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_AUTOS))) {
            for (Auto a : autos) {
                pw.println(a.getMatricula() + ";" + a.getMarca() + ";" + a.getModelo() + ";" +
                        a.getColor() + ";" + a.getPlazas());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar autos: " + e.getMessage());
        }
    }

    private static void guardarReservas(ArrayList<Reserva> reservas) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_RESERVAS))) {
            for (Reserva r : reservas) {
                StringBuilder autosStr = new StringBuilder();
                for (Auto auto : r.getAutos()) {
                    if (autosStr.length() > 0) autosStr.append(",");
                    autosStr.append(auto.getMatricula()).append(":")
                            .append(r.getPrecio(auto)).append(":")
                            .append(r.isEntregado(auto));
                }

                pw.println(r.getCodigo() + ";" +
                        r.getCliente().getCodigo() + ";" +
                        FORMATO_FECHA.format(r.getFechaInicio()) + ";" +
                        FORMATO_FECHA.format(r.getFechaFin()) + ";" +
                        autosStr);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar reservas: " + e.getMessage());
        }
    }
}