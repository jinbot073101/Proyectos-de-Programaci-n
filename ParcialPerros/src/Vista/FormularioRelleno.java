package Vista;

import Servicios.GestorVistasFormulario;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.*;

public class FormularioRelleno extends JFrame{
    
    private final GestorVistasFormulario gestorVistaFormulario;
    private final JLabel tituloLabel;
    private final JLabel turnoLabel;
    private int turnoActual = 1;
    // TextFields individuales
    private final JTextField peloTextField;
    private final JTextField colorTextField;
    private final JTextField espaldaTextField;
    private final JTextField lomoTextField;
    private final JTextField colaTextField;
    private final JTextField pechoTextField;
    private final JTextField descripcionTextField;
    private final JButton completarButton;
    private String opcionSeleccionada;
    private final int ancho = 200; // Inicializa ancho con un valor
    private final JComboBox<String> clasificacionComboBox; // ComboBox principal
    private final JPopupMenu subMenu; // PopupMenu para mostrar sub-opciones

    public FormularioRelleno() {
        this.gestorVistaFormulario = new GestorVistasFormulario(this);
        // Configuración básica del JFrame
        setTitle("Complete los datos del perro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(579, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear panel principal donde estarán los campos
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);

        // Título
        tituloLabel = new JLabel("Complete los datos del perro", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        tituloLabel.setForeground(Color.BLUE);
        add(tituloLabel, BorderLayout.NORTH);

        // Turno del perro
        turnoLabel = new JLabel("Perro 1", JLabel.CENTER);
        turnoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(turnoLabel, BorderLayout.SOUTH);

        // Labels y TextFields individuales
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_START;

        // Clasificación FCI
        gbc.gridy = 0;
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
        gbc.gridy = 1;
        panel.add(new JLabel("Pelo:"), gbc);
        peloTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(peloTextField, gbc);

        // Color
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Color:"), gbc);
        colorTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(colorTextField, gbc);

        // Espalda
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Espalda:"), gbc);
        espaldaTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(espaldaTextField, gbc);

        // Lomo
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Lomo:"), gbc);
        lomoTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(lomoTextField, gbc);

        // Cola
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Cola:"), gbc);
        colaTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(colaTextField, gbc);

        // Pecho
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Pecho:"), gbc);
        pechoTextField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(pechoTextField, gbc);

        // Descripción general
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Descripción general:"), gbc);
        descripcionTextField = new JTextField(25);
        gbc.gridx = 1;
        panel.add(descripcionTextField, gbc);
        

        // Botón Completar
        completarButton = new JButton("Completar");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(completarButton, gbc);

        add(panel, BorderLayout.CENTER);

        // Crear el PopupMenu para sub-opciones
        subMenu = new JPopupMenu();

        // Listener para el combo principal
        clasificacionComboBox.addActionListener(e -> {
            String selectedItem = (String) clasificacionComboBox.getSelectedItem();
            gestorVistaFormulario.actualizarSubMenu(selectedItem);
        });
    }

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

    // Añadir un listener al botón completar
    public void botonCompletar(ActionListener listener) {
        completarButton.addActionListener(listener);
    }

    public JButton getBotonCompletar() {
        return completarButton;
    }

    // Métodos que retornan los campos de valor y los atributos de clase necesarios donde se registran los datos de un perro
    public JTextField getPeloTextField() {
        return peloTextField;
    }

    public JTextField getColorTextField() {
        return colorTextField;
    }

    public JTextField getEspaldaTextField() {
        return espaldaTextField;
    }

    public JTextField getLomoTextField() {
        return lomoTextField;
    }

    public JTextField getColaTextField() {
        return colaTextField;
    }

    public JTextField getPechoTextField() {
        return pechoTextField;
    }

    public JTextField getDescripcionTextField() {
        return descripcionTextField;
    }

    public JComboBox<String> getClasificacionComboBox() {
        return clasificacionComboBox; // Devuelve el JComboBox, no el ítem seleccionado
    }

    public String getSelectedClasificacion() {
        return (String) clasificacionComboBox.getSelectedItem(); // Devuelve el ítem seleccionado
    }

    public JPopupMenu getSubMenu() {
        return subMenu;
    }

    public String getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccionada(String opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    public int getAncho() {
        return ancho;
    }

    // Método de mensaje para informar el ingreso del perro
    public void informarIngresoPerro() {
        JOptionPane.showMessageDialog(null, "El perro fue actualizado correctamente", "Validación", JOptionPane.INFORMATION_MESSAGE);
    }

    public void informarPerrosActualizados() {
        JOptionPane.showMessageDialog(null, "Todos los perros fueron actualizados correctamente", "Validación", JOptionPane.INFORMATION_MESSAGE);
    }

    public void informarDatosIncompletos() {
        JOptionPane.showMessageDialog(null, "Se han encontrado registrados ciertos perros con datos incompletos\nPor favor ayude a completar.", "Gestion de programa", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para limpiar los campos
    public void limpiarCampos() {
        peloTextField.setText("");
        colorTextField.setText("");
        espaldaTextField.setText("");
        lomoTextField.setText("");
        colaTextField.setText("");
        pechoTextField.setText("");
        descripcionTextField.setText("");
        clasificacionComboBox.setSelectedIndex(0);
    }

    // Método para actualizar el turno del perro
    public void actualizarTurno() {
        turnoActual++;
        if (turnoActual <= 4) {
            turnoLabel.setText("Perro " + turnoActual);
        } else {
            turnoLabel.setText("Todos los perros han sido ingresados.");
        }
    }
    
}
