package Controlador;

import java.util.ArrayList;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Persona;

public class Conector implements IConector {

    private final ControlPersona controlPersona;
    private final ControlEquipo controlEquipo;
    private final ArrayList<Equipo> equipos = new ArrayList<>();
    private final ArrayList<Persona> capitanes = new ArrayList<>();

    public Conector() {
        controlPersona = new ControlPersona();
        controlEquipo = new ControlEquipo();
    }

    @Override
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    @Override
    public void eliminarEquipo(Equipo equipo) {
        if (equipo == null) {
            throw new IllegalArgumentException("Equipo no puede ser nulo");
        }
        equipos.remove(equipo);
    }

    @Override
    public Persona crearJugadorConector(String nombre, int edad, long cedula, int posicionEnEquipo) {
        // Validación de parámetros
        if (nombre == null || nombre.isEmpty() || edad <= 0 || cedula <= 0 || posicionEnEquipo <= 0) {
            throw new IllegalArgumentException("Parámetros inválidos para crear jugador");
        }
        return controlPersona.crearJugador(nombre, edad, cedula, posicionEnEquipo);
    }

    @Override
    public Persona crearCapitanConector(String nombre, int edad, long cedula, int exp, int idCapitan) {
        // Validación de parámetros
        if (nombre == null || nombre.isEmpty() || edad <= 0 || cedula <= 0 || exp < 0 || idCapitan <= 0) {
            throw new IllegalArgumentException("Parámetros inválidos para crear capitán");
        }
        return controlPersona.crearCapitan(nombre, edad, cedula, exp, idCapitan);
    }

    @Override
    public Persona crearJuezConector(String nombre, int edad, long cedula, long tarjetaProfesional) {
        // Validación de parámetros
        if (nombre == null || nombre.isEmpty() || edad <= 0 || cedula <= 0 || tarjetaProfesional <= 0) {
            throw new IllegalArgumentException("Parámetros inválidos para crear juez");
        }
        return controlPersona.crearJuez(nombre, edad, cedula, tarjetaProfesional);
    }

    @Override
    public void crearEquipoConector(String nombre, int id, Jugador[] jugadores) {
        if (nombre == null || nombre.isEmpty() || id <= 0 || jugadores == null || jugadores.length == 0) {
            throw new IllegalArgumentException("Parámetros inválidos para crear equipo");
        }
        Equipo equipo = controlEquipo.crearEquipo(nombre, id);
        controlEquipo.agregarJugadoresEquipo(equipo, jugadores);
        equipos.add(equipo);  // Verificar si este método está siendo llamado correctamente
    }

    @Override
    public void agregarCapitanConector(Persona capitan) {
        if (capitan == null) {
            throw new IllegalArgumentException("Capitán no puede ser nulo");
        }
        capitanes.add(capitan);
    }

    @Override
    public ArrayList<Persona> getCapitanes() {
        return new ArrayList<>(capitanes); // Devolver una copia para evitar modificaciones externas
    }

}

