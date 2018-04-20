//import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    private ActionListener creerListener;

    TestCreator testCreation;

    private ArrayList<TestCreator> createdTests = new ArrayList<>();


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

        double screenWidth = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().getWidth();
        double screenHeight = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight();
        int x = (int) ((screenWidth / 2) - (HAUT_BOUTON / 2));
        int y = (int) ((screenHeight / 2) - (LARGEUR_BOUTON / 2));

        fenetreDemarage = new JFrame("Générateur de tests");
        fenetreDemarage.setBounds(x, y, 380, 360);
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
        for(int i = 0; i<createdTests.size(); i++){
            //listeDeTests.add();
            //createdTests.get(i).testNameAnswer;
            // TODO create testNameAnswer in TestCreator

        }
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

        /*******************
         * ACTIONS HANDLING*
         *******************/
        //Boutton creer

        creerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testCreation = new TestCreator();
                createdTests.add(testCreation);
            }
        };
        buttonCreer.addActionListener(creerListener);



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
