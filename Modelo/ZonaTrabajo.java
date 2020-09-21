package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Clase que representa el repositorio de Git.
 * @author Hernan
 */
public class ZonaTrabajo {
    
    // Atributos
    
    /**
     * Atributo nombreRepositorio, String que representa nombre del repositorio
     * Atributo nombreAutor, String que representa nombre del autor
     * Atributo workspace, Objeto Workspace que representa workspace
     * Atributo index, Objeto Index que representa index
     * Atributo local, Objeto LocalRepository que representa local repository
     * Atributo remote, Objeto RemoteRepository que representa remote repository
     */
    private String nombreRepositorio;
    private String nombreAutor;
    private Workspace workspace;
    private Index index;
    private LocalRepository local;
    private RemoteRepository remote;
    
    // Metodos
    
    /**
     * Este metodo es el constructor de ZonaTrabajo (gitInit)
     * @param nombreRepositorio String, Nombre del Repositorio.
     * @param nombreAutor String, Nombre del Autor del Repositorio.
     */
    public ZonaTrabajo(String nombreRepositorio, String nombreAutor) {
        this.nombreRepositorio = nombreRepositorio;
        this.nombreAutor = nombreAutor;
        this.workspace = new Workspace();
        this.index = new Index();
        this.local = new LocalRepository();
        this.remote = new RemoteRepository();
    }
    
    /**
     * Metodo para crear e ingresar archivos a workspace
     * @param nombre String, Nombre Archivo.
     * @param contenido String, Contenido Archivo.
     */
    public void gitCrear(String nombre, String contenido){
                
        LocalDateTime objFecha = LocalDateTime.now();   
        DateTimeFormatter objFormateado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        String formattedDate = objFecha.format(objFormateado);
                
        // Se crea y agrega el texto plano nuevo
        
        TextoPlano archivo = new TextoPlano(nombre,formattedDate,contenido);
        
        workspace.agregarArchivos(archivo);
        
        // Se filtran archivos repetidos
        
        workspace.archivosWorkspaceRepetidos();
             
    }
    
    /**
     * Metodo para simular funcion Add de Git
     * @param opcion Entero, indica opcion de add
     * @param Archivos ArrayList String, indica los archivos a agregar
     * @return Entero, este es para finalizar metodo.
     */
    public int gitAdd(int opcion, String Archivos){
                      
        // Opcion de Ingresar todos los Archivos
        if(opcion == 1){

            // Se agregan los archivos
            
            index.agregarArchivosWorkspace(workspace);
            
            // Se eliminan archivos repetidos

            index.archivosIndexRepetidos();
         
        }

        // Opcion de Ingresar ciertos archivos
        if(opcion == 2){
            
            // Se procesa String
            
            String[] ArchivosB = Archivos.split(" ");
            
            // Se agegan los archivos
            
            index.agregarArchivosWorkspace(workspace,ArchivosB);
            
            // Se eliminan los archivos repetidos 

            index.archivosIndexRepetidos();
   
        }
        
        return 0;
    
    }
    
    /**
     * Metodo que simula la funcion Commit de Git
     * @param nAutor String, Nombre autor commit
     * @param mensajeCommit String, Mensaje commit
     * @return Entero, este es para finalizar metodo. 
     */
    public int gitCommit(String nAutor, String mensajeCommit){
                
        // Se obtienen fecha para el Commit
        
        LocalDateTime objFecha = LocalDateTime.now();   
        DateTimeFormatter objFormateado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        String formattedDate = objFecha.format(objFormateado);
         
        // Se crea e inserta nuevo commit
        
        ArrayList<TextoPlano> textosIndex = index.getTextosPlanos();
        Commit commit = new Commit(nAutor,formattedDate,mensajeCommit,textosIndex);
        
        local.agregarCommit(commit);
        
        // Se limpia index
        
        Index indexnew = new Index();
        index = indexnew;
        
        return 0;
    }
    
    /**
     * Metodo que simula la funcion Push de Git
     * @return Entero, este es para finalizar metodo.
     */
    public int gitPush(){
                        
        // Se agregan los commits
        
        remote.agregarCommits(local);
        
        // Se filtran los commits
        
        remote.commitsRemoteRepetidos();
                
        return 0;            
    }
    
    /**
     * Metodo que simula la funcion Pull de Git
     * @return Entero, este es para finalizar metodo.
     */
    public int gitPull(){
   
        // Se extraen los Textos planos de los commits y se ingresan a Workspace
        
        workspace.agregaArchivosRemote(remote);
            
        // Se eliminan archivos repetidos 

        workspace.archivosWorkspaceRepetidos();
        
        return 0;
             
    }
      
