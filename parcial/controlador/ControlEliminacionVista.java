package controlador;

import vista.EliminacionVista;

public class ControlEliminacionVista {

    private final EliminacionVista vista;
    private final IControlPerro controlPerro;

    public ControlEliminacionVista(IControlPerro controlPerro) {
        this.vista = new EliminacionVista();
        this.controlPerro = controlPerro;
    }

    public void gestionarEliminacion() {
        // Implementar la lógica de eliminación
    }
}
