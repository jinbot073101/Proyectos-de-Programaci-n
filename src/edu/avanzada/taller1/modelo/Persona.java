package edu.avanzada.taller1.modelo;

public abstract class Persona {

    private int cedula;
    private String nombre;
    private String apellido;
    private String situacionMilitar;
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSituacionMilitar(){
        return situacionMilitar;
    }

    public void setSituacionMilitar(String situacionMilitar){
        this.situacionMilitar=situacionMilitar;
    }
    
    public abstract void getDatos();

}