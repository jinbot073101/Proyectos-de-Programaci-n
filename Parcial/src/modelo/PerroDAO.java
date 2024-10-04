package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IPerroDAO para realizar operaciones de
 * acceso a datos relacionadas con los perros en la base de datos.
 *
 * Proporciona métodos para registrar, modificar, consultar y eliminar objetos
 * de tipo PerroVO en la base de datos.
 */
public class PerroDAO implements IPerroDAO {

    private Connection con;  // Conexión a la base de datos
    private PreparedStatement ps;  // Preparación de la consulta SQL
    private ResultSet rs;  // Resultados de la consulta SQL

    /**
     * Constructor de la clase PerroDAO. Inicializa los recursos de conexión.
     */
    public PerroDAO() {
        con = null;
        ps = null;
        rs = null;
    }

    @Override
    public void registrar(PerroVO perro) {
        /**
         * Registra un nuevo perro en la base de datos.
         *
         * @param perro Objeto PerroVO que se desea registrar.
         */
        String query = "INSERT INTO perros (nombreRaza, paisOrigen, clasificacionFCI, aparienciaGeneral, pelo, color, espalda, lomo, cola, pecho) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
            ps.setString(1, perro.getNombreRaza());
            ps.setString(2, perro.getPaisOrigen());
            ps.setString(3, perro.getClasificacionFCI());
            ps.setString(4, perro.getAparienciaGeneral());
            ps.setString(5, perro.getPelo());
            ps.setString(6, perro.getColor());
            ps.setString(7, perro.getEspalda());
            ps.setString(8, perro.getLomo());
            ps.setString(9, perro.getCola());
            ps.setString(10, perro.getPecho());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
    }

    @Override
    public void modificarPerros(PerroVO perroModificado) {
        /**
         * Modifica un perro existente en la base de datos.
         *
         * @param perroModificado Objeto PerroVO que contiene los datos
         * actualizados del perro.
         */
        String query = "UPDATE perros SET nombreRaza = ?, paisOrigen = ?, clasificacionFCI = ?, aparienciaGeneral = ?, pelo = ?, color = ?, espalda = ?, lomo = ?, cola = ?, pecho = ? WHERE id = ?";
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
            ps.setString(1, perroModificado.getNombreRaza());
            ps.setString(2, perroModificado.getPaisOrigen());
            ps.setString(3, perroModificado.getClasificacionFCI());
            ps.setString(4, perroModificado.getAparienciaGeneral());
            ps.setString(5, perroModificado.getPelo());
            ps.setString(6, perroModificado.getColor());
            ps.setString(7, perroModificado.getEspalda());
            ps.setString(8, perroModificado.getLomo());
            ps.setString(9, perroModificado.getCola());
            ps.setString(10, perroModificado.getPecho());
            ps.setInt(11, perroModificado.getId());
            ps.executeUpdate();  // Ejecutar la actualización
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
    }

    @Override
    public ArrayList<Integer> retornoId() {
        /**
         * Retorna una lista de IDs de perros que tienen atributos vacíos en la
         * base de datos.
         *
         * @return ArrayList de IDs de perros.
         */
        String cons = "SELECT id FROM perros WHERE clasificacionFCI='' AND aparienciaGeneral='' AND pelo='' "
                + "AND color='' AND espalda='' AND lomo='' AND cola='' AND pecho=''";
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(cons);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                ids.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
        return ids;  // Retorna los IDs
    }

    /**
     * Retorna una lista de razas de perros disponibles en la base de datos.
     *
     * @return ArrayList de cadenas que representan las razas de perros.
     */
    @Override
    public ArrayList<String> retornoRazas() {

        String cons = "SELECT nombreRaza FROM perros";  // Consulta para obtener todas las razas
        ArrayList<String> razas = new ArrayList<>();

        try {
            con = ConexionBD.getConexion();  // Conexión a la base de datos
            ps = con.prepareStatement(cons);
            rs = ps.executeQuery();

            while (rs.next()) {
                String raza = rs.getString("nombreRaza");
                razas.add(raza);  // Añade cada raza a la lista
            }
        } catch (SQLException ex) {
           Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();  // Cierra los recursos abiertos
        }
        return razas;  // Retorna la lista de razas
    }

