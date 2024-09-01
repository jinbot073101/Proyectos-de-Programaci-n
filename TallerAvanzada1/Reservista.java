public class Reservista extends Persona {

    private int numeroLibretaMilitar;
    private String situacion = "Reservista";

    public int getNumeroLibretaMilitar() {
        return numeroLibretaMilitar;
    }

    public void setNumeroLibretaMilitar(int numeroLibretaMilitar) {
        this.numeroLibretaMilitar = numeroLibretaMilitar;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

}
