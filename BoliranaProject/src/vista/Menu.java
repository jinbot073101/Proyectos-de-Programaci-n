package vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class Menu extends JFrame {

    private final JButton btnRegistrar;
    private final JButton btnTorneo;

    public Menu() {

        setTitle("Menú Principal");
        setSize(400, 250); // Aumentamos el tamaño del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializamos los botones
        btnRegistrar = new JButton("Registrar equipo");
        btnTorneo = new JButton("Comenzar Juego");

        // Cambiamos el color y los bordes de los botones
        btnRegistrar.setBackground(new Color(214, 180, 65));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false); // Elimina el borde cuando el botón está enfocado
        btnRegistrar.setPreferredSize(new Dimension(200, 50)); // Tamaño uniforme

        btnTorneo.setBackground(new Color(214, 180, 65));
        btnTorneo.setForeground(Color.WHITE);
        btnTorneo.setFocusPainted(false); // Elimina el borde cuando el botón está enfocado
        btnTorneo.setPreferredSize(new Dimension(200, 50)); // Tamaño uniforme

        // Configuración del panel
        JPanel panel = new JPanel(new GridBagLayout()); // Usamos GridBagLayout para centrar mejor los componentes
        panel.setBackground(new Color(79, 41, 41));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre los botones

        // Añadimos los botones al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(btnRegistrar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(btnTorneo, gbc);

        // Añadimos el panel al frame
        this.add(panel);
        this.setVisible(true);
    }

    /**
     *
     * @param listener
     */
    public void setBotonRegistrarListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);   
    }

    // Método para el ActionListener del botón "Comenzar Juego"
    public void setComenzarJuegoListener(ActionListener listener) {
        btnTorneo.addActionListener(listener);
    }
    
}