    /**
     * Se muestra por pantalla los ultimos 5 commits
     * @return String, Retorna informacion ultimos commits
     */
    public String gitLog(){
        
        // Muestra por pantalla ultimos commits
        return local.obtenerUltimosCommits();
  
    }
    
    // Verificadores Casos borde
    
    /**
     * Verfica si tiene archivos Workspace 
     * @return Boolean, Indica caso borde
     */
    public boolean verificarWorkspace(){
        
        // Caso borde    
        if(workspace.numeroArchivosWorkspace() == 0){
            return false;
        }
        return true;
    }
    
    /**
     * Verfica si tiene archivos Index
     * @return Boolean, Indica caso borde
     */
    public boolean verificarIndex(){
        
        // Condicion de Borde        
        if(index.numeroArchivosIndex() == 0){
            return false;
        }
        return true;
    }
    
    /**
     * Verfica si tiene commits Local Repository
     * @return Boolean, Indica caso borde
     */
    public boolean verificarLocal(){
        
        // Condicion de Borde
        if(local.numeroCommitsLocal() == 0){
            return false;
        }    
        return true; 
    }
    
    /**
     * Verfica si tiene commits Remote Repository
     * @return Boolean, Indica caso borde
     */
    public boolean verificarRemote(){
        
        // Condicion de Borde
        if(remote.numeroCommitsRemote() == 0){
            return false;
        }
        return true;
    }
    
    
    /**
     * Selector del nombre del repositorio
     * @return String, nombre del repositorio
     */
    public String getNombreRepositorio() {
        return nombreRepositorio;
    }
    
    /**
     * Modificador del nombre del repositorio
     * @param nombreRepositorio String, nombre del repositorio
     */
    public void setNombreRepositorio(String nombreRepositorio) {
        this.nombreRepositorio = nombreRepositorio;
    }
    
    /**
     * Selector del nombre del autor
     * @return String, nombre del autor del repositorio
     */
    public String getNombreAutor() {
        return nombreAutor;
    }
    
    /**
     * Modificador del nombre del autor
     * @param nombreAutor String, nombre del autor
     */
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    
    /**
     * Selector del workspace
     * @return Objeto Workspace, entrega el workspace
     */
    public Workspace getWorkspace() {
        return workspace;
    }
    
    /**
     * Modificador de workspace
     * @param workspace Objeto Workspace, nuevo workspace
     */
    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    /**
     * Selector de index
     * @return Objeto Index, entrega el index
     */
    public Index getIndex() {
        return index;
    }

    /**
     * Modificador de index
     * @param index Objeto Index, nuevo index
     */
    public void setIndex(Index index) {
        this.index = index;
    }
    
    /**
     * Selector de local repository
     * @return Objeto LocalRepository, entrega el local repository
     */
    public LocalRepository getLocal() {
        return local;
    }
    
    /**
     * Modificador de Local Repository
     * @param local Objeto LocalRepository, nuevo local repository
     */
    public void setLocal(LocalRepository local) {
        this.local = local;
    }
    
    /**
     * Selector de Remote Repository
     * @return Objeto RemoteRepository, entrega el remote repository
     */
    public RemoteRepository getRemote() {
        return remote;
    }

    /**
     * Modificador de Remote Repository
     * @param remote Objeto RemoteRepository, nuevo remote repository
     */
    public void setRemote(RemoteRepository remote) {
        this.remote = remote;
    }
    
    // ToStrings
    
    /**
     * Print de ZonaTrabajo
     * @return String con datos
     */
    @Override
    public String toString() {
        return "ZonaTrabajo" + "\n\nNombre Repositorio = " + nombreRepositorio + "\nNombre Autor = " + nombreAutor + "\n\nWorkspace = " + workspace + "\n\nIndex = " + index + "\n\nLocal Repository = " + local + "\n\nRemote Repository = " + remote;
    }
    
    /**
     * Print de Workspace
     * @return String con datos
     */
    public String toStringWorkspace(){
        return workspace.toString();
    }
    
    /**
     * Print de Index
     * @return String con datos
     */
    public String toStringIndex(){
        return index.toString();
    }
    
    /**
     * Print de Local Repository
     * @return String con datos
     */
    public String toStringLocal(){
        return local.toString();
    }
    
    /**
     * Print de Remote Repository
     * @return String con datos
     */
    public String toStringRemote(){
        return remote.toString();
    }
    
}
