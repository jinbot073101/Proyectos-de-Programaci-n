package edu.avanzada.talleravanzadosituacionmilitar.controlDatos;

import java.util.ArrayList;

import edu.avanzada.talleravanzadosituacionmilitar.modelo.Persona;

/**
 * Esta interfaz define los métodos que deben ser implementados por las clases encargadas
 * de gestionar y controlar los datos de personas en diferentes estados militares.
 */

public interface InterfaceControl {

    /**
     * Permite ingresar una persona con el número de cédula especificado.
     * 
     * @param cedula el número de cédula de la persona a ingresar.
     */

    public void ingresarPersona(int cedula);

     /**
     * Permite consultar los datos de una persona.
     * Este método debe buscar una persona en la lista y mostrar su información si se encuentra registrada.
     */

    public void consultarPersona();

    /**
     * Permite cambiar la situación militar de una persona.
     * Este método debe manejar la lógica para cambiar el estado militar de una persona registrada.
     */

    public void cambiarSituacion();

    /**
     * Muestra la lista completa de personas registradas.
     * Este método debe mostrar los datos de todas las personas en la lista.
     */

    public void mostrarArray();

    /**
     * Retorna la lista de personas almacenadas.
     * 
     * @return un {@link ArrayList} de {@link Persona} que contiene todas las personas registradas.
     */

    ArrayList<Persona> getLista();

}