package edu.avanzada.taller1.modelo;

public class Reclutado extends Persona{

    private long codigoReclutado;
    


    public long getCodigoReclutado() {
        return codigoReclutado;
    }

    public void setCodigoReclutado(long codigoReclutado) {
        this.codigoReclutado = codigoReclutado;
    }


    @Override
    public void getDatos() {
        System.out.println("\nCédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + super.getSituacionMilitar() + "\nCódigo de reclutamiento: " + codigoReclutado + "\n");
    }


}