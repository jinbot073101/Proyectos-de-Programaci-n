package Control;

import Vista.EliminacionVistas;


public class ControlEliminacionVista {
    
    private final EliminacionVistas vista;
    private final IControlPerro controlPerro;

    public ControlEliminacionVista(IControlPerro controlPerro) {
        this.vista = new EliminacionVistas();
        this.controlPerro = controlPerro;
    }

    public void gestionarEliminacion() {
        // Implementar la lógica de eliminación
    }
    
}
