
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Director;

/**
 *
 * @author Felipe
 */
public class DirectorDAO {
    
    Connection cone;

    public DirectorDAO() {
        cone = new ConexionOracle().getCone();
    }
    
    
    public boolean agregarDirector(Director d) throws SQLException{
        boolean resp = false;
        try {
            String sql = "INSERT INTO director(id_director, nombre, appaterno, fecha_nacimiento, nacionalidad) VALUES(?,?,?,?,?)";
            PreparedStatement pst = cone.prepareStatement(sql);
            
            pst.setInt(1, d.getId_director());
            pst.setString(2, d.getPnombre());
            pst.setString(3, d.getAppaterno());
            
            java.util.Date fecha_util = d.getFecha_nacimiento();
            java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());
            pst.setDate(4, fecha_sql);
            
            pst.setString(5, d.getNacionalidad());
            
            int lineas = pst.executeUpdate();
            if (lineas > 0) {
                resp = true;
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally{
            cone.close();
        }
        return resp;
    }
    
    public boolean eliminarDirector(int id) throws SQLException{
        boolean resp = false;
        try {
            String sql = "DELETE FROM director WHERE id_director = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setInt(1, id);
            
            int lineas = pst.executeUpdate();
            if (lineas > 0) {
                resp = true;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            cone.close();
        }
        return resp;
    }
    
    public boolean modificarDirector(Director d) throws SQLException{
        boolean resp = false;
        try {
            
            String sql = "UPDATE director SET nombre = ?, appaterno = ?, fecha_nacimiento = ?, nacionalidad = ? WHERE id_director = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setString(1, d.getPnombre());
            pst.setString(2, d.getAppaterno());

            java.util.Date fecha_util = d.getFecha_nacimiento();
            java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());
            pst.setDate(3, fecha_sql);
            
            pst.setString(4, d.getNacionalidad());
            pst.setInt(5, d.getId_director());
            
            int lineas = pst.executeUpdate();
            if (lineas > 0) {
                resp = true;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            cone.close();
        }
        return resp;
    }
    
    public Director buscarDirector(int id) throws SQLException{
        Director d = new Director();
        try {
            
            String sql = "SELECT id_director, nombre, appaterno, fecha_nacimiento, nacionalidad FROM director WHERE id_director = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                d.setPnombre(rs.getString("nombre"));
                d.setAppaterno(rs.getString("appaterno"));
                
                java.sql.Date fecha_sql = rs.getDate("fecha_nacimiento");
                java.util.Date fecha_txt = new java.util.Date(fecha_sql.getTime());
                d.setFecha_nacimiento(fecha_txt);
                
                d.setNacionalidad(rs.getString("nacionalidad"));
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            cone.close();
        }
        return d;
    }
    
    public List<Director> listar_directores() throws SQLException{
        List<Director> lista = new ArrayList<>();
        try {
            String sql = "SELECT id_director, nombre, appaterno, fecha_nacimiento, nacionalidad FROM director";
            PreparedStatement pst = cone.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                Director d = new Director();
                d.setId_director(rs.getInt(1));
                d.setPnombre(rs.getString(2));
                d.setAppaterno(rs.getString(3));
                d.setFecha_nacimiento(rs.getDate(4));
                d.setNacionalidad(rs.getString(5));
                lista.add(d);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            cone.close();
        }
        return lista;
    }
    
    public ResultSet listar_director() throws SQLException{
        ResultSet rs = null;
        try {
            String sql = "SELECT * from director";
            PreparedStatement pst = cone.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return rs;
    }   
    
    
}