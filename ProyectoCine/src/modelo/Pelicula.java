
package modelo;

import java.util.Date;

/**
 *
 * @author Felipe
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

    public Pelicula(int id_pelicula, Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) {
        this.id_pelicula = id_pelicula;
        this.director = director;
        this.titulo = titulo;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.duracion = duracion;
        this.rating = rating;
    }

    public Pelicula(Director director, String titulo, Date fecha_lanzamiento, int duracion, int rating) {
        this.director = director;
        this.titulo = titulo;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.duracion = duracion;
        this.rating = rating;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    
    
}
