import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.*;

public class FenetrePrincipale {
    /************************************
     * VARIABLES D'INSTANCES
     ************************************/
    private JFrame fenetreDemarage;
    private JButton boutonCreer;
    private JButton boutonPasser;
    private JButton boutonSupprimer;
    private JComboBox<String> listeDeTests;


    /************************************
     * CONSTANTES DE CLASSE
     ************************************/
    public final static int HAUT_BOUTON = 20;
    public final static int LARGEUR_BOUTON = 200;



    public FenetrePrincipale() {
        initialisationDeFenetre();
    }

    private void initialisationDeFenetre() {

        /************************************
         * INIT FENETRE PRINCIPALE (JFRAME)
         ************************************/

        //creation et initialisation des proprietes de la fenetre principale
        fenetreDemarage = new JFrame("Générateur de tests");
        fenetreDemarage.setBounds(400, 300, 380, 360);
        fenetreDemarage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreDemarage.setResizable(false);
        fenetreDemarage.setLayout(null);  //pas de layout manager

        /*****************************
         * INITIALISATION DES BOUTONS*
         *****************************/
        boutonCreer = new JButton("Créer un nouveau test");
        boutonCreer.setBounds(
                fenetreDemarage.getWidth()/2 - LARGEUR_BOUTON/2
                ,(fenetreDemarage.getHeight()/2)-120
                ,LARGEUR_BOUTON,HAUT_BOUTON );
        fenetreDemarage.getContentPane().add(boutonCreer);


        /***********************************
         * AFFICHAGE D'UNE LISTE DEROULANTE*
         ***********************************/
        listeDeTests = new JComboBox<String>();
        listeDeTests.addItem("blabla");
        listeDeTests.setEnabled(true);

        listeDeTests.setBounds(
                (fenetreDemarage.getWidth() - LARGEUR_BOUTON)/2,
                (fenetreDemarage.getHeight()/2)+20,
                LARGEUR_BOUTON,
                HAUT_BOUTON);

        fenetreDemarage.getContentPane().add(listeDeTests);
        /**************************
         * AFFICHAGE DE LA FENETRE*
         **************************/
        fenetreDemarage.setVisible(true);



    }
    public static void main (String [] args) {

        new FenetrePrincipale();
    }
}
