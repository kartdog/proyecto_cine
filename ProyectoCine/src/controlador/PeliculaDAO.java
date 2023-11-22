
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Accion;
import modelo.Director;
import modelo.Pelicula;
import modelo.Suspenso;
import modelo.Independiente;

/**
 *
 * @author Felipe
 */
public class PeliculaDAO {

    Connection cone;
    
    public PeliculaDAO(){
        cone = new ConexionOracle().getCone();
    }
    
    public boolean agregarPelicula(Pelicula p) throws SQLException{
        boolean resp = false;
        try {
            if (p instanceof Accion) {
                String sql = "INSERT INTO accion VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cone.prepareStatement(sql);
                
                pst.setInt(1, p.getId_pelicula());
                pst.setInt(2, p.getDirector().getId_director());
                pst.setString(3, p.getTitulo());
                
                java.util.Date fecha_util = p.getFecha_lanzamiento();
                java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());
                pst.setDate(4, fecha_sql);
                
                pst.setInt(5, p.getDuracion());
                pst.setInt(6, p.getRating());
                
                pst.setInt(7, ((Accion) p).getCant_explosion());
                pst.setString(8, ((Accion) p).isTiene_cgi() ? "S" : "N");
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    resp = true;
                }   
            }else if(p instanceof Suspenso){
                String sql = "INSERT INTO suspenso VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cone.prepareStatement(sql);
                
                pst.setInt(1, p.getId_pelicula());
                pst.setInt(2, p.getDirector().getId_director());
                pst.setString(3, p.getTitulo());
                
                java.util.Date fecha_util = p.getFecha_lanzamiento();
                java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());
                pst.setDate(4, fecha_sql);
                
                pst.setInt(5, p.getDuracion());
                pst.setInt(6, p.getRating());
                
