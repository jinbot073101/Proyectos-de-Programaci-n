package Servicios;

import Vista.FormularioRelleno;
import javax.swing.JMenuItem;



public class GestorVistasFormulario {
    
    private final FormularioRelleno vista;
    
    public GestorVistasFormulario(FormularioRelleno vista) {
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
