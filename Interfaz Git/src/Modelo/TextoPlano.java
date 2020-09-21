package Modelo;

import java.util.Objects;

/**
 * Clase que representa los archivos
 * @author Hernan
 */
public class TextoPlano {
    
    // Atributos
    
    /**
     * Atributo nombre, String que representa el nombre del archivo de texto
     * Atributo fecha, String que representa la creacion del archivo de texto
     * Atributo contenido, String que representa el contenido del archivo de texto
     */
    private String nombre;
    private String fecha;
    private String contenido;
    
    // Metodos
    
    /**
     * Constructor de un Texto Plano
     * @param nombre String, Nombre del Texto Plano
     * @param fecha String, Fecha creacion Texto Plano
     * @param contenido String, Contenido del Texto Plano
     */
    public TextoPlano(String nombre, String fecha, String contenido) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.contenido = contenido;
    }

    /**
     * Selector Nombre Texto Plano
     * @return String, nombre del archivo
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Modificador Nombre Texto Plano
     * @param nombre String, Nombre del archivo a insertar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Selector Fecha de creacion texto plano
     * @return String, fecha de creacion
     */
    public String getFecha() {
        return fecha;
    }
    
    /**
     * Modificador Fecha de Creacion Texto Plano
     * @param fecha String, Nueva Fecha de Creacion
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Selector Contenido Texto Plano
     * @return String, Contenido Texto Plano
     */
    public String getContenido() {
        return contenido;
    }
    
    /**
     * Modificador Contenido Texto Plano
     * @param contenido String, Contenido Texto Plano
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    /**
    * hash
    * @return Entero hash 
    */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    /**
     * Comparar objetos de tipo TextoPlano
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
        final TextoPlano other = (TextoPlano) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    /**
     * Print Texto Plano
     * @return String con Datos
     */
    @Override
    public String toString() {
        return "\nNombre archivo = " + nombre + " - Contenido = " + contenido;
    }
    
}
