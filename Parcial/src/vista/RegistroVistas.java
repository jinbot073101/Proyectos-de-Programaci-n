package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Clase RegistroVistas que representa la interfaz gráfica para mostrar y
 * gestionar el registro de razas de perros en el sistema. La ventana muestra
 * una lista de razas y un botón para cerrar la vista.
 */
public class RegistroVistas extends JFrame {

    // Componentes de la interfaz
    private final JList<String> listaRazas;   // JList para mostrar las razas
    private final JButton btnCerrar;          // Botón para cerrar la ventana
    private final DefaultListModel<String> modeloLista;  // Modelo para gestionar la lista de razas

    /**
     * Constructor que inicializa los componentes de la ventana, como la lista
     * de razas y el botón de cerrar.
     */
    public RegistroVistas() {
        setTitle("Registro de Razas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra la ventana sin terminar el programa
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout());

        // Crear el modelo para la lista
        modeloLista = new DefaultListModel<>();

        // Crear la lista de razas y asociarla con el modelo
        listaRazas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaRazas); // Añadir scroll para listas largas

        // Botón para cerrar la ventana
        btnCerrar = new JButton("Cerrar");

        // Panel para el botón
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnCerrar);

        // Añadir componentes a la ventana
        add(scrollPane, BorderLayout.CENTER);  // Añadir la lista en el centro
        add(panelBoton, BorderLayout.SOUTH);   // Añadir el botón en la parte inferior
    }

    /**
     * Método para agregar una raza a la lista de razas.
     *
     * @param raza Nombre de la raza que se va a agregar a la lista.
     */
    public void agregarRaza(String raza) {
        modeloLista.addElement(raza);
    }

    /**
     * Método para configurar el ActionListener del botón de cerrar.
     *
     * @param listener ActionListener que se asociará con el botón de cerrar.
     */
    public void botonCerrar(ActionListener listener) {
        btnCerrar.addActionListener(listener);
    }

    /**
     * Método para obtener el botón de cerrar, en caso de que sea necesario
     * acceder al botón de forma externa.
     *
     * @return JButton del botón de cerrar.
     */
    public JButton getBotonCerrar() {
        return btnCerrar;
    }

    /**
     * Método para limpiar la lista de razas, eliminando todos los elementos.
     */
    public void limpiarLista() {
        modeloLista.clear();
    }
}
