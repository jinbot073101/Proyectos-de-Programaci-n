package control;

import servicios.ValidadorCampos;
import vista.IngresoVista;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.PerroVO;

/**
 * Clase que gestiona el ingreso de nuevos perros a través de la interfaz de
 * usuario.
 *
 * Esta clase se encarga de recoger los datos ingresados por el usuario en la
 * vista de ingreso y validar la información antes de agregar un nuevo perro a
 * la base de datos.
 */
public class GestorlngresoVista {

    /**
     * Vista de ingreso donde se introducen los datos del perro
     */
    private final IngresoVista vistaIngreso;

    /**
     * Controlador que maneja las operaciones relacionadas con perros
     */
    private final IControlPerro controlPerro;

    /**
     * Constructor de GestorlngresoVista.
     *
     * @param controlPerro Controlador que se utilizará para manejar los datos
     * de los perros.
     */
    public GestorlngresoVista(IControlPerro controlPerro) {
        this.vistaIngreso = new IngresoVista();
        this.controlPerro = controlPerro;
    }

    /**
     * Método que gestiona la interacción del usuario con la vista de ingreso.
     *
     * Este método configura la vista de ingreso, limpia los action listeners
     * previos y establece la lógica para validar y registrar un nuevo perro al
     * presionar el botón de ingreso.
     */
    public void gestionarIngreso() {
        vistaIngreso.setVisible(true);

        // Limpiar los action listeners previos
        for (ActionListener al : vistaIngreso.getBotonIngresar().getActionListeners()) {
            vistaIngreso.getBotonIngresar().removeActionListener(al);
        }
        vistaIngreso.botonIngresar(e -> {
            String raza = vistaIngreso.getRazaTextField().getText();
            String paisOrigen = vistaIngreso.getPaisOrigenTextField().getText();
            String clasificacion = vistaIngreso.getSelectedClasificacion();
            String pelo = vistaIngreso.getPeloTextField().getText();
            String color = vistaIngreso.getColorTextField().getText();
            String espalda = vistaIngreso.getEspaldaTextField().getText();
            String lomo = vistaIngreso.getLomoTextField().getText();
            String cola = vistaIngreso.getColaTextField().getText();
            String pecho = vistaIngreso.getPechoTextField().getText();
            String descripcion = vistaIngreso.getDescripcionTextField().getText();
            String subOpcion = vistaIngreso.getOpcionSeleccionada() != null ? vistaIngreso.getOpcionSeleccionada() : "";
            String clasificacionCompleta = clasificacion + (subOpcion.isEmpty() ? "" : ", " + subOpcion);
            int id = 0; // ID por defecto, debe ser generado o proporcionado por la base de datos

            // Validar si los campos están completos
            if (!ValidadorCampos.validarCampos(raza, paisOrigen, pelo, color, espalda, lomo, cola, pecho, descripcion)) {
                try {
                    // Llamar al método de validación para comprobar si el perro ya existe en la base de datos
                    boolean esRepetido = ValidarIngresoPerro(raza, paisOrigen, clasificacionCompleta, pelo, color, espalda, lomo, cola, pecho, descripcion, id);
                    if (!esRepetido) {
                        // Ingresar el nuevo perro en la base de datos si no es repetido
                        controlPerro.ingresarPerro(raza, paisOrigen, clasificacionCompleta, pelo, color, espalda, lomo, cola, pecho, descripcion, id);
                        vistaIngreso.informarIngresoPerro(); // Notificar que el ingreso fue exitoso
                        vistaIngreso.limpiarCampos(); // Limpiar los campos de texto
                        vistaIngreso.setVisible(false); // Cerrar la vista
                    } else {
                        // Mostrar mensaje de perro repetido
                        vistaIngreso.limpiarCampos(); // Limpiar los campos de texto
                        vistaIngreso.perroRepetido(); // Mostrar alerta de perro repetido
                    }
                } catch (NumberFormatException ex) {
                    vistaIngreso.datosIncompletos(); // Mostrar mensaje de error en los datos
                    vistaIngreso.limpiarCampos(); // Limpiar los campos de texto
                    gestionarIngreso(); // Volver a activar la gestión de ingreso
                }
            } else {
                vistaIngreso.pedirDatos(); // Mostrar mensaje de campos incompletos
            }
        });
    }

    /**
     * Método que valida si un perro con los mismos atributos ya existe en la
     * base de datos.
     *
     * @param raza Nombre de la raza del perro.
     * @param paisOrigen País de origen del perro.
     * @param clasificacionCompleta Clasificación completa del perro.
     * @param pelo Tipo de pelo del perro.
     * @param color Color del perro.
     * @param espalda Descripción de la espalda del perro.
     * @param lomo Descripción del lomo del perro.
     * @param cola Descripción de la cola del perro.
     * @param pecho Descripción del pecho del perro.
     * @param descripcion Descripción general del perro.
     * @param id ID del perro (debe ser único).
     * @return true si el perro ya existe, false si no.
     */
    public boolean ValidarIngresoPerro(String raza, String paisOrigen, String clasificacionCompleta, String pelo, String color, String espalda, String lomo,
            String cola, String pecho, String descripcion, int id) {
        // Crear un objeto perro basado en los parámetros que se ingresaron
        PerroVO perroNuevo = new PerroVO(raza, paisOrigen, clasificacionCompleta, pelo, color, espalda, lomo, cola, pecho, descripcion, id);

        // Obtener la lista de perros de la base de datos
        ArrayList<PerroVO> listaPerros = controlPerro.mostrarPerrosBaseDeDatos();

        // Comparar los atributos del nuevo perro con los de la lista de perros
        for (PerroVO perroExistente : listaPerros) {
            if (perroNuevo.getNombreRaza().equals(perroExistente.getNombreRaza())
                    && perroNuevo.getPaisOrigen().equals(perroExistente.getPaisOrigen())
                    && perroNuevo.getClasificacionFCI().equals(perroExistente.getClasificacionFCI())
                    && perroNuevo.getPelo().equals(perroExistente.getPelo())
                    && perroNuevo.getColor().equals(perroExistente.getColor())
                    && perroNuevo.getEspalda().equals(perroExistente.getEspalda())
                    && perroNuevo.getLomo().equals(perroExistente.getLomo())
                    && perroNuevo.getCola().equals(perroExistente.getCola())
                    && perroNuevo.getPecho().equals(perroExistente.getPecho())
                    && perroNuevo.getAparienciaGeneral().equals(perroExistente.getAparienciaGeneral())) {
                return true; // El perro ya existe
            }
        }
        return false; // El perro no existe en la lista
    }
}
