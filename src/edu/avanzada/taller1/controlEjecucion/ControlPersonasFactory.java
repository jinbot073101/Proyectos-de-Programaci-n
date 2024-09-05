package edu.avanzada.taller1.controlEjecucion;

import edu.avanzada.taller1.controlDatos.ControlAplazado;
import edu.avanzada.taller1.controlDatos.ControlBaseDatos;
import edu.avanzada.taller1.controlDatos.ControlReclutado;
import edu.avanzada.taller1.controlDatos.ControlRemiso;
import edu.avanzada.taller1.controlDatos.ControlReservista;
import edu.avanzada.taller1.controlDatos.InterfaceControl;

/**
 * La clase <code>ControlPersonasFactory</code> actúa como una fábrica para crear instancias de los
 * controladores de personas según el flujo del programa. Se encarga de proporcionar una instancia de
 * <code>ControlPersonas</code> que gestiona los diferentes tipos de controladores de personas.
 */

public class ControlPersonasFactory {

    /**
     * Crea e inicializa una instancia de <code>ControlPersonas</code> con los controladores específicos
     * para cada tipo de persona, utilizando una instancia de <code>ControlBaseDatos</code>.
     * 
     * @return una instancia de <code>ControlPersonas</code> que contiene los controladores para los
     *         diferentes tipos de personas (Remiso, Reclutado, Reservista, Aplazado)
     */

    public static ControlPersonas createControlPersonas() {
        ControlBaseDatos controlDatos = new ControlBaseDatos();
        InterfaceControl controlRemiso = new ControlRemiso(controlDatos);
        InterfaceControl controlReclutado = new ControlReclutado(controlDatos);
        InterfaceControl controlReservista = new ControlReservista(controlDatos);
        InterfaceControl controlAplazado = new ControlAplazado(controlDatos);

        return new ControlPersonas(controlRemiso, controlReclutado, controlReservista, controlAplazado);
    }
}

