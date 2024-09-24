package controlador;

import modelo.*;

public class ControlPersona {

    public Persona crearJugador(String nombre, int edad, long cedula, int posicionEnEquipo) {
        Persona jugador = new Jugador(nombre, edad, cedula, posicionEnEquipo);
        return jugador;
    }

    public Persona crearCapitan(String nombre, int edad, long cedula, int exp, int idCapitan) {
        Persona capitan = new Capitan(nombre, edad, cedula, exp, idCapitan);
        return capitan;
    }

    public Persona crearJuez(String nombre, int edad, long cedula, long numeroTarjetaProfesional) {
        Persona juez = new Juez(nombre, edad, cedula, numeroTarjetaProfesional);
        return juez;
    }
}
