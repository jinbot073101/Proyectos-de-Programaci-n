package edu.avanzada.taller1.modelo;

public class Remiso extends Persona{

    private String situacion = "Remiso";

    public Remiso(){
        super.setSituacionMilitar(situacion);
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
        System.out.println("Situación militar: " + situacion + "\n");
    }


}
