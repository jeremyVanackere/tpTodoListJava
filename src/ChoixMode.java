import graphique.MyMainThread;

import javax.swing.*;
import java.util.Scanner;

/**
 * Permet de choisir le mode graphique ou console
 */
public class ChoixMode {

    private ActionConsole actionConsole;

    public ChoixMode() {
        this.actionConsole = new ActionConsole();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous l'interface graphique ou console ? oui / non");
        String str = sc.nextLine();
        if(str.equals("oui")) {
            SwingUtilities.invokeLater(new MyMainThread());
        } else {
            this.actionConsole.start();
        }
    }
}
