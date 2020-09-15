package Modelo;

import java.util.ArrayList;

/**
 * Clase que representa el Index de Git.
 * @author Hernan
 */
public class Index {
    
    // Atributos
    
    /**
     * Atributo TextosPlanos, ArrayList TextoPlano que almacena los archivos de index
     */
    private ArrayList<TextoPlano> TextosPlanos = new ArrayList<>();
    
    // Metodos
    
    /**
     * Agrega todos los archivos de workspace
     * @param workspace Onbjeto Workspace, contiene los archivos de workspace
     */
    public void agregarArchivosWorkspace(Workspace workspace){
        ArrayList<TextoPlano> workspaceTextos = workspace.getTextosPlanos();
        for(int i = 0; i < workspaceTextos.size(); i++){
            TextosPlanos.add(workspaceTextos.get(i));
        }
    }
    
    /**
     * Agrega solo los archivos seleccionados de workspace
     * @param workspace Objeto Workspace, contiene los archivos workspace
     * @param Cantidad Entero, cantidad de archivos a selecionar
     */
    public void agregarArchivosWorkspace(Workspace workspace, int Cantidad){ 
        ArrayList<TextoPlano> workspaceTextos = workspace.obtenerArchivos(Cantidad);
        for(int i = 0; i < workspaceTextos.size(); i++){
            TextosPlanos.add(workspaceTextos.get(i));
        }
    }
    
    /**
     * Elimina los archivos repetidos de index
     */
    public void archivosIndexRepetidos(){
        ArrayList<TextoPlano> TextosPlanosFinal = new ArrayList<>();
        TextoPlano Aux;
        TextoPlano Aux2;
        boolean Repetido = false;

        for(int i = 0; i < TextosPlanos.size(); i++){
            Aux = TextosPlanos.get(i);
            for(int j = i + 1; j < TextosPlanos.size(); j++){
                Aux2 = TextosPlanos.get(j);
                if(Aux.equals(Aux2)){
                    Repetido = true;
                }                
            }
            if(Repetido == false){
                TextosPlanosFinal.add(TextosPlanos.get(i));
            }
            Repetido = false;
        }
        this.TextosPlanos = TextosPlanosFinal;        
    }
    
    /**
     * Indica la cantidad de archivos en index
     * @return Entero, cantidad de archivos de index
     */
    public int numeroArchivosIndex(){
        return TextosPlanos.size();
    }
    
    /**
     * Selector de Textos Planos de Index
     * @return ArrayList TextoPlano, obtiene los archivos de index
     */
    public ArrayList<TextoPlano> getTextosPlanos() {
        return TextosPlanos;
    }
    
    /**
     * Modificador de Textos Planos de Index
     * @param TextosPlanos ArrayList TextoPlano, nuevos archivos index
     */
    public void setTextosPlanos(ArrayList<TextoPlano> TextosPlanos) {
        this.TextosPlanos = TextosPlanos;
    }
    
    /**
     * Print de Index
     * @return String con datos
     */
    @Override
    public String toString() {
        return "TextosPlanos = " + TextosPlanos;
    }
    
}
