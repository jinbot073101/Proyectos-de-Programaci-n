public class Reclutado extends Persona{

    private int codigoReclutado;
    private String situacion = "Reclutado";

    public int getCodigoReclutado() {
        return codigoReclutado;
    }

    public void setCodigoReclutado(int codigoReclutado) {
        this.codigoReclutado = codigoReclutado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    @Override
    public void getDatos() {
        System.out.println("Cédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + situacion + "\nCódigo de reclutamiento: " + codigoReclutado);
    }


}
