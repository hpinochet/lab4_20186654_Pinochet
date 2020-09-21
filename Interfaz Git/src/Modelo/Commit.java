package Modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase que representa un commit de Git
 * @author Hernan
 */
public class Commit {
    
    /**
     * Atributo autor, String que representa el nombre del autor del commit
     * Atributo fecha, String que representa la fecha de creacion del commit
     * Atributo mensaje, String que representa el mensaje descriptivo del commit
     * Atributo TextosPlanos, ArrayList TextoPlano representa los archivos que tiene el commit 
     */
    private String autor;
    private String fecha;
    private String mensaje;
    private ArrayList<TextoPlano> TextosPlanos;
    
    // Metodos
    
    /**
     * Constructor de Commit
     * @param autor String, autor del commits
     * @param fecha String, fecha creacion del commit
     * @param mensaje String, mensaje creacion del commit
     * @param TextosPlanos ArrayList TextoPlano, archivos del commit 
     */
    public Commit(String autor, String fecha, String mensaje, ArrayList<TextoPlano> TextosPlanos) {
        this.autor = autor;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.TextosPlanos = TextosPlanos;
    }
    
    /**
     * hash
     * @return Entero hash 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    /**
     * Comparar objetos de tipo Commit
     * @param obj Objeto con el que comparar
     * @return Boolean Representado la comparacion
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commit other = (Commit) obj;
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.mensaje, other.mensaje)) {
            return false;
        }
        if (!Objects.equals(this.TextosPlanos, other.TextosPlanos)) {
            return false;
        }
        return true;
    }
    
    /**
     * Selector de Autor Commit
     * @return String, autor de commit
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Modificador de Autor de Commit
     * @param autor String, Autor de Commit
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    /**
     * Selector de Fecha de Commit
     * @return String, Fecha de commit
     */
    public String getFecha() {
        return fecha;
    }
    
    /**
     * Modificador de Fecha de Commit
     * @param fecha String, Fecha nueva de commit
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Selector de Mensaje de Commit
     * @return String, Mensaje del commit
     */
    public String getMensaje() {
        return mensaje;
    }
    
    /**
     * Modificador Mensaje de Commit
     * @param mensaje String, Mmensaje nuevo del commit
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    /**
     * Selector de TextosPlanos del Commit
     * @return ArrayList TextoPlano, entrega los archivos del Commit
     */
    public ArrayList<TextoPlano> getTextosPlanos() {
        return TextosPlanos;
    }
    
    /**
     * Modificador de TextosPlanos de Commit
     * @param TextosPlanos ArrayList TextoPlano, nuevos archivos para el commit
     */
    public void setTextosPlanos(ArrayList<TextoPlano> TextosPlanos) {
        this.TextosPlanos = TextosPlanos;
    }
    
    /**
     * Print de Commit
     * @return String de Datos
     */
    @Override
    public String toString() {
        return "\n\nAutor commit = " + autor + " - Mensaje = " + mensaje + " - Archivos = " + TextosPlanos;
    }
   
}
