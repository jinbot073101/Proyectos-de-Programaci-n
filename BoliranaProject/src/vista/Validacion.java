package vista;

import java.awt.event.ActionListener;
import javax.swing.*;

public class Validacion extends JFrame {

    private final JLabel labelPregunta1;
    private final JLabel labelPregunta2;
    private final JRadioButton rbSi1, rbNo1, rbSi2, rbNo2;
    private final JTextField textFieldEquipo;
    private final JButton btnAceptar;
    private final ButtonGroup grupo1;
    private final ButtonGroup grupo2;

    public Validacion() {
        // Configuración del JFrame
        setTitle("Validación de Equipos y Participantes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Primera pregunta
        labelPregunta1 = new JLabel("¿Todos los equipos están presentes al iniciar el torneo?");
        labelPregunta1.setBounds(20, 20, 350, 20);
        add(labelPregunta1);

        rbSi1 = new JRadioButton("Sí");
        rbSi1.setBounds(20, 50, 50, 20);
        rbNo1 = new JRadioButton("No");
        rbNo1.setBounds(80, 50, 50, 20);

        grupo1 = new ButtonGroup();
        grupo1.add(rbSi1);
        grupo1.add(rbNo1);
        add(rbSi1);
        add(rbNo1);

        // Campo de texto para ingresar equipo no presente
        textFieldEquipo = new JTextField();
        textFieldEquipo.setBounds(20, 80, 200, 20);
        textFieldEquipo.setVisible(false);
        add(textFieldEquipo);

        // Botón Aceptar para confirmar equipo no presente
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(240, 80, 100, 20);
        btnAceptar.setVisible(false);
        add(btnAceptar);

        // Segunda pregunta (oculta al principio)
        labelPregunta2 = new JLabel("¿De los equipos presentes están todos los participantes?");
        labelPregunta2.setBounds(20, 130, 350, 20);
        labelPregunta2.setVisible(false);
        add(labelPregunta2);

        rbSi2 = new JRadioButton("Sí");
        rbSi2.setBounds(20, 160, 50, 20);
        rbSi2.setVisible(false);
        rbNo2 = new JRadioButton("No");
        rbNo2.setBounds(80, 160, 50, 20);
        rbNo2.setVisible(false);

        grupo2 = new ButtonGroup();
        grupo2.add(rbSi2);
        grupo2.add(rbNo2);
        add(rbSi2);
        add(rbNo2);
    }

    // Métodos para validar cuales botones fueron presionados
    public boolean setEquipoPresenteNo() {
        return rbNo1.isSelected();
    }

    public boolean setEquipoPresenteSi() {
        return rbSi1.isSelected();
    }

    public boolean setEquipoCompletoNo() {
        return rbNo2.isSelected();
    }

    public boolean setEquipoCompletoSi() {
        return rbSi2.isSelected();
    }

    public void setBotonAceptar(ActionListener listener) {
        btnAceptar.addActionListener(listener);
    }

    public void mostrarCampoEquipo(boolean mostrar) {
        textFieldEquipo.setVisible(mostrar);
        btnAceptar.setVisible(mostrar);
    }

    public String getTextoEquipo() {
        return textFieldEquipo.getText();
    }

    public void mostrarSegundaPregunta(boolean mostrar) {
        labelPregunta2.setVisible(mostrar);
        rbSi2.setVisible(mostrar);
        rbNo2.setVisible(mostrar);
    }

    public void ocultarCampos() {
        textFieldEquipo.setVisible(false);
        btnAceptar.setVisible(false);
    }
}
