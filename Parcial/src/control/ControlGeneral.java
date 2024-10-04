package control;

import modelo.PerroVO;
import modelo.PerroDAO;
import vista.FormularioRelleno;
import vista.MenuPrincipal;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 * Controlador principal del sistema que gestiona la interacción entre las
 * vistas y la lógica del modelo.
 *
 * Esta clase es responsable de coordinar las diferentes vistas (ingreso,
 * modificación, consulta, eliminación y serialización) y manejar los datos de
 * los perros a través del acceso a la base de datos.
 */
public class ControlGeneral {

    /**
     * Vista del formulario de relleno de datos incompletos de perros
     */
    private final FormularioRelleno vistaFormmularioRelleno;
    /**
     * Controlador de la lógica relacionada con los perros
     */
    private final IControlPerro controlPerro;
    /**
     * Lista de perros con datos incompletos
     */
    private ArrayList<PerroVO> perrosIncompletos;
    /**
     * Lista de identificadores de perros
     */
    private ArrayList<Integer> ids;
    /**
     * Gestores para las diferentes vistas
     */
    private final GestorlngresoVista gestorIngresoVista;
    private final GestorModificacionVista gestorModificacionVista;
    private final GestorConsultaVista gestorConsultaVista;
    private final GestorEliminacionVista gestorEliminacionVista;
    private final GestorSerializacion gestorSerializacion;
    private final MenuPrincipal vistaPrincipal;
    private final GestorRegistroVistas gestorRegistro;
    private final GestorPersistencia gestorPersistencia; // Controlador principal para gestionar vistas
    /**
     * Turno actual para el procesamiento de perros incompletos
     */
    int turnoActual = 0;
    /**
     * Posición actual en la lista de identificadores de perros
     */
    private int posicion = 0;

    /**
     * Constructor de ControlGeneral. Inicializa las vistas y controladores
     * necesarios para el funcionamiento del sistema.
     * @throws java.io.IOException
     */
    public ControlGeneral() throws IOException {
        this.vistaFormmularioRelleno = new FormularioRelleno();
        this.controlPerro = new ControlPerro(new PerroDAO());
        this.gestorIngresoVista = new GestorlngresoVista(controlPerro);
        this.gestorModificacionVista = new GestorModificacionVista(controlPerro);
        this.gestorConsultaVista = new GestorConsultaVista(controlPerro);
        this.gestorEliminacionVista = new GestorEliminacionVista(controlPerro);
        this.gestorSerializacion = new GestorSerializacion(controlPerro);
        this.vistaPrincipal = new MenuPrincipal(this);
        this.gestorRegistro = new GestorRegistroVistas(controlPerro);
        this.gestorPersistencia = new GestorPersistencia(controlPerro);
        cargarProperties();
    }

