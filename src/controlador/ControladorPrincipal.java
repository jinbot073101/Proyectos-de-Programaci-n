package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import vista.*;

public class ControladorPrincipal {

    //variables de la clase
    InputStream entrada = null;
    Properties propiedades = new Properties();
    private int puntajeMaximo;
    private final int[] valoresCargados;
    //instancias de las vistas
    private final Menu menu;
    private final Tablero tablero;
    private final Validacion validacion;
    private final Mensaje mensaje;
    private final RegistrarJugador registrarJugadorVista;
    private final RegistrarCapitan registrarCapitanVista;
    private final RegistrarJuez registrarJuezVista;
    //alcance a los controladores
    private final ControlRegistro controlRegistro;
    private final ControlValidaciones controlValidaciones;

    //Constructor que me inicializa las instancias, carga el archivo properties y comienza con la gestion del menú
    public ControladorPrincipal() {
        this.controlRegistro = new ControlRegistro(this);
        this.controlValidaciones = new ControlValidaciones(this);
        valoresCargados = new int[12];
        registrarJugadorVista = new RegistrarJugador();
        registrarCapitanVista = new RegistrarCapitan();
        registrarJuezVista = new RegistrarJuez();
        tablero = new Tablero();
        validacion = new Validacion();
        mensaje = new Mensaje();
        menu = new Menu();
        cargarProperties();
        gestionarVentanasMenu();
    }

    //Carga los valores del juego desde un archivo .properties
    private void cargarProperties() {
        try {
            entrada = new FileInputStream("C:\\Users\\PC\\Documents\\NetBeansProjects\\Bolirana\\src\\data\\Puntos.properties");
            propiedades.load(entrada);
            puntajeMaximo = Integer.parseInt(propiedades.getProperty("puntajeMaximo"));
            valoresCargados[0] = Integer.parseInt(propiedades.getProperty("hueco1"));
            valoresCargados[1] = Integer.parseInt(propiedades.getProperty("hueco2"));
            valoresCargados[2] = Integer.parseInt(propiedades.getProperty("hueco3"));
            valoresCargados[3] = Integer.parseInt(propiedades.getProperty("hueco4"));
            valoresCargados[4] = Integer.parseInt(propiedades.getProperty("hueco5"));
            valoresCargados[5] = Integer.parseInt(propiedades.getProperty("hueco6"));
            valoresCargados[6] = Integer.parseInt(propiedades.getProperty("hueco7"));
            valoresCargados[7] = Integer.parseInt(propiedades.getProperty("hueco8"));
            valoresCargados[8] = Integer.parseInt(propiedades.getProperty("hueco9"));
            valoresCargados[9] = Integer.parseInt(propiedades.getProperty("hueco10"));
            valoresCargados[10] = Integer.parseInt(propiedades.getProperty("hueco11"));
            valoresCargados[11] = Integer.parseInt(propiedades.getProperty("hueco12"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Devuelve todos los valores cargados desde el archivo properties almacenados en un array
    public int[] devolverValoresCargados() {
        return valoresCargados;
    }

    //Devuelve el puntaje máximo cargado desde el archivo properties
    public int devolverPuntajeMaximo() {
        return puntajeMaximo;
    }

    //Devuelve las instancias de las vistas para que los controles a los que se le delega la lógica puedan acceder a elementos de las vistas
    public Tablero getTablero() {
        return tablero;
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

    public Validacion getValidacion() {
        return validacion;
    }

    // Gestión de la ventana del menú principal
    private void gestionarVentanasMenu() {
        this.menu.setBotonRegistrarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEquipo();
            }
        });

        this.menu.setComenzarJuegoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestionarComienzoJuego();
                } catch (IOException ex) {
                    
                }
            }
        });
    }

    //Delega responsabilidad a controlRegistro
    private void registrarEquipo() {
        controlRegistro.iniciarRegistroEquipo();
    }

    //Delega responsabilidad a controlValidaciones
    private void gestionarComienzoJuego() throws IOException {
        controlValidaciones.gestionarComienzoJuego();
    }
}
