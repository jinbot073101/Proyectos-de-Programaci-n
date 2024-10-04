package modelo;

import java.util.ArrayList;

/**
 * Interfaz para la gestión de operaciones de acceso a datos relacionados con
 * los perros.
 *
 * Esta interfaz define métodos para registrar, modificar, consultar y eliminar
 * objetos de tipo PerroVO en la base de datos. Las implementaciones de esta
 * interfaz deben proporcionar la lógica específica para interactuar con el
 * sistema de persistencia.
 */
public interface IPerroDAO {

    /**
     * Registra un nuevo perro en la base de datos.
     *
     * @param perro Objeto PerroVO que se desea registrar.
     */
    public void registrar(PerroVO perro);

    /**
     * Modifica un perro existente en la base de datos.
     *
     * @param perroModificado Objeto PerroVO que contiene los datos actualizados
     * del perro.
     */
    public void modificarPerros(PerroVO perroModificado);

    /**
     * Consulta perros por grupo FCI.
     *
     * @param valor El valor del grupo FCI por el cual se desea consultar.
     * @return ArrayList de objetos PerroVO que pertenecen al grupo FCI
     * especificado.
     */
    public ArrayList<PerroVO> consultarPorGrupoFCI(String valor);

    /**
     * Consulta perros por raza.
     *
     * @param valor El valor de la raza por la cual se desea consultar.
     * @return ArrayList de objetos PerroVO que pertenecen a la raza
     * especificada.
     */
    public ArrayList<PerroVO> consultarPorRaza(String valor);

    /**
     * Consulta perros por tipo de manto.
     *
     * @param color El valor del tipo de manto por el cual se desea consultar.
     * @return ArrayList de objetos PerroVO que corresponden al tipo de manto
     * especificado.
     */
    public ArrayList<PerroVO> consultarPorManto(String color);

    /**
     * Consulta perros por país de origen.
     *
     * @param valor El valor del país por el cual se desea consultar.
     * @return ArrayList de objetos PerroVO que pertenecen al país especificado.
     */
    public ArrayList<PerroVO> consultarPorPais(String valor);

    /**
     * Elimina un perro de la base de datos.
     *
     * @param id El ID del perro que se desea eliminar.
     */
    public void eliminar(int id);

    /**
     * Trae un perro de la base de datos para su actualización.
     *
     * @param id El ID del perro que se desea traer.
     * @return Objeto PerroVO que representa al perro correspondiente al ID
     * especificado.
     */
    public PerroVO traerPerroActualizar(int id);

    /**
     * Trae todos los perros de la base de datos.
     *
     * @return ArrayList de objetos PerroVO que representan todos los perros en
     * la base de datos.
     */
    public ArrayList<PerroVO> traerPerrosBaseDatos();

    /**
     * Retorna una lista de razas disponibles en la base de datos.
     *
     * @return ArrayList de cadenas que representan las razas de perros
     * disponibles.
     */
    public ArrayList<String> retornoRazas();

    public ArrayList<Integer> retornoId();

}
