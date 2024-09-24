package modelo;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    
    private String nombre;
    private int edad;
    private long cedula;
    private String estado;
    
    public Persona(String nombre, int edad, long cedula){
        this.nombre=nombre;
        this.edad=edad;
        this.cedula=cedula;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
    
    public String getEstado(){
        return estado;
    }
}
