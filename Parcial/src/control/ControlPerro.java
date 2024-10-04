package control;

import modelo.PerroDAO;
import modelo.PerroVO;
import java.util.ArrayList;

/**
 * Controlador que gestiona la lógica relacionada con los perros.
 *
 * Esta clase implementa la interfaz IControlPerro y utiliza el objeto PerroDAO
 * para realizar operaciones sobre los perros en la base de datos.
 */
public class ControlPerro implements IControlPerro {

    /**
     * DAO para el manejo de operaciones relacionadas con perros
     */
    private final PerroDAO perroDao;

    /**
     * Objeto que representa un perro
     */
    private PerroVO perro;

    /**
     * Constructor de ControlPerro.
     *
     * @param perro DAO que se utilizará para realizar operaciones sobre perros.
     */
    public ControlPerro(PerroDAO perro) {
        this.perroDao = perro;
    }

    /**
     * Ingresa un nuevo perro en la base de datos.
     *
     * @param nombreRaza El nombre de la raza del perro.
     * @param paisOrigen El país de origen del perro.
     * @param clasificacionFCI La clasificación FCI del perro.
     * @param aparienciaGeneral La apariencia general del perro.
     * @param pelo El tipo de pelo del perro.
     * @param color El color del perro.
     * @param espalda Descripción de la espalda del perro.
     * @param lomo Descripción del lomo del perro.
     * @param cola Descripción de la cola del perro.
     * @param pecho Descripción del pecho del perro.
     * @param id El identificador del perro.
     */
    @Override
    public void ingresarPerro(String nombreRaza, String paisOrigen, String clasificacionFCI,
            String aparienciaGeneral, String pelo, String color, String espalda, String lomo, String cola, String pecho, int id) {
        perro = new PerroVO(nombreRaza, paisOrigen, clasificacionFCI, aparienciaGeneral, pelo,
                color, espalda, lomo, cola, pecho, id);
        perroDao.registrar(perro);
    }

    /**
     * Retorna un ArrayList de identificadores de perros registrados.
     *
     * @return Un ArrayList de enteros que representan los IDs de los perros.
     */
    @Override
    public ArrayList<Integer> retornoId() {
        return perroDao.retornoId();
    }

    /**
     * Retorna un ArrayList de razas de perros disponibles en la base de datos.
     *
     * @return Un ArrayList de cadenas que representan los nombres de las razas.
     */
    @Override
    public ArrayList<String> retornoRazas() {
        return perroDao.retornoRazas();
    }

    /**
     * Consulta perros en la base de datos según un valor y un tipo de consulta
     * seleccionados.
     *
     * @param valorConsulta El valor que se utilizará para la consulta.
     * @param consultaSeleccionada El tipo de consulta que se desea realizar.
     * @return Un ArrayList de PerroVO que cumplen con los criterios de
     * consulta.
     */
    @Override
    public ArrayList<PerroVO> consultarPerro(String valorConsulta, String consultaSeleccionada) {
        switch (consultaSeleccionada) {
            case "Por Nombre de Raza" -> {
                return perroDao.consultarPorRaza(valorConsulta);
            }
            case "Por Grupo y Sección FCI" -> {
                return perroDao.consultarPorGrupoFCI(valorConsulta);
            }
            case "Por País de Origen" -> {
                return perroDao.consultarPorPais(valorConsulta);
            }
            case "Por Color de Manto" -> {
                return perroDao.consultarPorManto(valorConsulta);
            }
            case "Todos los perros" -> {
                return perroDao.traerPerrosBaseDatos();
            }
            default -> {
                // Manejo de caso por defecto (se puede agregar una advertencia o log)
            }
        }
        return null;
    }

    /**
     * Obtiene un perro para ser actualizado según su identificador.
     *
     * @param id El identificador del perro a obtener.
     * @return El objeto PerroVO que corresponde al ID proporcionado.
     */
    @Override
    public PerroVO traerPerroActualizar(int id) {
        return perroDao.traerPerroActualizar(id);
    }

    /**
     * Elimina un perro de la base de datos.
     *
     * @param id El identificador del perro a eliminar.
     */
    @Override
    public void eliminarPerro(int id) {
        perroDao.eliminar(id);
    }

    /**
     * Muestra todos los perros registrados en la base de datos.
     *
     * @return Un ArrayList de PerroVO que representa todos los perros en la
     * base de datos.
     */
    @Override
    public ArrayList<PerroVO> mostrarPerrosBaseDeDatos() {
        return perroDao.traerPerrosBaseDatos();
    }

    /**
     * Modifica los datos de un perro en la base de datos.
     *
     * Este método recibe un objeto {@link PerroVO} que contiene la información
     * del perro que se desea modificar. Se delega la tarea de modificar en el
     * {@link PerroDao} correspondiente.
     *
     * @param perro El objeto {@link PerroVO} que contiene los nuevos datos del
     * perro.
     */
    @Override
    public void actualizarPerro(PerroVO perro) {
        perroDao.modificarPerros(perro);

    }

}
