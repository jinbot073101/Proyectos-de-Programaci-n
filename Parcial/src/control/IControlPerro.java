package control;

import modelo.PerroVO;
import java.util.ArrayList;

/**
 * Interfaz que define las operaciones para el control de los datos de los
 * perros.
 *
 * Esta interfaz proporciona métodos para ingresar, consultar, actualizar y
 * eliminar perros en la base de datos, así como para obtener información
 * relacionada con ellos.
 */
public interface IControlPerro {

    /**
     * Ingresa un nuevo perro en la base de datos.
     *
     * @param nombreRaza Nombre de la raza del perro.
     * @param paisOrigen País de origen del perro.
     * @param clasificacionFCI Clasificación FCI del perro.
     * @param aparienciaGeneral Descripción de la apariencia general del perro.
     * @param pelo Tipo de pelo del perro.
     * @param color Color del perro.
     * @param espalda Descripción de la espalda del perro.
     * @param lomo Descripción del lomo del perro.
     * @param cola Descripción de la cola del perro.
     * @param pecho Descripción del pecho del perro.
     * @param id ID del perro (debe ser único).
     */
    public void ingresarPerro(String nombreRaza, String paisOrigen, String clasificacionFCI,
            String aparienciaGeneral, String pelo, String color, String espalda, String lomo, String cola, String pecho, int id);

    /**
     * Consulta un perro en la base de datos según el valor de búsqueda y el
     * tipo de consulta.
     *
     * @param valorConsulta Valor a buscar en la base de datos.
     * @param consultaSeleccionada Tipo de consulta a realizar (por ejemplo, por
     * nombre, raza, etc.).
     * @return Lista de perros que coinciden con la consulta.
     */
    public ArrayList<PerroVO> consultarPerro(String valorConsulta, String consultaSeleccionada);

    /**
     * Elimina un perro de la base de datos por su ID.
     *
     * @param id ID del perro que se desea eliminar.
     */
    public void eliminarPerro(int id);

    /**
     * Muestra todos los perros almacenados en la base de datos.
     *
     * @return Lista de perros en la base de datos.
     */
    public ArrayList<PerroVO> mostrarPerrosBaseDeDatos();

    /**
     * Retorna una lista de IDs de los perros almacenados en la base de datos.
     *
     * @return Lista de IDs de perros.
     */
    public ArrayList<Integer> retornoId();

    /**
     * Trae un perro específico para ser actualizado, según su ID.
     *
     * @param id ID del perro que se desea obtener para actualizar.
     * @return Objeto PerroVO correspondiente al ID proporcionado.
     */
    public PerroVO traerPerroActualizar(int id);

    /**
     * Retorna una lista de razas disponibles.
     *
     * @return Lista de razas de perros.
     */
    public ArrayList<String> retornoRazas();

    public void actualizarPerro(PerroVO perro);
}
