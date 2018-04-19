import javax.swing.*;
import java.awt.*;

public class TestCreator {
    
    
    private final static int JFRAME_WIDTH = 550;
    private final static int JFRAME_HEIGHT = 540;
    
    private static String windowNameLabel = "Créer un test";
    private static String previousButtonNameLabel = "<";
    private static String nextButtonNameLabel = ">";
    private static String addButtonNameLabel = "+";
    private static String removeButtonNameLabel = "-";
    private static String saveButtonNameLabel = "Sauvegarder le test";
    private static JLabel testNameLabel;
    private static JLabel questionLabel = new JLabel("QUESTION");
    private static JLabel statementLabel = new JLabel("Énoncé");
    private static JLabel optionsStatementLabel = new JLabel("Choix de "
            + "réponses (cochez la bonne réponse");
    private static JLabel option1Label = new JLabel("1)");
    private static JLabel option2Label = new JLabel("2)");
    private static JLabel option3Label = new JLabel("3)");
    private static JLabel option4Label = new JLabel("4)");
    
    private static int questionsIndex = 0;
    
    private JFrame testCreatorWindow;
    
    private JPanel headerPanel;
    private JPanel centerPanel;
    private JPanel questionIdPanel;
    private JPanel questionDataPanel;
    private JPanel footerPanel;
    
    private JButton previousButton;
    private JButton nextButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton saveButton;
    
    private JLabel questionNumberLabel;
    
    private JTextField testNameField;
    private JTextField answer1Input;
    private JTextField answer2Input;
    private JTextField answer3Input;
    private JTextField answer4Input;
    
    private JTextArea statementInput;
    
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
        questionsIndex++;
        
        testNameLabel = new JLabel("Nom du test");
        testNameLabel.setBounds(0, 0, 90, 30);
        testNameLabel.setVisible(true);
        
        this.testNameField = new JTextField();
        this.testNameField.setBounds(95, 5, 415, 20);
        this.testNameField.setBackground(Color.WHITE);
        this.testNameField.setOpaque(true);
        this.testNameField.setVisible(true);
        
        questionLabel.setLocation(10, 0);
        questionLabel.setSize(90, 30);
        questionLabel.setVisible(true);
        
        this.questionNumberLabel = new JLabel(Integer.toString(questionsIndex));
        this.questionNumberLabel.setSize(10, 30);
        this.questionNumberLabel.setLocation(150, 0);
        this.questionNumberLabel.setVisible(true);
        
        statementLabel.setSize(90, 30);
        statementLabel.setLocation(20, 0);
        statementLabel.setVisible(true);
        
        this.statementInput = new JTextArea();
        this.statementInput.setSize(480, 60);
        this.statementInput.setLocation(20, 25);
        this.statementInput.setLineWrap(true);
        this.statementInput.setWrapStyleWord(true);
        this.statementInput.setVisible(true);
    
        optionsStatementLabel.setSize(300, 30);
        optionsStatementLabel.setLocation(20, 45);
        optionsStatementLabel.setVisible(true);
        
        this.questionDataPanel = new JPanel(null);
        this.questionDataPanel.setSize(510, 251);
        this.questionDataPanel.setLocation(0, 39);
        this.questionDataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.questionDataPanel.setVisible(true);
        
        this.questionIdPanel = new JPanel(null);
        this.questionIdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.questionIdPanel.setSize(510, 40);
        this.questionIdPanel.setLocation(0, 0);
        this.questionIdPanel.setVisible(true);
        
        this.headerPanel = new JPanel(null);
        this.headerPanel.setSize(510, 35);
        this.headerPanel.setLocation(18, (30));
        this.headerPanel.setVisible(true);
        
        this.centerPanel = new JPanel(null);
        this.centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.centerPanel.setSize(510, 290);
        this.centerPanel.setLocation(18, 75);
        this.centerPanel.setVisible(true);
        
        this.footerPanel = new JPanel(null);
        this.footerPanel.setBackground(Color.GRAY);
        this.footerPanel.setSize(510, 90);
        this.footerPanel.setLocation(18, 395);
        this.footerPanel.setVisible(true);
        
        this.testCreatorWindow = new JFrame(windowNameLabel);
        this.testCreatorWindow.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
        this.positionTestCreatorWindow();
        this.testCreatorWindow.setResizable(false);
        this.testCreatorWindow.setLayout(null);
        this.testCreatorWindow.setVisible(true);
        
        this.questionDataPanel.add(statementLabel);
        this.questionDataPanel.add(optionsStatementLabel);
        this.questionDataPanel.add(this.statementInput);
        
        this.questionIdPanel.add(questionLabel);
        this.questionIdPanel.add(this.questionNumberLabel);
        
        this.headerPanel.add(testNameLabel);
        this.headerPanel.add(testNameField);
        
        this.centerPanel.add(this.questionIdPanel);
        this.centerPanel.add(this.questionDataPanel);
        
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
    
    
    public static void main(String[] args) {
        
        // TestCreator example = new TestCreator();
        javax.swing.SwingUtilities.invokeLater(TestCreator::new);
        
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


