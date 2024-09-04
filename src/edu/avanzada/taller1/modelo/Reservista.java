package edu.avanzada.taller1.modelo;

public class Reservista extends Persona {

    private int numeroLibretaMilitar;



    public int getNumeroLibretaMilitar() {
        return numeroLibretaMilitar;
    }

    public void setNumeroLibretaMilitar(int numeroLibretaMilitar) {
        this.numeroLibretaMilitar = numeroLibretaMilitar;
    }


    @Override
    public void getDatos() {
        System.out.println("\nCédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + super.getSituacionMilitar() + "\nNúmero de libreta militar: " + numeroLibretaMilitar + "\n");
    }

}
