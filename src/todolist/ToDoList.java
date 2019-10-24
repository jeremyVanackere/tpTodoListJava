package todolist;
import java.util.ArrayList;

/**
 * Class qui contient la to do list
 */
public class ToDoList implements Affichage{

    // List qui contient les tache
    private ArrayList<Tache> taches;

    /**
     * Constructeur par defaut
     */
    public ToDoList() {
        setTaches(new ArrayList<Tache>());
    }

    /**
     * Permet d'ajouter une tache a la liste
     * @param tache la tache à ajouter
     */
    public void ajouterTache(Tache tache) {
        this.getTaches().add(tache);
    }

    /**
     * Permet de modifier une tache de la liste
     * @param index index dans la liste
     * @param tache la nouvelle tacheBO
     */
    public void modifierTacheParIndex(int index, TacheBO tache) {
        Tache laTache = this.getTaches().get(index); // Récupére la tache
        laTache.getHistoriqueTache().ajouterTache(laTache.getTache()); // Mes ca tache dans son historique
        laTache.setTache(tache); // Actualise la nouvelle tache
    }

    /**
     * Permet de supprimer une tache de la liste
     * @param index l'index dans la liste
     */
    public void supprimerTacheParIndex(int index) {
        this.taches.remove(index);
    }

    /**
     * Permet de récupérer l'historique d'une tache dans la liste
     * @param index son index dans la liste
     * @return retourne un object de type HistoriqueTache
     */
    public HistoriqueTache getHistoriqueTacheParIndex(int index) {
        return taches.get(index).getHistoriqueTache();
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }

    public void setTaches(ArrayList<Tache> taches) {
        this.taches = taches;
    }

    @Override
    public void afficher() {
        for(int i = 0; i < taches.size(); i++) {
            System.out.print("Tache n°" + i +" | ");
            taches.get(i).getTache().afficher();
        }
        System.out.println("");
    }
}
