package edu.avanzada.taller1.controlEjecucion;

import edu.avanzada.taller1.controlDatos.*;

public class ControlPersonasFactory {

    public static ControlPersonas createControlPersonas() {
        
        InterfaceControl controlRemiso = new ControlRemiso();
        InterfaceControl controlReclutado = new ControlReclutado();
        InterfaceControl controlReservista = new ControlReservista();
        InterfaceControl controlAplazado = new ControlAplazado();

        return new ControlPersonas(controlRemiso, controlReclutado, controlReservista, controlAplazado);
    }
}