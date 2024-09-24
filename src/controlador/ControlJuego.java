package controlador;

import java.io.IOException;
import java.util.Random;
import modelo.*;

public class ControlJuego {

    private final Conector conector;
    private final Random selector;
    private final ControlTablero controlTablero;

    public ControlJuego(ControladorPrincipal gestor) {
        conector = new Conector();
        controlTablero = new ControlTablero(gestor);
        selector = new Random();
    }

    public void iniciarJuego() throws IOException {

        controlTablero.mostrarTablero();
        // Selección aleatoria de equipos
        int equipoSeleccionado1 = selector.nextInt(conector.getEquipos().size());
        int equipoSeleccionado2;
        //Obtiene un segundo equipo diferente al primero
        do {
            equipoSeleccionado2 = selector.nextInt(conector.getEquipos().size());
        } while (equipoSeleccionado1 == equipoSeleccionado2);
        Equipo equipo1 = conector.getEquipos().get(equipoSeleccionado1);
        Equipo equipo2 = conector.getEquipos().get(equipoSeleccionado2);
        // Obtener los jugadores de los equipos
 
        Jugador[] jugadoresEquipo1 = (Jugador[]) equipo1.getJugadores();
        Jugador[] jugadoresEquipo2 = (Jugador[]) equipo2.getJugadores();
        int puntajeEquipo1 = 0;
        int puntajeEquipo2 = 0;
        int condicionDeJuego = controlTablero.obtenerPuntajeMaximo();

        boolean juegoTerminado = false;
        int i = 0, j = 0;// índices para iterar sobre los jugadores de ambos equipos
        while (!juegoTerminado) {
            // Turno del equipo 1 (si todavía tiene jugadores)
            if (i < jugadoresEquipo1.length) {
                Jugador jugador = jugadoresEquipo1[i];
                jugador.setCantidadBalines(5);
                int puntajeJugador = 0;
                // Realizar los 5 lanzamientos
                while (jugador.getCantidadBalines() > 0) {
                    controlTablero.setTurnoJugador(jugador.getNombre());
                    int lanzamiento = controlTablero.obtenerPuntajeDeLanzamiento();
                    puntajeJugador += lanzamiento;
                    jugador.setCantidadBalines(jugador.getCantidadBalines() - 1);
                }
                // Sumar el puntaje del jugador al puntaje del equipo
                puntajeEquipo1 += puntajeJugador;
                equipo1.setPuntaje(puntajeEquipo1);
                i++; // Pasar al siguiente jugador del equipo 1
            }
            // Verificar si el equipo 1 ha alcanzado el puntaje máximo
            if (puntajeEquipo1 >= condicionDeJuego) {
                juegoTerminado = true;
                seleccionarGanador(equipo1);
                break;
            }
            // Turno del equipo 2 (si todavía tiene jugadores)
            if (j < jugadoresEquipo2.length) {
                Jugador jugador = jugadoresEquipo2[j];
                jugador.setCantidadBalines(5);
                int puntajeJugador = 0;
                // Realizar los 5 lanzamientos
                while (jugador.getCantidadBalines() > 0) {
                    controlTablero.setTurnoJugador(jugador.getNombre());
                    int lanzamiento = controlTablero.obtenerPuntajeDeLanzamiento();
                    puntajeJugador += lanzamiento;
                    jugador.setCantidadBalines(jugador.getCantidadBalines() - 1);
                }
                // Sumar el puntaje del jugador al puntaje del equipo
                puntajeEquipo2 += puntajeJugador;
                equipo2.setPuntaje(puntajeEquipo2);
                j++; // Pasar al siguiente jugador del equipo 2
            }
            // Verificar si el equipo 2 ha alcanzado el puntaje máximo
            if (puntajeEquipo2 >= condicionDeJuego) {
                juegoTerminado = true;
                seleccionarGanador(equipo2);
                break;
            }
            // Si un equipo tiene menos jugadores, el otro sigue jugando sus turnos restantes
            if (i >= jugadoresEquipo1.length && j >= jugadoresEquipo2.length) {
                juegoTerminado = true; // Terminar el juego si ambos equipos han jugado todos sus turnos
            }
        }
    }
    /**
     *
     * @param equipo
     * @return
     */
    public static Equipo seleccionarGanador(Equipo equipo) throws IOException {
        PersistenciaDatos persistencia = new PersistenciaDatos();
        persistencia.guardarEquipo(equipo); // Guardar el equipo ganador
        return equipo; 
    }
}
