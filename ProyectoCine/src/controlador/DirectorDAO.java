
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            // se establecen los valores para decir 'USA ESTOS' de esa forma sql no se queja al pasarle solo 4 valores. (debido al autoincrementable)
            String sql = "INSERT INTO director(pnombre, appaterno, fecha_nacimiento, nacionalidad) VALUES(?,?,?,?)";
            PreparedStatement pst = cone.prepareStatement(sql); // le manda el codigo sql
            
            // se empieza a reemplazar los valores '?'
            pst.setString(1, d.getPnombre());
            pst.setString(2, d.getAppaterno());
            
            java.util.Date fecha_util = d.getFecha_nacimiento(); // creo variable tipo utilDate que guarda la fecha.
            java.sql.Date fecha_sql = new java.sql.Date(fecha_util.getTime()); // se crea una nueva fecha tipo (Date hoy = new Date()), pero de sql para transformar la fecha util a sql.
            pst.setDate(3, fecha_sql);
            
            pst.setString(4, d.getNacionalidad());
            
            // se ejecuta la accion y con el if se comprueba si algunas lineas fueron cambiadas
            int lineas = pst.executeUpdate();
            if (lineas > 0) {
                resp = true;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            cone.close();
        }
        return resp;
    }
    
    public boolean eliminarDirector(int id_director) throws SQLException{
        boolean resp = false;
        try {
            String sql = "DELETE FROM director WHERE id_director = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setInt(1, id_director);
            int lineas = pst.executeUpdate();
            if (lineas > 0) {
                resp = true;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() );
        } finally {
            cone.close();
        }
        return resp;
    }
    
    public boolean modificarPersona(Director d) throws SQLException{
        boolean resp = false;
        try {
            String sql = "UPDATE persona SET nombre = ?, edad = ?, genero = ?, pasaporte = ? WHERE rut = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setString(1, d.getPnombre() );
            pst.setString(2, d.getAppaterno() );
            pst.setString(3, String.valueOf(d.getFecha_nacimiento()) ); // modificar DATE
            pst.setString(5, d.getNacionalidad());
            int lineas = pst.executeUpdate();
            if (lineas > 0) {
                resp = true;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() );
        } finally {
            cone.close();
        }
        return resp;
    }
    
    public Director buscarDirector(int id_director) throws SQLException{
        Director d = new Director();
        try {
            String sql = "SELECT pnombre, appaterno, fecha_nacimiento, nacionalidad FROM director WHERE id_director = ?";
            PreparedStatement pst = cone.prepareStatement(sql);
            pst.setInt(1, id_director);
            //aquí es distinto!
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { 
                // arreglar (no lo entiendo aún).
                d.getPnombre();
                d.getAppaterno();
                d.getFecha_nacimiento();
                d.getNacionalidad();
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() );
        } finally {
            cone.close();
        }
        return d;
    }
    
    public ResultSet listarDirector(){
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM director";
            PreparedStatement pst = cone.prepareStatement(sql);
            rs = pst.executeQuery();            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() );
        }
        return rs;
    }
}