                pst.setInt(7, ((Suspenso) p).getCant_muerte());
                pst.setInt(8, ((Suspenso) p).getCant_grito());
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    resp = true;
                }
            }else{
                String sql = "INSERT INTO independiente VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement pst = cone.prepareStatement(sql);
                
                pst.setInt(1, p.getId_pelicula());
                pst.setInt(2, p.getDirector().getId_director());
                pst.setString(3, p.getTitulo());
                
                java.util.Date fecha_util = p.getFecha_lanzamiento();
                java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());
                pst.setDate(4, fecha_sql);
                
                pst.setInt(5, p.getDuracion());
                pst.setInt(6, p.getRating());
                
                pst.setInt(7, ((Independiente) p).getPresupuesto());
                pst.setInt(8, ((Independiente) p).getCant_reparto());    
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    resp = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            cone.close();
        }
        return resp;
    }
    
    public List<Number> listar_idAccion() throws SQLException{
        List<Number> lista = new ArrayList<>();
        try {
            String sql = "SELECT id_pelicula FROM accion";
            PreparedStatement pst = cone.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                lista.add(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return lista;
    }
    
    public List<Number> listar_idSuspenso() throws SQLException{
        List<Number> lista = new ArrayList<>();
        try {
            String sql = "SELECT id_pelicula FROM suspenso";
            PreparedStatement pst = cone.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                lista.add(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return lista;
    }
    
    public boolean eliminarPelicula(int id) throws SQLException{
        boolean resp = false;
        try {
            if (listar_idAccion().contains(id)) {
                String sql = "DELETE FROM accion WHERE id_pelicula = ?";
                PreparedStatement pst = cone.prepareStatement(sql);
                pst.setInt(1, id);
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    resp = true;
                }
            }else if(listar_idSuspenso().contains(id)){
                String sql = "DELETE FROM suspenso WHERE id_pelicula = ?";
                PreparedStatement pst = cone.prepareStatement(sql);
                pst.setInt(1, id);
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    resp = true;
                }
            }else{
                String sql = "DELETE FROM independiente WHERE id_pelicula = ?";
                PreparedStatement pst = cone.prepareStatement(sql);
                pst.setInt(1, id);
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    resp = true;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            cone.close();
        }
        return resp;
    }
    
    public boolean modificarPelicula(Pelicula p) throws SQLException{
        boolean resp = false;
        try {
            if (p instanceof Accion) {
                String sql = "UPDATE accion SET titulo = ?, fecha_lanzamiento = ?, duracion = ?, rating = ?, cant_explosion = ?, tiene_cgi = ? WHERE id_pelicula = ?";
                PreparedStatement pst = cone.prepareStatement(sql);
                
                pst.setInt(7, p.getId_pelicula());
                
                pst.setString(1, p.getTitulo());
                
                java.util.Date fecha_util = p.getFecha_lanzamiento();
                java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());
                pst.setDate(2, fecha_sql);
                
                pst.setInt(3, p.getDuracion());
                pst.setInt(4, p.getRating());
                
                pst.setInt(5, ((Accion) p).getCant_explosion());
                pst.setString(6, ((Accion) p).isTiene_cgi() ? "S" : "N");
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    resp = true;
                }
            }else if(p instanceof Suspenso){
                String sql = "UPDATE suspenso SET titulo = ?, fecha_lanzamiento = ?, duracion = ?, rating = ?, cant_muerte = ?, cant_grito = ? WHERE id_pelicula = ?";
                PreparedStatement pst = cone.prepareStatement(sql);
                
                pst.setInt(7, p.getId_pelicula());
                
                pst.setString(1, p.getTitulo());
                
                java.util.Date fecha_util = p.getFecha_lanzamiento();
                java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());
                pst.setDate(2, fecha_sql);
                
                pst.setInt(3, p.getDuracion());
                pst.setInt(4, p.getRating());
                
                pst.setInt(5, ((Suspenso) p).getCant_muerte());
                pst.setInt(6, ((Suspenso) p).getCant_grito());
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    resp = true;
                }
            }else{
                String sql = "UPDATE independiente SET titulo = ?, fecha_lanzamiento = ?, duracion = ?, rating = ?, presupuesto = ?, cant_reparto = ? WHERE id_pelicula = ?";
                PreparedStatement pst = cone.prepareStatement(sql);
                
                pst.setInt(7, p.getId_pelicula());
                
                pst.setString(1, p.getTitulo());

                java.util.Date fecha_util = p.getFecha_lanzamiento();
                java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime());
                pst.setDate(2, fecha_sql);
                
                pst.setInt(3, p.getDuracion());
                pst.setInt(4, p.getRating());
                
                pst.setInt(5, ((Independiente) p).getPresupuesto());
                pst.setInt(6, ((Independiente) p).getCant_reparto());
                
                int lineas = pst.executeUpdate();
                if (lineas > 0) {
                    return resp;
                } 
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            cone.close();
        }
        return resp;
    }
    
    public Pelicula buscarPelicula(int id) throws SQLException{
        Accion a = new Accion();
        try {
            if (listar_idAccion().contains(id)) {
                String sql = "SELECT id_pelicula, id_director, titulo, fecha_lanzamiento, duracion, rating, cant_explosion, tiene_cgi FROM accion WHERE id_pelicula = ?";
                PreparedStatement pst = cone.prepareStatement(sql);
                pst.setInt(1, id);
                
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    
                    Director d = new Director();
                    a.setDirector(d);
                    
                    a.setTitulo(rs.getString("titulo"));
                    
                    java.sql.Date fecha_sql = rs.getDate("fecha_lanzamiento");
                    java.util.Date fecha_txt = new java.util.Date(fecha_sql.getTime());
                    a.setFecha_lanzamiento(fecha_txt);
                    
                    a.setDuracion(rs.getInt("duracion"));
                    a.setRating(rs.getInt("rating"));
                    
                    a.setCant_explosion(rs.getInt("cant_explosion"));
                    
                    if (rs.getString("tiene_cgi").equals("S")) {
                        a.setTiene_cgi(true);
                    }else{
                        a.setTiene_cgi(false);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            cone.close();
        }
        return a;
    }
    
    public ResultSet listar_peliculas(){
        ResultSet rs = null;
        try {
            String sql = "SELECT * from accion";
            PreparedStatement pst = cone.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return rs;
    }
    
}