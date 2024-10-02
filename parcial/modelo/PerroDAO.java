package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PerroDAO implements IPerroDao {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public PerroDAO() {
        con = null;
        ps = null;
        rs = null;
    }

    @Override
    public void registrar(PerroVO perro) {
        String query = "INSERT INTO perros (nombre_raza, pais_origen, clasificacion_FCI, apariencia_general, pelo, color, espalda, lomo, cola, pecho) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ex.printStackTrace();
            // Manejo más apropiado, como loggear errores
        } finally {
            closeResources();
        }
    }

    @Override
    public void modificar(PerroVO perro) {
        String query = "UPDATE perros SET nombre_raza = ?, pais_origen = ?, clasificacion_FCI = ?, apariencia_general = ?, pelo = ?, color = ?, espalda = ?, lomo = ?, cola = ?, pecho = ? WHERE id = ?";
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
            //ps.setInt(11, perro.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public ArrayList<PerroVO> traerPerrosIncompletos() {
        ArrayList<PerroVO> perrosIncompletos = new ArrayList<>();
        String query = "SELECT * FROM perros WHERE pelo IS NULL OR color IS NULL OR espalda IS NULL OR lomo IS NULL OR cola IS NULL OR pecho IS NULL";
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                PerroVO perro = new PerroVO(
                        rs.getString("nombre_raza"),
                        rs.getString("pais_origen"),
                        rs.getString("clasificacion_FCI"),
                        rs.getString("apariencia_general"),
                        rs.getString("pelo"),
                        rs.getString("color"),
                        rs.getString("espalda"),
                        rs.getString("lomo"),
                        rs.getString("cola"),
                        rs.getString("pecho")
                );
                perrosIncompletos.add(perro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResources();
        }

        return perrosIncompletos;
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public PerroVO traerPerroActualizar(int id) {
        // Implementación pendiente
        return null;
    }

    @Override
    public void consultar(String parametro, String valor) {
        // Implementación pendiente
    }

    @Override
    public void eliminar() {
        // Implementación pendiente
    }

    @Override
    public ArrayList<PerroVO> listaDeRazas() {
        return new ArrayList<>();
    }
}
