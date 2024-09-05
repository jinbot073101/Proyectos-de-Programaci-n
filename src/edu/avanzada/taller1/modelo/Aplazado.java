package edu.avanzada.taller1.modelo;


/**
 * La clase <code>Aplazado</code> representa a una persona que ha sido aplazada en su situación militar.
 * Extiende de la clase <code>Persona</code> e incluye información adicional sobre la fecha de aplazamiento.
 */
public class Aplazado extends Persona{

    private String fechaAplazado;

    /**
     * Obtiene la fecha de aplazamiento.
     *
     * @return La fecha de aplazamiento en formato <code>String</code>.
     */
    public String getFechaAplazado() {
        return fechaAplazado;
    }


    /**
     * Establece la fecha de aplazamiento.
     *
     * @param fechaAplazado La fecha de aplazamiento a establecer en formato <code>String</code>.
     */
    public void setFechaAplazado(String fechaAplazado) {
        this.fechaAplazado = fechaAplazado;
    }


    /**
     * Muestra los datos de la persona aplazada, incluyendo cédula, nombre, apellido, situación militar
     * y fecha de aplazamiento.
     */
    @Override
    public void getDatos() {
        System.out.println("\nCédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + super.getSituacionMilitar() + "\nFecha de aplazamiento: " + fechaAplazado + "\n");
    }

}
