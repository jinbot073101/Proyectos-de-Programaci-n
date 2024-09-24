package modelo;

import java.io.Serializable;

public class Juez extends Persona implements Serializable{

    private long numeroTarjetaProfesional;

    public Juez(String nombre, int edad, long cedula, long numeroTarjetaProfesional) {
        super(nombre, edad, cedula);
        this.numeroTarjetaProfesional = numeroTarjetaProfesional;
    }

    public long getNumeroTarjetProfesional() {
        return numeroTarjetaProfesional;
    }

    public void setNumeroTarjetaProfesional(long numeroTarjetaProfesional) {
        this.numeroTarjetaProfesional = numeroTarjetaProfesional;
    }

}
