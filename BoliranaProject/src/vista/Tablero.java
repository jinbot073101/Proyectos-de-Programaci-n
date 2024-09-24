package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Tablero extends JFrame {

    private final JButton btnLanzar;
    private final JRadioButton rbtnLanzarSi;
    private final JRadioButton rbtnLanzarNo;
    private final JRadioButton rbtnPosicionSi;
    private final JRadioButton rbtnPosicionNo;
    private final JLabel lblTurnoJugador;
    private final int[] valores = {300, 100, 100, 300, 400, 200, 200, 400, 500, 2500, 1000, 500};

    public Tablero() {
        setTitle("Juego de bolirana");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel para el turno del jugador
        JPanel turnoPanel = new JPanel();
        turnoPanel.setBackground(new Color(255, 239, 201));
        lblTurnoJugador = new JLabel("Turno del jugador: ");
        turnoPanel.add(lblTurnoJugador);

        // Panel para contener los círculos y los labels
        JPanel circlePanel = new JPanel();
        circlePanel.setLayout(new GridLayout(3, 4)); // 3 filas, 4 columnas

        // Dibujar 12 círculos con sus respectivos labels (de abajo hacia arriba)
        for (int i = 11; i >= 0; i--) {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            // Crear el círculo|
            CirclePanel circle = new CirclePanel();
            panel.add(circle, BorderLayout.CENTER);

            // Crear el label con el valor correspondiente
            JLabel label = new JLabel(String.valueOf(valores[i]), SwingConstants.CENTER);
            panel.add(label, BorderLayout.SOUTH);

            circlePanel.add(panel);  // Añadir el panel al panel principal
        }

        // Crear el botón "Lanzar"
        btnLanzar = new JButton("Lanzar");
        btnLanzar.setBackground(new Color(79, 41, 41));
        btnLanzar.setForeground(new Color(255, 255, 255));
        btnLanzar.setPreferredSize(new Dimension(400, 50)); // Botón grande que ocupe la parte inferior

        // Panel para los botones de lanzamiento y posición
        JPanel optionPanel = new JPanel();
        optionPanel.setBackground(new Color(255, 239, 201));
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));  // Organización vertical

        // Pregunta 1: ¿Va a lanzar más de un tiro?
        JLabel lblLanzarMasDeUno = new JLabel("¿Va a lanzar más de un balín?");
        rbtnLanzarSi = new JRadioButton("Sí");
        rbtnLanzarNo = new JRadioButton("No");

        rbtnLanzarSi.setBackground(new Color(255, 239, 201));
        rbtnLanzarNo.setBackground(new Color(255, 239, 201));

        ButtonGroup lanzarGroup = new ButtonGroup();
        lanzarGroup.add(rbtnLanzarSi);
        lanzarGroup.add(rbtnLanzarNo);

        // Panel para los botones de la primera pregunta
        JPanel lanzarPanel = new JPanel();
        lanzarPanel.setBackground(new Color(255, 239, 201));
        lanzarPanel.add(rbtnLanzarSi);
        lanzarPanel.add(rbtnLanzarNo);

        // Pregunta 2: ¿Está realizando el tiro en la posición correcta?
        JLabel lblPosicionCorrecta = new JLabel("¿Está realizando el tiro detrás de la linea en el piso?");
        rbtnPosicionSi = new JRadioButton("Sí");
        rbtnPosicionNo = new JRadioButton("No");

        rbtnPosicionSi.setBackground(new Color(255, 239, 201));
        rbtnPosicionNo.setBackground(new Color(255, 239, 201));
        ButtonGroup posicionGroup = new ButtonGroup();
        posicionGroup.add(rbtnPosicionSi);
        posicionGroup.add(rbtnPosicionNo);

        // Panel para los botones de la segunda pregunta
        JPanel posicionPanel = new JPanel();
        posicionPanel.setBackground(new Color(255, 239, 201));
        posicionPanel.add(rbtnPosicionSi);
        posicionPanel.add(rbtnPosicionNo);

        // Añadir los componentes al panel de opciones
        optionPanel.add(Box.createVerticalStrut(10)); // Espacio entre el botón "Lanzar" y la primera pregunta
        optionPanel.add(lblLanzarMasDeUno);
        optionPanel.add(lanzarPanel);
        optionPanel.add(Box.createVerticalStrut(10)); // Espacio entre las dos preguntas
        optionPanel.add(lblPosicionCorrecta);
        optionPanel.add(posicionPanel);

        // Añadir paneles al frame
        this.setLayout(new BorderLayout());
        this.add(turnoPanel, BorderLayout.NORTH);    // El turno del jugador en la parte superior
        this.add(circlePanel, BorderLayout.CENTER);  // Los círculos en el centro
        this.add(btnLanzar, BorderLayout.SOUTH);     // El botón "Lanzar" en la parte inferior
        this.add(optionPanel, BorderLayout.WEST);    // Las opciones de los radio buttons debajo del botón "Lanzar"
    }

    // Método para asignar el listener al botón "Lanzar"
    public void setLanzarBotonListener(ActionListener listener) {
        btnLanzar.addActionListener(listener);
    }

    // Método para actualizar el turno del jugador
    public void mostrarTurnoJugador(String nombreJugador) {
        lblTurnoJugador.setText("Turno del jugador: " + nombreJugador);
    }

    // Clase interna para representar un círculo
    class CirclePanel extends JPanel {

        public CirclePanel() {
            // Cambiar el color de fondo del panel
            setBackground(new Color(214, 180, 65)); // Cambia a cualquier combinación RGB que desees
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(88, 64, 42));
            g.fillOval(10, 10, 50, 50); // Dibuja un círculo de tamaño 50x50
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(70, 70); // Dimensiones del área donde irá el círculo
        }
    }

    // Métodos para obtener las selecciones de los RadioButton
    public boolean LanzarMasDeUnoSelected() {
        return rbtnLanzarSi.isSelected();
    }

    public boolean PosicionCorrectaSelected() {
        return rbtnPosicionSi.isSelected();
    }   
}

