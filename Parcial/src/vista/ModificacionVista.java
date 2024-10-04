package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase ModificacionVista que representa la interfaz gráfica para modificar los
 * datos de un perro en el sistema. La vista permite buscar un perro por su ID y
 * modificar características como el pelo, color, espalda, entre otras.
 */
public class ModificacionVista extends JFrame {

    // Componentes de la interfaz
    private final JTextField idTextField;
    private final JTextField peloTextField;
    private final JTextField colorTextField;
    private final JTextField espaldaTextField;
    private final JTextField lomoTextField;
    private final JTextField colaTextField;
    private final JTextField pechoTextField;
    private final JTextField aparienciaGeneralTextField;

    private final JLabel lblCola;
    private final JLabel lblId;
    private final JLabel lblPelo;
    private final JLabel lblColor;
    private final JLabel lblEspalda;
    private final JLabel lblLomo;
    private final JLabel lblPecho;
    private final JLabel lblAparienciaGeneral;

    private final JButton btnBuscar;
    private final JButton btnModificar;
    private final JButton btnCancelar;

    public ModificacionVista() {

        setTitle("Modificar Datos del Perro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 5, 5)); // Usar GridLayout para organizar los componentes

        lblId = new JLabel("ID:");
        idTextField = new JTextField();

        lblPelo = new JLabel("Pelo:");
        peloTextField = new JTextField();

        lblColor = new JLabel("Color:");
        colorTextField = new JTextField();

        lblEspalda = new JLabel("Espalda:");
        espaldaTextField = new JTextField();

        lblLomo = new JLabel("Lomo:");
        lomoTextField = new JTextField();

        lblCola = new JLabel("Cola:");
        colaTextField = new JTextField();

        lblPecho = new JLabel("Pecho:");
        pechoTextField = new JTextField();

        lblAparienciaGeneral = new JLabel("Apariencia general:");
        aparienciaGeneralTextField = new JTextField();

        // Botones
        btnBuscar = new JButton("Buscar");
        btnModificar = new JButton("Modificar");
        btnCancelar = new JButton("Cancelar");

        // Agregar componentes a la ventana
        add(lblId);
        add(idTextField);

        add(lblPelo);
        add(peloTextField);
        lblPelo.setVisible(false);
        peloTextField.setVisible(false);

        add(lblColor);
        add(colorTextField);
        lblColor.setVisible(false);
        colorTextField.setVisible(false);

        add(lblEspalda);
        add(espaldaTextField);
        lblEspalda.setVisible(false);
        espaldaTextField.setVisible(false);

        add(lblLomo);
        add(lomoTextField);
        lblLomo.setVisible(false);
        lomoTextField.setVisible(false);

        add(lblCola);
        add(colaTextField);
        lblCola.setVisible(false);
        colaTextField.setVisible(false);

        add(lblPecho);
        add(pechoTextField);
        lblPecho.setVisible(false);
        pechoTextField.setVisible(false);

        add(lblAparienciaGeneral);
        add(aparienciaGeneralTextField);
        lblAparienciaGeneral.setVisible(false);
        aparienciaGeneralTextField.setVisible(false);

        add(btnBuscar);
        add(btnModificar);
        add(btnCancelar);
        btnModificar.setVisible(false);

    }

    /**
     * Obtiene el campo de texto para el ID del perro.
     *
     * @return JTextField del ID del perro.
     */
    public JTextField getIdTextField() {
        return idTextField;
    }

    /**
     * Obtiene el campo de texto para el pelo del perro.
     *
     * @return JTextField del pelo del perro.
     */
    public JTextField getPeloTextField() {
        return peloTextField;
    }

    /**
     * Obtiene el campo de texto para el color del perro.
     *
     * @return JTextField del color del perro.
     */
    public JTextField getColorTextField() {
        return colorTextField;
    }

    /**
     * Obtiene el campo de texto para la espalda del perro.
     *
     * @return JTextField de la espalda del perro.
     */
    public JTextField getEspaldaTextField() {
        return espaldaTextField;
    }

    /**
     * Obtiene el campo de texto para el lomo del perro.
     *
     * @return JTextField del lomo del perro.
     */
    public JTextField getLomoTextField() {
        return lomoTextField;
    }

    /**
     * Obtiene el campo de texto para la cola del perro.
     *
     * @return JTextField de la cola del perro.
     */
    public JTextField getColaTextField() {
        return colaTextField;
    }

    /**
     * Obtiene el campo de texto para el pecho del perro.
     *
     * @return JTextField del pecho del perro.
     */
    public JTextField getPechoTextField() {
        return pechoTextField;
    }

    /**
     * Obtiene el campo de texto para la apariencia general del perro.
     *
     * @return JTextField de la apariencia general del perro.
     */
    public JTextField getAparienciaGeneralTextField() {
        return aparienciaGeneralTextField;
    }

    /**
     * Obtiene el valor ingresado en el campo de texto del ID.
     *
     * @return String con el ID del perro.
     */
    public String getId() {
        return idTextField.getText();
    }

    /**
     * Obtiene el valor ingresado en el campo de texto del pelo.
     *
     * @return String con el valor del pelo del perro.
     */
    public String getPelo() {
        return peloTextField.getText();
    }

    /**
     * Obtiene el valor ingresado en el campo de texto del color.
     *
     * @return String con el color del perro.
     */
    public String getColor() {
        return colorTextField.getText();
    }

    /**
     * Obtiene el valor ingresado en el campo de texto de la espalda.
     *
     * @return String con la espalda del perro.
     */
    public String getEspalda() {
        return espaldaTextField.getText();
    }

    /**
     * Obtiene el valor ingresado en el campo de texto del lomo.
     *
     * @return String con el lomo del perro.
     */
    public String getLomo() {
        return lomoTextField.getText();
    }

    /**
     * Obtiene el valor ingresado en el campo de texto de la cola.
     *
     * @return String con la cola del perro.
     */
    public String getCola() {
        return colaTextField.getText();
    }

    /**
     * Obtiene el valor ingresado en el campo de texto del pecho.
     *
     * @return String con el pecho del perro.
     */
    public String getPecho() {
        return pechoTextField.getText();
    }

    /**
     * Obtiene el valor ingresado en el campo de texto de la apariencia general.
     *
     * @return String con la apariencia general del perro.
     */
    public String getAparienciaGeneral() {
        return aparienciaGeneralTextField.getText();
    }

    /**
     * Obtiene el botón de búsqueda.
     *
     * @return JButton del botón de buscar.
     */
    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    /**
     * Obtiene el botón de modificar.
     *
     * @return JButton del botón de modificar.
     */
    public JButton getBtnModificar() {
        return btnModificar;
    }

    /**
     * Obtiene el botón de cancelar.
     *
     * @return JButton del botón de cancelar.
     */
    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    /**
     * Obtiene la etiqueta para el pelo del perro.
     *
     * @return JLabel de la etiqueta del pelo.
     */
    public JLabel getLblPelo() {
        return lblPelo;
    }

    /**
     * Obtiene la etiqueta para el color del perro.
     *
     * @return JLabel de la etiqueta del color.
     */
    public JLabel getLblColor() {
        return lblColor;
    }

    /**
     * Obtiene la etiqueta para la espalda del perro.
     *
     * @return JLabel de la etiqueta de la espalda.
     */
    public JLabel getLblEspalda() {
        return lblEspalda;
    }

    /**
     * Obtiene la etiqueta para el lomo del perro.
     *
     * @return JLabel de la etiqueta del lomo.
     */
    public JLabel getLblLomo() {
        return lblLomo;
    }

    /**
     * Obtiene la etiqueta para el lomo del perro.
     *
     * @return JLabel de la etiqueta del id
     */
    public JLabel getLblId() {
        return lblId;
    }

    /**
     * Obtiene la etiqueta para la cola del perro.
     *
     * @return JLabel de la etiqueta de la cola.
     */
    public JLabel getLblCola() {
        return lblCola;
    }

    /**
     * Obtiene la etiqueta para el pecho del perro.
     *
     * @return JLabel de la etiqueta del pecho.
     */
    public JLabel getLblPecho() {
        return lblPecho;
    }

    /**
     * Obtiene la etiqueta para la apariencia general del perro.
     *
     * @return JLabel de la etiqueta de apariencia general.
     */
    public JLabel getLblAparienciaGeneral() {
        return lblAparienciaGeneral;
    }

    /**
     * Método para agregar un ActionListener al botón de buscar.
     *
     * @param listener ActionListener para el botón de buscar.
     */
    public void botonBuscar(ActionListener listener) {
        btnBuscar.addActionListener(listener);
    }

    /**
     * Método para agregar un ActionListener al botón de modificar.
     *
     * @param listener ActionListener para el botón de modificar.
     */
    public void botonModificar(ActionListener listener) {
        btnModificar.addActionListener(listener);
    }

    /**
     * Método para agregar un ActionListener al botón de cancelar.
     *
     * @param listener ActionListener para el botón de cancelar.
     */
    public void botonCancelar(ActionListener listener) {
        btnCancelar.addActionListener(listener);
    }

    public void idInvalido() {
        JOptionPane.showMessageDialog(null, "Ingrese un ID valido");
    }

    public void ConsultaValida() {
        JOptionPane.showMessageDialog(null, "cambio realizado...");
    }

    /**
     * Método para limpiar los campos de texto después de modificar.
     */
    public void limpiarCampos() {
        idTextField.setText("");
        peloTextField.setText("");
        colorTextField.setText("");
        espaldaTextField.setText("");
        lomoTextField.setText("");
        colaTextField.setText("");
        pechoTextField.setText("");
        aparienciaGeneralTextField.setText("");
    }
}
