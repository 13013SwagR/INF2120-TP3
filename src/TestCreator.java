import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
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
            + "réponses (cochez la bonne réponse)");
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
    private JPanel mainButtonsPanel;
    private JPanel saveButtonPanel;
    
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
    private JScrollPane statementInputScrollPane;
    
    private JCheckBox boxAnswer1;
    private JCheckBox boxAnswer2;
    private JCheckBox boxAnswer3;
    private JCheckBox boxAnswer4;
    
    // TODO: Créer une fenêtre.
    
    public TestCreator() {
        initTestCreatorWindow();
    }
    
    private void initTestCreatorWindow() {
        questionsIndex++;
        initHeaderPanel();
        initCenterPanel();
        initFooterPanel();
        this.testCreatorWindow = new JFrame(windowNameLabel);
        this.testCreatorWindow.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
        this.positionTestCreatorWindow();
        this.testCreatorWindow.setResizable(false);
        this.testCreatorWindow.setLayout(null);
        this.testCreatorWindow.setVisible(true);
        addComponentsToParents();
        // TODO: Effacer avant la remise
        this.testCreatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addComponentsToParents() {
        
        
        this.headerPanel.add(testNameLabel);
        this.headerPanel.add(testNameField);
        
        this.questionDataPanel.add(statementLabel);
        this.questionDataPanel.add(optionsStatementLabel);
    
        this.questionDataPanel.add(this.statementInputScrollPane);
        
        
        
        this.questionDataPanel.add(option1Label);
        this.questionDataPanel.add(this.answer1Input);
        this.questionDataPanel.add(this.boxAnswer1);
        this.questionDataPanel.add(option2Label);
        this.questionDataPanel.add(this.answer2Input);
        this.questionDataPanel.add(this.boxAnswer2);
        this.questionDataPanel.add(option3Label);
        this.questionDataPanel.add(this.answer3Input);
        this.questionDataPanel.add(this.boxAnswer3);
        this.questionDataPanel.add(option4Label);
        this.questionDataPanel.add(this.answer4Input);
        this.questionDataPanel.add(this.boxAnswer4);
        
        this.questionIdPanel.add(questionLabel);
        this.questionIdPanel.add(this.questionNumberLabel);
        
        this.centerPanel.add(this.questionIdPanel);
        this.centerPanel.add(this.questionDataPanel);
        
        this.saveButtonPanel.add(saveButton);
        
        this.mainButtonsPanel.add(this.previousButton);
        this.mainButtonsPanel.add(this.addButton);
        this.mainButtonsPanel.add(this.removeButton);
        this.mainButtonsPanel.add(this.nextButton);
        
        this.footerPanel.add(this.mainButtonsPanel);
        this.footerPanel.add(this.saveButtonPanel);
        
        this.testCreatorWindow.getContentPane().add(this.headerPanel);
        this.testCreatorWindow.getContentPane().add(this.centerPanel);
        this.testCreatorWindow.getContentPane().add(this.footerPanel);
    }
    
    private void initFooterPanel() {
        this.footerPanel = new JPanel(null);
        this.footerPanel.setSize(510, 90);
        this.footerPanel.setLocation(18, 420);
        this.footerPanel.setVisible(true);
        initMainButtonsPanel();
        initSaveButtonPanel();
    }
    
    private void initSaveButtonPanel() {
        this.saveButtonPanel = new JPanel(null);
        this.saveButtonPanel.setBorder(BorderFactory.createMatteBorder(1, 0,
                0, 0, Color
                        .BLACK));
        this.saveButtonPanel.setSize(510, 60);
        this.saveButtonPanel.setLocation(0, 25);
        this.saveButtonPanel.setVisible(true);
        initSaveButton();
    }
    
    private void initCenterPanel() {
        this.centerPanel = new JPanel(null);
        this.centerPanel.setSize(510, 330);
        this.centerPanel.setLocation(18, 75);
        this.centerPanel.setVisible(true);
        //Composants questionIdPanel
        initQuestionIdPanel();
        //Composants questionDataPanel
        initQuestionDataPanel();
    }
    
    private void initHeaderPanel() {
        this.headerPanel = new JPanel(null);
        this.headerPanel.setSize(510, 35);
        this.headerPanel.setLocation(18, (30));
        this.headerPanel.setVisible(true);
        initTestNameLabel();
        initTestNameField();
    }
    
    private void initQuestionIdPanel() {
        this.questionIdPanel = new JPanel(null);
        this.questionIdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.questionIdPanel.setSize(510, 40);
        this.questionIdPanel.setLocation(0, 0);
        this.questionIdPanel.setVisible(true);
        initQuestionLabel();
        initQuestionNumberLabel();
    }
    
    private void initQuestionDataPanel() {
        this.questionDataPanel = new JPanel(null);
        this.questionDataPanel.setSize(510, 290);
        this.questionDataPanel.setLocation(0, 39);
        this.questionDataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.questionDataPanel.setVisible(true);
        initStatementLabel();
        initStatementInput();
        initOptionsStatementLabel();
        initOptions();
    }
    
    private void initMainButtonsPanel() {
        this.mainButtonsPanel = new JPanel(new GridLayout(0, 4, 20, 0));
        this.mainButtonsPanel.setLocation(90, 0);
        this.mainButtonsPanel.setSize(330, 15);
        this.mainButtonsPanel.setVisible(true);
        initPreviousButton();
        initNextButton();
        initAddButton();
        initRemoveButton();
    }
    
    private void initSaveButton() {
        this.saveButton = new JButton(saveButtonNameLabel);
        this.saveButton.setSize(200, 20);
        this.saveButton.setLocation((510 - 200) / 2, 20);
        this.saveButton.setVisible(true);
    }
    
    private void initRemoveButton() {
        this.removeButton = new JButton(removeButtonNameLabel);
        this.removeButton.setVisible(true);
    }
    
    private void initAddButton() {
        this.addButton = new JButton(addButtonNameLabel);
        this.addButton.setVisible(true);
    }
    
    private void initNextButton() {
        this.nextButton = new JButton(nextButtonNameLabel);
        this.nextButton.setEnabled(false);
        this.nextButton.setVisible(true);
    }
    
    private void initPreviousButton() {
        this.previousButton = new JButton(previousButtonNameLabel);
        this.previousButton.setEnabled(false);
        this.previousButton.setVisible(true);
    }
    
    private void initOptions() {
        initOption1();
        initOption2();
        initOption3();
        initOption4();
    }
    
    private void initOption4() {
        initOption4Label();
        initOption4Input();
        initBoxAnswer4();
    }
    
    private void initBoxAnswer4() {
        this.boxAnswer4 = new JCheckBox();
        this.boxAnswer4.setLocation(440, 220);
        this.boxAnswer4.setSize(30, 30);
        this.boxAnswer4.setVisible(true);
    }
    
    private void initOption4Input() {
        this.answer4Input = new JTextField();
        this.answer4Input.setSize(380, 20);
        this.answer4Input.setLocation(50, 227);
        this.answer4Input.setVisible(true);
    }
    
    private void initOption3() {
        initOption3Label();
        initAnswer3Input();
        initBoxAnswer3();
    }
    
    private void initOption2() {
        initOption2Label();
        initAnswer2Input();
        initBoxAnswer2();
    }
    
    private void initOption1() {
        initOption1Label();
        initAnswer1Input();
        initBoxAnswer1();
    }
    
    private void initOption4Label() {
        option4Label.setSize(40, 30);
        option4Label.setLocation(20, 220);
        option4Label.setVisible(true);
    }
    
    private void initBoxAnswer3() {
        this.boxAnswer3 = new JCheckBox();
        this.boxAnswer3.setLocation(440, 190);
        this.boxAnswer3.setSize(30, 30);
        this.boxAnswer3.setVisible(true);
    }
    
    private void initAnswer3Input() {
        this.answer3Input = new JTextField();
        this.answer3Input.setSize(380, 20);
        this.answer3Input.setLocation(50, 197);
        this.answer3Input.setVisible(true);
    }
    
    private void initOption3Label() {
        option3Label.setSize(40, 30);
        option3Label.setLocation(20, 190);
        option3Label.setVisible(true);
    }
    
    private void initBoxAnswer2() {
        this.boxAnswer2 = new JCheckBox();
        this.boxAnswer2.setLocation(440, 160);
        this.boxAnswer2.setSize(30, 30);
        this.boxAnswer2.setVisible(true);
    }
    
    private void initAnswer2Input() {
        this.answer2Input = new JTextField();
        this.answer2Input.setSize(380, 20);
        this.answer2Input.setLocation(50, 167);
        this.answer2Input.setVisible(true);
    }
    
    private void initOption2Label() {
        option2Label.setSize(40, 30);
        option2Label.setLocation(20, 160);
        option2Label.setVisible(true);
    }
    
    private void initBoxAnswer1() {
        this.boxAnswer1 = new JCheckBox();
        this.boxAnswer1.setLocation(440, 130);
        this.boxAnswer1.setSize(30, 30);
        this.boxAnswer1.setVisible(true);
    }
    
    private void initAnswer1Input() {
        this.answer1Input = new JTextField();
        this.answer1Input.setSize(380, 20);
        this.answer1Input.setLocation(50, 137);
        this.answer1Input.setVisible(true);
    }
    
    private void initOption1Label() {
        option1Label.setSize(40, 30);
        option1Label.setLocation(20, 130);
        option1Label.setVisible(true);
    }
    
    private void initOptionsStatementLabel() {
        optionsStatementLabel.setSize(420, 30);
        optionsStatementLabel.setLocation(20, 90);
        optionsStatementLabel.setVisible(true);
    }
    
    private void initStatementInput() {
        this.statementInput = new JTextArea();
        this.statementInput.setSize(480, 50);
        this.statementInput.setLocation(20, 25);
        this.statementInput.setLineWrap(true);
        this.statementInput.setWrapStyleWord(true);
        this.statementInput.setVisible(true);
        initStatementInputScrollPane();
    }
    
    private void initStatementInputScrollPane() {
        this.statementInputScrollPane = new JScrollPane(statementInput);
        this.statementInputScrollPane.setSize(480, 50);
        this.statementInputScrollPane.setLocation(20,25);
        this.statementInputScrollPane.setVerticalScrollBarPolicy(JScrollPane
                .VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    
    private void initStatementLabel() {
        statementLabel.setSize(90, 30);
        statementLabel.setLocation(20, 0);
        statementLabel.setVisible(true);
    }
    
    private void initQuestionNumberLabel() {
        this.questionNumberLabel = new JLabel(Integer.toString(questionsIndex));
        this.questionNumberLabel.setSize(10, 30);
        this.questionNumberLabel.setLocation(90, 0);
        this.questionNumberLabel.setVisible(true);
    }
    
    private void initQuestionLabel() {
        questionLabel.setLocation(10, 0);
        questionLabel.setSize(90, 30);
        questionLabel.setVisible(true);
    }
    
    private void initTestNameField() {
        this.testNameField = new JTextField();
        this.testNameField.setBounds(95, 5, 415, 20);
        this.testNameField.setBackground(Color.WHITE);
        this.testNameField.setOpaque(true);
        this.testNameField.setVisible(true);
    }
    
    private void initTestNameLabel() {
        testNameLabel = new JLabel("Nom du test");
        testNameLabel.setBounds(0, 0, 90, 30);
        testNameLabel.setVisible(true);
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


