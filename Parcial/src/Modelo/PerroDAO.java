package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PerroDAO implements IPerroDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public PerroDAO() {
        con = null;
        st = null;
        rs = null;
    } 
    
    @Override
    public void ingresarPerro(PerroVO perro) {
        try {
            con = ConexionBD.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO Estudiantes VALUES('" + perro.getNombreRaza() + "','" + perro.getPaisOrigen() + "'," + perro.getClasificacionFCI() +
                    "'," + perro.getAparienciaGeneral()+ "'," + perro.getCola() + "'," + perro.getEspalda()+ "'," + perro.getLomo()+ "'," + perro.getPecho()
                    + "'," + perro.getPelo()+ "'," + perro.getPelo()+")";
            st.executeUpdate(insercion);
            st.close();
            ConexionBD.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }
    
    @Override
    public boolean modificarPerro() {
        //Update estudiantes set nombre='Maria Perez' where codigo=202210200031
        //String consulta = "update Estudiantes set edad=" + 45 + " where codigo='" + codigo + "'";
        try {
            con = ConexionBD.getConexion();
            st = con.createStatement();
            //st.executeUpdate(consulta);
            st.close();
            ConexionBD.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la modifcacion");
        }
        return false;
    }
    
    @Override
    public ArrayList<PerroVO> listaDePerros() {
        ArrayList<PerroVO> misPerros = new ArrayList<>();
        String consulta = "SELECT * FROM Estudiantes";
        try {
            con = ConexionBD.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                PerroVO perro = new PerroVO();
                perro.setNombreRaza(rs.getString("NombreRaza"));
                perro.setPaisOrigen(rs.getString("paisOrigen"));
                perro.setClasificacionFCI(rs.getString("ClasificacionFCI"));
                perro.setAparienciaGeneral(rs.getString("AparienciaGeneral"));
                perro.setPelo(rs.getString("Pelo"));
                perro.setColor(rs.getString("Color"));
                perro.setEspalda(rs.getString("Espalda"));
                perro.setLomo(rs.getString("Lomo"));
                perro.setCola(rs.getString("Cola"));
                perro.setPecho(rs.getString("Pecho"));                
                misPerros.add(perro);
            }
            st.close();
            ConexionBD.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return misPerros;
    }
    
    
    
    
   
}
