/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Accion;
import modelo.Independiente;
import modelo.Pelicula;
import modelo.Suspenso;

/**
 *
 * @author DUOC
 */
public class PeliculaDAO {
    Connection cone;

    public PeliculaDAO() {
        cone = new ConexionOracle().getCone();
    }
    
    //CRUD
    public boolean agregarPelicula(Pelicula p) throws SQLException{
        boolean resp = false;
        try {
            if (p instanceof Suspenso) {
                
                String sql = "INSERT INTO pelicula VALUES (sq_pel.NEXTVAL, ?,?,?,?,?,?,?)";
            PreparedStatement pst = cone.prepareStatement(sql);

            java.util.Date fecha_util = p.getFecha_lanzamiento();
            java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());

            pst.setInt(1, p.getDirector().getId_director());
            pst.setString(2, p.getNombre());
            pst.setDate(3, fecha_sql);
            pst.setInt(4, p.getDuracion());
            pst.setInt(5, p.getRating());
            pst.setInt(6, ((Suspenso) p).getCant_muerte());
            pst.setInt(7, ((Suspenso) p).getCant_grito());
               
            }else if (p instanceof Accion) {
                
              String sql = "INSERT INTO pelicula VALUES (sq_pel.NEXTVAL, ?,?,?,?,?,?,?)";
                PreparedStatement pst = cone.prepareStatement(sql);
               
                java.util.Date fecha_util = p.getFecha_lanzamiento();
                java.sql.Date fecha_sql= new java.sql.Date(fecha_util.getTime());
                pst.setInt(1, p.getDirector().getId_director());
                pst.setString(2, p.getNombre());
                pst.setDate(3, fecha_sql);
                pst.setInt(4, p.getDuracion());
                pst.setInt(5, p.getRating());
                pst.setInt(6, ((Accion) p).getCant_explosion());
                pst.setInt(7, ((Accion) p).isTiene_cgi() ? "TIENE" : "NO TIENE" );
               

            }else if (p instanceof Independiente) {
           String sql = "INSERT INTO pelicula VALUES (sq_pel.NEXTVAL, ?,?,?,?,?,?,?)";
            PreparedStatement pst = cone.prepareStatement(sql);

            java.util.Date fecha_util = p.getFecha_lanzamiento();
            java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());

            pst.setInt(1, p.getDirector().getId_director());
            pst.setString(2, p.getNombre());
            pst.setDate(3, fecha_sql);
            pst.setInt(4, p.getDuracion());
            pst.setInt(5, p.getRating());
            pst.setInt(6, ((Independiente) p).getPresupuesto());
            pst.setInt(7, ((Independiente) p).getCant_reparto());

            int lineas = pst.executeUpdate();
            resp = (lineas > 0);
        }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            cone.close();
        }
        return resp;
    }
    public boolean eliminarPelicula(int id_pelicula) throws SQLException{
        boolean resp = false; 
        try {
            
            String sql = "DELETE FROM pelicula WHERE nombre = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setInt(1, id_pelicula);
            int lineas = pst.executeUpdate();
            if (lineas > 0) {
                resp = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            cone.close();
        }
        return resp;
    }
    
    public boolean modificarPelicula(Pelicula p) throws SQLException{
        boolean resp = false;
        try {
            if (p instanceof Accion) {
                
            java.util.Date fecha_util = p.getFecha_lanzamiento();
            java.sql.Date fecha_sql= new java.sql.Date(fecha_util.getTime());
            String sql = "UPDATE pelicula SET nombre = ?, fecha_lanzamiento = ?, duracion = ?, rating = ?, cant_explosion = ?,tiene_cgi =?  WHERE id_pelicula = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setDate(2, fecha_sql);
            pst.setInt(3, p.getDuracion());
            pst.setInt(4, p.getRating());
            pst.setString(5, p.getDirector().getPnombre());
            pst.setInt(6, ((Accion) p).getCant_explosion());
            pst.setBoolean(7, ((Accion) p).isTiene_cgi());
                
            }else if (p instanceof Independiente) {
                
            java.util.Date fecha_util = p.getFecha_lanzamiento();
            java.sql.Date fecha_sql= new java.sql.Date(fecha_util.getTime());
            String sql = "UPDATE pelicula SET nombre = ?, fecha_lanzamiento = ?, duracion = ?, rating = ?, presupuesto = ?,cant_reparto =?  WHERE id_pelicula = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setDate(2, fecha_sql);
            pst.setInt(3, p.getDuracion());
            pst.setInt(4, p.getRating());
            pst.setString(5, p.getDirector().getPnombre()); 
            pst.setInt(6, ((Independiente) p).getPresupuesto());
            pst.setInt(7, ((Independiente) p).getCant_reparto());
                
            }else if (p instanceof Suspenso){
                
            java.util.Date fecha_util = p.getFecha_lanzamiento();
            java.sql.Date fecha_sql= new java.sql.Date(fecha_util.getTime());
            String sql = "UPDATE pelicula SET nombre = ?, fecha_lanzamiento = ?, duracion = ?, rating = ?, cant_muerte = ?,cant_grito =?  WHERE id_pelicula = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setDate(2, fecha_sql);
            pst.setInt(3, p.getDuracion());
            pst.setInt(4, p.getRating());
            pst.setString(5, p.getDirector().getPnombre());
            pst.setInt(6, ((Suspenso) p).getCant_muerte());
            pst.setInt(7, ((Suspenso) p).getCant_grito());
            }
            
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            cone.close();
        }
        return resp;
    }
    public Pelicula buscarPelicula(int codigo) throws SQLException{
        Pelicula p = new Pelicula();
        try {
            if (p instanceof Suspenso) {
                
            String sql = "SELECT nombre, fecha_lanzamiento, duracion, rating, cant_muerte, cant_grito FROM pelicula WHERE id_pelicula = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setInt(1, p.getId_pelicula());
           
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {     
                
                p.setNombre(rs.getString("nombre"));
                p.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));
                p.setDuracion(rs.getInt("duracion"));
                p.setRating(rs.getInt("rating"));
                ((Suspenso) p).setCant_muerte(rs.getInt("cant_muerte"));
                ((Suspenso) p).setCant_grito(rs.getInt("cant_grito"));
                
            }   
            }else if (p instanceof Accion){
                
            String sql = "SELECT nombre, fecha_lanzamiento, duracion, rating, cant_explosion, tiene_cgi FROM pelicula WHERE id_pelicula = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setInt(1, p.getId_pelicula());
           
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {     
               
                p.setNombre(rs.getString("nombre"));
                p.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));
                p.setDuracion(rs.getInt("duracion"));
                p.setRating(rs.getInt("rating"));
                ((Accion) p).setCant_explosion(rs.getInt("cant_explosion"));
                ((Accion) p).setTiene_cgi(rs.getBoolean("tiene_cgi"));
                
            }
            }else if (p instanceof Independiente){
                 String sql = "SELECT nombre, fecha_lanzamiento, duracion, rating, presupuesto, cant_reparto FROM pelicula WHERE id_pelicula = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setInt(1, p.getId_pelicula());
           
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {     
               
                p.setNombre(rs.getString("nombre"));
                p.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));
                p.setDuracion(rs.getInt("duracion"));
                p.setRating(rs.getInt("rating"));
                ((Independiente) p).setPresupuesto(rs.getInt("presupuesto"));
                ((Independiente) p).setCant_reparto(rs.getInt("cant_reparto"));
                
                
            }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            cone.close();
        }
        return p;
    }
    
    
    
    
    public ResultSet listarPeliculas() throws SQLException{
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM pelicula";
            PreparedStatement pst = cone.prepareStatement(sql);
            rs = pst.executeQuery();
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            cone.close();
        }
        return rs;
    }
}


