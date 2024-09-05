package edu.avanzada.talleravanzadosituacionmilitar.modelo;

 /**
 * La clase <code>Remiso</code> representa una persona que ha sido clasificada como remiso y que extiende
 * la clase abstracta <code>Persona</code>. Esta clase no tiene atributos adicionales específicos,
 * pero hereda el comportamiento y los atributos de <code>Persona</code>.
 */

public class Remiso extends Persona{


    /**
     * Muestra los datos completos de la persona remisa, incluyendo la cédula, nombre, apellido
     * y situación militar.
     */
    @Override
    public void getDatos() {
        System.out.println("\nCédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + super.getSituacionMilitar() + "\n");
    }


}
