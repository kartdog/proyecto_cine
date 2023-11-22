
package modelo;

import java.util.Date;

/**
 *
 * @author Felipe
 */
public class Independiente extends Pelicula{
    
    private int presupuesto;
    private int cant_reparto;

    public Independiente() {
    }

    public Independiente(int presupuesto, int cant_reparto, int id_pelicula, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) {
        super(id_pelicula, director, titulo, fecha_lanzamiento, duracion, rating);
        this.presupuesto = presupuesto;
        this.cant_reparto = cant_reparto;
    }

    public Independiente(int presupuesto, int cant_reparto, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) {
        super(director, titulo, fecha_lanzamiento, duracion, rating);
        this.presupuesto = presupuesto;
        this.cant_reparto = cant_reparto;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getCant_reparto() {
        return cant_reparto;
    }

    public void setCant_reparto(int cant_reparto) {
        this.cant_reparto = cant_reparto;
    }
    
    
    
}
