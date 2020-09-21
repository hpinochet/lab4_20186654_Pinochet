package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa el workspace de Git
 * @author Hernan
 */
public class Workspace {
    
    // Atributos
    
    /**
     * Atributo TextosPlanos, ArrayList TextoPlano que almacena los archivos de workspace
     */
    private ArrayList<TextoPlano> TextosPlanos = new ArrayList<>();
    
    // Metodos
   
    /**
     * Agrega archivos al workspace
     * @param archivo TextoPlano, archivo a almacenar.
     */
    public void agregarArchivos(TextoPlano archivo){
        TextosPlanos.add(archivo);
    }
    
    /**
     * Detecta y obtiene archivos seleccionados por el usuario
     * @param Archivos List String, Nombres de archivos a agregar 
     * @return ArrayList TextoPlano, arreglo con los archivos seleccionados
     */
    public ArrayList<TextoPlano> obtenerArchivos(String[] Archivos){
 
        ArrayList<TextoPlano> TextosPlanosFinal = new ArrayList<>();
        
        for(int i = 0; i < Archivos.length; i++){        
            String nombreArchivo = Archivos[i];
            for(int j = 0; j < TextosPlanos.size(); j++){
                TextoPlano Aux2 = TextosPlanos.get(j);
                String nombreArchivoAux = Aux2.getNombre();
                if(nombreArchivo.equals(nombreArchivoAux)){
                    TextosPlanosFinal.add(Aux2);
                }
            }
        }
        return TextosPlanosFinal;
    }
    
    /**
     * Procesa y agrega los archivos de remote a workspace
     * @param remote Objeto RemoteRepository, contiene commits
     */
    public void agregaArchivosRemote(RemoteRepository remote){
        
        ArrayList<Commit> commitsRemote = remote.getCommits();
        for(int i = 0; i < commitsRemote.size(); i++){
            Commit auxiliarCommit = commitsRemote.get(i);
            ArrayList<TextoPlano> auxliarTextosPlanos = auxiliarCommit.getTextosPlanos();
            for(int j = 0; j < auxliarTextosPlanos.size(); j++){
                TextosPlanos.add(auxliarTextosPlanos.get(j));
            }
        }
    }
    
    /**
     * Elimina los arhivos repetidos  
     */
    public void archivosWorkspaceRepetidos(){
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
     * Obtiene la cantidad de archivos de workspace
     * @return Entero, cantidad de archivos en workspace
     */
    public int numeroArchivosWorkspace(){
        return TextosPlanos.size();
    }
    
    // Getters y Setters
    
    /**
     * Selector de Textos Planos de Workspace
     * @return ArrayList TextoPlano, entrega los archivos de workspace
     */
    public ArrayList<TextoPlano> getTextosPlanos() {
        return TextosPlanos;
    }

    /**
     * Modificador TextosPlanos Workspace
     * @param TextosPlanos ArrayList TextoPlano, ingresa nueva lista de archivos
     */
    public void setTextosPlanos(ArrayList<TextoPlano> TextosPlanos) {
        this.TextosPlanos = TextosPlanos;
    }
    
    /**
     * Print de Workspace
     * @return String con datos
     */
    @Override
    public String toString() {
        return "Archivos: " + TextosPlanos;
    }
    
}
