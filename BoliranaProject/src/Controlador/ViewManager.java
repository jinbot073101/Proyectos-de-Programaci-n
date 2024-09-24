package Controlador;

import vista.*;

import java.awt.event.ActionListener;

public class ViewManager {
    private final Menu menu;
    private final Tablero tablero;
    private final Validacion validacion;
    private final Mensaje mensaje;
    private final RegistrarJugador registrarJugadorVista;
    private final RegistrarCapitan registrarCapitanVista;
    private final RegistrarJuez registrarJuezVista;

    public ViewManager() {
        menu = new Menu();
        tablero = new Tablero();
        validacion = new Validacion();
        mensaje = new Mensaje();
        registrarJugadorVista = new RegistrarJugador();
        registrarCapitanVista = new RegistrarCapitan();
        registrarJuezVista = new RegistrarJuez();
    }

    public void gestionarVentanasMenu(ActionListener registrarListener, ActionListener comenzarJuegoListener) {
        menu.setBotonRegistrarListener(registrarListener);
        menu.setComenzarJuegoListener(comenzarJuegoListener);
    }

    public Menu getMenu() {
        return menu;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Validacion getValidacion() {
        return validacion;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public RegistrarJugador getRegistrarJugadorVista() {
        return registrarJugadorVista;
    }

    public RegistrarCapitan getRegistrarCapitanVista() {
        return registrarCapitanVista;
    }

    public RegistrarJuez getRegistrarJuezVista() {
        return registrarJuezVista;
    }
}