package modelo;

import java.io.Serializable;

public class Jugador extends Persona implements Serializable {
    
    private int posicionEnEquipo;
    private int puntaje;
    private int cantidadBalines;

    @Override
    public String getEstado() {
        return super.getEstado(); }    

    public Jugador(String nombre, int edad, long cedula, int posicionEnEquipo) {
        super(nombre, edad, cedula);
        this.posicionEnEquipo=posicionEnEquipo;
    }

    public int getPosicionEnEquipo() {
        return posicionEnEquipo;
    }

    public void setPosicionEnEquipo(int posicionEnEquipo) {
        this.posicionEnEquipo = posicionEnEquipo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public int getCantidadBalines() {
        return cantidadBalines;
    }

    public void setCantidadBalines(int cantidadBalines) {
        this.cantidadBalines = cantidadBalines;
    }
}
