package controlador;

import modelo.*;
import java.util.ArrayList;

public class Conector {

    private final ControlPersona controlPersona;
    private final ControlEquipo controlEquipo;
    private final ArrayList<Equipo> equipos = new ArrayList<>();
    private final ArrayList<Persona> capitanes = new ArrayList<>();

    public Conector() {
        controlPersona = new ControlPersona();
        controlEquipo = new ControlEquipo();
    }

    public Persona crearJugadorConector(String nombre, int edad, long cedula, int posicionEnEquipo) {
        return controlPersona.crearJugador(nombre, edad, cedula, posicionEnEquipo);
    }

    public Persona crearCapitanConector(String nombre, int edad, long cedula, int exp, int idCapitan) {
        return controlPersona.crearCapitan(nombre, edad, cedula, exp, idCapitan);
    }

    public Persona crearJuezConector(String nombre, int edad, long cedula, long tarjetaProfesional) {
        return controlPersona.crearJuez(nombre, edad, cedula, tarjetaProfesional);
    }

    public void crearEquipoConector(String nombre, int id, Jugador[] jugadores) {
        Equipo equipo = controlEquipo.crearEquipo(nombre, id);
        controlEquipo.agregarJugadoresEquipo(jugadores);
        equipos.add(equipo);
    }
    
    public void agregarCapitanConector(Persona capitan) {
        capitanes.add(capitan);
    }

    public void eliminarEquipo(Equipo equipo) {
        equipos.remove(equipo);
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public ArrayList<Persona> getCapitanes() {
        return capitanes;
    }
}
