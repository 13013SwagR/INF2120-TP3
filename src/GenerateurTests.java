//import com.sun.xml.internal.bind.v2.TODO;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

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
    private static JFrame testCreatorWindow;
    
    private static ArrayList createdTests = new ArrayList<>();
    private static ArrayList<Test> testsList = new ArrayList<Test>();
    private static Question currentQuestion;
    private static Test currentTest = new Test();
    //Ajouts
    private static final JLabel questionLabel = new JLabel("QUESTION");
    private static final JLabel statementLabel = new JLabel("Énoncé");
    private static final JLabel optionsStatementLabel = new JLabel("Choix de "
            + "réponses (cochez la bonne réponse)");
    private static final JLabel option1Label = new JLabel("1)");
    private static final JLabel option2Label = new JLabel("2)");
    private static final JLabel option3Label = new JLabel("3)");
    private static final JLabel option4Label = new JLabel("4)");
    private static final String windowNameLabel = "Créer un test";
    private static final String previousButtonNameLabel = "<";
    private static final String nextButtonNameLabel = ">";
    private static final String addButtonNameLabel = "+";
    private static final String removeButtonNameLabel = "-";
    private static final String saveButtonNameLabel = "Sauvegarder le test";
    private final static int TEST_CREATOR_WINDOW_WIDTH = 550;
    private final static int TEST_CREATOR_WINDOW_HEIGHT = 540;
    private final static int STARTUP_WINDOW_WIDTH = 380;
    private final static int STARTUP_WINDOW_HEIGHT = 360;
    public final static int HAUT_BOUTON = 30;
    public final static int LARGEUR_BOUTON = 250;
    
    private static JPanel headerPanel;
    private static JPanel questionIdPanel;
    private static JPanel questionDataPanel;
    private static JPanel centerPanel;
    private static JPanel footerPanel;
    private static JPanel mainButtonsPanel;
    private static JPanel saveButtonPanel;
    private static JButton previousButton;
    private static JButton nextButton;
    private static JButton addButton;
    private static JButton removeButton;
    private static JButton saveButton;
    
    private static JButton createNewTestButton;
    private static JButton buttonPasser;
    private static JButton buttonSupprimer;
    private static JComboBox<String> testsListComboBox;
    private static JCheckBox boxAnswer1;
    private static JCheckBox boxAnswer2;
    private static JCheckBox boxAnswer3;
    private static JCheckBox boxAnswer4;
    private static ButtonGroup boxAnswersGroup;
    
    
    private static JLabel testNameLabel;
    private static JLabel questionNumberLabel;
    private static JTextField testNameField;
    private static JTextField answer1Input;
    private static JTextField answer2Input;
    private static JTextField answer3Input;
    private static JTextField answer4Input;
    
    private static JTextArea questionStatementInput;
    private static JScrollPane statementInputScrollPane;
    
    private static ActionListener createNewTestButtonListener;
    private static ActionListener addButtonListener;
    private static ActionListener removeButtonListener;
    
    private static int questionsIndex = 1;
    
    /************************************
     * CONSTANTES DE CLASSE
     ************************************/
    
    
    public static void initStartUpWindow() {
        
        startUpWindow = new JFrame("Générateur de tests");
        startUpWindow.setBounds(getStartupWindowPositionX(),
                getStartupWindowPositionY(), STARTUP_WINDOW_WIDTH, STARTUP_WINDOW_HEIGHT);
        startUpWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUpWindow.setResizable(false);
        startUpWindow.setLayout(null);
        
        initStartupWindowButtons();
        initTestsListComboBox();
        addComponentsToStartupWindow();
        
        startUpWindow.setVisible(true);
        
        
    }
    
    private static void createNewTestButtonActionListener() {
        createNewTestButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initTestCreatorWindow();
            }
        };
        createNewTestButton.addActionListener(createNewTestButtonListener);
    }
    
    private static void addComponentsToStartupWindow() {
        startUpWindow.getContentPane().add(createNewTestButton);
        startUpWindow.getContentPane().add(buttonPasser);
        startUpWindow.getContentPane().add(buttonSupprimer);
        startUpWindow.getContentPane().add(createStartUpWindowBlackLine());
        startUpWindow.getContentPane().add(testsListComboBox);
    }
    
    private static void initStartupWindowButtons() {
        createNewTestButton = createStandardJButton("Créer un nouveau test", 150);
        createNewTestButtonActionListener();
        buttonPasser = createStandardJButton("Passer le test sélectionné", -30);
        buttonSupprimer = createStandardJButton("Supprimer le test sélectionné", -80);
    }
    
    private static void initTestsListComboBox() {
        testsListComboBox = new JComboBox<String>();
        testsListComboBox = getTestList();
        testsListComboBox.addItem("blabla");
        testsListComboBox.setEnabled(true);
        testsListComboBox.setBounds(
                (startUpWindow.getWidth() - LARGEUR_BOUTON) / 2,
                (startUpWindow.getHeight() / 2) - 40,
                LARGEUR_BOUTON,
                HAUT_BOUTON - 10);
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
    
    private static int getStartupWindowPositionX() {
        return (int) ((getScreenWidth() / 2) - (STARTUP_WINDOW_WIDTH / 2));
    }
    
    private static int getStartupWindowPositionY() {
        return (int) ((getScreenHeight() / 2) - (STARTUP_WINDOW_HEIGHT / 2));
    }
    
    private static double getScreenHeight() {
        return Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight();
    }
    
    private static double getScreenWidth() {
        return Toolkit.getDefaultToolkit()
                .getScreenSize().getWidth();
    }
    
    private static JButton createStandardJButton(String buttonName, int height) {
        JButton newJButton = new JButton(buttonName);
        newJButton.setBounds(
                startUpWindow.getWidth() / 2 - LARGEUR_BOUTON / 2
                , (startUpWindow.getHeight() / 2) - height
                , LARGEUR_BOUTON, HAUT_BOUTON);
        return newJButton;
    }
    
    
    private static void initTestCreatorWindow() {
        testCreatorWindow = new JFrame(windowNameLabel);
        testCreatorWindow.setSize(TEST_CREATOR_WINDOW_WIDTH, TEST_CREATOR_WINDOW_HEIGHT);
        testCreatorWindow.setLocation(getTestCreatorWindowPositionX(), getTestCreatorWindowPositionY());
        testCreatorWindow.setResizable(false);
        testCreatorWindow.setLayout(null);
        testCreatorWindow.setVisible(true);
        
        initHeaderPanel();
        initCenterPanel();
        initFooterPanel();
        
        // TODO: Effacer avant la remise
        testCreatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addComponentsToParents();
    }
    
    
    private static int getTestCreatorWindowPositionY() {
        return (int) ((getScreenHeight() / 2) - (TEST_CREATOR_WINDOW_HEIGHT
                / 2));
    }
    
    private static int getTestCreatorWindowPositionX() {
        return (int) ((getScreenWidth() / 2) - (TEST_CREATOR_WINDOW_WIDTH / 2));
    }
    
    private static void addComponentsToParents() {
        
        headerPanel.add(testNameLabel);
        headerPanel.add(testNameField);
        
        questionDataPanel.add(statementLabel);
        questionDataPanel.add(optionsStatementLabel);
        
        questionDataPanel.add(statementInputScrollPane);
        
        questionDataPanel.add(option1Label);
        questionDataPanel.add(answer1Input);
        questionDataPanel.add(boxAnswer1);
        questionDataPanel.add(option2Label);
        questionDataPanel.add(answer2Input);
        questionDataPanel.add(boxAnswer2);
        questionDataPanel.add(option3Label);
        questionDataPanel.add(answer3Input);
        questionDataPanel.add(boxAnswer3);
        questionDataPanel.add(option4Label);
        questionDataPanel.add(answer4Input);
        questionDataPanel.add(boxAnswer4);
        
        questionIdPanel.add(questionLabel);
        questionIdPanel.add(questionNumberLabel);
        
        centerPanel.add(questionIdPanel);
        centerPanel.add(questionDataPanel);
        
        testCreatorWindow.add(headerPanel);
        testCreatorWindow.add(centerPanel);
        saveButtonPanel.add(saveButton);
        
        mainButtonsPanel.add(previousButton);
        mainButtonsPanel.add(addButton);
        mainButtonsPanel.add(removeButton);
        mainButtonsPanel.add(nextButton);
        
        footerPanel.add(mainButtonsPanel);
        footerPanel.add(saveButtonPanel);
        
        testCreatorWindow.getContentPane().add(footerPanel);
    }
    
    private static void initCenterPanel() {
        centerPanel = new JPanel(null);
        centerPanel.setSize(510, 330);
        centerPanel.setLocation(18, 75);
        centerPanel.setVisible(true);
        //Composants questionIdPanel
        initQuestionIdPanel();
        //Composants questionDataPanel
        initQuestionDataPanel();
    }
    
    private static void initHeaderPanel() {
        headerPanel = new JPanel(null);
        headerPanel.setSize(510, 35);
        headerPanel.setLocation(18, (30));
        headerPanel.setVisible(true);
        initTestNameLabel();
        initTestNameField();
    }
    
    private static void initQuestionIdPanel() {
        questionIdPanel = new JPanel(null);
        questionIdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        questionIdPanel.setSize(510, 40);
        questionIdPanel.setLocation(0, 0);
        questionIdPanel.setVisible(true);
        initQuestionLabel();
        initQuestionNumberLabel();
    }
    
    private static void initQuestionDataPanel() {
        questionDataPanel = new JPanel(null);
        questionDataPanel.setSize(510, 290);
        questionDataPanel.setLocation(0, 39);
        questionDataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        questionDataPanel.setVisible(true);
        initStatementLabel();
        initStatementInput();
        initOptionsStatementLabel();
        initOptions();
    }
    
    private static void initOptions() {
        initOption1();
        initOption2();
        initOption3();
        initOption4();
        boxAnswersGroup = new ButtonGroup();
        boxAnswersGroup.add(boxAnswer1);
        boxAnswersGroup.add(boxAnswer2);
        boxAnswersGroup.add(boxAnswer3);
        boxAnswersGroup.add(boxAnswer4);
        
    }
    
    private static void initOption4() {
        initOption4Label();
        initOption4Input();
        initBoxAnswer4();
    }
    
    private static void initBoxAnswer4() {
        boxAnswer4 = new JCheckBox();
        boxAnswer4.setLocation(440, 220);
        boxAnswer4.setSize(30, 30);
        boxAnswer4.setVisible(true);
    }
    
    private static void initOption4Input() {
        answer4Input = new JTextField();
        answer4Input.setSize(380, 20);
        answer4Input.setLocation(50, 227);
        answer4Input.setVisible(true);
    }
    
    private static void initOption3() {
        initOption3Label();
        initAnswer3Input();
        initBoxAnswer3();
    }
    
    private static void initOption2() {
        initOption2Label();
        initAnswer2Input();
        initBoxAnswer2();
    }
    
    private static void initOption1() {
        initOption1Label();
        initAnswer1Input();
        initBoxAnswer1();
    }
    
    private static void initOption4Label() {
        option4Label.setSize(40, 30);
        option4Label.setLocation(20, 220);
        option4Label.setVisible(true);
    }
    
    private static void initBoxAnswer3() {
        boxAnswer3 = new JCheckBox();
        boxAnswer3.setLocation(440, 190);
        boxAnswer3.setSize(30, 30);
        boxAnswer3.setVisible(true);
    }
    
    private static void initAnswer3Input() {
        answer3Input = new JTextField();
        answer3Input.setSize(380, 20);
        answer3Input.setLocation(50, 197);
        answer3Input.setVisible(true);
    }
    
    private static void initOption3Label() {
        option3Label.setSize(40, 30);
        option3Label.setLocation(20, 190);
        option3Label.setVisible(true);
    }
    
    private static void initBoxAnswer2() {
        boxAnswer2 = new JCheckBox();
        boxAnswer2.setLocation(440, 160);
        boxAnswer2.setSize(30, 30);
        boxAnswer2.setVisible(true);
    }
    
    private static void initAnswer2Input() {
        answer2Input = new JTextField();
        answer2Input.setSize(380, 20);
        answer2Input.setLocation(50, 167);
        answer2Input.setVisible(true);
    }
    
    private static void initOption2Label() {
        option2Label.setSize(40, 30);
        option2Label.setLocation(20, 160);
        option2Label.setVisible(true);
    }
    
    private static void initBoxAnswer1() {
        boxAnswer1 = new JCheckBox();
        boxAnswer1.setLocation(440, 130);
        boxAnswer1.setSize(30, 30);
        boxAnswer1.setVisible(true);
    }
    
    private static void initAnswer1Input() {
        answer1Input = new JTextField();
        answer1Input.setSize(380, 20);
        answer1Input.setLocation(50, 137);
        answer1Input.setVisible(true);
    }
    
    private static void initOption1Label() {
        option1Label.setSize(40, 30);
        option1Label.setLocation(20, 130);
        option1Label.setVisible(true);
    }
    
    private static void initOptionsStatementLabel() {
        optionsStatementLabel.setSize(420, 30);
        optionsStatementLabel.setLocation(20, 90);
        optionsStatementLabel.setVisible(true);
    }
    
    private static void initStatementInput() {
        questionStatementInput = new JTextArea();
        questionStatementInput.setSize(480, 50);
        questionStatementInput.setLocation(20, 25);
        questionStatementInput.setLineWrap(true);
        questionStatementInput.setWrapStyleWord(true);
        questionStatementInput.setVisible(true);
        initStatementInputScrollPane();
    }
    
    private static void initStatementInputScrollPane() {
        statementInputScrollPane = new JScrollPane(questionStatementInput);
        statementInputScrollPane.setSize(480, 50);
        statementInputScrollPane.setLocation(20, 25);
        statementInputScrollPane.setVerticalScrollBarPolicy(JScrollPane
                .VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    
    private static void initStatementLabel() {
        statementLabel.setSize(90, 30);
        statementLabel.setLocation(20, 0);
        statementLabel.setVisible(true);
    }
    
    private static void initQuestionNumberLabel() {
        questionNumberLabel = new JLabel(Integer.toString(questionsIndex));
        questionNumberLabel.setSize(10, 30);
        questionNumberLabel.setLocation(90, 0);
        questionNumberLabel.setVisible(true);
    }
    
    private static void initQuestionLabel() {
        questionLabel.setLocation(10, 0);
        questionLabel.setSize(90, 30);
        questionLabel.setVisible(true);
    }
    
    private static void initTestNameField() {
        testNameField = new JTextField();
        testNameField.setBounds(95, 5, 415, 20);
        testNameField.setBackground(Color.WHITE);
        testNameField.setOpaque(true);
        testNameField.setVisible(true);
    }
    
    private static void initTestNameLabel() {
        testNameLabel = new JLabel("Nom du test");
        testNameLabel.setBounds(0, 0, 90, 30);
        testNameLabel.setVisible(true);
    }
    
    private static void initFooterPanel() {
        footerPanel = new JPanel(null);
        footerPanel.setSize(510, 90);
        footerPanel.setLocation(18, 420);
        footerPanel.setVisible(true);
        
        initMainButtonsPanel();
        initSaveButtonPanel();
    }
    
    private static void initMainButtonsPanel() {
        mainButtonsPanel = new JPanel(new GridLayout(0, 4, 20, 0));
        mainButtonsPanel.setLocation(90, 0);
        mainButtonsPanel.setSize(330, 15);
        mainButtonsPanel.setVisible(true);
        
        initPreviousButton();
        initNextButton();
        initAddButton();
        initRemoveButton();
    }
    
    private static void initRemoveButton() {
        removeButton = new JButton(removeButtonNameLabel);
        removeButton.setEnabled(false);
        initRemoveButtonListener();
    }
    
    private static void initRemoveButtonListener() {
        removeButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anotherQuestionExist()) {
                    Question questionToRemove = currentQuestion;
                    setExistingQuestion();
                    currentTest.removeQuestion(questionToRemove);
                    System.out.print(questionsIndex);
                    updateButtonsStatus();
                }
            }
        };
        removeButton.addActionListener(removeButtonListener);
    }
    
    private static void setExistingQuestion() {
        if (currentTest.hasNext(questionsIndex)) {
            setNextQuestion();
            questionsIndex--;
            adjustCurrentQuestionNumberToCurrentQuestionIndex();
        } else {
            setPreviousQuestion();
        }
    }
    
    private static void adjustCurrentQuestionNumberToCurrentQuestionIndex() {
        currentQuestion.setQuestionNumber(questionsIndex);
        questionNumberLabel.setText(Integer.toString(currentQuestion.getQuestionNumber()));
    }
    
    private static void setNextQuestion() {
        currentQuestion = currentTest.getNextQuestion(questionsIndex);
        questionsIndex++;
        setToCurrentQuestion();
    }
    
    private static void setToCurrentQuestion() {
        questionStatementInput.setText(currentQuestion.getQuestionStatement());
        answer1Input.setText(currentQuestion.getAnswerOption1());
        answer2Input.setText(currentQuestion.getAnswerOption2());
        answer3Input.setText(currentQuestion.getAnswerOption3());
        answer4Input.setText(currentQuestion.getAnswerOption4());
        boxAnswer1.setSelected(currentQuestion.isAnswer1());
        boxAnswer2.setSelected(currentQuestion.isAnswer2());
        boxAnswer3.setSelected(currentQuestion.isAnswer3());
        boxAnswer4.setSelected(currentQuestion.isAnswer4());
        questionNumberLabel.setText(Integer.toString(currentQuestion.getQuestionNumber()));
    }
    
    private static void setPreviousQuestion() {
        currentQuestion = currentTest.getPreviousQuestion(questionsIndex - 1);
        questionsIndex--;
        setToCurrentQuestion();
    }
    
    private static void initAddButton() {
        addButton = new JButton(addButtonNameLabel);
        initAddButtonListener();
    }
    
    private static void initAddButtonListener() {
        addButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isQuestionComplete()) {
                    saveCurrentQuestion();
                    questionsIndex++;
                    resetQuestionForm();
                    currentQuestion = new Question(questionsIndex);
                    updateButtonsStatus();
                }
            }
        };
        addButton.addActionListener(addButtonListener);
    }
    
    private static void resetQuestionForm() {
        questionStatementInput.setText("");
        answer1Input.setText("");
        answer2Input.setText("");
        answer3Input.setText("");
        answer4Input.setText("");
        boxAnswersGroup.clearSelection();
        questionNumberLabel.setText(Integer.toString(questionsIndex));
    }
    
    private static boolean isQuestionComplete() {
        return isACheckBoxSelected() && isTheQuestionWritten() &&
                areAllAnswersWritten();
    }
    
    private static boolean areAllAnswersWritten() {
        return !(answer1Input.getText().equals("") || answer2Input.equals("")
                || answer3Input.equals("") || answer4Input.equals(""));
    }
    
    private static boolean isTheQuestionWritten() {
        return !questionStatementInput.getText().equals("");
    }
    
    private static boolean isACheckBoxSelected() {
        return boxAnswer1.isSelected() || boxAnswer2.isSelected() ||
                boxAnswer3.isSelected() || boxAnswer4.isSelected();
    }
    
    private static void saveCurrentQuestion() {
        currentQuestion = new Question(questionsIndex);
        currentQuestion.setQuestionStatement(questionStatementInput.getText());
        currentQuestion.setAnswerOptions(answer1Input.getText(),
                answer2Input.getText(), answer3Input.getText(),
                answer4Input.getText());
        currentQuestion.setAnswers(boxAnswer1.isSelected(),
                boxAnswer2.isSelected(),
                boxAnswer3.isSelected(),
                boxAnswer4.isSelected());
        currentTest.addQuestion(currentQuestion);
    }
    
    private static void initNextButton() {
        nextButton = new JButton(nextButtonNameLabel);
        nextButton.setEnabled(false);
    
        nextButtonListener();
        
    }
    
    private static void nextButtonListener() {
        removeButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (anotherQuestionExist()) {
                    Question questionToRemove = currentQuestion;
                    setExistingQuestion();
                    currentTest.removeQuestion(questionToRemove);
                    System.out.print(questionsIndex);
                    updateButtonsStatus();
                }
            }
        };
        removeButton.addActionListener(removeButtonListener);
    }
    
    private static void initPreviousButton() {
        previousButton = new JButton(previousButtonNameLabel);
        previousButton.setEnabled(false);
    }
    
    private static void initSaveButtonPanel() {
        saveButtonPanel = new JPanel(null);
        saveButtonPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        saveButtonPanel.setSize(510, 60);
        saveButtonPanel.setLocation(0, 25);
        saveButtonPanel.setVisible(true);
        initSaveButton();
    }
    
    private static void initSaveButton() {
        saveButton = new JButton(saveButtonNameLabel);
        saveButton.setSize(200, 20);
        saveButton.setLocation((510 - 200) / 2, 20);
        saveButton.setVisible(true);
    }
    
    private static void updateButtonsStatus() {
        updateRemoveButtonStatus();
        updateNextButtonStatus();
        updatePreviousButtonStatus();
    }
    
    private static void updatePreviousButtonStatus() {
        if (currentTest.hasPrevious(questionsIndex)) {
            previousButton.setEnabled(true);
        } else {
            previousButton.setEnabled(false);
        }
    }
    
    private static void updateNextButtonStatus() {
        if (currentTest.hasNext(questionsIndex)) {
            nextButton.setEnabled(true);
        } else {
            nextButton.setEnabled(false);
        }
    }
    
    private static void updateRemoveButtonStatus() {
        if (anotherQuestionExist()) {
            removeButton.setEnabled(true);
        } else {
            removeButton.setEnabled(false);
        }
    }
    
    private static boolean anotherQuestionExist() {
        boolean debug1 = currentTest.hasPrevious(questionsIndex);
        return currentTest.hasPrevious(questionsIndex) || currentTest.hasNext(questionsIndex);
    }
    
    public static void main(String[] args) {
        
        initStartUpWindow();
    }
}
