package graphique.listener;

import graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class btnModifierListner implements Action {

    private Fenetre fenetre;
    private int index;

    public btnModifierListner(Fenetre fenetre, int index) {
        this.fenetre = fenetre;
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.getTxtNomAjouter().setText(fenetre.getToDoList().getTaches().get(index).getTache().getNom());
        fenetre.getTxtDescriptionAjouter().setText(fenetre.getToDoList().getTaches().get(index).getTache().getDescription());
        fenetre.setIndexModifiere(this.index);
        fenetre.getBtnAjouter().setText("modifier");
        fenetre.getBtnAjouter().updateUI();
        fenetre.afficherToDoList();
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
