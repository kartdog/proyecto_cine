
package modelo;

import java.util.Date;

/**
 *
 * @author Felipe
 */
public class Accion extends Pelicula{
    
    private int cant_explosion;
    private boolean tiene_cgi;

    public Accion() {
    }

    public Accion(int cant_explosion, boolean tiene_cgi) {
        this.cant_explosion = cant_explosion;
        this.tiene_cgi = tiene_cgi;
    }

    public Accion(int cant_explosion, boolean tiene_cgi, int id_pelicula, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) {
        super(id_pelicula, director, titulo, fecha_lanzamiento, duracion, rating);
        this.cant_explosion = cant_explosion;
        this.tiene_cgi = tiene_cgi;
    }

    public Accion(int cant_explosion, boolean tiene_cgi, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) {
        super(director, titulo, fecha_lanzamiento, duracion, rating);
        this.cant_explosion = cant_explosion;
        this.tiene_cgi = tiene_cgi;
    }

    public int getCant_explosion() {
        return cant_explosion;
    }

    public void setCant_explosion(int cant_explosion) {
        this.cant_explosion = cant_explosion;
    }

    public boolean isTiene_cgi() {
        return tiene_cgi;
    }

    public void setTiene_cgi(boolean tiene_cgi) {
        this.tiene_cgi = tiene_cgi;
    }
    
    
    
}
