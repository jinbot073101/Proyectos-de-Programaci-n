package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.PerroVO;
import vista.ModificacionVista;

/**
 * Clase que gestiona la lógica de la vista de modificación de perros.
 *
 * Esta clase maneja la interacción entre la vista de modificación y el
 * controlador de perros, permitiendo modificar los detalles de un perro
 * registrado en la base de datos.
 */
public class GestorModificacionVista {

    /**
     * Vista para modificar perros
     */
    private final ModificacionVista vistaModificar;

    /**
     * Controlador que maneja las operaciones relacionadas con perros
     */
    private final IControlPerro controlPerro;

    /**
     * Objeto que contiene los datos del perro a modificar
     */
    private PerroVO perroActualizado;

    /**
     * Constructor de GestorModificacionVista.
     *
     * @param controlPerro Controlador que se utilizará para realizar la
     * modificación de perros.
     */
    public GestorModificacionVista(IControlPerro controlPerro) {
        this.vistaModificar = new ModificacionVista();
        this.controlPerro = controlPerro;
    }

    /**
     * Inicia el manejo de la vista de modificación.
     *
     * Muestra la vista y configura los eventos para el botón de búsqueda.
     */
    public void gestionarModificacion() {
        vistaModificar.setVisible(true);

        for (ActionListener al : vistaModificar.getBtnBuscar().getActionListeners()) {
            vistaModificar.getBtnBuscar().removeActionListener(al);
        }
        vistaModificar.getBtnBuscar().addActionListener((ActionEvent e) -> {
            String id = vistaModificar.getId();
            if (!id.isEmpty()) {
                try {
                    int idMascota = Integer.parseInt(id);  // Convertir el texto a entero
                    perroActualizado = controlPerro.traerPerroActualizar(idMascota);
                    if (perroActualizado == null) {
                        vistaModificar.limpiarCampos();
                        vistaModificar.idInvalido();
                    } else {
                        // Hacer visibles los campos para la modificación
                        conrolApartadosVisibles();
                    }
                } catch (NumberFormatException ex) {
                    // Manejo de error de formato, puede descomentarse la siguiente línea para informar al usuario  
                    vistaModificar.limpiarCampos();
                    vistaModificar.idInvalido();
                }
            } else {
                // Manejo de error si el campo ID está vacío, puede descomentarse la siguiente línea para informar al usuario
                vistaModificar.idInvalido();
            }
        });

        for (ActionListener al : vistaModificar.getBtnModificar().getActionListeners()) {
            vistaModificar.getBtnModificar().removeActionListener(al);
        }
        vistaModificar.getBtnModificar().addActionListener((ActionEvent e) -> {
            String pelo = vistaModificar.getPeloTextField().getText();
            String color = vistaModificar.getColorTextField().getText();
            String espalda = vistaModificar.getEspaldaTextField().getText();
            String lomo = vistaModificar.getLomoTextField().getText();
            String cola = vistaModificar.getColaTextField().getText();
            String pecho = vistaModificar.getPechoTextField().getText();
            String aparienciaGeneral = vistaModificar.getAparienciaGeneral();

            perroActualizado.setPelo(pelo);
            perroActualizado.setColor(color);
            perroActualizado.setEspalda(espalda);
            perroActualizado.setLomo(lomo);
            perroActualizado.setCola(cola);
            perroActualizado.setPecho(pecho);
            perroActualizado.setAparienciaGeneral(aparienciaGeneral);

            controlPerro.actualizarPerro(perroActualizado);
            vistaModificar.limpiarCampos();
            vistaModificar.ConsultaValida();
            conrolApartadosInvisibles();
        });

        vistaModificar.getBtnCancelar().addActionListener((ActionEvent e) -> {
            vistaModificar.limpiarCampos();
            conrolApartadosInvisibles();
            vistaModificar.dispose();
        });
    }

    public void conrolApartadosInvisibles() {
        vistaModificar.getPeloTextField().setVisible(false);
        vistaModificar.getLblPelo().setVisible(false);
        vistaModificar.getColorTextField().setVisible(false);
        vistaModificar.getLblColor().setVisible(false);
        vistaModificar.getEspaldaTextField().setVisible(false);
        vistaModificar.getLblEspalda().setVisible(false);
        vistaModificar.getLomoTextField().setVisible(false);
        vistaModificar.getLblLomo().setVisible(false);
        vistaModificar.getColaTextField().setVisible(false);
        vistaModificar.getLblCola().setVisible(false);
        vistaModificar.getPechoTextField().setVisible(false);
        vistaModificar.getLblPecho().setVisible(false);
        vistaModificar.getAparienciaGeneralTextField().setVisible(false);
        vistaModificar.getLblAparienciaGeneral().setVisible(false);
        vistaModificar.getBtnModificar().setVisible(false);
        vistaModificar.getIdTextField().setVisible(true);
        vistaModificar.getLblId().setVisible(true);
        vistaModificar.getBtnBuscar().setVisible(true);
    }

    public void conrolApartadosVisibles() {
        vistaModificar.getPeloTextField().setVisible(true);
        vistaModificar.getLblPelo().setVisible(true);
        vistaModificar.getColorTextField().setVisible(true);
        vistaModificar.getLblColor().setVisible(true);
        vistaModificar.getEspaldaTextField().setVisible(true);
        vistaModificar.getLblEspalda().setVisible(true);
        vistaModificar.getLomoTextField().setVisible(true);
        vistaModificar.getLblLomo().setVisible(true);
        vistaModificar.getColaTextField().setVisible(true);
        vistaModificar.getLblCola().setVisible(true);
        vistaModificar.getPechoTextField().setVisible(true);
        vistaModificar.getLblPecho().setVisible(true);
        vistaModificar.getAparienciaGeneralTextField().setVisible(true);
        vistaModificar.getLblAparienciaGeneral().setVisible(true);
        vistaModificar.getBtnModificar().setVisible(true);
        vistaModificar.getIdTextField().setVisible(false);
        vistaModificar.getLblId().setVisible(false);
        vistaModificar.getBtnBuscar().setVisible(false);
    }
}
