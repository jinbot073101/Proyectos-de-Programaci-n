package vista;

import controlador.ControlGeneral;
import javax.swing.*;

public class MenuPrincipal {

    private final JFrame frame;
    private final JMenuBar menuBar;
    private final JMenu consultaMenu;
    private final JMenuItem ingresoItem;
    private final JMenuItem consultaItem; // Corrección de nombre (inicial con minúscula)
    private final JMenuItem modificacionItem;
    private final JMenuItem eliminacionItem;
    private final JMenu registroMenu;
    private final JMenuItem razasIngresadasItem;
    private final JMenu aplicacionMenu;
    private final JMenuItem aboutItem;
    private final JMenuItem exitItem;
    private final ControlGeneral controlGeneral;

    public MenuPrincipal(ControlGeneral controlGeneral) {
        this.controlGeneral = controlGeneral;
        frame = new JFrame("Bienvenido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        menuBar = new JMenuBar();

        // Menú Gestión
        consultaMenu = new JMenu("Gestión");
        menuBar.add(consultaMenu);

        ingresoItem = new JMenuItem("Ingresar perro");
        consultaItem = new JMenuItem("Consultar perro");
        modificacionItem = new JMenuItem("Modificar perro");
        eliminacionItem = new JMenuItem("Eliminar perro");

        consultaMenu.add(ingresoItem);
        consultaMenu.addSeparator();
        consultaMenu.add(consultaItem);
        consultaMenu.addSeparator();
        consultaMenu.add(modificacionItem);
        consultaMenu.addSeparator();
        consultaMenu.add(eliminacionItem);

        // Menú Registro
        registroMenu = new JMenu("Registro");
        menuBar.add(registroMenu);
        razasIngresadasItem = new JMenuItem("Consultar razas registradas");
        registroMenu.add(razasIngresadasItem);

        // Menú Aplicación
        aplicacionMenu = new JMenu("Aplicación");
        menuBar.add(aplicacionMenu);
        aboutItem = new JMenuItem("Acerca del programa");
        exitItem = new JMenuItem("Salir");

        aplicacionMenu.add(aboutItem);
        aplicacionMenu.addSeparator();
        aplicacionMenu.add(exitItem);

        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null);
        gestionarElMenu(); // Iniciar la gestión de acciones
    }

    private void gestionarElMenu() {
        // Creación de los controles utilizando la misma instancia de controlPerro
        ingresoItem.addActionListener(e -> controlGeneral.getControlIngresoVista().gestionarIngreso());
        consultaItem.addActionListener(e -> controlGeneral.getControlConsultaVista().gestionarConsulta());
        modificacionItem.addActionListener(e -> controlGeneral.getControlModificacionVista().gestionarModificacion());
        eliminacionItem.addActionListener(e -> controlGeneral.getControlEliminacionVista().gestionarEliminacion());

        exitItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Programa finalizado.", "Cerrando programa...", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        razasIngresadasItem.addActionListener(e -> controlGeneral.listarRazasRegistradas());

        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, """
                Esta aplicación permite la gestión y consulta de una base de datos de perros.
                Su interfaz facilita las búsquedas, siendo útil para criadores, veterinarios, e investigadores.
                """, "Acerca del programa", JOptionPane.INFORMATION_MESSAGE));
    }

    public JFrame getFrameVistaPrincipal() {
        return frame;
    }
}
