import todolist.*;

import javax.swing.*;
import javax.xml.soap.DetailEntry;
import java.io.IOException;
import java.util.Scanner;


/**
 * Contient les action a faire sur la console
 */
public class ActionConsole {

    private ToDoList toDoList;
    private Scanner sc;

    public ActionConsole() {
        this.toDoList = new ToDoList(); // On crée une to do list
        this.sc = new Scanner(System.in);
    }

    /**
     * Permet de tester non manuellement
     */
    public void test() {
        TacheBO tache1 = new TacheBO("premierTache", "finir le tp", ""+ Etat.EN_COUR);
        TacheBO tache2 = new TacheBO("premierTache", "finir le tp", ""+Etat.TERMINER);
       this.toDoList.ajouterTache(new Tache(tache1));
       this.toDoList.afficher();

       this.toDoList.modifierTacheParIndex(0, tache2);
       this.toDoList.getHistoriqueTacheParIndex(0).afficher();
       this.toDoList.afficher();
    }

    public void start() {
        System.out.println("Que voulez vous faire ? afficher | ajouter | modifier | supprimer | historique ");
        clearConsole();
        String str = sc.nextLine();
        choixAction(str);
    }

    public void choixAction(String value) {
        try {
            if (value.equals("afficher")) {
                this.afficher();
            } else if (value.equals("modifier")) {
                this.modifier();
            } else if (value.equals("supprimer")) {
                this.supprimer();
            } else if (value.equals("historique")) {
                this.historique();
            } else if (value.equals("ajouter")) {
                this.ajouter();
            } else {
                System.out.println("mauvaise saisie recommener !");
                this.start();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ce n'est pas un nombre !");
            this.start();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("cette valeur d'index n'existe pas !");
            this.start();
        }
    }

    public void ajouter() throws NumberFormatException, ArrayIndexOutOfBoundsException {
        System.out.println("ajouter (comence toujours par etat en cour): ");
        System.out.println("nom : ");
        String nom = sc.nextLine();
        System.out.println("description :");
        String description = sc.nextLine();
        toDoList.ajouterTache(new Tache(new TacheBO(nom, description, ""+Etat.EN_COUR)));
        this.start();
    }

    public void modifier() {
        System.out.println("Modifier : index numéro ?");
        String str = sc.nextLine();
        int n = Integer.parseInt(str);
        System.out.println("nom : ");
        String nom = sc.nextLine();
        System.out.println("description :");
        String description = sc.nextLine();
        System.out.println("etat ? EN_COUR : 0 || TERMINER : 1");
        str = sc.nextLine();
        String etat = ""+toDoList.getTaches().get(n).getTache().getEtat();
        if(str.equals("0")) etat = ""+Etat.EN_COUR;
        else if(str.equals("1")) etat = ""+Etat.TERMINER;
        toDoList.modifierTacheParIndex(n,new TacheBO(nom, description, etat));
        this.start();
    }

    public void afficher() {
        toDoList.afficher();
        this.start();
    }

    public void supprimer() {
        System.out.println("supprimer : index numéro ?");
        String str = sc.nextLine();
        int n = Integer.parseInt(str);
        toDoList.supprimerTacheParIndex(n);
        this.start();
    }

    public void historique() {
        System.out.println("historique : index numéro ?");
        String str = sc.nextLine();
        int n = Integer.parseInt(str);
        toDoList.getHistoriqueTacheParIndex(n).afficher();
        this.start();
    }

    public void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

