package controlador;

import javax.swing.JMenuItem;
import vista.FormularioRelleno;

public class ControlFormularioRelleno {

    private final FormularioRelleno vista;

    public ControlFormularioRelleno(FormularioRelleno vista) {
        this.vista = vista;
    }

    public void actualizarSubMenu(String selectedItem) {
        vista.getSubMenu().removeAll();  // Limpia el menú
        String[] subOptions = vista.obtenerSubOpciones(selectedItem); // Asegúrate de tener este método

        for (String option : subOptions) {
            JMenuItem menuItem = new JMenuItem(option);
            menuItem.addActionListener(e -> vista.setOpcionSeleccionada(option)); // Establecer la opción seleccionada
            vista.getSubMenu().add(menuItem);
        }

        if (subOptions.length > 0) {
            vista.getSubMenu().show(vista.getClasificacionComboBox(), vista.getAncho(), 0);
        }
    }
}
