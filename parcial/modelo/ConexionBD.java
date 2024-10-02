package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    
    private static Connection cn = null;
    private static final String URLBD = "jdbc:mysql://localhost/parcial_db";
    private static final String usuario = "root";
    private static final String contrasena = "";
    
    public static Connection getConexion() {
        try {
            cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        } catch (SQLException ex) {
            System.out.println("No se puede cargar el controlado");
        }
        return cn;
    }
    
    public static void desconectar() {
        cn = null;
    }       
}
