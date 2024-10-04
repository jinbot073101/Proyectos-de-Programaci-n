package servicios;

import vista.IngresoVista;
import javax.swing.JMenuItem;

/**
 * Clase responsable de gestionar la vista de ingreso. Se encarga de actualizar
 * el submenú de opciones basado en la selección del usuario.
 */
public class GestorVistaIngreso {

    private final IngresoVista vista; // Referencia a la vista de ingreso

    /**
     * Constructor de la clase GestorVistaIngreso.
     *
     * @param vista La vista de ingreso a gestionar.
     */
    public GestorVistaIngreso(IngresoVista vista) {
        this.vista = vista;
    }

    /**
     * Actualiza el submenú de opciones en función del ítem seleccionado.
     *
     * @param selectedItem El ítem seleccionado que determina las subopciones a
     * mostrar.
     */
    public void actualizarSubMenu(String selectedItem) {
        vista.getSubMenu().removeAll();  // Limpia el menú
        String[] subOptions = vista.obtenerSubOpciones(selectedItem); // Obtiene las subopciones

        for (String option : subOptions) {
            JMenuItem menuItem = new JMenuItem(option);
            menuItem.addActionListener(e -> vista.setOpcionSeleccionada(option)); // Establecer la opción seleccionada
            vista.getSubMenu().add(menuItem); // Añadir el ítem al submenú
        }

        if (subOptions.length > 0) {
            vista.getSubMenu().show(vista.getClasificacionComboBox(), vista.getAncho(), 0); // Mostrar el submenú
        }
    }
}
