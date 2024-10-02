package controlador;

import modelo.PerroVO;

public interface IControlPerro {

    public void ingresarPerro(String nombreRaza, String paisOrigen, String clasificacionFCI,
            String aparienciaGeneral, String pelo, String color, String espalda, String lomo, String cola, String pecho);

    public PerroVO consultarPerro(String clasificacion, String raza, String pais, String color);

    public void modificarPerro(int id);

    public boolean eliminarPerro();
}
