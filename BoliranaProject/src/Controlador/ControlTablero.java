package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
/**
 *
 * @author PC
 */
public class ControlTablero {

    private Random indiceRandom;
    private int puntajeObtenido;
    private final ControladorPrincipal gestor;

    public ControlTablero(ControladorPrincipal gestor) {
        this.gestor = gestor;
    }

    public void mostrarTablero() {
        gestor.getTablero().setVisible(true);
    }

    public int obtenerPuntajeDeLanzamiento() {
        indiceRandom = new Random();
        gestor.getTablero().setLanzarBotonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestor.getTablero().LanzarMasDeUnoSelected() || !gestor.getTablero().PosicionCorrectaSelected()) {
                    puntajeObtenido = 0;
                } else {
                    puntajeObtenido = indiceRandom.nextInt(gestor.devolverValoresCargados().length);
                }
            }
        });
        return puntajeObtenido;
    }

    public void setTurnoJugador(String nombre) {
        gestor.getTablero().mostrarTurnoJugador(nombre);
    }
    
    public int obtenerPuntajeMaximo(){
        return gestor.devolverPuntajeMaximo();
    }
}