    /**
     * Trae un perro de la base de datos para su actualización.
     *
     * @param id El ID del perro que se desea traer.
     * @return Objeto PerroVO correspondiente al perro que se desea actualizar.
     */
    @Override
    public PerroVO traerPerroActualizar(int id) {
        String query = "SELECT * FROM perros WHERE id = ?";
        PerroVO perro = null;
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            // Si el resultado contiene un perro, mapeamos los datos al objeto PerroVO
            if (rs.next()) {
                perro = new PerroVO(
                        rs.getString("nombreRaza"),
                        rs.getString("paisOrigen"),
                        rs.getString("clasificacionFCI"),
                        rs.getString("aparienciaGeneral"),
                        rs.getString("pelo"),
                        rs.getString("color"),
                        rs.getString("espalda"),
                        rs.getString("lomo"),
                        rs.getString("cola"),
                        rs.getString("pecho"),
                        rs.getInt("id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perro; // Devuelve el objeto PerroVO o null si no se encontró el perro
    }

    /**
     * Consulta perros por grupo FCI en la base de datos.
     *
     * @param clasificacionFCI El valor del grupo FCI por el cual se desea
     * consultar.
     * @return ArrayList de objetos PerroVO que pertenecen al grupo FCI
     * especificado.
     */
    @Override
    public ArrayList<PerroVO> consultarPorGrupoFCI(String clasificacionFCI) {

        String query = "SELECT * FROM perros WHERE clasificacionFCI = ?";
        ArrayList<PerroVO> listaPerrosFCI = new ArrayList<>();
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
            ps.setString(1, clasificacionFCI);
            rs = ps.executeQuery();

            while (rs.next()) {
                PerroVO perro = new PerroVO(
                        rs.getString("nombreRaza"),
                        rs.getString("paisOrigen"),
                        rs.getString("clasificacionFCI"),
                        rs.getString("aparienciaGeneral"),
                        rs.getString("pelo"),
                        rs.getString("color"),
                        rs.getString("espalda"),
                        rs.getString("lomo"),
                        rs.getString("cola"),
                        rs.getString("pecho"),
                        rs.getInt("id")
                );
                listaPerrosFCI.add(perro);  // Agregar el objeto Perro a la lista
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
        return listaPerrosFCI;  // Retorna la lista de perros
    }

    /**
     * Consulta perros por raza en la base de datos.
     *
     * @param nombreRaza El valor de la raza por la cual se desea consultar.
     * @return ArrayList de objetos PerroVO que pertenecen a la raza
     * especificada.
     */
    @Override
    public ArrayList<PerroVO> consultarPorRaza(String nombreRaza) {

        String query = "SELECT * FROM perros WHERE nombreRaza = ?";
        ArrayList<PerroVO> listaPerrosRaza = new ArrayList<>();
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
            ps.setString(1, nombreRaza);
            rs = ps.executeQuery();

            while (rs.next()) {
                PerroVO perro = new PerroVO(
                        rs.getString("nombreRaza"),
                        rs.getString("paisOrigen"),
                        rs.getString("clasificacionFCI"),
                        rs.getString("aparienciaGeneral"),
                        rs.getString("pelo"),
                        rs.getString("color"),
                        rs.getString("espalda"),
                        rs.getString("lomo"),
                        rs.getString("cola"),
                        rs.getString("pecho"),
                        rs.getInt("id")
                );
                listaPerrosRaza.add(perro);  // Agregar el objeto Perro a la lista
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
        return listaPerrosRaza;  // Retorna la lista de perros
    }

    /**
     * Consulta perros por tipo de manto en la base de datos.
     *
     * @param color El valor del color del manto por el cual se desea consultar.
     * @return ArrayList de objetos PerroVO que tienen el color de manto
     * especificado.
     */
    @Override
    public ArrayList<PerroVO> consultarPorManto(String color) {

        String query = "SELECT * FROM perros WHERE color = ?";
        ArrayList<PerroVO> listaPerrosManto = new ArrayList<>();
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
            ps.setString(1, color);
            rs = ps.executeQuery();

            while (rs.next()) {
                PerroVO perro = new PerroVO(
                        rs.getString("nombreRaza"),
                        rs.getString("paisOrigen"),
                        rs.getString("clasificacionFCI"),
                        rs.getString("aparienciaGeneral"),
                        rs.getString("pelo"),
                        rs.getString("color"),
                        rs.getString("espalda"),
                        rs.getString("lomo"),
                        rs.getString("cola"),
                        rs.getString("pecho"),
                        rs.getInt("id")
                );
                listaPerrosManto.add(perro);  // Agregar el objeto Perro a la lista
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
        return listaPerrosManto;  // Retorna la lista de perros
    }

    @Override
    public ArrayList<PerroVO> consultarPorPais(String pais) {
        /**
         * Consulta perros por país de origen en la base de datos.
         *
         * @param pais El país de origen por el cual se desea consultar.
         * @return ArrayList de objetos PerroVO que tienen el país de origen
         * especificado.
         */
        String query = "SELECT * FROM perros WHERE paisOrigen = ?";
        ArrayList<PerroVO> listaPerrosPais = new ArrayList<>();
        try {

            con = ConexionBD.getConexion();  // Establecer conexión con la base de datos
            ps = con.prepareStatement(query);
            ps.setString(1, pais);  // Establecer el parámetro de consulta
            rs = ps.executeQuery();  // Ejecutar la consulta

            while (rs.next()) {
                PerroVO perro = new PerroVO(
                        rs.getString("nombreRaza"),
                        rs.getString("paisOrigen"),
                        rs.getString("clasificacionFCI"),
                        rs.getString("aparienciaGeneral"),
                        rs.getString("pelo"),
                        rs.getString("color"),
                        rs.getString("espalda"),
                        rs.getString("lomo"),
                        rs.getString("cola"),
                        rs.getString("pecho"),
                        rs.getInt("id")
                );  // Crear objeto PerroVO con los datos de la consulta
                listaPerrosPais.add(perro);  // Agregar el objeto Perro a la lista
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();  // Cerrar los recursos abiertos
        }
        return listaPerrosPais;  // Retornar la lista de perros
    }

    /**
     * Elimina un perro de la base de datos.
     *
     * @param id El ID del perro que se desea eliminar.
     */
    @Override
    public void eliminar(int id) {

        String query = "DELETE FROM perros WHERE id = ?";
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();  // Ejecutar la eliminación
        } catch (SQLException ex) {
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
    }

    @Override
    public ArrayList<PerroVO> traerPerrosBaseDatos() {
        /**
         * Recupera todos los perros de la base de datos.
         *
         * @return ArrayList de objetos PerroVO que representan todos los perros
         * en la base de datos.
         */
        ArrayList<PerroVO> listaPerros = new ArrayList<>();
        String query = "SELECT * FROM perros";  // Consulta para obtener todos los perros
        try {
            con = ConexionBD.getConexion(); // Obtén la conexión a la base de datos
            ps = con.prepareStatement(query); // Prepara la consulta SQL
            rs = ps.executeQuery(); // Ejecuta la consulta
            // Recorre los resultados y crea objetos PerroVO
            while (rs.next()) {
                PerroVO perro = new PerroVO(
                        rs.getString("nombreRaza"),
                        rs.getString("paisOrigen"),
                        rs.getString("clasificacionFCI"),
                        rs.getString("aparienciaGeneral"),
                        rs.getString("pelo"),
                        rs.getString("color"),
                        rs.getString("espalda"),
                        rs.getString("lomo"),
                        rs.getString("cola"),
                        rs.getString("pecho"),
                        rs.getInt("id") // El id del perro
                );
                listaPerros.add(perro); // Añade cada objeto al ArrayList}
            }
        } catch (SQLException ex) {
            // Manejo de excepciones
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(); // Cierra los recursos abiertos
        }
        return listaPerros; // Devuelve la lista con los perros
    }

    private void closeResources() {
        /**
         * Cierra los recursos utilizados en las operaciones de base de datos.
         * Asegura que el ResultSet, PreparedStatement y Connection se cierren
         * para liberar recursos y evitar fugas de memoria.
         */
        try {
            if (rs != null) {
                rs.close(); // Cierra el ResultSet si no es nulo
            }
            if (ps != null) {
                ps.close(); // Cierra el PreparedStatement si no es nulo
            }
            if (con != null) {
                con.close(); // Cierra la conexión si no es nula
            }
        } catch (SQLException ex) {
            // Manejo de excepciones opcional, como imprimir el error o registrarlo en un log
            Logger.getLogger(PerroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
