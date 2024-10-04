package Control;

import Vista.ConsultaVistas;


public class ControlConsultaVista {
    
    private final ConsultaVistas vista;
    private final IControlPerro controlPerro;

    public ControlConsultaVista(IControlPerro controlPerro) {
        this.vista = new ConsultaVistas();
        this.controlPerro = controlPerro;
    }

    public void gestionarConsulta() {
        // Implementar la lógica de consulta
    }
    
}
