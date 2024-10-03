package Control;


import Modelo.PerroDAO;
import Modelo.PerroVO;
import Vista.FormularioRelleno;
import Vista.MenuPrincipal;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ControlGeneral {
    
    private final FormularioRelleno vistaFormmularioRelleno;
    private final IControlPerro controlPerro;
    private ArrayList<PerroVO> perrosIncompletos;
    private ArrayList<Integer> ids;
    private final ControlngresoVista controlIngresoVista;
    private final ControlModificacionVista controlModificacionVista;
    private final ControlConsultaVista controlConsultaVista;
    private final ControlEliminacionVista controlEliminacionVista;
    private final MenuPrincipal vistaPrincipal;
    private int turnoActual;
    private int posicion;
    
    
    public ControlGeneral() {
        this.vistaFormmularioRelleno = new FormularioRelleno();
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
        controlPerro.ingresarPerro(raza1, pais1, "", "", "", "", "", "", "", "", 0);
        controlPerro.ingresarPerro(raza2, pais2, "", "", "", "", "", "", "", "", 0);
        controlPerro.ingresarPerro(raza3, pais3, "", "", "", "", "", "", "", "", 0);
        controlPerro.ingresarPerro(raza4, pais4, "", "", "", "", "", "", "", "", 0);
        completarDatos();
    }

    private void completarDatos() {
        vistaFormmularioRelleno.informarDatosIncompletos();
        perrosIncompletos = controlPerro.mostrarPerrosProperties();
        ids = controlPerro.retornoId();
        turnoActual = 0; // Asegurarnos de empezar desde el primer perro
        posicion = 0; // Reiniciar la posición de IDs si es necesario

        
        // Solo mostrar el formulario si hay perros incompletos
        if (!perrosIncompletos.isEmpty()) {
            vistaFormmularioRelleno.setVisible(true);
            mostrarFormularioPerro(); // Mostrar el primer perro
        }
    }
    
    private void mostrarFormularioPerro() {
        for (ActionListener al : vistaFormmularioRelleno.getBotonCompletar().getActionListeners()) {
            vistaFormmularioRelleno.getBotonCompletar().removeActionListener(al);
        }

        // Añadir ActionListener al botón "Completar"
        vistaFormmularioRelleno.botonCompletar(e -> {
            if (turnoActual < perrosIncompletos.size()) {
            completarPerro(perrosIncompletos.get(turnoActual)); // Completar los datos del perro actual
            turnoActual++;
            posicion++; // Incrementar la posición de los IDs

            // Si aún hay perros por completar, mostrar el siguiente
            if (turnoActual < perrosIncompletos.size()) {
                vistaFormmularioRelleno.limpiarCampos();
                mostrarFormularioPerro(); // Llamar nuevamente para el próximo perro
            } else {
                vistaFormmularioRelleno.setVisible(false); // Ocultar el formulario si se completaron todos
                vistaPrincipal.getFrameVistaPrincipal().setVisible(true);
            }
        }
        });
    }
    
 
    private void completarPerro(PerroVO perroModificado) {
        
        String clasificacion = vistaFormmularioRelleno.getSelectedClasificacion();
        String pelo = vistaFormmularioRelleno.getPeloTextField().getText();
        String color = vistaFormmularioRelleno.getColorTextField().getText();
        String espalda = vistaFormmularioRelleno.getEspaldaTextField().getText();
        String lomo = vistaFormmularioRelleno.getLomoTextField().getText();
        String cola = vistaFormmularioRelleno.getColaTextField().getText();
        String pecho = vistaFormmularioRelleno.getPechoTextField().getText();
        String descripcion = vistaFormmularioRelleno.getDescripcionTextField().getText();

        String subOpcion = vistaFormmularioRelleno.getOpcionSeleccionada() != null
                ? vistaFormmularioRelleno.getOpcionSeleccionada() : "";
        String clasificacionCompleta = clasificacion + (subOpcion.isEmpty() ? "" : ", " + subOpcion);

        // Modificar los atributos del perro
        perroModificado.setPelo(pelo);
        perroModificado.setColor(color);
        perroModificado.setEspalda(espalda);
        perroModificado.setLomo(lomo);
        perroModificado.setCola(cola);
        perroModificado.setPecho(pecho);
        perroModificado.setAparienciaGeneral(descripcion);
        perroModificado.setClasificacionFCI(clasificacionCompleta);
        perroModificado.setId(ids.get(posicion));

        // Actualizar el perro
        controlPerro.actualizarPerro(perroModificado);

        // Informar al usuario y limpiar campos
        vistaFormmularioRelleno.informarIngresoPerro();   
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
