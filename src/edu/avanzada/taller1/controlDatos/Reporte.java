
package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.Persona;
import java.util.ArrayList;


public class Reporte {

    private final ControlAplazado controlAplazado;
    private final ControlReclutado controlReclutado;
    private final ControlRemiso controlRemiso;
    private final ControlReservista controlReservista;

    public Reporte(ControlAplazado aplazado, ControlReclutado reclutado, ControlRemiso remiso,
    ControlReservista reservista) {
        this.controlAplazado = aplazado;
        this.controlReclutado = reclutado;
        this.controlRemiso = remiso;
        this.controlReservista = reservista;
    }


    public void generarReporte() {

        controlReservista.mostrarArray();
        System.out.println("array es de " + controlReservista.getLista().size());
        
        controlAplazado.mostrarArray();
        controlRemiso.mostrarArray();
        controlReclutado.mostrarArray();
        generarReportePorTipo(controlReservista, "reservistas");
        generarReportePorTipo(controlRemiso, "remisos");
        generarReportePorTipo(controlAplazado, "aplazados");
        generarReportePorTipo(controlReclutado, "reclutados");
    }

    private void generarReportePorTipo(InterfaceControl control, String tipo) {
        System.out.println("\n >> Reporte de " + tipo + ":");
        ArrayList<Persona> lista = control.getLista();

        System.out.println("Tamaño de la lista de " + tipo + ": " + lista.size());

        if (lista.isEmpty()) {
            System.out.println("No hay datos disponibles para el reporte de " + tipo);
        } else {
            for (Persona persona : lista) {
                persona.getDatos();
            }
        }
    }
}
