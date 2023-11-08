
package modelo;

import java.util.Date;

/**
 *
 * @author Felipe
 */
public class Director {
    
    private int id_director;
    private String pnombre;
    private String appaterno;
    private Date fecha_nacimiento;
    private String nacionalidad;   

    public Director() {
    }

    public Director(int id_director, String pnombre, String appaterno, Date fecha_nacimiento, String nacionalidad) throws Exception {
        setId_director(id_director);
        setPnombre(pnombre);
        setAppaterno(appaterno);
        setFecha_nacimiento(fecha_nacimiento);
        setNacionalidad(nacionalidad);
    }

    // Marca sin codigo para ser registrado automaticamente (autoincrementable o sequence)
    public Director(String pnombre, String appaterno, Date fecha_nacimiento, String nacionalidad) throws Exception {
        setPnombre(pnombre);
        setAppaterno(appaterno);
        setFecha_nacimiento(fecha_nacimiento);
        setNacionalidad(nacionalidad);
    }

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) throws Exception {
        if (pnombre.trim().length() == 0) {
            throw new Exception("El nombre del director no puede estar en blanco!");
        }else if(pnombre.trim().length() < 3){
            throw new Exception("El nombre del director no puede tener menos de 3 caracteres!");       
        }else{
            this.pnombre = pnombre;
        }
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) throws Exception {
        if (appaterno.trim().length() == 0) {
            throw new Exception("El apellido del director no puede estar en blanco!");
        }else if(appaterno.trim().length() < 3){
            throw new Exception("El apellido del director no puede tener menos de 3 caracteres!");       
        }else{
            this.appaterno = appaterno;
        }
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) throws Exception {
        Date hoy = new Date();
        if (fecha_nacimiento.after(hoy) || fecha_nacimiento.equals(hoy)) {
            throw new Exception("La fecha de nacimiento no puede ser hoy o posterior a hoy!");
        }else{
            this.fecha_nacimiento = fecha_nacimiento;        
        }
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}