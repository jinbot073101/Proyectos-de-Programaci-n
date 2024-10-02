package controlador;

import java.util.ArrayList;
import modelo.PerroVO;
import modelo.PerroDAO;

public class ControlPerro implements IControlPerro {

    private final PerroDAO perroDao;
    private PerroVO perro;

    public ControlPerro(PerroDAO perro) {
        this.perroDao = perro;
    }

    @Override
    public void ingresarPerro(String nombreRaza, String paisOrigen, String clasificacionFCI,
            String aparienciaGeneral, String pelo, String color, String espalda, String lomo, String cola, String pecho) {
        //Crea el perro con los datos que le llegan de la vista 
        perro = new PerroVO(nombreRaza, paisOrigen, clasificacionFCI, aparienciaGeneral, pelo,
                color, espalda, lomo, cola, pecho);

        System.out.println(perro.getNombreRaza());
        System.out.println(perro.getPaisOrigen());
        System.out.println(perro.getClasificacionFCI());
        System.out.println(perro.getAparienciaGeneral());
        System.out.println(perro.getPelo());
        System.out.println(perro.getColor());
        System.out.println(perro.getEspalda());
        System.out.println(perro.getLomo());
        System.out.println(perro.getCola());
        System.out.println(perro.getPecho());
        /*ESTOS MKS LOS TENGO QUE QUITAR*/
 /*envia el perro creado al dao para mandarlo a la base de datos
        perroDao.registrar(perro);*/
    }
    
    @Override
    public PerroVO consultarPerro(String clasificacion, String raza, String pais, String color) {
        // Implementar la lógica de consulta llamando a perroDao.consultar(...)
        return null;
    }

    @Override
    public PerroVO traerPerroActualizar(int id) {
        return perroDao.traerPerroActualizar(id);
    }

    @Override
    public boolean eliminarPerro() {
        // Implementar la lógica de eliminación llamando a perroDao.eliminar()
        return false;
    }

    @Override
    public ArrayList<PerroVO> mostrarPerrosProperties() {
        return perroDao.traerPerrosIncompletos();
    }

    @Override
    public void actualizarPerro(PerroVO perro) {
        perroDao.modificar(perro);
    }
}
