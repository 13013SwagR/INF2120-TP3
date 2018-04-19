import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GenerateurTests {
    /************************************
     * VARIABLES D'INSTANCES
     ************************************/
    private JFrame fenetreDemarage;
    private JButton buttonCreer;
    private JButton buttonPasser;
    private JButton buttonSupprimer;
    private JComboBox<String> listeDeTests;
    private JPanel blackLine;


    /************************************
     * CONSTANTES DE CLASSE
     ************************************/
    public final static int HAUT_BOUTON = 30;
    public final static int LARGEUR_BOUTON = 250;



    public GenerateurTests() {
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
        buttonCreer = createJButton("Créer un nouveau test", 150);
        fenetreDemarage.getContentPane().add(buttonCreer);

        buttonPasser = createJButton("Passer le test sélectionné", -30);
        fenetreDemarage.getContentPane().add(buttonPasser);

        buttonSupprimer = createJButton("Supprimer le test sélectionné", -80);
        fenetreDemarage.getContentPane().add(buttonSupprimer);

        /************************
         * AFFICHAGE D'UN JPanel*
         ************************/
        blackLine = new JPanel();
        blackLine.setSize(fenetreDemarage.getWidth()-40,1);
        blackLine.setLocation((fenetreDemarage.getWidth()-blackLine.getWidth())/2, (fenetreDemarage.getHeight()/2)-85);
        blackLine.setBackground(Color.black);

        fenetreDemarage.getContentPane().add(blackLine);


        /***********************************
         * AFFICHAGE D'UNE LISTE DEROULANTE*
         ***********************************/
        listeDeTests = new JComboBox<String>();
        listeDeTests.addItem("blabla");
        listeDeTests.setEnabled(true);

        listeDeTests.setBounds(
                (fenetreDemarage.getWidth() - LARGEUR_BOUTON)/2,
                (fenetreDemarage.getHeight()/2)-40,
                LARGEUR_BOUTON,
                HAUT_BOUTON-10);

        fenetreDemarage.getContentPane().add(listeDeTests);
        /**************************
         * AFFICHAGE DE LA FENETRE*
         **************************/
        fenetreDemarage.setVisible(true);



    }
    public JButton createJButton(String buttonName, int height){
        JButton newJButton = new JButton(buttonName);
        newJButton.setBounds(
                fenetreDemarage.getWidth()/2 - LARGEUR_BOUTON/2
                ,(fenetreDemarage.getHeight()/2)-height
                ,LARGEUR_BOUTON,HAUT_BOUTON );
        return newJButton;
    }
    public static void main (String [] args) {

        new GenerateurTests();
    }
}
