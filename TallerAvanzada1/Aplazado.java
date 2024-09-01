public class Aplazado extends Persona{

    private String fechaAplazado;
    private String situacion = "Aplazado";

    public String getFechaAplazado() {
        return fechaAplazado;
    }

    public void setFechaAplazado(String fechaAplazado) {
        this.fechaAplazado = fechaAplazado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

}
