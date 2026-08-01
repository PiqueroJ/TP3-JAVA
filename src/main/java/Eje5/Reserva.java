package Eje5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Reserva implements Serializable {

    private static int contador = 0;

    private final int codigo;
    private Date fechaInicio;
    private Date fechaFin;
    private Cliente cliente;
    private ArrayList<Auto> autos;
    private ArrayList<Float> precios;      // precios[i] es el precio de autos[i]
    private ArrayList<Boolean> entregados; // entregados[i] indica si autos[i] fue entregado

    public Reserva(Cliente cliente, Date fechaInicio, Date fechaFin) {
        if (cliente == null) {
            throw new IllegalArgumentException("La reserva debe tener un cliente.");
        }
        if (fechaInicio == null || fechaFin == null || fechaFin.before(fechaInicio)) {
            throw new IllegalArgumentException("Las fechas de la reserva son inválidas.");
        }
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.autos = new ArrayList<>();
        this.precios = new ArrayList<>();
        this.entregados = new ArrayList<>();
        this.codigo = contador++;
    }

    public void agregarAuto(Auto auto, float precio) {
        if (auto == null) {
            throw new IllegalArgumentException("El auto no puede ser nulo.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        if (autos.contains(auto)) {
            throw new IllegalArgumentException("Ese auto ya está en la reserva.");
        }
        autos.add(auto);
        precios.add(precio);
        entregados.add(false);
    }

    public void marcarEntregado(Auto auto) {
        int i = autos.indexOf(auto);
        if (i == -1) {
            throw new IllegalArgumentException("Ese auto no pertenece a la reserva.");
        }
        entregados.set(i, true);
    }

    public boolean estaEntregada() {
        for (boolean b : entregados) {
            if (!b) return false;
        }
        return true;
    }

    public float getPrecioTotal() {
        float total = 0;
        for (float precio : precios) {
            total += precio;
        }
        return total;
    }

    public float getPrecio(Auto auto) {
        int i = autos.indexOf(auto);
        if (i == -1) {
            throw new IllegalArgumentException("Ese auto no pertenece a la reserva.");
        }
        return precios.get(i);
    }

    public boolean isEntregado(Auto auto) {
        int i = autos.indexOf(auto);
        if (i == -1) {
            throw new IllegalArgumentException("Ese auto no pertenece a la reserva.");
        }
        return entregados.get(i);
    }

    public int getCodigo() { return codigo; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public Cliente getCliente() { return cliente; }
    public ArrayList<Auto> getAutos() { return autos; }

    public static void ajustarContador(int ultimoCodigo) {
        if (ultimoCodigo >= contador) {
            contador = ultimoCodigo + 1;
        }
    }

    @Override
    public String toString() {
        return "Reserva: " +
                "codigo = " + codigo +
                ", cliente = " + cliente.getNombre() + " " + cliente.getApellido() +
                ", fechaInicio = " + fechaInicio +
                ", fechaFin = " + fechaFin +
                ", precioTotal = " + getPrecioTotal() +
                ", autos = " + autos.size() ;
    } 
}
