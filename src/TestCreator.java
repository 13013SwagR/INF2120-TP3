import javax.swing.*;
import java.awt.*;

public class TestCreator {
    
    
    private final static int JFRAME_WIDTH = 550;
    private final static int JFRAME_HEIGHT = 540;
    
    private static String windowName = "Créer un test";
    private static String previousButtonName = "<";
    private static String nextButtonName = ">";
    private static String addButtonName = "+";
    private static String removeButtonName = "-";
    private static String saveButtonName = "Sauvegarder le test";
    private static JLabel testNameLabel;
    private static JLabel question = new JLabel("question");
    private static JLabel statement = new JLabel("Énoncé");
    private static JLabel answerOptions = new JLabel("Choix de réponses "
            + "(cochez la bonne réponse");
    private static JLabel option1 = new JLabel("1)");
    private static JLabel option2 = new JLabel("2)");
    private static JLabel option3 = new JLabel("3)");
    private static JLabel option4 = new JLabel("4)");
    private static int questionsIndex = 0;
    
    private JFrame testCreatorWindow;
    
    private JPanel headerPanel;
    private JPanel centerPanel;
    private JPanel footerPanel;
    
    private JButton previousButton;
    private JButton nextButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton saveButton;
    
    private JLabel questionNumber;
    
    private JTextField testNameField;
    private JTextField answer1;
    private JTextField answer2;
    private JTextField answer3;
    private JTextField answer4;
    
    private JCheckBox boxAnswer1;
    private JCheckBox boxAnswer2;
    private JCheckBox boxAnswer3;
    private JCheckBox boxAnswer4;
    
    // TODO: Créer une fenêtre.
    
    public TestCreator() {
        initTestCreatorWindow();
        /*
        this.previousButton = new JButton(previousButtonName);
        this.nextButton = new JButton(nextButtonName);
        this.addButton = new JButton(addButtonName);
        this.removeButton = new JButton(removeButtonName);
        this.saveButton = new JButton(saveButtonName);
        
        questionsIndex++;
        
        this.questionNumber = new JLabel(Integer.toString(questionsIndex));
        
        this.answer1 = new JTextField();
        this.answer2 = new JTextField();
        this.answer3 = new JTextField();
        this.answer4 = new JTextField();
        
        this.boxAnswer1 = new JCheckBox();
        this.boxAnswer2 = new JCheckBox();
        this.boxAnswer3 = new JCheckBox();
        this.boxAnswer4 = new JCheckBox();*/
    }
    
    private void initTestCreatorWindow() {
        this.testCreatorWindow = new JFrame(windowName);
        this.testCreatorWindow.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
        this.positionTestCreatorWindow();
        this.testCreatorWindow.setResizable(false);
        this.testCreatorWindow.setLayout(null);
        this.testCreatorWindow.setVisible(true);
        
        initHeaderPanel();
        initCenterPanel();
        initFooterPanel();
        this.testCreatorWindow.getContentPane().add(this.headerPanel);
        this.testCreatorWindow.getContentPane().add(this.centerPanel);
        this.testCreatorWindow.getContentPane().add(this.footerPanel);
        // TODO: Effacer avant la remise
        this.testCreatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void positionTestCreatorWindow() {
        double screenWidth = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().getWidth();
        double screenHeight = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight();
        int x = (int) ((screenWidth / 2) - (JFRAME_WIDTH / 2));
        int y = (int) ((screenHeight / 2) - (JFRAME_WIDTH / 2));
        this.testCreatorWindow.setLocation(x, y);
    }
    
    private void initHeaderPanel() {
        this.headerPanel = new JPanel(null);
        this.headerPanel.setSize(510, 35);
        this.headerPanel.setLocation(18, (30));
        this.headerPanel.setVisible(true);
        
        initTestNameLabel();
        iniTestNameField();
        this.headerPanel.add(testNameLabel);
        this.headerPanel.add(testNameField);
    }
    
    private void iniTestNameField() {
        this.testNameField = new JTextField();
        this.testNameField.setBounds(95, 5, 405, 20);
        this.testNameField.setBackground(Color.WHITE);
        this.testNameField.setOpaque(true);
        this.testNameField.setVisible(true);
    }
    
    private void initTestNameLabel() {
        this.testNameLabel = new JLabel("Nom du test");
        this.testNameLabel.setBounds(0, 0, 90, 30);
        this.testNameLabel.setVisible(true);
    }
    
    private void initCenterPanel() {
        this.centerPanel = new JPanel(new FlowLayout());
        this.centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.centerPanel.setSize(510, 290);
        this.centerPanel.setLocation(18, 90);
        this.centerPanel.setVisible(true);
    }
    
    private void initFooterPanel() {
        this.footerPanel = new JPanel(new FlowLayout());
        this.footerPanel.setBackground(Color.GRAY);
        this.footerPanel.setSize(510, 90);
        this.footerPanel.setLocation(18, 395);
        this.footerPanel.setVisible(true);
    }
    
    public static void main(String[] args) {
        
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
