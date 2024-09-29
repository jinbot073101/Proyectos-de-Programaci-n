package Control;

import Modelo.PerroVO;
import Modelo.PerroDAO;

public class ControlPerro implements IControlPerro{
    
    private final PerroDAO perroDao;
    private PerroVO perro;
    
    public ControlPerro(PerroDAO perro){
        this.perroDao=perro;
    }
  
    @Override
    public void ingresarPerro(PerroVO perro){
       
    }
    
    @Override
    public PerroVO consultarPerro(String id){
        
        return null;
    }
    
    @Override
    public boolean modificarPerro (PerroVO perroModificado){
        return false;
    }
    
    @Override
    public boolean eliminarPerro (){
        //Codigo para borrar perro
        return false; //Modificar
    }
    
}
