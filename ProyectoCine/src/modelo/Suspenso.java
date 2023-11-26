
package modelo;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author betza
 */
public class Suspenso extends Pelicula{
    
    private int cant_muerte;
    private int cant_grito;

    public Suspenso() {
    }

    public Suspenso(int cant_muerte, int cant_grito) throws Exception {
        setCant_grito(cant_grito);
        setCant_muerte(cant_muerte);
    }

    public Suspenso(int cant_muerte, int cant_grito, int id_pelicula, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) throws Exception {
        super(id_pelicula, director, titulo, fecha_lanzamiento, duracion, rating);
        setCant_grito(cant_grito);
        setCant_muerte(cant_muerte);
    }

    public Suspenso(int cant_muerte, int cant_grito, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) throws Exception {
        super(director, titulo, fecha_lanzamiento, duracion, rating);
        setCant_grito(cant_grito);
        setCant_muerte(cant_muerte);
    }

    public int getCant_muerte() {
        return cant_muerte;
    }

    public void setCant_muerte(int cant_muerte) throws Exception {
        if (cant_muerte >= 0) {
             this.cant_muerte = cant_muerte;
        }else{
            JOptionPane.showMessageDialog(null, "La cantidad de muertes no puede ser menor que 0!");
            throw new Exception("La cantidad de muertes no puede ser menor que 0!");
        }
       
    }

    public int getCant_grito() {
        return cant_grito;
    }

    public void setCant_grito(int cant_grito) throws Exception {
        if (cant_grito >= 0) {
        this.cant_grito = cant_grito;
            
        }else{
            JOptionPane.showMessageDialog(null, "La cantidad de gritos no puede ser menor que 0!");
            throw new Exception("La cantidad de gritos no puede ser menor que 0!");
        }
    }
    
    
    
}
