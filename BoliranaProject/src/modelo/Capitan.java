package modelo;

import java.io.Serializable;

public class Capitan extends Persona implements Serializable  {

    private int exp;
    private int idCapitan;

    public Capitan(String nombre, int edad, long cedula, int exp, int idCapitan) {
        super(nombre, edad, cedula);
        this.exp = exp;
        this.idCapitan=idCapitan;
    }

    public int getExperiencia() {
        return exp;
    }

    public void setExperiencia(int exp) {
        this.exp = exp;
    }
    
    public int getIdCapitan() {
        return idCapitan;
    }

    public void setIdCapitan(int id) {
        this.idCapitan = id;
    }
}
