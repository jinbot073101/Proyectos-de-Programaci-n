package controlador;

import modelo.PerroDAO;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;
/*ESTE MK LO TENGO QUE QUITAR*/import javax.swing.JOptionPane;

public class ControlGeneral {

    //private final Serializacion serializacion;
    private final ControlPerro controlPerro;
    //Acceso a las vistas
    private final MenuPrincipal vistaPrincipal;
    private final MenuIngresar vistaIngreso;
    private final MenuConsultar vistaConsulta;
    private final MenuModificar vistaModificacion;
    private final MenuEliminar vistaEliminacion;

    public ControlGeneral() {
        this.vistaPrincipal = new MenuPrincipal(this); // Inyectando el ControlGeneral a la vista
        this.vistaIngreso = new MenuIngresar(this); // Inyectando el ControlGeneral a la vista
        this.vistaConsulta = new MenuConsultar(this); // Inyectando el ControlGeneral a la vista
        this.vistaModificacion = new MenuModificar(this); // Inyectando el ControlGeneral a la vista
        this.vistaEliminacion = new MenuEliminar(this); // Inyectando el ControlGeneral a la vista
        this.controlPerro = new ControlPerro(new PerroDAO());
        //serializacion = new Serializacion();
        cargarProperties();
    }

    private void cargarProperties() {
        String raza1 = "";
        String pais1 = "";
        String raza2 = "";
        String pais2 = "";
        String raza3 = "";
        String pais3 = "";
        String raza4 = "";
        String pais4 = "";
        Properties propiedades = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream("src//data//perrosPrecarga.properties");
            propiedades.load(entrada);
            raza1 = propiedades.getProperty("perro1.raza");
            pais1 = propiedades.getProperty("perro1.pais");
            raza2 = propiedades.getProperty("perro2.raza");
            pais2 = propiedades.getProperty("perro2.pais");
            raza3 = propiedades.getProperty("perro3.raza");
            pais3 = propiedades.getProperty("perro3.pais");
            raza4 = propiedades.getProperty("perro4.raza");
            pais4 = propiedades.getProperty("perro4.pais");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //asigna valores que le llegan del properties y llama a el metodo ingresarPerro para mandarlos.
        controlPerro.ingresarPerro(raza1, pais1, "", "", "", "", "", "", "", "");
        //ingresa a perro dos
        controlPerro.ingresarPerro(raza2, pais2, "", "", "", "", "", "", "", "");
        //ingresa a perro tres
        controlPerro.ingresarPerro(raza3, pais3, "", "", "", "", "", "", "", "");
        //ingresa a perro cuatro
        controlPerro.ingresarPerro(raza4, pais4, "", "", "", "", "", "", "", "");
        //LOGICA PARA COMPLETAR LOS DATOS FALTANTES DE CADA PERRO
        completarDatos();
    }

    public void gestionarIngreso() {
        vistaIngreso.setVisible(true);
        // Remover todos los ActionListeners previos del botón "Registrar"
        for (ActionListener al : vistaIngreso.getBotonIngresar().getActionListeners()) {
            vistaIngreso.getBotonIngresar().removeActionListener(al);
        }
        // Agregar un nuevo ActionListener
        vistaIngreso.botonIngresar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Recoger los datos de la vista
                String raza = vistaIngreso.getRazaTextField().getText();
                String paisOrigen = vistaIngreso.getPaisOrigenTextField().getText();
                String clasificacion = vistaIngreso.getSelectedClasificacion(); // Obtener la clasificación
                String pelo = vistaIngreso.getPeloTextField().getText();
                String color = vistaIngreso.getColorTextField().getText();
                String espalda = vistaIngreso.getEspaldaTextField().getText();
                String lomo = vistaIngreso.getLomoTextField().getText();
                String cola = vistaIngreso.getColaTextField().getText();
                String pecho = vistaIngreso.getPechoTextField().getText();
                String descripcion = vistaIngreso.getDescripcionTextField().getText();
                // Obtener la opción seleccionada del submenú (si existe)
                String subOpcion = vistaIngreso.getOpcionSeleccionada() != null ? vistaIngreso.getOpcionSeleccionada() : "";
                // Concatenar clasificación y subopción
                String clasificacionCompleta = clasificacion + (subOpcion.isEmpty() ? "" : ", " + subOpcion);

                //ACÁ CONSULTA
                controlPerro.ingresarPerro(raza, paisOrigen, clasificacionCompleta, pelo, color, espalda, lomo, cola, pecho, descripcion);

                /*ESTE MK LO TENGO QUE QUITAR*/
                JOptionPane.showMessageDialog(null, "Simulando....");
                vistaIngreso.limpiarCampos();
                vistaIngreso.setVisible(false);
            }
        });
    }

    public void gestionarConsulta() {
        //vistaConsulta.setVisible(true);
        //controlPerro.consultarPerro();
    }

    public void gestionarModificacion() {
        //vistaModificacion.setVisible(true);
        int idPerro = 0;
        controlPerro.modificarPerro(idPerro);
    }

    public void gestionarEliminacion() {
        //vistaEliminacion.setVisible(true);
        controlPerro.eliminarPerro();
    }

    public void ListarRazasIngresadas() {

    }

    public void gestionarAplicacion() {
        //serializacion.serializarObjetos();
        vistaPrincipal.cerrarPrograma();
        System.exit(0);
    }

    private void completarDatos() {
        /*ESTE MK LO TENGO QUE QUITAR*/
        JOptionPane.showMessageDialog(null, "Acá debería saltar la ventana de formulario y terminar de llenar los datos de los perros");

    }
}
