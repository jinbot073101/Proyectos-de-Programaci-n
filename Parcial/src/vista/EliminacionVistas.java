package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase que representa la vista para la eliminación de mascotas en la interfaz
 * gráfica.
 */
public class EliminacionVistas extends JFrame {

    private final JTextField txtIdMascota;  // Campo de texto para el ID de la mascota
    private final JButton btnEliminar; // Botón para eliminar la mascota
    private final JButton btnCancelar; // Botón para cancelar la acción

    /**
     * Constructor de la clase EliminacionVistas. Inicializa la ventana y sus
     * componentes.
     */
    public EliminacionVistas() {
        setTitle("Eliminar Mascota");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar la ventana
        setLayout(new GridLayout(3, 2));  // Usar un GridLayout para organizar los componentes

        // Etiqueta y campo de texto para el ID de la mascota
        JLabel lblIdMascota = new JLabel("ID de la Mascota:");
        txtIdMascota = new JTextField(10);
        btnEliminar = new JButton("Eliminar");
        btnCancelar = new JButton("Cancelar");

        // Agregar los componentes a la ventana
        add(lblIdMascota);
        add(txtIdMascota);
        add(btnEliminar);
        add(btnCancelar);
    }

    /**
     * Agrega un ActionListener al botón de eliminar.
     *
     * @param listener ActionListener a agregar.
     */
    public void botonEliminar(ActionListener listener) {
        btnEliminar.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al botón de cancelar.
     *
     * @param listener ActionListener a agregar.
     */
    public void botonCancelar(ActionListener listener) {
        btnCancelar.addActionListener(listener);
    }

    /**
     * Obtiene el botón de eliminar.
     *
     * @return JButton para eliminar la mascota.
     */
    public JButton getBotonEliminar() {
        return btnEliminar;
    }

    /**
     * Obtiene el botón de cancelar.
     *
     * @return JButton para cancelar la acción.
     */
    public JButton getBotonCancelar() {
        return btnCancelar;
    }

    /**
     * Obtiene el campo de texto para el ID de la mascota.
     *
     * @return JTextField que contiene el ID de la mascota.
     */
    public JTextField getTxtIdMascota() {
        return txtIdMascota;
    }

    /**
     * Muestra un mensaje de error si el ID ingresado es inválido.
     */
    public void idInvalido() {
        JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
    }

    /**
     * Muestra un mensaje solicitando al usuario que ingrese el ID de la
     * mascota.
     */
    public void ingresarId() {
        JOptionPane.showMessageDialog(null, "Por favor ingresa el ID de la mascota.");
    }

    /**
     * Muestra un mensaje informando al usuario sobre la forma de eliminación.
     */
    public void informarFormaEliminacion() {
        JOptionPane.showMessageDialog(null, """
                                            Para poder eliminar el registro de un perro, debe conocer su ID asociado.
                                            Puede conocer este dato consultando el perro primero.""");
    }

    /**
     * Muestra un mensaje de confirmación de eliminación.
     *
     * @param idMascota ID de la mascota que ha sido eliminada.
     */
    public void eliminacionCompleta(int idMascota) {
        // Mostrar mensaje de confirmación
        JOptionPane.showMessageDialog(this, "La mascota con ID " + idMascota + " ha sido eliminada.");
    }
}
