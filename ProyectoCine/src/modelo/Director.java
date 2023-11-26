
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            JOptionPane.showMessageDialog(null, "El nombre del director no puede estar en blanco!");
            throw new Exception("El nombre del director no puede estar en blanco!");
        }else if(pnombre.trim().length() < 3){
            JOptionPane.showMessageDialog(null, "El nombre del director no puede tener menos de 3 caracteres!");
            throw new Exception("El nombre del director no puede tener menos de 3 caracteres!");       
        }else if(!pnombre.trim().matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras!");
            throw new Exception("El nombre solo puede contener letras!");
        }else{
            this.pnombre = pnombre;
            
        }
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) throws Exception {
        if (appaterno.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "El apellido del director no puede estar en blanco!");
            throw new Exception("El apellido del director no puede estar en blanco!");
        }else if(appaterno.trim().length() < 3){
            JOptionPane.showMessageDialog(null, "El apellido del director no puede tener menos de 3 caracteres!");
            throw new Exception("El apellido del director no puede tener menos de 3 caracteres!");       
        }else if(!appaterno.trim().matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "El apellido solo puede contener letras!");
            throw new Exception("El apellido solo puede contener letras!");
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
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser hoy o posterior a hoy!");
            throw new Exception("La fecha de nacimiento no puede ser hoy o posterior a hoy!");
        }else{
            this.fecha_nacimiento = fecha_nacimiento;        
        }
    }
        
       
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) throws Exception {
        if (nacionalidad.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "La nacionalidad no puede estar en blanco!");
            throw new Exception("La nacionalidad no puede estar en blanco!");            
        }else if (nacionalidad.trim().length() < 3){
            JOptionPane.showMessageDialog(null, "La nacionalidad no puede tener menos de 3 caracteres!");
            throw new Exception("La nacionalidad no puede tener menos de 3 caracteres!");                
        }
        this.nacionalidad = nacionalidad;
    }
}