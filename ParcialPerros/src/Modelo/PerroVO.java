package Modelo;


public class PerroVO {
    
    private String nombreRaza;
    private String paisOrigen;
    private String clasificacionFCI;
    private String aparienciaGeneral;
    private String pelo;
    private String color;
    private String espalda;
    private String lomo;
    private String cola;
    private String pecho;
    private int id;

    public PerroVO(String nombreRaza, String paisOrigen, String clasificacionFCI,
            String aparienciaGeneral, String pelo, String color, String espalda, String lomo, String cola, String pecho, int id) {
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
