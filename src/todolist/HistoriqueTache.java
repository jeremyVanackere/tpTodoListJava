package todolist;
import javax.swing.text.AsyncBoxView;
import java.util.ArrayList;

/**
 * class qui contient la list de l'hitorique d'une tache
 */
public class HistoriqueTache implements Affichage {

    // Contient des taches
    private ArrayList<TacheBO> historique;

    /**
     * Contructeur par defaut
     */
    public HistoriqueTache() {
        this.setHistorique(new ArrayList<TacheBO>());
    }

    /**
     * permet d'ajouter une tache a notre liste historique des taches
     * @param tache la tache
     */
    public void ajouterTache(TacheBO tache) {
        this.historique.add(tache);
    }

    @Override
    public void afficher() {
        if(0 == historique.size()) System.out.println("Aucun historique");
        for(TacheBO tache : historique) {
            System.out.println("historique : ");
            System.out.print("    - ");
            tache.afficher();
        }
    }

    public ArrayList<TacheBO> getHistorique() {
        return historique;
    }

    public void setHistorique(ArrayList<TacheBO> historique) {
        this.historique = historique;
    }
}
