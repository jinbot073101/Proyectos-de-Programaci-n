package Vista;

import Control.ControlGeneral;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {

    //frame de la clase
    private final ControlGeneral controlador;
    private final JFrame frame;
    private final JMenuBar menuBar;
    //menu desplegable de consulta
    private final JMenu consultaMenu;
    private final JMenuItem ingresoItem;
    private final JMenuItem ConsultaItem;
    private final JMenuItem modificacionItem;
    private final JMenuItem eliminacionItem;
    //menu desplegable de registro
    private final JMenu registroMenu;
    private final JMenuItem razasIngresadasItem;
    //menu desplegable de aplicacion
    private final JMenu aplicacionMenu;
    private final JMenuItem aboutItem;
    private final JMenuItem exitItem;

    public MenuPrincipal(ControlGeneral controlador) {
        this.controlador = controlador;
        // Crear la ventana principal
        frame = new JFrame("Bienvenido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Crear una barra de menú
        menuBar = new JMenuBar();

        // Crear el menú "Consulta"
        consultaMenu = new JMenu("Consulta");
        menuBar.add(consultaMenu);

        // Crear ítems del menú "Consulta"
        ingresoItem = new JMenuItem("Ingresar perro");
        ConsultaItem = new JMenuItem("Consultar perro");
        modificacionItem = new JMenuItem("Modificar perro");
        eliminacionItem = new JMenuItem("Eliminar perro");

        // Añadir los ítems al menú "Consulta"
        consultaMenu.add(ingresoItem);
        consultaMenu.addSeparator();
        consultaMenu.add(ConsultaItem);
        consultaMenu.addSeparator();
        consultaMenu.add(modificacionItem);
        consultaMenu.addSeparator();
        consultaMenu.add(eliminacionItem);

        // Crear el menú "Registro"
        registroMenu = new JMenu("Registro");
        menuBar.add(registroMenu);

        // Crear ítems del menú "Registro"
        razasIngresadasItem = new JMenuItem("Consultar razas registradas");

        // Añadir el ítem al menú "Registro"
        registroMenu.add(razasIngresadasItem);

        // Crear el menú "Aplicacion"
        aplicacionMenu = new JMenu("Aplicacion");
        menuBar.add(aplicacionMenu);

        // Crear ítems del menú "Aplicacion"
        aboutItem = new JMenuItem("Acerca del programa");
        exitItem = new JMenuItem("Salir");

        // Añadir el ítem al menú "Aplicacion"
        aplicacionMenu.add(aboutItem);
        aplicacionMenu.addSeparator();
        aplicacionMenu.add(exitItem);

        // Configurar el menú
        frame.setJMenuBar(menuBar);

        // Mostrar la ventana
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        //Iniciar la gestion de ventanas
        gestionarElMenu();
    }

    //Metodo que gestiona los action listeners del menú principal
    private void gestionarElMenu() {

        // Añadir listeners de eventos a los ítems del menú consulta
        ingresoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.gestionarIngreso();
            }
        });

        ConsultaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.gestionarConsulta();
            }
        });

        modificacionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.gestionarModificacion();
            }
        });

        eliminacionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.gestionarEliminacion();
            }
        });

        //Sale del programa
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        razasIngresadasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.ListarRazasIngresadas();
            }
        });

        //Mostrar información del programa
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, """
                                                     Esta aplicacion permite la gestion y consulta en una base de datos de perros, registrando caracteristicas como raza, pais de origen, etc.
                                                     Su interfaz facilita las busquedas, siendo una herramienta util para criadores, veterinarios e investigadores en el ambito canino. """, "Acerca del programa", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
