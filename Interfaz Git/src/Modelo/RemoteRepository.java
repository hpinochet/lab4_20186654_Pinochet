package Modelo;

import java.util.ArrayList;

/**
 * Clase que representa el remote repository de Git
 * @author Hernan
 */
public class RemoteRepository {
    
    // Atributos
    
    /**
     * Atributo Commits, ArrayList Commit que almacena los commits de remote repository
     */
    private ArrayList<Commit> Commits = new ArrayList<>();
    
    // Metodos
    
    /**
     * Se agregan los commits de local repository a remote repository
     * @param local Objeto LocalRepository, contiene commits
     */
    public void agregarCommits(LocalRepository local){
        ArrayList<Commit> commitsLocal = local.getCommits();
        for(int i = 0; i < commitsLocal.size(); i++){
            Commits.add(commitsLocal.get(i));
        }
    }
    
    /**
     * Indica la cantidad de commits en remote repository
     * @return Entero, cantidad de commits en remote repository
     */
    public int numeroCommitsRemote(){
        return Commits.size();
    }
        
    /**
     * Elimina los commits repetidos
     */
    public void commitsRemoteRepetidos(){
        ArrayList<Commit> CommitsFinal = new ArrayList<>();
        Commit Aux;
        Commit Aux2;
        boolean Repetido = false;

        for(int i = 0; i < Commits.size(); i++){
            Aux = Commits.get(i);
            for(int j = i + 1; j < Commits.size(); j++){
                Aux2 = Commits.get(j);
                if(Aux.equals(Aux2)){
                    Repetido = true;
                }                
            }
            if(Repetido == false){
                CommitsFinal.add(Commits.get(i));
            }
            Repetido = false;
        }
        this.Commits = CommitsFinal;        
    }
            
    /**
     * Selector de Commits de Remote Repository
     * @return ArrayList Commit, obtiene los commits de remote repository
     */
    public ArrayList<Commit> getCommits() {
        return Commits;
    }
    
    /**
     * Modificador de commits de Remote Repository
     * @param Commits ArrayList Commit, ingresa nuevos commits
     */
    public void setCommits(ArrayList<Commit> Commits) {
        this.Commits = Commits;
    }
    
    /**
     * Print de Remote Repository
     * @return String con datos
     */
    @Override
    public String toString() {
        return "Commits = " + Commits;
    }
}
