package edu.avanzada.taller1.modelo;

public class Reclutado extends Persona{

    private long codigoReclutado;
    private String situacion = "Reclutado";

    public Reclutado(){
        super.setSituacionMilitar(situacion);
    }

    public long getCodigoReclutado() {
        return codigoReclutado;
    }

    public void setCodigoReclutado(long codigoReclutado) {
        this.codigoReclutado = codigoReclutado;
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
        System.out.println("Situación militar: " + situacion + "\nCódigo de reclutamiento: " + codigoReclutado + "\n");
    }


}