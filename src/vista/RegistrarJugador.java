package vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionListener;
import javax.swing.text.BadLocationException;

public class RegistrarJugador extends JFrame implements IDatosParticipantes {

    private final JTextField txtName;
    private final JTextField txtCedula;
    private final JTextField txtAge;
    private final JTextField txtPosicion;
    private final JButton btnSave;

    public RegistrarJugador() {
        setTitle("Registro del jugador");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializamos los JTextField
        txtName = new JTextField(15);
        txtCedula = new JTextField(15);
        txtAge = new JTextField(15);
        txtPosicion = new JTextField(15);

        // Aplicamos filtros para restringir las entradas
        ((AbstractDocument) txtCedula.getDocument()).setDocumentFilter(new NumericFilter());
        ((AbstractDocument) txtAge.getDocument()).setDocumentFilter(new NumericFilter());
        ((AbstractDocument) txtPosicion.getDocument()).setDocumentFilter(new NumericFilter());

        btnSave = new JButton("Registrar");
        btnSave.setBackground(new Color(79, 41, 41));
        btnSave.setForeground(Color.WHITE);
        btnSave.setPreferredSize(new Dimension(100, 30)); // Ajustar tamaño del botón

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(198, 139, 139));
        panel.setBorder(BorderFactory.createTitledBorder("Detalles del Jugador")); // Añadir un borde
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Cédula:"), gbc);
        gbc.gridx = 1;
        panel.add(txtCedula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Edad:"), gbc);
        gbc.gridx = 1;
        panel.add(txtAge, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3; // Cambiar a 3 para que esté en la fila correcta
        panel.add(new JLabel("Posición:"), gbc);
        gbc.gridx = 1;
        panel.add(txtPosicion, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4; // Ajustar la fila para el botón
        panel.add(btnSave, gbc);

        this.add(panel);
    }

    public void setRegistrarJugador(ActionListener listener) {
        btnSave.addActionListener(listener);
    }

    // Métodos para obtener el valor de los TextField
    @Override
    public String obtenerNombrePersona() {
        return txtName.getText();
    }

    @Override
    public int obtenerCedulaPersona() {
        return Integer.parseInt(txtCedula.getText());
    }

    @Override
    public int obtenerEdadPersona() {
        return Integer.parseInt(txtAge.getText());
    }

    public int obtenerPosicionJugador() {
        return Integer.parseInt(txtPosicion.getText());
    }

    public void limpiarCampos() {
        txtName.setText("");
        txtCedula.setText("");
        txtAge.setText("");
        txtPosicion.setText("");
    }
    
    // Filtro para permitir solo números en los campos
    class NumericFilter extends DocumentFilter {

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) {
            if (string.matches("\\d*")) {
                try {
                    super.insertString(fb, offset, string, attr);
                } catch (BadLocationException e) {
                }
            }
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) {
            if (text.matches("\\d*")) {
                try {
                    super.replace(fb, offset, length, text, attrs);
                } catch (BadLocationException e) {
                }
            }
        }
    }

    
}
