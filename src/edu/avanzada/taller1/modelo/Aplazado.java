package edu.avanzada.taller1.modelo;

public class Aplazado extends Persona{

    private String fechaAplazado;
   
    public String getFechaAplazado() {
        return fechaAplazado;
    }

    public void setFechaAplazado(String fechaAplazado) {
        this.fechaAplazado = fechaAplazado;
    }


    @Override
    public void getDatos() {
        System.out.println("\nCédula: " + super.getCedula() + "\nNombre: " + super.getNombre() + "\nApellido: " + super.getApellido());
        System.out.println("Situación militar: " + super.getSituacionMilitar() + "\nFecha de aplazamiento: " + fechaAplazado + "\n");
    }

}
