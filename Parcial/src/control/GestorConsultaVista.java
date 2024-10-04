package control;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.PerroVO;
import vista.ConsultaVistas;

/**
 * Clase que gestiona la lógica de la vista de consultas de perros.
 *
 * Esta clase se encarga de la interacción entre la vista de consultas y el
 * controlador de perros, permitiendo realizar consultas sobre los perros
 * registrados.
 */
public class GestorConsultaVista {

    /**
     * Vista para realizar consultas sobre perros
     */
    private final ConsultaVistas vistaConsulta;

    /**
     * Controlador que maneja las operaciones relacionadas con perros
     */
    private final IControlPerro controlPerro;

    /**
     * Lista que almacena los resultados de la consulta de perros
     */
    private ArrayList<PerroVO> consultaPerros;

    /**
     * Constructor de GestorConsultaVista.
     *
     * @param controlPerro Controlador que se utilizará para realizar consultas
     * sobre perros.
     */
    public GestorConsultaVista(IControlPerro controlPerro) {
        this.vistaConsulta = new ConsultaVistas(this);
        this.controlPerro = controlPerro;
    }

    /**
     * Inicia el manejo de la vista de consulta.
     *
     * Muestra la vista y configura los eventos para los botones de consulta y
     * cancelación.
     */
    public void gestionarConsulta() {
        vistaConsulta.setVisible(true);
        // Botón para realizar la consulta
        vistaConsulta.getBtnConsultar().addActionListener((ActionEvent e) -> {
            String consultaSeleccionada = vistaConsulta.getTipoConsultaSeleccionada();  // Obtener el tipo de consulta
            String valorConsulta = vistaConsulta.getValorConsulta();                    // Obtener el valor ingresado

            if (!valorConsulta.isEmpty() && !consultaSeleccionada.isEmpty()) {
                consultaPerros = controlPerro.consultarPerro(valorConsulta, consultaSeleccionada);
                ArrayList<Object[]> resultados = new ArrayList<>();

                for (PerroVO perro : consultaPerros) {
                    resultados.add(new Object[]{
                        perro.getId(),
                        perro.getNombreRaza(),
                        perro.getPaisOrigen(),
                        perro.getClasificacionFCI(),
                        perro.getColor()
                    });
                }
                if (consultaPerros != null && !consultaPerros.isEmpty()) {
                    vistaConsulta.mostrarResultados(resultados);
                } else {
                    vistaConsulta.ArrayInvalido();
                }
            } else {
                vistaConsulta.ConsultaInvalida();
            }
        });

        // Botón para cancelar la acción
        vistaConsulta.getBtnCancelar().addActionListener((ActionEvent e) -> {
            vistaConsulta.dispose();  // Cerrar la ventana
        });
    }

    public void actualizarTabla(List<Object[]> resultados) {
        for (Object[] fila : resultados) {
            vistaConsulta.getTableModel().addRow(fila); // Asumiendo que tienes un método para obtener el modelo de la tabla
        }
    }
}
