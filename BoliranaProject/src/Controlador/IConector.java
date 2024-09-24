package Controlador;

import java.util.ArrayList;
import modelo.*;

public interface IConector {

    ArrayList<Equipo> getEquipos();
    void eliminarEquipo(Equipo equipo);
    Persona crearJugadorConector(String nombre, int edad, long cedula, int posicionEnEquipo);
    Persona crearCapitanConector(String nombre, int edad, long cedula, int exp, int idCapitan);
    Persona crearJuezConector(String nombre, int edad, long cedula, long tarjetaProfesional);
    public void crearEquipoConector(String nombre, int id, Jugador[] jugadores);
    void agregarCapitanConector(Persona capitan);
    ArrayList<Persona> getCapitanes();
    
    
}
