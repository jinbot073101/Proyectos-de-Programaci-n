package vista;

import servicios.GestorVistaIngreso;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IngresoVista extends JFrame {

    private final GestorVistaIngreso gestorVistaIngreso;
    private final JLabel tituloLabel;
    // TextFields individuales
    private final JTextField razaTextField;
    private final JTextField paisOrigenTextField;
    private final JTextField peloTextField;
    private final JTextField colorTextField;
    private final JTextField espaldaTextField;
    private final JTextField lomoTextField;
    private final JTextField colaTextField;
    private final JTextField pechoTextField;
    private final JTextField descripcionTextField;
    private final JButton registrarButton;
    private String opcionSeleccionada;
    private int ancho;
    private final JComboBox<String> clasificacionComboBox; // ComboBox principal
    private final JPopupMenu subMenu; // PopupMenu para mostrar sub-opciones

    /**
     * Constructor de la clase IngresoVista. Inicializa los componentes de la
     * interfaz gráfica para el registro de perros, como el panel principal, los
     * campos de texto, el ComboBox para la clasificación FCI, y el botón de
     * registrar. También configura el JFrame con un tamaño y título
     * específicos.
     */
    public IngresoVista() {
        this.gestorVistaIngreso = new GestorVistaIngreso(this);
        // Configuración básica del JFrame
        setTitle("Registro de Perros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(579, 650); // Aumentar el tamaño vertical para más espacio
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear panel principal donde estarán los campos
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20); // Ajustar los márgenes (top, left, bottom, right)

        // Título
        tituloLabel = new JLabel("Registre los datos del perro", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        tituloLabel.setForeground(Color.BLUE); // Cambiar el color del título
        add(tituloLabel, BorderLayout.NORTH);  // Añadir título al borde norte del JFrame

        // Añadir los campos de texto y etiquetas (Raza, País de origen, Clasificación FCI, etc.)
        // Cada campo tiene su respectivo JLabel y JTextField
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_START; // Alinear a la izquierda

        // Raza
        gbc.gridy = 0;
        panel.add(new JLabel("Raza:"), gbc);
        razaTextField = new JTextField(20);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panel.add(razaTextField, gbc);

        // País de origen
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("País de origen:"), gbc);
        paisOrigenTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(paisOrigenTextField, gbc);

        // Clasificación FCI
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Clasificación FCI:"), gbc);
        clasificacionComboBox = new JComboBox<>(new String[]{
            "Grupo I: Perros de pastor y perros boyeros",
            "Grupo II: Perros Pinscher, Schnauzer, Molosoide",
            "Grupo III: Perros Terriers",
            "Grupo IV: Perros Dachshund o Teckel",
            "Grupo V: Perros tipo Spitz y primitivo",
            "Grupo VI: Perros tipo sabueso y rastreo",
            "Grupo VII: Perros de muestra",
            "Grupo VIII: Perros cobradores, cazadores y perros de aguas",
            "Grupo IX: Perros de compañía",
            "Grupo X: Perros lebreles"
        });
        gbc.gridx = 1;
        panel.add(clasificacionComboBox, gbc);

        // Pelo
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Pelo:"), gbc);
        peloTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(peloTextField, gbc);

        // Color
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Color:"), gbc);
        colorTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(colorTextField, gbc);

        // Espalda
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Espalda:"), gbc);
        espaldaTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(espaldaTextField, gbc);

        // Lomo
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Lomo:"), gbc);
        lomoTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(lomoTextField, gbc);

        // Cola
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Cola:"), gbc);
        colaTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(colaTextField, gbc);

        // Pecho
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Pecho:"), gbc);
        pechoTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(pechoTextField, gbc);

        // Label y TextField para "Descripción general"
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Descripción general:"), gbc);
        descripcionTextField = new JTextField(25);  // Más grande que los demás
        gbc.gridx = 1;
        panel.add(descripcionTextField, gbc);

        // Botón Registrar
        registrarButton = new JButton("Registrar");
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registrarButton, gbc);

        // Añadir el panel al centro del JFrame
        add(panel, BorderLayout.CENTER);

        // Crear el PopupMenu para sub-opciones
        subMenu = new JPopupMenu();

        // Listener para el combo principal
        clasificacionComboBox.addActionListener(e -> {
            String selectedItem = (String) clasificacionComboBox.getSelectedItem();
            gestorVistaIngreso.actualizarSubMenu(selectedItem);
        });
        SwingUtilities.invokeLater(() -> {
            // Validar y repintar el JComboBox
            clasificacionComboBox.revalidate();
            clasificacionComboBox.repaint();

            // Obtener el ancho del JComboBox ya visible
            ancho = clasificacionComboBox.getWidth();
        });
    }

    /**
     * Obtiene un arreglo de sub-opciones basado en la clasificación FCI
     * seleccionada. Cada grupo de perros de la FCI tiene una serie de
     * subcategorías que son devueltas según la opción seleccionada en el
     * JComboBox.
     *
     * @param selectedItem la opción seleccionada en el JComboBox de
     * clasificación FCI.
     * @return un arreglo de Strings que contiene las subcategorías
     * correspondientes al grupo seleccionado. Si no hay coincidencias, se
     * devuelve un arreglo vacío.
     */
    public String[] obtenerSubOpciones(String selectedItem) {
        return switch (selectedItem) {
            case "Grupo I: Perros de pastor y perros boyeros" ->
                new String[]{"Perros de pastor", "Perros boyeros"};
            case "Grupo II: Perros Pinscher, Schnauzer, Molosoide" ->
                new String[]{"Perros Pinscher y Schnauzer", "Perros Molosoides", "Perros tipo montaña y boyeros suizos"};
            case "Grupo III: Perros Terriers" ->
                new String[]{"Terriers de talla grande y media", "Terriers de talla pequeña", "Terriers tipo bull", "Terriers de compañía"};
            case "Grupo V: Perros tipo Spitz y primitivo" ->
                new String[]{"Perros nórdicos de trineo", "Perros nórdicos de cacería", "Perros nórdicos de guarda y pastoreo", "Spitz europeos", "Spitz asiáticos y razas semejantes", "Tipo primitivo", "Tipo primitivo - perros de caza"};
            case "Grupo VI: Perros tipo sabueso y rastreo" ->
                new String[]{"Perros tipo sabueso", "Perros de rastro", "Razas semejantes"};
            case "Grupo VII: Perros de muestra" ->
                new String[]{"Perros de muestra continentales", "Perros de muestra ingleses e irlandeses"};
            case "Grupo VIII: Perros cobradores, cazadores y perros de aguas" ->
                new String[]{"Perros cobradores de caza", "Perros levantadores de caza", "Perros de agua"};
            case "Grupo IX: Perros de compañía" ->
                new String[]{"Bichons y razas semejantes", "Caniche", "Perros belga de talla pequeña", "Perros sin pelos", "Perros tibetanos", "Chihuahueno", "Spaniels ingleses de compañía", "Spaniels japoneses y pekineses", "Spaniels continental enano y otro", "Kromfohrländer", "Molosoides de talla pequeña"};
            case "Grupo X: Perros lebreles" ->
                new String[]{"Lebreles de pelo largo u ondulado", "Lebreles de pelo duro", "Lebreles de pelo corto"};
            default ->
                new String[0];
        };
    }

    /**
     * Añade un ActionListener al botón "Registrar". Este método permite agregar
     * un controlador al botón encargado de registrar los datos del perro.
     *
     * @param listener el ActionListener que será asignado al botón.
     */
    public void botonIngresar(ActionListener listener) {
        registrarButton.addActionListener(listener);
    }

    /**
     * Retorna el botón "Registrar" para poder ser utilizado por otras clases,
     * como el controlador general.
     *
     * @return el JButton correspondiente al botón "Registrar".
     */
    public JButton getBotonIngresar() {
        return registrarButton;
    }

    /**
     * Retorna el campo de texto donde se ingresa la raza del perro.
     *
     * @return el JTextField correspondiente al campo de raza.
     */
    public JTextField getRazaTextField() {
        return razaTextField;
    }

    /**
     * Retorna el campo de texto donde se ingresa el país de origen del perro.
     *
     * @return el JTextField correspondiente al campo de país de origen.
     */
    public JTextField getPaisOrigenTextField() {
        return paisOrigenTextField;
    }

    /**
     * Retorna el campo de texto donde se ingresa el tipo de pelo del perro.
     *
     * @return el JTextField correspondiente al campo de pelo.
     */
    public JTextField getPeloTextField() {
        return peloTextField;
    }

    /**
     * Retorna el campo de texto donde se ingresa el color del perro.
     *
     * @return el JTextField correspondiente al campo de color.
     */
    public JTextField getColorTextField() {
        return colorTextField;
    }

    /**
     * Retorna el campo de texto donde se ingresa la descripción de la espalda
     * del perro.
     *
     * @return el JTextField correspondiente al campo de espalda.
     */
    public JTextField getEspaldaTextField() {
        return espaldaTextField;
    }

    /**
     * Retorna el campo de texto donde se ingresa la descripción del lomo del
     * perro.
     *
     * @return el JTextField correspondiente al campo de lomo.
     */
    public JTextField getLomoTextField() {
        return lomoTextField;
    }

    /**
     * Retorna el campo de texto donde se ingresa la descripción de la cola del
     * perro.
     *
     * @return el JTextField correspondiente al campo de cola.
     */
    public JTextField getColaTextField() {
        return colaTextField;
    }

    /**
     * Retorna el campo de texto donde se ingresa la descripción del pecho del
     * perro.
     *
     * @return el JTextField correspondiente al campo de pecho.
     */
    public JTextField getPechoTextField() {
        return pechoTextField;
    }

    /**
     * Retorna el campo de texto donde se ingresa la descripción general del
     * perro.
     *
     * @return el JTextField correspondiente al campo de descripción general.
     */
    public JTextField getDescripcionTextField() {
        return descripcionTextField;
    }

    /**
     * Retorna el JComboBox donde se selecciona la clasificación FCI del perro.
     *
     * @return el JComboBox con las opciones de clasificación FCI.
     */
    public JComboBox<String> getClasificacionComboBox() {
        return clasificacionComboBox;
    }

    /**
     * Retorna la opción seleccionada en el JComboBox de clasificación FCI.
     *
     * @return un String que contiene la opción seleccionada.
     */
    public String getSelectedClasificacion() {
        return (String) clasificacionComboBox.getSelectedItem();
    }

    /**
     * Retorna el JPopupMenu que contiene las sub-opciones relacionadas con la
     * clasificación FCI.
     *
     * @return el JPopupMenu que se utiliza para mostrar las sub-opciones.
     */
    public JPopupMenu getSubMenu() {
        return subMenu;
    }

    /**
     * Retorna la sub-opción seleccionada dentro del menú.
     *
     * @return un String que contiene la sub-opción seleccionada.
     */
    public String getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    /**
     * Asigna la sub-opción seleccionada en el menú.
     *
     * @param opcionSeleccionada la opción seleccionada a establecer.
     */
    public void setOpcionSeleccionada(String opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    /**
     * Retorna el ancho del JComboBox de clasificación FCI.
     *
     * @return el ancho en píxeles del JComboBox.
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Muestra un mensaje de confirmación cuando un perro es ingresado
     * correctamente en la base de datos.
     */
    public void informarIngresoPerro() {
        JOptionPane.showMessageDialog(null, "El perro fue ingresado a la base de datos correctamente.", "Validación", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje de error indicando que los datos ingresados están
     * incompletos o no son válidos.
     */
    public void datosIncompletos() {
        JOptionPane.showMessageDialog(null, "Los datos no son válidos, por favor llenar los datos.", "Error de ingreso", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje solicitando al usuario que ingrese los datos del perro
     * correctamente.
     */
    public void pedirDatos() {
        JOptionPane.showMessageDialog(null, "Por favor ingrese los datos del perro correctamente.", "Error de ingreso", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje de error indicando que el perro ya está registrado en
     * la base de datos.
     */
    public void perroRepetido() {
        JOptionPane.showMessageDialog(null, "Este perro ya existe en la BD.", "Error de ingreso", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Resetea todos los campos de texto y reinicia el ComboBox de clasificación
     * a su valor inicial. Este método limpia los campos de entrada de datos
     * utilizados para registrar un perro, estableciendo cadenas vacías para los
     * campos de texto y seleccionando el primer valor del JComboBox.
     */
    public void limpiarCampos() {
        razaTextField.setText("");
        paisOrigenTextField.setText("");
        peloTextField.setText("");
        colorTextField.setText("");
        espaldaTextField.setText("");
        lomoTextField.setText("");
        colaTextField.setText("");
        pechoTextField.setText("");
        descripcionTextField.setText("");
        clasificacionComboBox.setSelectedIndex(0);//Reinicia el ComboBox
    }
}
