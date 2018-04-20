//import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GenerateurTests {
    /************************************
     * VARIABLES D'INSTANCES
     ************************************/
    private static JFrame startUpWindow;
    private static ActionListener creerListener;
    
    static TestCreator testCreation;
    
    private static ArrayList<TestCreator> createdTests = new ArrayList<>();
    
    
    /************************************
     * CONSTANTES DE CLASSE
     ************************************/
    public final static int HAUT_BOUTON = 30;
    public final static int LARGEUR_BOUTON = 250;
    
    
    public static void initStartUpWindow() {
        
        JButton createNewTestButton;
        JButton buttonPasser;
        JButton buttonSupprimer;
        JComboBox<String> testsList;
        
        // INIT FENETRE PRINCIPALE (JFRAME)
        startUpWindow = new JFrame("Générateur de tests");
        startUpWindow.setBounds(getWindowPositionX(), getWindowPositionY(), 380, 360);
        startUpWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUpWindow.setResizable(false);
        startUpWindow.setLayout(null);  //pas de layout manager
        
        // INITIALISATION DES BOUTONS
        createNewTestButton = createStandardJButton("Créer un nouveau test", 150);
        startUpWindow.getContentPane().add(createNewTestButton);
        
        buttonPasser = createStandardJButton("Passer le test sélectionné", -30);
        startUpWindow.getContentPane().add(buttonPasser);
        
        buttonSupprimer = createStandardJButton("Supprimer le test sélectionné", -80);
        startUpWindow.getContentPane().add(buttonSupprimer);
        
        //creation et initialisation des proprietes de la fenetre principale
        
        startUpWindow.getContentPane().add(createStartUpWindowBlackLine());
        
        testsList = initTestsListComboBox();
        startUpWindow.getContentPane().add(testsList);
        
        startUpWindow.setVisible(true);
        
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
        createNewTestButton.addActionListener(creerListener);
        
        
    }
    
    private static JComboBox<String> initTestsListComboBox() {
        JComboBox<String> testsList;
        testsList = getTestList();
        testsList.addItem("blabla");
        testsList.setEnabled(true);
        testsList.setBounds(
                (startUpWindow.getWidth() - LARGEUR_BOUTON) / 2,
                (startUpWindow.getHeight() / 2) - 40,
                LARGEUR_BOUTON,
                HAUT_BOUTON - 10);
        return testsList;
    }
    
    private static JComboBox<String> getTestList() {
        JComboBox<String> listeDeTests;
        listeDeTests = new JComboBox<String>();
        for (int i = 0; i < createdTests.size(); i++) {
            //listeDeTests.add();
            //createdTests.get(i).testNameAnswer;
            // TODO create testNameAnswer in TestCreator
        }
        return listeDeTests;
    }
    
    private static JPanel createStartUpWindowBlackLine() {
        JPanel blackLine;
        blackLine = new JPanel();
        blackLine.setSize(startUpWindow.getWidth() - 40, 1);
        blackLine.setLocation((startUpWindow.getWidth() - blackLine.getWidth())
                / 2, (
                startUpWindow.getHeight() / 2) - 85);
        blackLine.setBackground(Color.black);
        return blackLine;
    }
    
    private static int getWindowPositionX() {
        double screenWidth = getScreenWidth();
        return (int) ((screenWidth / 2) - (HAUT_BOUTON / 2));
    }
    
    private static int getWindowPositionY() {
        double screenHeight = getScreenHeight();
        return (int) ((screenHeight / 2) - (LARGEUR_BOUTON / 2));
    }
    
    
    private static double getScreenHeight() {
        return Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight();
    }
    
    private static double getScreenWidth() {
        return Toolkit.getDefaultToolkit()
                .getScreenSize().getWidth();
    }
    
    public static JButton createStandardJButton(String buttonName, int height) {
        JButton newJButton = new JButton(buttonName);
        newJButton.setBounds(
                startUpWindow.getWidth() / 2 - LARGEUR_BOUTON / 2
                , (startUpWindow.getHeight() / 2) - height
                , LARGEUR_BOUTON, HAUT_BOUTON);
        return newJButton;
    }
    
    public static void main(String[] args) {
        
        initStartUpWindow();
    }
}
