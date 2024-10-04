package modelo;

import java.io.Serializable;

/**
 * Clase que representa un perro en el sistema. Implementa Serializable para
 * permitir la serialización de objetos.
 */
public class PerroVO implements Serializable {

    private String nombreRaza;         // Nombre de la raza del perro
    private String paisOrigen;         // País de origen de la raza
    private String clasificacionFCI;  // Clasificación FCI de la raza
    private transient String aparienciaGeneral; // Descripción de la apariencia general (transitorio)
    private transient String pelo;     // Tipo de pelo del perro (transitorio)
    private transient String color;    // Color del perro (transitorio)
    private transient String espalda;   // Descripción de la espalda (transitorio)
    private transient String lomo;      // Descripción del lomo (transitorio)
    private transient String cola;      // Descripción de la cola (transitorio)
    private transient String pecho;     // Descripción del pecho (transitorio)
    private transient int id;           // Identificador del perro (transitorio)

    /**
     * Constructor para crear un objeto PerroVO.
     *
     * @param nombreRaza Nombre de la raza del perro.
     * @param paisOrigen País de origen de la raza.
     * @param clasificacionFCI Clasificación FCI de la raza.
     * @param aparienciaGeneral Descripción de la apariencia general del perro.
     * @param pelo Tipo de pelo del perro.
     * @param color Color del perro.
     * @param espalda Descripción de la espalda del perro.
     * @param lomo Descripción del lomo del perro.
     * @param cola Descripción de la cola del perro.
     * @param pecho Descripción del pecho del perro.
     * @param id Identificador del perro.
     */
    public PerroVO(String nombreRaza, String paisOrigen, String clasificacionFCI,
            String aparienciaGeneral, String pelo, String color, String espalda,
            String lomo, String cola, String pecho, int id) {
        this.nombreRaza = nombreRaza;
        this.paisOrigen = paisOrigen;
        this.clasificacionFCI = clasificacionFCI;
        this.aparienciaGeneral = aparienciaGeneral;
        this.pelo = pelo;
        this.color = color;
        this.espalda = espalda;
        this.lomo = lomo;
        this.cola = cola;
        this.pecho = pecho;
        this.id = id;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getClasificacionFCI() {
        return clasificacionFCI;
    }

    public void setClasificacionFCI(String clasificacionFCI) {
        this.clasificacionFCI = clasificacionFCI;
    }

    public String getAparienciaGeneral() {
        return aparienciaGeneral;
    }

    public void setAparienciaGeneral(String aparienciaGeneral) {
        this.aparienciaGeneral = aparienciaGeneral;
    }

    public String getPelo() {
        return pelo;
    }

    public void setPelo(String pelo) {
        this.pelo = pelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEspalda() {
        return espalda;
    }

    public void setEspalda(String espalda) {
        this.espalda = espalda;
    }

    public String getLomo() {
        return lomo;
    }

    public void setLomo(String lomo) {
        this.lomo = lomo;
    }

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    public String getPecho() {
        return pecho;
    }

    public void setPecho(String pecho) {
        this.pecho = pecho;
    }
}
