package todolist;

/**
 * Contient une tache avec son historique
 */
public class Tache {
    private TacheBO tache;
    private HistoriqueTache historiqueTache;

    /**
     * Construteur par defaut
     */
    public Tache() {
        this.creerHistorique();
    }

    public Tache(TacheBO tache) {
        this.creerHistorique();
        this.tache = tache;
    }

    /**
     * Permet d'initialiser l'hitorique
     */
    private void creerHistorique() {
        historiqueTache = new HistoriqueTache();
    }

    public TacheBO getTache() {
        return tache;
    }

    public void setTache(TacheBO tache) {
        this.tache = tache;
    }

    public HistoriqueTache getHistoriqueTache() {
        return historiqueTache;
    }

    public void setHistoriqueTache(HistoriqueTache historiqueTache) {
        this.historiqueTache = historiqueTache;
    }
}
