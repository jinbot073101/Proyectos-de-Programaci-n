package edu.avanzada.talleravanzadosituacionmilitar.modelo;

/**
 * La clase <code>Reservista</code> representa una persona que ha sido clasificada como reservista y
 * extiende la clase abstracta <code>Persona</code>. Esta clase añade un atributo específico,
 * <code>numeroLibretaMilitar</code>, para almacenar el número de la libreta militar del reservista.
 */

public class Reservista extends Persona {

    private int numeroLibretaMilitar;
    
    /**
     * Obtiene el número de la libreta militar del reservista.
     * 
     * @return el número de la libreta militar
     */
    public int getNumeroLibretaMilitar() {
        return numeroLibretaMilitar;
    }

    /**
     * Establece el número de la libreta militar del reservista.
     * 
     * @param numeroLibretaMilitar el número de la libreta militar a establecer
     */
    public void setNumeroLibretaMilitar(int numeroLibretaMilitar) {
        this.numeroLibretaMilitar = numeroLibretaMilitar;
    }


    /**
     * Muestra los datos completos del reservista, incluyendo la cédula, nombre, apellido,
     * situación militar y el número de libreta militar.
     */
    @Override
    public void getDatos() {
        System.out.println("\nCédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + super.getSituacionMilitar() + "\nNúmero de libreta militar: " + numeroLibretaMilitar + "\n");
    }

}
