package modelo;

public class Equipo {

    private String nombreEquipo;
    private int idEquipo;
    public Persona[] jugadores;
    private int puntaje;

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Persona[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Persona[] jugadores) {
        this.jugadores = jugadores;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }   
}
