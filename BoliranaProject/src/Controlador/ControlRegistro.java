package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import herramienta.Servicios;
import modelo.Jugador;
import modelo.Persona;

public class ControlRegistro {

    private final ControladorPrincipal gestor;
    private int contJugadores;
    private int cantidadJugadores;
    private final Jugador[] jugadoresTemporales;
    private final Conector conector;
    private int identificador;
    private boolean juezCreado;

    public ControlRegistro(ControladorPrincipal gestor, Conector conector) {
        juezCreado = false;
        this.gestor = gestor;
        this.conector = conector;
        this.jugadoresTemporales = new Jugador[5];// Inicializar el array para jugadores
    }

    public void iniciarRegistroEquipo() {
        if (!juezCreado) {
            gestor.getMensaje().noJuecesRegistrado();
            registroJuez();
        } else {
            comienzoRegistro();
        }
    }

    private void comienzoRegistro() {
        if (identificador == 0) {
            identificador = 1;
        }
        gestor.getMensaje().informeIngresoCapitan();
        gestor.getRegistrarCapitanVista().setVisible(true);
        gestor.getRegistrarCapitanVista().setRegistrarCapitan(null);// Limpia el ActionListener anterior
        // >>REGISTRAR CAPITAN<<
        gestor.getRegistrarCapitanVista().setRegistrarCapitan(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = gestor.getRegistrarCapitanVista().obtenerNombrePersona();
                try {
                    String strEdad = Integer.toString(gestor.getRegistrarCapitanVista().obtenerEdadPersona());
                    String strCedula = Integer.toString(gestor.getRegistrarCapitanVista().obtenerCedulaPersona());
                    String strExp = Integer.toString(gestor.getRegistrarCapitanVista().obtenerExperienciaCapitan());

                    if (strExp.isBlank() || Servicios.verificarCamposVacios(nombre, strEdad, strCedula)
                            || Servicios.verificarCamposEnCero(nombre, strEdad, strCedula)) {
                        gestor.getMensaje().datosIncompletos();
                    } else {
                        int edad = gestor.getRegistrarCapitanVista().obtenerEdadPersona();
                        long cedula = gestor.getRegistrarCapitanVista().obtenerCedulaPersona();
                        int exp = gestor.getRegistrarCapitanVista().obtenerExperienciaCapitan();
                        Persona capitan = conector.crearCapitanConector(nombre, edad, cedula, exp, identificador);
                        conector.agregarCapitanConector(capitan);
                        gestor.getMensaje().ingresoCapitan();
                        gestor.getRegistrarCapitanVista().limpiarCampos();
                        gestor.getRegistrarCapitanVista().setVisible(false);
                        do {
                            String consulta = gestor.getMensaje().preguntarCantidadDeJugadores();
                            cantidadJugadores = Integer.parseInt(consulta);
                            if (cantidadJugadores > 0 && cantidadJugadores <= 5) {
                                contJugadores = 0;
                                registrarJugador();
                                break;
                            } else {
                                gestor.getMensaje().cantidadDeJugadoresIncorrecta();
                            }
                        } while (0 < cantidadJugadores && cantidadJugadores <= 5);
                    }
                } catch (Exception ex) {
                    gestor.getRegistrarCapitanVista().limpiarCampos();
                    gestor.getMensaje().manejarError();
                }
            }
        });
    }

    private void registrarJugador() {
        if (contJugadores < cantidadJugadores) {
            gestor.getRegistrarJugadorVista().setVisible(true);
            gestor.getRegistrarJugadorVista().setRegistrarJugador(null);// Limpia el ActionListener anterior
            // >>REGISTRAR JUGADOR<<
            gestor.getRegistrarJugadorVista().setRegistrarJugador(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nombre = gestor.getRegistrarJugadorVista().obtenerNombrePersona();
                    try {
                        String strEdad = Integer.toString(gestor.getRegistrarJugadorVista().obtenerEdadPersona());
                        String strCedula = Integer.toString(gestor.getRegistrarJugadorVista().obtenerCedulaPersona());
                        String strPosicion = Integer
                                .toString(gestor.getRegistrarJugadorVista().obtenerPosicionJugador());
                        if (strPosicion.isBlank() || Servicios.verificarCamposVacios(nombre, strEdad, strCedula)
                                || Servicios.verificarCamposEnCero(nombre, strEdad, strCedula)) {
                            gestor.getMensaje().datosIncompletos();
                        } else {
                            int edad = gestor.getRegistrarJugadorVista().obtenerEdadPersona();
                            long cedula = gestor.getRegistrarJugadorVista().obtenerCedulaPersona();
                            int posicion = gestor.getRegistrarJugadorVista().obtenerPosicionJugador();
                            Persona jugador = conector.crearJugadorConector(nombre, edad, cedula, posicion);
                            jugadoresTemporales[contJugadores] = (Jugador) jugador;
                            gestor.getMensaje().ingresoJugador(contJugadores);
                            gestor.getRegistrarJugadorVista().limpiarCampos();
                            gestor.getRegistrarJugadorVista().setVisible(false);// reiniciar la vista
                            contJugadores++; // Incrementar contador
                            registrarJugador(); // Llamar de nuevo hasta completar los jugadores
                        }
                    } catch (Exception ex) {
                        gestor.getRegistrarJugadorVista().limpiarCampos();
                    }
                }
            });
        } else {
            gestor.getMensaje().jugadoresIngresados();
            String nombreEquipo = gestor.getMensaje().preguntarNombreDelEquipo();
            conector.crearEquipoConector(nombreEquipo, identificador, jugadoresTemporales);
            System.out.println(conector.getEquipos());
            System.out.println("Tamaño de la lista de equipos: " + conector.getEquipos().size()); // Debugging
            gestor.getRegistrarJugadorVista().setVisible(false);
            identificador++;
        }
    }

    private void registroJuez() {
        gestor.getRegistrarJuezVista().setVisible(true);
        // >>REGISTRAR JUEZ<<
        this.gestor.getRegistrarJuezVista().setJuez(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = gestor.getRegistrarJuezVista().obtenerNombrePersona();
                try {
                    String strEdad = Integer.toString(gestor.getRegistrarJuezVista().obtenerEdadPersona());
                    String strCedula = Integer.toString(gestor.getRegistrarJuezVista().obtenerCedulaPersona());
                    String strTarjetaProfesional = Integer
                            .toString(gestor.getRegistrarJuezVista().obtenerTarjetaProfesional());
                    if (strTarjetaProfesional.isBlank() || Servicios.verificarCamposVacios(nombre, strEdad, strCedula)
                            || Servicios.verificarCamposEnCero(nombre, strEdad, strCedula)) {
                        gestor.getMensaje().datosIncompletos();
                    } else {
                        int edad = gestor.getRegistrarJuezVista().obtenerEdadPersona();
                        long cedula = gestor.getRegistrarJuezVista().obtenerCedulaPersona();
                        int tarjetaProfesional = gestor.getRegistrarJuezVista().obtenerTarjetaProfesional();
                        // falta guardar el juez en alguna parte
                        conector.crearJuezConector(nombre, edad, cedula, tarjetaProfesional);
                        juezCreado = true;
                        gestor.getMensaje().ingresoJuez();
                        gestor.getRegistrarJuezVista().limpiarCampos();
                        gestor.getRegistrarJuezVista().setVisible(false);
                        comienzoRegistro();
                    }
                } catch (Exception ex) {
                    gestor.getRegistrarJuezVista().limpiarCampos();
                }
            }
        });
    }
}
