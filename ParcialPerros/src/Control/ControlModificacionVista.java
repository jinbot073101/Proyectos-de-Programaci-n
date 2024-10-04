package Control;

import Vista.ModificacionVista;



public class ControlModificacionVista {
    
    private final ModificacionVista vista;
    private final IControlPerro controlPerro;

    public ControlModificacionVista(IControlPerro controlPerro) {
        this.vista = new ModificacionVista();
        this.controlPerro = controlPerro;
    }

    public void gestionarModificacion() {
        // Implementar la lógica de modificación
    }
    
}
