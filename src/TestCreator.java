import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestCreator {
    private final static JLabel TEST_NAME_LABEL = new JLabel("Nom du test");
    private final static JLabel QUESTION = new JLabel("QUESTION");
    private final static JLabel STATEMENT = new JLabel("Énoncé");
    private final static JLabel ANSWER_OPTIONS = new JLabel("Choix de réponses "
            + "(cochez la bonne réponse");
    private final static JLabel OPTION_1 = new JLabel("1)");
    private final static JLabel OPTION_2 = new JLabel("2)");
    private final static JLabel OPTION_3 = new JLabel("3)");
    private final static JLabel OPTION_4 = new JLabel("4)");
    
    private final static int JFRAME_WIDTH = 550;
    private final static int JFRAME_HEIGHT = 540;
    
    private final static String WINDOW_NAME = "Créer un test";
    private final static String PREVIOUS_BUTTON_NAME = "<";
    private final static String NEXT_BUTTON_NAME = ">";
    private final static String ADD_BUTTON_NAME = "+";
    private final static String REMOVE_BUTTON_NAME = "-";
    private final static String SAVE_BUTTON_NAME = "Sauvegarder le test";
    
    private static int questionsIndex = 0;
    
    private JFrame testCreatorWindow;
    
    private JButton previousButton;
    private JButton nextButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton saveButton;
    
    private JLabel questionNumber;
    
    private JTextField questionStatement;
    private JTextField answer1;
    private JTextField answer2;
    private JTextField answer3;
    private JTextField answer4;
    
    private JCheckBox boxAnswer1;
    private JCheckBox boxAnswer2;
    private JCheckBox boxAnswer3;
    private JCheckBox boxAnswer4;
    
    // TODO: Créer une fenêtre.
    
    public TestCreator () {
        initTestCreatorWindow();
        this.previousButton = new JButton(PREVIOUS_BUTTON_NAME);
        this.nextButton = new JButton(NEXT_BUTTON_NAME);
        this.addButton = new JButton(ADD_BUTTON_NAME);
        this.removeButton = new JButton(REMOVE_BUTTON_NAME);
        this.saveButton = new JButton(SAVE_BUTTON_NAME);
        
        questionsIndex++;
        
        this.questionNumber = new JLabel(Integer.toString(questionsIndex));
    
        this.questionStatement = new JTextField();
        this.answer1 = new JTextField();
        this.answer2 = new JTextField();
        this.answer3 = new JTextField();
        this.answer4 = new JTextField();
    
        this.boxAnswer1 = new JCheckBox();
        this.boxAnswer2 = new JCheckBox();
        this.boxAnswer3 = new JCheckBox();
        this.boxAnswer4 = new JCheckBox();
    }
    
    private void initTestCreatorWindow() {
        this.testCreatorWindow  = new JFrame(WINDOW_NAME);
        this.testCreatorWindow.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
        this.positionTestCreatorWindow();
        this.testCreatorWindow.setResizable(false);
        this.testCreatorWindow.setVisible(true);
        // TODO: Effacer avant la remise
        this.testCreatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void positionTestCreatorWindow() {
        double screenWidth = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().getWidth();
        double screenHeight = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight();
        int x = (int) ( (screenWidth / 2) - (JFRAME_WIDTH / 2) );
        int y = (int) ( (screenHeight / 2)  - (JFRAME_WIDTH / 2) );
        this.testCreatorWindow.setLocation(x,y);
    }

    public static void main (String [] args)  {

        new TestCreator();

        // OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple1JFrame();
            }
      });
      */
    }
    /** TODO: Bouton [ < ] :
    Ce bouton sert à revenir à la question qui précède la question courante. Il doit être désactivé
    lorsque la question courante est la première question de ce test.
    
    Lorsqu’on clique sur ce bouton (s’il est actif) :
            1) Si les champs de la question courante sont valides, on affiche la question précédente.
            2) Si les champs de la question courante sont invalides, on affiche un message d’erreur
            dans une fenêtre surgissante, et la question courante reste
            inchangée.*/
    
   /** TODO:Bouton [ > ]
   Ce bouton sert à aller à la question qui suit la question courante. Il doit être désactivé lorsque
    la question courante est la dernière question de ce test.
    
    Lorsqu’on clique sur ce bouton (s’il est actif) :
             1) Si les champs de la question courante sont valides, on affiche la question suivante.
             2) Si les champs de la question courante sont invalides, on affiche un message d’erreur
             dans une fenêtre surgissante, et la question courante reste
             inchangée.*/
   
    /** TODO:Bouton [ + ]
    Ce bouton sert à ajouter une question au test courant.
    Lorsqu’on clique sur ce bouton :
            1) Si les champs de la question courante sont valides, on affiche une nouvelle question
            (dont tous les champs sont vides et les cases décochées) tout de suite après la
            question courante (le numéro de toutes les questions suivantes augmente de 1, sauf si
            la question courante était la dernière, et que dans ce cas, on ajoute à la fin).
            
            2) Si les champs de la question courante sont invalides, on affiche un message d’erreur
                dans une fenêtre surgissante, la question courante reste
                inchangée, et l’ajout est annulé.*/
    /** TODO: Bouton [ - ]
    Ce bouton sert à supprimer une question. Il doit être désactivé lorsqu’il n’y a aucune ou
    seulement une question dans le test courant.
    
    Lorsqu’on clique sur ce bouton (s’il est actif), la question courante est supprimée, et l’on affiche
    la question qui venait juste après la question supprimée. Aussi, le numéro des questions qui
    venaient après la question supprimée diminue de 1.*/
    
    /** TODO: Bouton [ Sauvegarder le test ]
    Ce bouton sert à sauvegarder le test courant.
    
    Lorsqu’on clique sur ce bouton :
            1) Si le nom du test n’est pas valide, ou si la question courante n’est pas valide, le
            programme affiche un message d’erreur dans une fenêtre surgissante,selon le cas,
            l’enregistrement est annulé, et la fenêtre demeure inchangée. Notez que le programme
            n’affiche qu’un seul message d’erreur, dans cet ordre : 1) nom du test invalide, et 2)
            champ(s) de la question courante invalide(s) (voir précision #5
            pour les champs de la question invalides).
            
            2) Si le nom du test, et la question courante sont valides :
            - Le test est sauvegardé dans le fichier tests.txt ainsi que dans
              la liste déroulante de la fenêtre #1.
            - La fenêtre #2 se ferme.
            - Un message de confirmation de l’enregistrement est affiché.*/
    
    
}
