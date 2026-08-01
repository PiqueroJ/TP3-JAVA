package Eje5;

import java.io.Serializable;
import java.util.Objects;

public class Auto implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int plazas;

    public Auto(String matricula, String marca, String modelo, String color, int plazas) {
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("La matrícula no puede estar vacía.");
        }
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca no puede estar vacía.");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        }
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("El color no puede estar vacío.");
        }
        if (plazas < 1 || plazas > 6) {
            throw new IllegalArgumentException("Las plazas ingresadas son inválidas.");
        }

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.plazas = plazas;
    }


    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public int getPlazas() { return plazas; }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return matricula.equals(auto.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Auto: " +
                "matricula= " + matricula + '\'' +
                ", marca= " + marca + '\'' +
                ", modelo= " + modelo + '\'' +
                ", color= " + color + '\'' +
                ", plazas= " + plazas ;
    }
}