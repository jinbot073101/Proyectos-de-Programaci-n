package Controlador;

import java.io.IOException;

import vista.Mensaje;
import vista.RegistrarCapitan;
import vista.RegistrarJuez;
import vista.RegistrarJugador;
import vista.Tablero;
import vista.Validacion;

public class ControladorPrincipal {

    private final PropertyLoader propertyLoader;
    private final ViewManager viewManager;
    private final ControlRegistro controlRegistro;
    private final ControlValidaciones controlValidaciones;
    private final Conector conector;

    public ControladorPrincipal() {
        propertyLoader = new PropertyLoader();
        viewManager = new ViewManager();
        conector = new Conector();
        controlRegistro = new ControlRegistro(this, conector);
        controlValidaciones = new ControlValidaciones(this, conector);
        propertyLoader.cargarProperties("C:\\Users\\PC\\Documents\\NetBeansProjects\\Bolirana\\src\\data\\Puntos.properties");
        gestionarVentanasMenu();
    }

    private void gestionarVentanasMenu() {
        viewManager.gestionarVentanasMenu(
            e -> registrarEquipo(),
            e -> {
                try {
                    gestionarComienzoJuego();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        );
    }

    private void registrarEquipo() {
        controlRegistro.iniciarRegistroEquipo();
    }

    private void gestionarComienzoJuego() throws IOException {
        controlValidaciones.gestionarComienzoJuego();
    }

    public int[] devolverValoresCargados() {
        return propertyLoader.devolverValoresCargados();
    }

    public int devolverPuntajeMaximo() {
        return propertyLoader.devolverPuntajeMaximo();
    }

    public Tablero getTablero() {
        return viewManager.getTablero();
    }

    public Mensaje getMensaje() {
        return viewManager.getMensaje();
    }

    public RegistrarJugador getRegistrarJugadorVista() {
        return viewManager.getRegistrarJugadorVista();
    }

    public RegistrarCapitan getRegistrarCapitanVista() {
        return viewManager.getRegistrarCapitanVista();
    }

    public RegistrarJuez getRegistrarJuezVista() {
        return viewManager.getRegistrarJuezVista();
    }

    public Validacion getValidacion() {
        return viewManager.getValidacion();
    }
}
