package edu.avanzada.taller1.controlDatos;

import edu.avanzada.taller1.modelo.*;
import java.util.*;

public class Reporte {

    private ControlAplazado aplazados;
    private ControlReclutado reclutados;
    private ControlRemiso remisos;
    private ControlReservista reservistas;
    
    
    public Reporte(){
        reservistas = new ControlReservista();
        
    }

    public void generarReporte() {
        try {
            System.out.println(" >> Generando reporte en la base de datos de Reservistas...");
            ArrayList<Persona> listaAplazados = reservistas.getLista();
            Thread.sleep(2000); // Pausa por 2 segundos (2000 milisegundos)
            for(Persona persona:listaAplazados){
                
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
