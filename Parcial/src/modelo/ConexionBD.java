package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase para gestionar la conexión a la base de datos.
 *
 * Esta clase proporciona métodos para establecer y cerrar la conexión con la
 * base de datos utilizando JDBC. Contiene información sobre la URL de la base
 * de datos, el usuario y la contraseña necesarios para la conexión.
 */
public class ConexionBD {
    private static Connection cn = null; // Conexión a la base de datos
    private static final String URLBD = "jdbc:mysql://localhost/parcial_db"; // URL de la base de datos
    private static final String usuario = "root"; // Nombre de usuario para la conexión
    private static final String contrasena = ""; // Contraseña para la conexión
    /**
     * Establece y devuelve la conexión a la base de datos.
     *
     * @return Connection objeto que representa la conexión a la base de datos,
     * o null si no se pudo establecer la conexión.
     */
    public static Connection getConexion() {
        try {
            cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
    /**
     * Cierra la conexión a la base de datos.
     *
     * Esta función establece la variable de conexión a null, lo que indica que
     * la conexión ha sido cerrada.
     */
    public static void desconectar() {
        cn = null;
    }
}