    /**
     * Carga las propiedades iniciales desde un archivo de configuración. Si no
     * hay perros en la base de datos, se ingresan los perros definidos en las
     * propiedades.
     */
    private void cargarProperties() {
        String raza1 = "";
        String pais1 = "";
        String raza2 = "";
        String pais2 = "";
        String raza3 = "";
        String pais3 = "";
        String raza4 = "";
        String pais4 = "";

        Properties propiedades = new Properties();
        int resultado = vistaPrincipal.getFileChooser().showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File archivoSeleccionado = vistaPrincipal.getFileChooser().getSelectedFile();
            try (InputStream entrada = new FileInputStream(archivoSeleccionado)) {
                propiedades.load(entrada);
                raza1 = propiedades.getProperty("perro1.raza");
                pais1 = propiedades.getProperty("perro1.pais");
                raza2 = propiedades.getProperty("perro2.raza");
                pais2 = propiedades.getProperty("perro2.pais");
                raza3 = propiedades.getProperty("perro3.raza");
                pais3 = propiedades.getProperty("perro3.pais");
                raza4 = propiedades.getProperty("perro4.raza");
                pais4 = propiedades.getProperty("perro4.pais");
            } catch (IOException ex) {
                Logger.getLogger(ControlGeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
            perrosIncompletos = controlPerro.mostrarPerrosBaseDeDatos();
            if (perrosIncompletos.isEmpty()) {
                controlPerro.ingresarPerro(raza1, pais1, "", "", "", "", "", "", "", "", 0);
                controlPerro.ingresarPerro(raza2, pais2, "", "", "", "", "", "", "", "", 0);
                controlPerro.ingresarPerro(raza3, pais3, "", "", "", "", "", "", "", "", 0);
                controlPerro.ingresarPerro(raza4, pais4, "", "", "", "", "", "", "", "", 0);
                completarDatos();
            } else {
                vistaPrincipal.PropertiesCargados();
                vistaPrincipal.getFrameVistaPrincipal().setVisible(true);
            }
        }
    }

    /**
     * Completa los datos de los perros que están incompletos. Muestra el
     * formulario para completar la información y gestiona el flujo de datos.
     */
    private void completarDatos() {
        vistaFormmularioRelleno.informarDatosIncompletos();
        perrosIncompletos = controlPerro.mostrarPerrosBaseDeDatos();
        if (perrosIncompletos.size() > 4) {
            vistaPrincipal.getFrameVistaPrincipal().setVisible(true);
        } else {
            ids = controlPerro.retornoId();
            turnoActual = 0; // Asegurarse de empezar desde el primer perro
            posicion = 0; // Reiniciar la posición de IDs si es necesario

            // Solo mostrar el formulario si hay perros incompletos
            if (!perrosIncompletos.isEmpty()) {
                vistaFormmularioRelleno.setVisible(true);
                mostrarFormularioPerro(); // Mostrar el primer perro
            }
        }
    }

    /**
     * Muestra el formulario para completar los datos de un perro específico.
     * Asocia el evento de acción al botón "Completar" para gestionar el flujo
     * de datos.
     */
    private void mostrarFormularioPerro() {
        for (ActionListener al : vistaFormmularioRelleno.getBotonCompletar().getActionListeners()) {
            vistaFormmularioRelleno.getBotonCompletar().removeActionListener(al);
        }
        // Añadir ActionListener al botón "Completar"
        vistaFormmularioRelleno.botonCompletar(e -> {
            if (turnoActual < 4) {
                completarPerro(perrosIncompletos.get(turnoActual)); // Completar los datos del perro actual
                turnoActual++;
                posicion++; // Incrementar la posición de los IDs

                // Si aún hay perros por completar, mostrar el siguiente
                if (turnoActual < 4) {
                    vistaFormmularioRelleno.limpiarCampos();
                    mostrarFormularioPerro(); // Llamar nuevamente para el próximo perro
                } else {
                    vistaFormmularioRelleno.setVisible(false); // Ocultar el formulario si se completaron todos
                    vistaFormmularioRelleno.informarPerrosActualizados();
                    vistaPrincipal.getFrameVistaPrincipal().setVisible(true);
                }
            }
        });
    }

    /**
     * Completa los datos de un perro específico.
     *
     * @param perroModificado El perro a modificar con los nuevos datos.
     */
    private void completarPerro(PerroVO perroModificado) {
        String clasificacion = vistaFormmularioRelleno.getSelectedClasificacion();
        String pelo = vistaFormmularioRelleno.getPeloTextField().getText();
        String color = vistaFormmularioRelleno.getColorTextField().getText();
        String espalda = vistaFormmularioRelleno.getEspaldaTextField().getText();
        String lomo = vistaFormmularioRelleno.getLomoTextField().getText();
        String cola = vistaFormmularioRelleno.getColaTextField().getText();
        String pecho = vistaFormmularioRelleno.getPechoTextField().getText();
        String descripcion = vistaFormmularioRelleno.getDescripcionTextField().getText();
        String subOpcion = vistaFormmularioRelleno.getOpcionSeleccionada() != null
                ? vistaFormmularioRelleno.getOpcionSeleccionada() : "";
        String clasificacionCompleta = clasificacion + (subOpcion.isEmpty() ? "" : ", " + subOpcion);
        // Modificar los atributos del perro
        perroModificado.setPelo(pelo);
        perroModificado.setColor(color);
        perroModificado.setEspalda(espalda);
        perroModificado.setLomo(lomo);
        perroModificado.setCola(cola);
        perroModificado.setPecho(pecho);
        perroModificado.setAparienciaGeneral(descripcion);
        perroModificado.setClasificacionFCI(clasificacionCompleta);
        perroModificado.setId(ids.get(posicion));
        // Actualizar el perro
        controlPerro.actualizarPerro(perroModificado);

        // Informar al usuario y limpiar campos
        vistaFormmularioRelleno.informarIngresoPerro();
    }

    /**
     * Obtiene el gestor de ingreso de vistas.
     *
     * @return El gestor de ingreso de vistas.
     */
    public GestorlngresoVista getControlIngresoVista() {
        return gestorIngresoVista;
    }

    /**
     * Obtiene el gestor de modificación de vistas.
     *
     * @return El gestor de modificación de vistas.
     */
    public GestorModificacionVista getControlModificacionVista() {
        return gestorModificacionVista;
    }

    /**
     * Obtiene el gestor de consulta de vistas.
     *
     * @return El gestor de consulta de vistas.
     */
    public GestorConsultaVista getControlConsultaVista() {
        return gestorConsultaVista;
    }

    /**
     * Obtiene el gestor de eliminación de vistas.
     *
     * @return El gestor de eliminación de vistas.
     */
    public GestorEliminacionVista getControlEliminacionVista() {
        return gestorEliminacionVista;
    }

    /**
     * Obtiene el gestor de serialización.
     */
    public void getControlSerializacion() {
        vistaPrincipal.informarSerializacion();
        gestorSerializacion.gestionarSerializacion();
    }
    
    /**
     * Obtiene el gestor de registro de vistas.
     *
     * @return El gestor de registro de vistas.
     */
    public GestorRegistroVistas getGestorRegistro() {
        return gestorRegistro;
    }

    public void gestionarPersistencia() throws IOException {
        gestorPersistencia.gestionarPersistencia();
    }
}
