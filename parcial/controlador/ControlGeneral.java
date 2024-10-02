package controlador;

import java.awt.event.ActionListener;
import modelo.*;
import vista.*;
import java.io.*;
import java.util.Properties;
import java.util.ArrayList;

public class ControlGeneral {

    private final FormularioRelleno vista;
    private final IControlPerro controlPerro;
    private ArrayList<PerroVO> perrosIncompletos;
    private final ControlngresoVista controlIngresoVista;
    private final ControlModificacionVista controlModificacionVista;
    private final ControlConsultaVista controlConsultaVista;
    private final ControlEliminacionVista controlEliminacionVista;
    private final MenuPrincipal vistaPrincipal;

    public ControlGeneral() {
        this.vista = new FormularioRelleno();
        this.controlPerro = new ControlPerro(new PerroDAO());
        this.controlIngresoVista = new ControlngresoVista(controlPerro);
        this.controlModificacionVista = new ControlModificacionVista(controlPerro);
        this.controlConsultaVista = new ControlConsultaVista(controlPerro);
        this.controlEliminacionVista = new ControlEliminacionVista(controlPerro);
        this.vistaPrincipal = new MenuPrincipal(this);
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
        try (InputStream entrada = new FileInputStream("src//data//perrosPrecarga.properties")) {
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
        }
        controlPerro.ingresarPerro(raza1, pais1, "", "", "", "", "", "", "", "");
        controlPerro.ingresarPerro(raza2, pais2, "", "", "", "", "", "", "", "");
        controlPerro.ingresarPerro(raza3, pais3, "", "", "", "", "", "", "", "");
        controlPerro.ingresarPerro(raza4, pais4, "", "", "", "", "", "", "", "");
        completarDatos();
    }

    private void completarDatos() {
        vista.informarDatosIncompletos();
        perrosIncompletos = controlPerro.mostrarPerrosProperties();
        vista.setVisible(true);

        for (ActionListener al : vista.getBotonCompletar().getActionListeners()) {
            vista.getBotonCompletar().removeActionListener(al);
        }

        vista.botonCompletar(e -> {
            int turnoActual = 0;
            while (turnoActual < perrosIncompletos.size()) {
                String clasificacion = vista.getSelectedClasificacion();
                String pelo = vista.getPeloTextField().getText();
                String color = vista.getColorTextField().getText();
                String espalda = vista.getEspaldaTextField().getText();
                String lomo = vista.getLomoTextField().getText();
                String cola = vista.getColaTextField().getText();
                String pecho = vista.getPechoTextField().getText();
                String descripcion = vista.getDescripcionTextField().getText();

                String subOpcion = vista.getOpcionSeleccionada() != null
                        ? vista.getOpcionSeleccionada() : "";
                String clasificacionCompleta = clasificacion + (subOpcion.isEmpty() ? "" : ", " + subOpcion);

                PerroVO perroModificado = perrosIncompletos.get(turnoActual);
                perroModificado.setPelo(pelo);
                perroModificado.setColor(color);
                perroModificado.setEspalda(espalda);
                perroModificado.setLomo(lomo);
                perroModificado.setCola(cola);
                perroModificado.setPecho(pecho);
                perroModificado.setAparienciaGeneral(descripcion);
                perroModificado.setClasificacionFCI(clasificacionCompleta);

                controlPerro.actualizarPerro(perroModificado);

                vista.informarIngresoPerro();
                vista.limpiarCampos();
                turnoActual++;
            }
            vista.setVisible(false);
            vista.informarPerrosActualizados();
            vistaPrincipal.getFrameVistaPrincipal().setVisible(true);
        });
    }

    public ControlngresoVista getControlIngresoVista() {
        return controlIngresoVista;
    }

    public ControlModificacionVista getControlModificacionVista() {
        return controlModificacionVista;
    }

    public ControlConsultaVista getControlConsultaVista() {
        return controlConsultaVista;
    }

    public ControlEliminacionVista getControlEliminacionVista() {
        return controlEliminacionVista;
    }

    public void listarRazasRegistradas() {
        // Lógica para listar razas registradas
    }
}
