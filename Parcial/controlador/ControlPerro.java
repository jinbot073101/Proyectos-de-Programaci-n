package controlador;

import javax.swing.JOptionPane;
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

        /*if (raza.isBlank() && pais.isBlank() && color.isBlank()) {
            perroDao.consultar("clasificacionFCI", clasificacion);
        } else if (clasificacion.isBlank() && pais.isBlank() && color.isBlank()) {
            perroDao.consultar("nombreRaza", raza);
        } else if (raza.isBlank() && clasificacion.isBlank() && color.isBlank()) {
            perroDao.consultar("paisOrigen", pais);
        } else if (raza.isBlank() && clasificacion.isBlank() && pais.isBlank()) {
            perroDao.consultar("color", color);
        }*/

        /*ESTE MK LO TENGO QUE QUITAR*/
        JOptionPane.showMessageDialog(null, "De momento, pongo este texto aquí. Pero este metodo debe contener la logica de consultar un perro a la base de datos.");
        return null;
    }

    @Override
    public void modificarPerro(int id) {
        perroDao.modificar(id);
        //JOptionPane.showMessageDialog(null, "De momento, pongo este texto aquí. Pero este metodo debe contener la logica de modificar un perro a la base de datos.");
    }

    @Override
    public boolean eliminarPerro() {
        /*ESTE MK LO TENGO QUE QUITAR*/
        JOptionPane.showMessageDialog(null, "De momento, pongo este texto aquí. Pero este metodo debe contener la logica de eliminar un perro a la base de datos.");
        return false; //Modificar
    }

}
