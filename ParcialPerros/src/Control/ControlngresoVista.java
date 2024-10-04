package Control;

import Vista.IngresoVista;
import java.awt.event.ActionListener;


public class ControlngresoVista {
    
    private final IngresoVista vista;
    private final IControlPerro controlPerro;

    public ControlngresoVista(IControlPerro controlPerro) {
        this.vista = new IngresoVista();
        this.controlPerro = controlPerro;
    }

    public void gestionarIngreso() {
        vista.setVisible(true);
        // Limpiar los action listeners previos
        for (ActionListener al : vista.getBotonIngresar().getActionListeners()) {
            vista.getBotonIngresar().removeActionListener(al);
        }
        vista.botonIngresar(e -> {
            String raza = vista.getRazaTextField().getText();
            String paisOrigen = vista.getPaisOrigenTextField().getText();
            String clasificacion = vista.getSelectedClasificacion();
            String pelo = vista.getPeloTextField().getText();
            String color = vista.getColorTextField().getText();
            String espalda = vista.getEspaldaTextField().getText();
            String lomo = vista.getLomoTextField().getText();
            String cola = vista.getColaTextField().getText();
            String pecho = vista.getPechoTextField().getText();
            String descripcion = vista.getDescripcionTextField().getText();
            String subOpcion = vista.getOpcionSeleccionada() != null ? vista.getOpcionSeleccionada() : "";
            String clasificacionCompleta = clasificacion + (subOpcion.isEmpty() ? "" : ", " + subOpcion);
            int id = 0;

            controlPerro.ingresarPerro(raza, paisOrigen, clasificacionCompleta, pelo, color, espalda, lomo, cola, pecho, descripcion, id);
            vista.limpiarCampos();
            vista.setVisible(false);
        });
    }
    
}
