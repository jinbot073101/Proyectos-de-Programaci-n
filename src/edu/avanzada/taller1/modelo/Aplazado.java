package edu.avanzada.taller1.modelo;

public class Aplazado extends Persona{

    private String fechaAplazado;
    private String situacion = "Aplazado";

    public Aplazado(){
        super.setSituacionMilitar(situacion);
    }

    public String getFechaAplazado() {
        return fechaAplazado;
    }

    public void setFechaAplazado(String fechaAplazado) {
        this.fechaAplazado = fechaAplazado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    @Override
    public void getDatos() {
        System.out.println("\nCédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + situacion + "\nFecha de aplazamiento: " + fechaAplazado + "\n");
    }

}
