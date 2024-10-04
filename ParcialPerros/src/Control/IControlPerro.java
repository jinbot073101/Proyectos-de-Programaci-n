package Control;

import Modelo.PerroVO;
import java.util.ArrayList;


public interface IControlPerro {
    
    public void ingresarPerro(String nombreRaza, String paisOrigen, String clasificacionFCI,
            String aparienciaGeneral, String pelo, String color, String espalda, String lomo, String cola, String pecho, int id);

    public PerroVO consultarPerro(String clasificacion, String raza, String pais, String color);

    public void actualizarPerro(PerroVO perroModificado);

    public boolean eliminarPerro();

    public ArrayList<PerroVO> mostrarPerrosProperties();
    public ArrayList<Integer> retornoId();
    
    public PerroVO traerPerroActualizar(int id);
    
    
}
