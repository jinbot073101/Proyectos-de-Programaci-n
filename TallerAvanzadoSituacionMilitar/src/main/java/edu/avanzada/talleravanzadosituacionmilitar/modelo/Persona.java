package edu.avanzada.talleravanzadosituacionmilitar.modelo;

/**
 * La clase abstracta <code>Persona</code> representa la información básica de una persona en el sistema
 * de gestión de situación militar. Incluye los atributos comunes como cédula, nombre, apellido y situación
 * militar, y proporciona métodos para acceder y modificar estos atributos.
 */
public abstract class Persona {

    private int cedula;
    private String nombre;
    private String apellido;
    private String situacionMilitar;
    
    /**
     * Obtiene la cédula de la persona.
     *
     * @return La cédula de la persona en formato <code>int</code>.
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula de la persona.
     *
     * @param cedula La cédula de la persona a establecer en formato <code>int</code>.
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }


    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona en formato <code>String</code>.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre de la persona a establecer en formato <code>String</code>.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     *
     * @return El apellido de la persona en formato <code>String</code>.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona.
     *
     * @param apellido El apellido de la persona a establecer en formato <code>String</code>.
     */

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la situación militar de la persona.
     *
     * @return La situación militar de la persona en formato <code>String</code>.
     */
    public String getSituacionMilitar(){
        return situacionMilitar;
    }

    /**
     * Establece la situación militar de la persona.
     *
     * @param situacionMilitar La situación militar de la persona a establecer en formato <code>String</code>.
     */

    public void setSituacionMilitar(String situacionMilitar){
        this.situacionMilitar = situacionMilitar;
    }
    
    /**
     * Método abstracto que debe ser implementado por las subclases para mostrar los datos de la persona.
     * La implementación concreta debe proporcionar los detalles específicos de cómo se muestran los datos.
     */
    public abstract void getDatos();

}