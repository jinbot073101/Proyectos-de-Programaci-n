package edu.avanzada.taller1.modelo;

public class Reservista extends Persona {

    private int numeroLibretaMilitar;
    private String situacion = "Reservista";

    public Reservista(){
        super.setSituacionMilitar(situacion);
    }

    public int getNumeroLibretaMilitar() {
        return numeroLibretaMilitar;
    }

    public void setNumeroLibretaMilitar(int numeroLibretaMilitar) {
        this.numeroLibretaMilitar = numeroLibretaMilitar;
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
        System.out.println("Situación militar: " + situacion + "\nNúmero de libreta militar: " + numeroLibretaMilitar + "\n");
    }

}
