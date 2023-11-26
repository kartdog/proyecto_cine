
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

/**
 *
 * @author betza
 */
public class Pelicula {
    
    protected int id_pelicula;
    protected Director director;
    protected String titulo;
    protected Date fecha_lanzamiento;
    protected int duracion;
    protected int rating;

    public Pelicula() {
    }

    public Pelicula(int id_pelicula, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) throws Exception {
        setId_pelicula(id_pelicula);
        setDirector(director);
        setTitulo(titulo);
        setFecha_lanzamiento(fecha_lanzamiento);
        setDuracion(duracion);
        setRating(rating);
    }

    public Pelicula(Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) throws Exception {
        setDirector(director);
        setTitulo(titulo);
        setFecha_lanzamiento(fecha_lanzamiento);
        setDuracion(duracion);
        setRating(rating);
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception {
        if (titulo.trim().length() >= 3) {
            this.titulo = titulo;
        }else{
            JOptionPane.showMessageDialog(null, "El título debe tener al menos 3 caracteres!");
            throw new Exception("El titulo debe tener al menos 3 caracteres!");
        }
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Date fecha_lanzamiento) throws Exception {
        Date hoy = new Date();
        if (fecha_lanzamiento.after(hoy)) {
            JOptionPane.showMessageDialog(null, "La fecha de lanzamiento no puede ser posterior a hoy!");
            throw new Exception("La fecha de lanzamiento no puede ser posterior a hoy!");
        }else{
            this.fecha_lanzamiento = fecha_lanzamiento;        
        }
    }
    
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) throws Exception {
        if (duracion >= 40) {
                    this.duracion = duracion;
        }else{
            JOptionPane.showMessageDialog(null, "La duración no puede ser menor a 40 min!");
            throw new Exception("La duración no puede ser menor a 40 min!");   
        }
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws Exception {
        if (rating > 0 && rating <= 10) {
            this.rating = rating;
        }else{
            JOptionPane.showMessageDialog(null, "EL RATING debe ser del 1 al 10!");
            throw new Exception("EL RATING debe ser del 1 al 10!");
        }
    }
}
