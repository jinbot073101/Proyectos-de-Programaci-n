package controlador;

import vista.ConsultaVista;

public class ControlConsultaVista {
    private final ConsultaVista vista;
    private final IControlPerro controlPerro;

    public ControlConsultaVista(IControlPerro controlPerro) {
        this.vista = new ConsultaVista();
        this.controlPerro = controlPerro;
    }

    public void gestionarConsulta() {
        // Implementar la lógica de consulta
    }
}
