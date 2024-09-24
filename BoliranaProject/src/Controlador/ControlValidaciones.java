package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipo;

public class ControlValidaciones {

    // Controladores con los que se comunica
    private final Conector conector;
    private final ControladorPrincipal gestor;
    private final ControlJuego controlJuego;
    private boolean condicion1;
    private boolean condicion2;

    public ControlValidaciones(ControladorPrincipal gestor, Conector conector) {
        controlJuego = new ControlJuego(gestor);
        this.conector = conector; 
        this.gestor = gestor;
    }

    public void gestionarComienzoJuego() throws IOException {
        System.out.println("Tamaño de la lista de equipos: " + conector.getEquipos().size()); // Debugging
        if (conector.getEquipos().size() >= 2) {
            gestor.getMensaje().requisitos();
            // Verificar las condiciones antes de iniciar el juego
            if (validarCondicionesPreJuego()) {
                controlJuego.iniciarJuego();
            } else {
                gestor.getMensaje().validacionIncompleta(); // Mensaje en caso de que no se cumplan las condiciones
            }
        } else {
            gestor.getMensaje().noCumpleRequisito(); // No hay suficientes equipos registrados
        }
    }

    private boolean validarCondicionesPreJuego() {
        condicion1 = true;
        condicion2 = true;
        gestor.getValidacion().setVisible(true);
        // Validar si todos los equipos están presentes
        if (!gestor.getValidacion().setEquipoPresenteSi()) {
            gestor.getValidacion().mostrarCampoEquipo(true);
            buscarEquipoFaltante(true);
            condicion1 = false;
            return false; // Detener el flujo para esperar la intervención del usuario
        }
        // Validar si los equipos están completos
        gestor.getValidacion().mostrarSegundaPregunta(true);
        if (!gestor.getValidacion().setEquipoCompletoSi()) {
            gestor.getValidacion().mostrarCampoEquipo(true);
            buscarEquipoFaltante(false);
            condicion2 = false;
            return false; // Detener el flujo para esperar la intervención del usuario
        }
        return condicion1 || condicion2;
    }

    private void descalificarEquipo(String eliminado) {
        for (Equipo equipo : conector.getEquipos()) {
            if (equipo.getNombreEquipo().equalsIgnoreCase(eliminado)) {
                conector.eliminarEquipo(equipo);
                gestor.getMensaje().equipoEliminado(eliminado);
                break;
            }
        }
    }

    private void buscarEquipoFaltante(boolean esPrimeraPregunta) {
        gestor.getValidacion().setBotonAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipoFaltante = gestor.getValidacion().getTextoEquipo();
                if (conector.getEquipos().size() > 2) {
                    descalificarEquipo(equipoFaltante);
                    if (esPrimeraPregunta) {
                        condicion1 = false;
                        gestor.getValidacion().mostrarSegundaPregunta(true);
                    } else {
                        condicion2 = false;
                    }
                    gestor.getValidacion().ocultarCampos();
                } else {
                    descalificarEquipo(equipoFaltante);
                    Equipo ganador = conector.getEquipos().remove(0);
                    gestor.getMensaje().errorAlDescalificarEquipo();
                    try {
                        ControlJuego.seleccionarGanador(ganador);
                    } catch (IOException ex) {
                        Logger.getLogger(ControlValidaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
}