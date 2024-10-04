package control;

import java.util.ArrayList;
import vista.RegistroVistas;

/**
 * Clase que gestiona la lógica de la vista de registro de perros.
 *
 * Esta clase se encarga de manejar la interacción entre la vista de registro y
 * el controlador de perros, permitiendo registrar nuevas razas de perros.
 */
public class GestorRegistroVistas {

    /**
     * Vista para registrar perros
     */
    private final RegistroVistas vistaRegistro;

    /**
     * Controlador que maneja las operaciones relacionadas con perros
     */
    private final IControlPerro controlPerro;

    /**
     * Constructor de GestorRegistroVistas.
     *
     * @param controlPerro Controlador que se utilizará para realizar el
     * registro de perros.
     */
    public GestorRegistroVistas(IControlPerro controlPerro) {
        this.controlPerro = controlPerro;
        this.vistaRegistro = new RegistroVistas();
    }

    /**
     * Inicia el manejo de la vista de registro.
     *
     * Muestra la vista y configura la lista de razas y los eventos para el
     * botón de cerrar.
     */
    public void gestionarRegistro() {
        vistaRegistro.setVisible(true);

        // Obtener la lista de razas desde el control
        ArrayList<String> razas = controlPerro.retornoRazas();

        // Limpiar la lista en la vista antes de agregar nuevas razas
        vistaRegistro.limpiarLista();

        // Agregar cada raza al modelo de la vista
        for (String raza : razas) {
            vistaRegistro.agregarRaza(raza);
        }

        // Configurar el botón cerrar
        vistaRegistro.botonCerrar(e -> {
            vistaRegistro.dispose();  // Cerrar la ventana cuando se presione el botón
        });
    }
}
