
package modelo;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author betza
 */
public class Accion extends Pelicula{
    
    private int cant_explosion;
    private boolean tiene_cgi;

    public Accion() {
    }

    public Accion(int cant_explosion, boolean tiene_cgi) throws Exception {
        setCant_explosion(cant_explosion);
        setTiene_cgi(tiene_cgi);
        
    }

    public Accion(int cant_explosion, boolean tiene_cgi, int id_pelicula, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) throws Exception {
        super(id_pelicula, director, titulo, fecha_lanzamiento, duracion, rating);
        setCant_explosion(cant_explosion);
        setTiene_cgi(tiene_cgi);
    }

    public Accion(int cant_explosion, boolean tiene_cgi, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) throws Exception {
        super(director, titulo, fecha_lanzamiento, duracion, rating);
        setCant_explosion(cant_explosion);
        setTiene_cgi(tiene_cgi);
    }

    public int getCant_explosion() {
        return cant_explosion;
    }

    public void setCant_explosion(int cant_explosion) throws Exception {
        if (cant_explosion >= 0) {
                    this.cant_explosion = cant_explosion;

        }else{
            JOptionPane.showMessageDialog(null, "La cantidad de explosiones no puede ser menor que 0!");
            throw new Exception("La cantidad de explosiones no puede ser menor que 0!");
        }
    }

    public boolean isTiene_cgi() {
        return tiene_cgi;
    }

    public void setTiene_cgi(boolean tiene_cgi) {
        this.tiene_cgi = tiene_cgi;
    }
    
    
    
}
