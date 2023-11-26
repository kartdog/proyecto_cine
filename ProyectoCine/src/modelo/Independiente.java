
package modelo;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class Independiente extends Pelicula{
    
    private int presupuesto;
    private int cant_reparto;

    public Independiente() {
    }

    public Independiente(int presupuesto, int cant_reparto, int id_pelicula, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) throws Exception {
        super(id_pelicula, director, titulo, fecha_lanzamiento, duracion, rating);
        setPresupuesto(presupuesto);
        setCant_reparto(cant_reparto);
    }

    public Independiente(int presupuesto, int cant_reparto, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) throws Exception {
        super(director, titulo, fecha_lanzamiento, duracion, rating);
        setPresupuesto(presupuesto);
        setCant_reparto(cant_reparto);
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) throws Exception {
        if (presupuesto > 500000) {
            this.presupuesto = presupuesto;
        }else{
            JOptionPane.showMessageDialog(null, "EL PRESUPUESTO NO DEBE SER MENOR A $500.000");
            throw new Exception("EL PRESUPUESTO NO DEBE SER MENOR A $500.000");
        }
    }

    public int getCant_reparto() {
        return cant_reparto;
    }

    public void setCant_reparto(int cant_reparto) throws Exception {
        if (cant_reparto > 0) {
            this.cant_reparto = cant_reparto;
        }else{
            JOptionPane.showMessageDialog(null, "EL REPARTO NO PUEDE SER 0, POR FAVOR COLOQUE UN VALOR MAYOR!");
            throw new Exception("EL REPARTO NO PUEDE SER 0, POR FAVOR COLOQUE UN VALOR MAYOR!");
        }
    }
    
    
    
}
