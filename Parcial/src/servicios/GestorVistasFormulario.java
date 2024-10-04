package servicios;

import javax.swing.JMenuItem;
import vista.FormularioRelleno;

/**
 * Clase responsable de gestionar la vista del formulario de relleno. Se encarga
 * de actualizar el submenú de opciones y el turno del perro.
 */
public class GestorVistasFormulario {

    private int turnoActual = 1; // Turno actual del perro
    private final FormularioRelleno vista; // Referencia a la vista del formulario

    /**
     * Constructor de la clase GestorVistasFormulario.
     *
     * @param vista La vista del formulario de relleno a gestionar.
     */
    public GestorVistasFormulario(FormularioRelleno vista) {
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

    /**
     * Actualiza el turno del perro. Si el turno actual es menor o igual a 4, se
     * establece el nuevo turno; de lo contrario, se restablecen los turnos.
     */
    public void actualizarTurno() {
        turnoActual++;
        if (turnoActual <= 4) {
            vista.setTurno(turnoActual); // Establece el turno actual
        } else {
            vista.setTurnos(); // Restablece los turnos si se supera el límite
        }
    }
}
