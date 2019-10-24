package graphique;

import graphique.listener.btnAjouterListener;
import graphique.listener.btnModifierListner;
import todolist.*;

import javax.swing.*;
import java.awt.*;

public class Fenetre  extends JFrame {

    private ToDoList toDoList;

    private JPanel content;
    private JPanel contentAjouter;
    private JPanel contentToDoList;
    private JButton btnAjouter;
    private TextField txtNomAjouter;
    private  TextField txtDescriptionAjouter;
    private int indexModifiere = 0;
    

    public Fenetre() {
        this.setToDoList(new ToDoList());
        this.setTitle("Ma première fenêtre Java");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(buildContent());
        this.setVisible(true);
        this.afficherToDoList();

    }

    private JPanel buildContent() {
        this.content = new JPanel(new GridLayout(2, 1));
        this.contentAjouter = new JPanel(new GridLayout(1,3));

        this.setBtnAjouter(new JButton("ajouter"));
        this.getBtnAjouter().addActionListener(new btnAjouterListener(Fenetre.this));
        this.setTxtNomAjouter(new TextField("nom"));
        this.setTxtDescriptionAjouter(new TextField("description"));
        this.contentAjouter.add(this.getTxtNomAjouter());
        this.contentAjouter.add(this.getTxtDescriptionAjouter());
        this.contentAjouter.add(this.getBtnAjouter());
        this.content.add(this.contentAjouter);
        return this.content;
    }

    public void afficherToDoList() {
        if(null != this.contentToDoList) {
            this.contentToDoList.removeAll();
            this.content.remove(1);
        }
        this.contentToDoList = new JPanel(new GridLayout(getToDoList().getTaches().size(), 6));
        for(int i = 0; i < getToDoList().getTaches().size(); i++) {
            TacheBO tache = this.getToDoList().getTaches().get(i).getTache();
            this.contentToDoList.add(new JLabel("" + i));
            this.contentToDoList.add(new JLabel(tache.getNom()));
            this.contentToDoList.add(new JLabel(tache.getDescription()));
            this.contentToDoList.add(new JLabel(tache.getEtat()));
            JButton btnModifier = new JButton("modifier");
            btnModifier.addActionListener(new btnModifierListner(Fenetre.this, i));
            this.contentToDoList.add(new JButton("modifier"));
            this.contentToDoList.add(new JButton("supprimer"));
        }

        this.content.add(this.contentToDoList);
        this.content.repaint();
        this.content.updateUI();
        this.contentToDoList.updateUI();
        this.contentToDoList.repaint();
    }

    public TextField getTxtNomAjouter() {
        return txtNomAjouter;
    }

    public void setTxtNomAjouter(TextField txtNomAjouter) {
        this.txtNomAjouter = txtNomAjouter;
    }

    public TextField getTxtDescriptionAjouter() {
        return txtDescriptionAjouter;
    }

    public void setTxtDescriptionAjouter(TextField txtDescriptionAjouter) {
        this.txtDescriptionAjouter = txtDescriptionAjouter;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public JButton getBtnAjouter() {
        return btnAjouter;
    }

    public void setBtnAjouter(JButton btnAjouter) {
        this.btnAjouter = btnAjouter;
    }

    public int getIndexModifiere() {
        return indexModifiere;
    }

    public void setIndexModifiere(int indexModifiere) {
        this.indexModifiere = indexModifiere;
    }
}
