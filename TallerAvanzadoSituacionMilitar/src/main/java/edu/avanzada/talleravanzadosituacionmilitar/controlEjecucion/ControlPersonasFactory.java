package edu.avanzada.talleravanzadosituacionmilitar.controlEjecucion;

import edu.avanzada.talleravanzadosituacionmilitar.controlDatos.ControlAplazado;
import edu.avanzada.talleravanzadosituacionmilitar.controlDatos.ControlBaseDatos;
import edu.avanzada.talleravanzadosituacionmilitar.controlDatos.ControlReclutado;
import edu.avanzada.talleravanzadosituacionmilitar.controlDatos.ControlRemiso;
import edu.avanzada.talleravanzadosituacionmilitar.controlDatos.ControlReservista;
import edu.avanzada.talleravanzadosituacionmilitar.controlDatos.InterfaceControl;

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

