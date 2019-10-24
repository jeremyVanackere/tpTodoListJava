package todolist;
/**
 * Class qui contient une tache
 * Objet de type buiness Object (BO)
 */
public class TacheBO implements Affichage {
    private String nom;
    private String etat;
    private String description;

    /**
     * Construteur par defaut
     */
    public TacheBO() {

    }

    /**
     * Contructeur avec parametre
     * @param nom le nom
     * @param etat l'état
     * @param description description
     */
    public TacheBO(String nom, String description, String etat) {
        this.nom = nom; this.etat = etat; this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void afficher() {
        System.out.println("nom : "+this.getNom()+" | description : "+this.getDescription()+ " | etat : "+this.getEtat());
    }
}
