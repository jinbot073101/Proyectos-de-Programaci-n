
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class PerroDAO implements IPerroDAO{

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
            ex.printStackTrace();
            // Manejo más apropiado, como loggear errores
        } finally {
            closeResources();
        }
    }

   
    @Override
    public void modificar(PerroVO perroModificado) {
        String query = "UPDATE perros SET nombreRaza = ?, paisOrigen = ?, clasificacionFCI = ?, aparienciaGeneral = ?, pelo = ?, color = ?, espalda = ?, lomo = ?, cola = ?, pecho = ? WHERE id = ?";
        try {
            con = ConexionBD.getConexion();
        ps = con.prepareStatement(query);
        
        // Imprimir los valores que se están pasando
        System.out.println("nombreRaza: " + perroModificado.getNombreRaza());
        System.out.println("paisOrigen: " + perroModificado.getPaisOrigen());
        System.out.println("clasificacionFCI: " + perroModificado.getClasificacionFCI());
        System.out.println("aparienciaGeneral: " + perroModificado.getAparienciaGeneral());
        System.out.println("pelo: " + perroModificado.getPelo());
        System.out.println("color: " + perroModificado.getColor());
        System.out.println("espalda: " + perroModificado.getEspalda());
        System.out.println("lomo: " + perroModificado.getLomo());
        System.out.println("cola: " + perroModificado.getCola());
        System.out.println("pecho: " + perroModificado.getPecho());
        System.out.println("ID: " + perroModificado.getId());
        
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

        // Ejecutar la actualización
        int rowsAffected = ps.executeUpdate();
        System.out.println("Filas afectadas: " + rowsAffected);
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
        String query = "SELECT * FROM perros ";
        try {
            con = ConexionBD.getConexion();
            ps = con.prepareStatement(query);
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
                perrosIncompletos.add(perro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResources();
        }

        return perrosIncompletos;
    }
    
    public ArrayList<Integer> retornoId(){
        
        String cons = "SELECT id FROM perros WHERE clasificacionFCI='' AND aparienciaGeneral='' AND pelo='' AND color='' AND espalda='' AND lomo='' AND cola='' AND pecho=''";
        
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
            ex.printStackTrace();
        } finally {
            closeResources();
        }

        return ids;
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
