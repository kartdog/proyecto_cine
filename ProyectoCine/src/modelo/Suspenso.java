
package modelo;

import java.util.Date;

/**
 *
 * @author Felipe
 */
public class Suspenso extends Pelicula{
    
    private int cant_muerte;
    private int cant_grito;

    public Suspenso() {
    }

    public Suspenso(int cant_muerte, int cant_grito, int id_pelicula, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) {
        super(id_pelicula, director, titulo, fecha_lanzamiento, duracion, rating);
        this.cant_muerte = cant_muerte;
        this.cant_grito = cant_grito;
    }

    public Suspenso(int cant_muerte, int cant_grito, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) {
        super(director, titulo, fecha_lanzamiento, duracion, rating);
        this.cant_muerte = cant_muerte;
        this.cant_grito = cant_grito;
    }

    public int getCant_muerte() {
        return cant_muerte;
    }

    public void setCant_muerte(int cant_muerte) {
        this.cant_muerte = cant_muerte;
    }

    public int getCant_grito() {
        return cant_grito;
    }

    public void setCant_grito(int cant_grito) {
        this.cant_grito = cant_grito;
    }
    
    
    
}
