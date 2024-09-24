package controlador;

import modelo.*;

public class ControlEquipo {

    private final Equipo equipo = new Equipo();

    public Equipo crearEquipo(String nombre, int id) {
        equipo.setNombreEquipo(nombre);
        equipo.getIdEquipo();
        return equipo;
    }
    
    public void agregarJugadoresEquipo(Jugador[] personas) {
        equipo.setJugadores(personas);
    }

}
