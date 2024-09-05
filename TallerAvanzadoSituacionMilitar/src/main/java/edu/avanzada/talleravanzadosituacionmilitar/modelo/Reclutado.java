package edu.avanzada.talleravanzadosituacionmilitar.modelo;

    /**
 * La clase <code>Reclutado</code> representa una persona que ha sido reclutada y que extiende la
 * clase abstracta <code>Persona</code>. Incluye un atributo adicional específico para el código de
 * reclutamiento, junto con los métodos para acceder y modificar este atributo.
 */

public class Reclutado extends Persona{

    private long codigoReclutado;
    
     /**
     * Obtiene el código de reclutamiento de la persona.
     *
     * @return El código de reclutamiento en formato <code>long</code>.
     */

    public long getCodigoReclutado() {
        return codigoReclutado;
    }

    /**
     * Establece el código de reclutamiento de la persona.
     *
     * @param codigoReclutado El código de reclutamiento a establecer en formato <code>long</code>.
     */

    public void setCodigoReclutado(long codigoReclutado) {
        this.codigoReclutado = codigoReclutado;
    }


    /**
     * Muestra los datos completos de la persona reclutada, incluyendo la cédula, nombre, apellido,
     * situación militar y código de reclutamiento.
     */
    @Override
    public void getDatos() {
        System.out.println("\nCédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + super.getSituacionMilitar() + "\nCódigo de reclutamiento: " + codigoReclutado + "\n");
    }


}