package Modelo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que representa la interfaz de usuario y realiza los llamados de la funcion git
 * @author Hernan
 */
public class Main2{

    public static void main(String[] args) {
        
        // Inicio del programa
        
        System.out.println("\n### BIENVENIDO A SIMULACION GIT ###");
        System.out.println("### Cree su nuevo repositorio ###");
        
        Scanner objRepo = new Scanner(System.in);
        System.out.println("Ingrese nombre de repositorio: ");
        String nombreRepo = objRepo.nextLine();
        
        Scanner objAutor = new Scanner(System.in);
        System.out.println("Ingrese nombre autor de repositorio: ");
        String nombreAutor = objAutor.nextLine();
        
        // Instanciar la clase con los parametors reflejaria nuestra funcion gitInit
        
        ZonaTrabajo Zona = new ZonaTrabajo(nombreRepo,nombreAutor);
        
        System.out.println(" ");
        System.out.println(Zona);
        System.out.println(" ");
        
        int opcion = 0;
        
        // Menu
        
        while(opcion != 8){
            System.out.println("### SIMULACION GIT ###");
            System.out.println("Escoja su opcion");
            System.out.println("1. Crear nuevo archivo");
            System.out.println("2. add");
            System.out.println("3. commit");
            System.out.println("4. pull");
            System.out.println("5. push");
            System.out.println("6. status");
            System.out.println("7. log");
            System.out.println("8. salir");
            Scanner objOpcion = new Scanner(System.in);
            System.out.println("INTRODUZCA SU OPCION: ");
            
            // Esto es en caso de que haya error al ingresar una opcion,
            //el try pasara la opcion sin modificacion por lo cual entraria a una opcion anterior
            opcion = 9;
            
            try{
                opcion = objOpcion.nextInt();
                
                if(opcion < 1 || opcion > 9){
                    System.out.println(" \n! Error, introduzca una opcion valida.\n");
                }
            }catch(InputMismatchException e){
               System.out.println("\n! Error, introduzca una opcion valida.\n");
               objOpcion.next();
            }
            
            System.out.println(" ");
            
            // Opciones Git
            
            if(opcion == 1){
                Zona.gitCrear();
            }
            
            if(opcion == 2){
                Zona.gitAdd();
            }
            
            
            if(opcion == 3){
                Zona.gitCommit();
            }
            
            
            if(opcion == 4){
                Zona.gitPull();
            }
            
            if(opcion == 5){
                Zona.gitPush();
            }
            
            if(opcion == 6){
                Zona.gitStatus();
                System.out.println(" ");
            }
            
            if(opcion == 7){
                Zona.gitLog();
                System.out.println(" ");
            }
            
            System.out.println(Zona);
            System.out.println(" ");
        }        
    }
}
