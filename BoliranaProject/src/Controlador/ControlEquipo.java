package Controlador;

import modelo.Equipo;
import modelo.Jugador;

public class ControlEquipo {
    public Equipo crearEquipo(String nombre, int id) {
        // Validación de parámetros
        if (nombre == null || nombre.isEmpty() || id <= 0) {
            throw new IllegalArgumentException("Ejemplo de mensaje de error");
        }
        Equipo equipo = new Equipo(); // Crear una nueva instancia de Equipo
        equipo.setNombreEquipo(nombre);
        equipo.setIdEquipo(id);
        return equipo;
    }

    public void agregarJugadoresEquipo(Equipo equipo, Jugador[] jugadores) {
        // Validación de parámetros
        if (equipo == null || jugadores == null || jugadores.length == 0) {
            throw new IllegalArgumentException("Ejemplo de mensaje de error");
        }
        equipo.setJugadores(jugadores);
    }
}
