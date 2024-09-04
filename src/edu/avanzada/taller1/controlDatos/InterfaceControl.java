package edu.avanzada.taller1.controlDatos;

import java.util.ArrayList;

import edu.avanzada.taller1.modelo.Persona;

public interface InterfaceControl {

    public void ingresarPersona(int cedula);

    public void consultarPersona();

    public void cambiarSituacion();

    ArrayList<Persona> getLista();

}