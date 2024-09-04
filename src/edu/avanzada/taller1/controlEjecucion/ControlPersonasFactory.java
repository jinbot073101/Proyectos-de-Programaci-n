package edu.avanzada.taller1.controlEjecucion;

import edu.avanzada.taller1.controlDatos.ControlAplazado;
import edu.avanzada.taller1.controlDatos.ControlBaseDatos;
import edu.avanzada.taller1.controlDatos.ControlReclutado;
import edu.avanzada.taller1.controlDatos.ControlRemiso;
import edu.avanzada.taller1.controlDatos.ControlReservista;
import edu.avanzada.taller1.controlDatos.InterfaceControl;

/*Esta clase se encarga de ser la intermediaria entre la fachada y el controlDatos con los controladores
 * de cada tipo de persona. Utilizando una fábrica que crea instancias de los controladores
 * según lo que el flujo del programa lo requiera
 */

public class ControlPersonasFactory {

    public static ControlPersonas createControlPersonas() {
        ControlBaseDatos controlDatos = new ControlBaseDatos();
        InterfaceControl controlRemiso = new ControlRemiso(controlDatos);
        InterfaceControl controlReclutado = new ControlReclutado(controlDatos);
        InterfaceControl controlReservista = new ControlReservista(controlDatos);
        InterfaceControl controlAplazado = new ControlAplazado(controlDatos);

        return new ControlPersonas(controlRemiso, controlReclutado, controlReservista, controlAplazado);
    }
}

