package vista;

import control.ControlGeneral;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase MenuPrincipal que crea el menú principal de la aplicación. Este menú
 * ofrece diversas funcionalidades como gestionar el ingreso, consulta,
 * modificación y eliminación de datos de perros, además de opciones para la
 * serialización y consultar información del programa.
 */
public class MenuPrincipal extends JFrame {

    private final JFrame frame; // Marco principal de la aplicación
    private final JMenuBar menuBar; // Barra de menús principal
    private final BackgroundPanel backgroundPanel; // Barra de menús principal
    private final JMenu consultaMenu; // Menú de gestión
    private final JMenuItem ingresoItem; // Opción de ingresar perro
    private final JMenuItem consultaItem; // Opción de consultar perro
    private final JMenuItem modificacionItem; // Opción de modificar perro
    private final JMenuItem eliminacionItem; // Opción de eliminar perro
    private final JMenu registroMenu; // Menú de registro
    private final JMenuItem razasIngresadasItem; // Opción para consultar razas ingresadas
    private final JMenu aplicacionMenu; // Menú de aplicación
    private final JMenuItem aboutItem; // Opción para mostrar información acerca del programa
    private final JMenuItem exitItem; // Opción para salir de la aplicación
    private final JMenuItem serializacionItem; // Opción para serializar datos
    private final ControlGeneral controlGeneral; // Controlador principal para gestionar vistas
    private final JFileChooser fileChooser;

    /**
     * Constructor que inicializa el menú principal de la aplicación.
     *
     * @param controlGeneral instancia de ControlGeneral para la gestión de
     * vistas y acciones
     */
    public MenuPrincipal(ControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;

        frame = new JFrame("Bienvenido"); // Creación de la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // Tamaño de la ventana

        backgroundPanel = new BackgroundPanel();

        // Inicialización de la barra de menú
        menuBar = new JMenuBar();

        // Creación del menú "Gestión" y adición de opciones
        consultaMenu = new JMenu("Gestión");
        menuBar.add(consultaMenu);

        ingresoItem = new JMenuItem("Ingresar perro");
        consultaItem = new JMenuItem("Consultar perro");
        modificacionItem = new JMenuItem("Modificar perro");
        eliminacionItem = new JMenuItem("Eliminar perro");

        // Añadir las opciones al menú de gestión con separadores
        consultaMenu.add(ingresoItem);
        consultaMenu.addSeparator();
        consultaMenu.add(consultaItem);
        consultaMenu.addSeparator();
        consultaMenu.add(modificacionItem);
        consultaMenu.addSeparator();
        consultaMenu.add(eliminacionItem);

        // Creación del menú "Registro"
        registroMenu = new JMenu("Registro");
        menuBar.add(registroMenu);
        razasIngresadasItem = new JMenuItem("Consultar razas registradas");
        registroMenu.add(razasIngresadasItem);

        // Creación del menú "Aplicación"
        aplicacionMenu = new JMenu("Aplicación");
        menuBar.add(aplicacionMenu);
        aboutItem = new JMenuItem("Acerca del programa");
        exitItem = new JMenuItem("Salir");
        serializacionItem = new JMenuItem("Serializar datos");

        aplicacionMenu.add(aboutItem);
        aplicacionMenu.addSeparator();
        aplicacionMenu.add(serializacionItem);
        aplicacionMenu.addSeparator();
        aplicacionMenu.add(exitItem);

        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de propiedades");

        // Configuración del JFrame principal
        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null); // Centrar ventana en pantalla
        frame.setContentPane(backgroundPanel); // Asigna el panel con la imagen de fondo
        gestionarElMenu(); // Llama al método que gestiona las acciones del menú
    }

    /**
     * Método que gestiona las acciones asociadas a los ítems del menú. Se
     * enlazan los ActionListeners para cada opción del menú, permitiendo que
     * cada acción ejecute una tarea específica.
     */
    private void gestionarElMenu() {
        // Acción para el ítem de ingresar perro
        ingresoItem.addActionListener(e -> controlGeneral.getControlIngresoVista().gestionarIngreso());

        // Acción para el ítem de consultar perro
        consultaItem.addActionListener(e -> controlGeneral.getControlConsultaVista().gestionarConsulta());

        // Acción para el ítem de modificar perro
        modificacionItem.addActionListener(e -> controlGeneral.getControlModificacionVista().gestionarModificacion());

        // Acción para el ítem de eliminar perro
        eliminacionItem.addActionListener(e -> controlGeneral.getControlEliminacionVista().gestionarEliminacion());

        // Acción para consultar las razas ingresadas
        razasIngresadasItem.addActionListener(e -> controlGeneral.getGestorRegistro().gestionarRegistro());

        // Acción para salir de la aplicación
        exitItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Programa finalizado.", "Cerrando programa...", JOptionPane.INFORMATION_MESSAGE);
            try {
                controlGeneral.gestionarPersistencia();
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        });

        // Acción para mostrar información sobre el programa
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, """
                Esta aplicación permite la gestión y consulta de una base de datos de perros.
                Su interfaz facilita las búsquedas, siendo útil para criadores, veterinarios, e investigadores.
                """, "Acerca del programa", JOptionPane.INFORMATION_MESSAGE));

        // Acción para serializar datos
        serializacionItem.addActionListener(e -> controlGeneral.getControlSerializacion());
    }

    /**
     * Método que retorna el JFrame principal.
     *
     * @return el marco principal de la vista
     */
    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    /**
     * Método que retorna el JFrame principal.
     *
     * @return el marco principal de la vista
     */
    public JFrame getFrameVistaPrincipal() {
        return frame;
    }

    public void PropertiesCargados() {
        JOptionPane.showMessageDialog(null, "Properties ya fue cargado con anterioridad");
    }

    public void informarSerializacion() {
        JOptionPane.showMessageDialog(null, "Se han guardado los elementos de la base datos en un archivo de respaldo.");
    }

    // Clase interna para el panel con imagen de fondo
    private class BackgroundPanel extends JPanel {

        private final Image backgroundImage;

        public BackgroundPanel() {
            // Carga la imagen de fondo desde el paquete
            backgroundImage = new ImageIcon(getClass().getResource("/data/imagenDelMenu.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dibuja la imagen de fondo
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
