package control;

import vista.EliminacionVistas;
import java.awt.event.ActionEvent;

/**
 * Clase que gestiona la lógica de la vista de eliminación de perros.
 *
 * Esta clase maneja la interacción entre la vista de eliminación y el
 * controlador de perros, permitiendo eliminar perros registrados en la base de
 * datos.
 */
public class GestorEliminacionVista {

    /**
     * Vista para eliminar perros
     */
    private final EliminacionVistas vistaEliminar;
    /**
     * Controlador que maneja las operaciones relacionadas con perros
     */
    private final IControlPerro controlPerro;

    /**
     * Constructor de GestorEliminacionVista.
     *
     * @param controlPerro Controlador que se utilizará para realizar la
     * eliminación de perros.
     */
    public GestorEliminacionVista(IControlPerro controlPerro) {
        this.vistaEliminar = new EliminacionVistas();
        this.controlPerro = controlPerro;
    }

    /**
     * Inicia el manejo de la vista de eliminación.
     *
     * Muestra la vista y configura los eventos para los botones de eliminación
     * y cancelación.
     */
    public void gestionarEliminacion() {
        vistaEliminar.informarFormaEliminacion();
        vistaEliminar.setVisible(true);
        // Botón para eliminar la mascota
        vistaEliminar.getBotonEliminar().addActionListener((ActionEvent e) -> {
            // Acciones al hacer clic en el botón de eliminar
            String id = vistaEliminar.getTxtIdMascota().getText();
            if (!id.isEmpty()) {
                try {
                    int idMascota = Integer.parseInt(id);  // Convertir el texto a entero
                    controlPerro.eliminarPerro(idMascota);
                    vistaEliminar.eliminacionCompleta(idMascota);
                } catch (NumberFormatException ex) {
                    vistaEliminar.idInvalido();
                }
            } else {
                vistaEliminar.ingresarId();
            }
        });
        // Botón para cancelar la acción
        vistaEliminar.getBotonCancelar().addActionListener((ActionEvent e) -> {
            vistaEliminar.dispose();  // Cerrar la ventana
        });
    }
}
