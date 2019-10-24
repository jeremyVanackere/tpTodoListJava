package graphique.listener;

import graphique.Fenetre;
import todolist.Etat;
import todolist.Tache;
import todolist.TacheBO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class btnAjouterListener implements Action {

    private Fenetre fenetre;

    public btnAjouterListener(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom = fenetre.getTxtNomAjouter().getText();
        String description = fenetre.getTxtDescriptionAjouter().getText();
        if(fenetre.getBtnAjouter().getText().equals("ajouter")) {
            this.fenetre.getToDoList().ajouterTache(new Tache(new TacheBO(nom, description, "" + Etat.EN_COUR)));
        } else if(fenetre.getBtnAjouter().getText().equals("modifier")) {
            this.fenetre.getToDoList().modifierTacheParIndex(fenetre.getIndexModifiere(),new TacheBO(nom, description, "" + Etat.EN_COUR));
            this.fenetre.getBtnAjouter().setText("ajouter");
        }
        this.fenetre.afficherToDoList();
    }
    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void putValue(String key, Object value) {

    }

    @Override
    public void setEnabled(boolean b) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }


}
