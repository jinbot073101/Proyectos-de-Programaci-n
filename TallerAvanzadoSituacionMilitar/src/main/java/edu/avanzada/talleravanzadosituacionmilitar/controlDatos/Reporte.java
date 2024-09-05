package edu.avanzada.talleravanzadosituacionmilitar.controlDatos;

import edu.avanzada.talleravanzadosituacionmilitar.modelo.Persona;
import java.util.ArrayList;

/*Esta clase se encarga de generar un reporte por cada ArrayList
 * en la que se imprimen los objetos guardados con sus respectivos datos.
 * Accede a los distintos ArrayLists de cada tipo de persona y los recorre
 */
public class Reporte {

    private final InterfaceControl controlAplazado;
    private final InterfaceControl controlReclutado;
    private final InterfaceControl controlRemiso;
    private final InterfaceControl controlReservista;


    public Reporte(InterfaceControl aplazado, InterfaceControl reclutado, InterfaceControl remiso,
            InterfaceControl reservista) {            
        this.controlAplazado = aplazado;
        this.controlReclutado = reclutado;
        this.controlRemiso = remiso;
        this.controlReservista = reservista;
    }

    /*
     * Aplica el método generarReportePorTipo a cada ArrayList según que tipo de
     * objeto contiene
     */
    public void generarReporte() {
        try {
            generarReportePorTipo(controlReservista, "reservistas");
            generarReportePorTipo(controlRemiso, "remisos");
            generarReportePorTipo(controlAplazado, "aplazados");
            generarReportePorTipo(controlReclutado, "reclutados");
        } catch (InterruptedException e) {
            System.out.println("Error en la generación del reporte: " + e.getMessage());
        }
    }

    // Genera el reporte en un ArrayList concreto
    private void generarReportePorTipo(InterfaceControl control, String tipo) throws InterruptedException {
        System.out.println(" >> Generando reporte en la base de datos de los " + tipo + "...");
        ArrayList<Persona> lista = control.getLista();
        Thread.sleep(3000); // Pausa por 3 segundos

        if(lista.isEmpty()){
            System.out.println("No hay datos disponibles para el reporte de " + tipo);
            return;
        }

        for (Persona persona : lista) {
            Thread.sleep(1000);
            persona.getDatos();
        }

    }



}