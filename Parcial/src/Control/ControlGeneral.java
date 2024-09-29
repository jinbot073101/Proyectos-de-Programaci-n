package Control;

import Modelo.PerroDAO;
import Modelo.PerroVO;
import Vista.*;
import javax.swing.JOptionPane;

public class ControlGeneral {
    private final ControlPerro controlPerro;
    private PropertiesLoader properties;
    //Acceso a las vistas
    private final MenuPrincipal vistaPrincipal;
    private final MenuIngresar vistaIngreso;
    private final MenuConsultar vistaConsulta;
    private final MenuModificar vistaModificacion;
    private final MenuEliminar vistaEliminacion;
   
    public ControlGeneral() {
        this.controlPerro = new ControlPerro(new PerroDAO());
        this.vistaPrincipal = new MenuPrincipal(this); // Inyectando el ControlGeneral a la vista
        this.vistaIngreso = new MenuIngresar(this); // Inyectando el ControlGeneral a la vista
        this.vistaConsulta = new MenuConsultar(this); // Inyectando el ControlGeneral a la vista
        this.vistaModificacion = new MenuModificar(this); // Inyectando el ControlGeneral a la vista
        this.vistaEliminacion = new MenuEliminar(this); // Inyectando el ControlGeneral a la vista
        properties = new PropertiesLoader();
        cargarProperties();

    }
    
    private void cargarProperties(){
        //RECIBE LOS PERROS DEL PROPERTIES Y USA A CONTROL PERRO PARA ENVIARLO DIRECTAMENTE A LA BASE DE DATOS.
    }
    
    public void gestionarIngreso(){
        JOptionPane.showMessageDialog(null,"De momento, pongo este texto aquí. Pero este metodo debe contener la logica de ingresar un perro a la base de datos.");
    }
    
    public void gestionarConsulta(){
        JOptionPane.showMessageDialog(null,"De momento, pongo este texto aquí. Pero este metodo debe contener la logica de consultar un perro a la base de datos.");
    }
    
    public void gestionarModificacion(){
        JOptionPane.showMessageDialog(null,"De momento, pongo este texto aquí. Pero este metodo debe contener la logica de modificar un perro a la base de datos.");
    }
    
    public void gestionarEliminacion(){
        JOptionPane.showMessageDialog(null,"De momento, pongo este texto aquí. Pero este metodo debe contener la logica de eliminar un perro a la base de datos.");
    }
    
    public void ListarRazasIngresadas(){
        JOptionPane.showMessageDialog(null,"De momento, pongo este texto aquí. Pero este método debe preguntarle a la base de datos todos las razas registradas y devolverla.");
    }
    
    

}
