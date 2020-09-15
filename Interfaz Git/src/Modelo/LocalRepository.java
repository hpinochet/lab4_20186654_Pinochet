package Modelo;

import java.util.ArrayList;

/**
 * Clase que representa el Local Repository de Git
 * @author Hernan
 */
public class LocalRepository {
    
    // Atributos
    
    /**
     * Atributo Commits, ArrayList Commit que almacena los commits de local repository
     */
    private ArrayList<Commit> Commits = new ArrayList<>();
    
    // Metodos
    
    /**
     * Agrega commits al local repository
     * @param commit Commit, commit a agregar
     */
    public void agregarCommit(Commit commit){
        Commits.add(commit);
    }
    
    /**
     * Indica la cantidad de commits de local repository
     * @return Entero, cantidad de commits de local repository
     */
    public int numeroCommitsLocal(){
        return Commits.size();
    }
    
    /**
     * Entrega por pantalla los ultimos 5 commits, funcion log
     */
    public void obtenerUltimosCommits(){
        
        ArrayList<Commit> ultimosCommits = new ArrayList<>();
        
        if(Commits.size() <= 5){
            for(int i = Commits.size() - 1; i >= 0; i-- ){
                ultimosCommits.add(Commits.get(i));
            }
        }else{
            for(int i = Commits.size() - 1; i >= Commits.size() - 5; i-- ){
                ultimosCommits.add(Commits.get(i));
            }           
        }
        
        System.out.println("Ultimos commits = " + ultimosCommits); 
    }
    
    /**
     * Selector de Commits de Local Repository
     * @return ArrayList Commit, Entrega los commits de local repository
     */
    public ArrayList<Commit> getCommits() {
        return Commits;
    }
    
    /**
     * Modificador de Commits de Local Repository
     * @param Commits ArrayList Commit, commits nuevos a cambiar
     */
    public void setCommits(ArrayList<Commit> Commits) {
        this.Commits = Commits;
    }
    
    /**
     * Print de Local Repository
     * @return String con datos
     */
    @Override
    public String toString() {
        return "Commits = " + Commits;
    }
    
}
