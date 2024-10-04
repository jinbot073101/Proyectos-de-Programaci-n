package vista;

import control.GestorConsultaVista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase que representa la vista de consulta de mascotas en la interfaz gráfica.
 */
public class ConsultaVistas extends JFrame {

    private final JButton btnConsultar; // Botón para realizar la consulta
    private final JButton btnCancelar; // Botón para cancelar la acción
    private final JTable tableResultados; // Tabla para mostrar los resultados de la consulta
    private final DefaultTableModel tableModel; // Modelo de la tabla
    private final JComboBox<String> tipoConsulta; // ComboBox para seleccionar el tipo de consulta
    private final JTextField valorConsulta; // Campo de texto para ingresar el valor de consulta
    private final GestorConsultaVista gestorConsultaVista;

    /**
     * Constructor de la clase ConsultaVistas. Inicializa la ventana y sus
     * componentes.
     *
     * @param gestorConsultaVista
     */
    public ConsultaVistas(GestorConsultaVista gestorConsultaVista) {
        this.gestorConsultaVista = gestorConsultaVista;
        setTitle("Consultar Mascota");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2));
        panelSuperior.add(new JLabel("Tipo de Consulta:"));
        tipoConsulta = new JComboBox<>(new String[]{"Por Nombre de Raza", "Por Grupo y Sección FCI", "Por País de Origen", "Por Color de Manto", "Todos los perros"});
        panelSuperior.add(tipoConsulta);

        panelSuperior.add(new JLabel("Valor de Consulta:"));
        valorConsulta = new JTextField();
        panelSuperior.add(valorConsulta);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnConsultar = new JButton("Consultar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnConsultar);
        panelBotones.add(btnCancelar);

        String[] columnas = {"ID", "Raza", "País de Origen", "Clasificación FCI", "Color"};
        tableModel = new DefaultTableModel(columnas, 0);
        tableResultados = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableResultados);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Obtiene el tipo de consulta seleccionado.
     *
     * @return Tipo de consulta seleccionado como String.
     */
    public String getTipoConsultaSeleccionada() {
        return (String) tipoConsulta.getSelectedItem();
    }

    /**
     * Obtiene el valor de consulta ingresado en el campo de texto.
     *
     * @return Valor de consulta como String.
     */
    public String getValorConsulta() {
        return valorConsulta.getText();
    }

    /**
     * Obtiene el botón de consultar.
     *
     * @return JButton para realizar la consulta.
     */
    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    /**
     * Obtiene el botón de cancelar.
     *
     * @return JButton para cancelar la acción.
     */
    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    /**
     * Muestra los resultados en la tabla.
     *
     * @param resultados Lista de resultados a mostrar, donde cada fila es un
     * arreglo de objetos.
     */
    public void mostrarResultados(List<Object[]> resultados) {
        tableModel.setRowCount(0); // Limpia la tabla antes de mostrar nuevos resultados
        gestorConsultaVista.actualizarTabla(resultados);
    }

    /**
     * Muestra un mensaje de error.
     *
     * @param mensaje Mensaje de error a mostrar.
     */
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje indicando que el tipo de consulta es inválido.
     */
    public void tipoConsultaInvalida() {
        JOptionPane.showMessageDialog(null, "Ingrese una consulta correcta");
    }

    /**
     * Muestra un mensaje indicando que el valor de consulta es inválido.
     */
    public void ConsultaInvalida() {
        JOptionPane.showMessageDialog(null, "Ingrese un valor de consulta válido");
    }

    /**
     * Muestra un mensaje indicando que no se encontraron resultados.
     */
    public void ArrayInvalido() {
        JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
    }

    /**
     * Agrega un ActionListener al botón de consultar.
     *
     * @param listener ActionListener a agregar.
     */
    public void botonConsultar(ActionListener listener) {
        btnConsultar.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al botón de cancelar.
     *
     * @param listener ActionListener a agregar.
     */
    public void botonCancelar(ActionListener listener) {
        btnCancelar.addActionListener(listener);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
