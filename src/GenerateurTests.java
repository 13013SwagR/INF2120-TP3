//import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GenerateurTests {
    private static final JLabel TEST_NAME_LABEL = new JLabel("Nom du test");
    private static final JLabel QUESTION_LABEL = new JLabel("QUESTION");
    private static final JLabel STATEMENT_LABEL = new JLabel("Énoncé");
    private static final JLabel OPTIONS_STATEMENT_LABEL = new JLabel("Choix de "
            + "réponses (cochez la bonne réponse)");
    private static final JLabel option1Label = new JLabel("1)");
    private static final JLabel option2Label = new JLabel("2)");
    private static final JLabel option3Label = new JLabel("3)");
    private static final JLabel option4Label = new JLabel("4)");
    
    private static final String TESTER = "Tester";
    private static final String CREATOR = "Creator";
    private static final String WINDOW_NAME_LABEL = "Créer un test";
    
    private final static int TEST_CREATOR_WINDOW_WIDTH = 550;
    private final static int TEST_CREATOR_WINDOW_HEIGHT = 540;
    private final static int STARTUP_WINDOW_WIDTH = 380;
    private final static int STARTUP_WINDOW_HEIGHT = 360;
    private final static int HAUT_BOUTON = 30;
    private final static int LARGEUR_BOUTON = 250;
    
    private static int questionsIndex = 1;
    
    private static ArrayList<Test> testsList = new ArrayList<>();
    private static Question currentQuestion;
    private static Test currentTest;
    
    private static JFrame startUpWindow;
    private static JFrame testCreatorWindow;
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
    
    private static JButton correctTestButton;
    private static JButton createNewTestButton;
    private static JButton passTestButton;
    private static JButton deleteTestButton;
    private static JComboBox<String> testsListComboBox;
    private static JCheckBox boxAnswer1;
    private static JCheckBox boxAnswer2;
    private static JCheckBox boxAnswer3;
    private static JCheckBox boxAnswer4;
    private static ButtonGroup boxAnswersGroup;
    
    private static JLabel questionNumberLabel;
    private static JTextField testNameField = new JTextField();
    private static JTextField answer1Input;
    private static JTextField answer2Input;
    private static JTextField answer3Input;
    private static JTextField answer4Input;
    
    private static JTextArea questionStatementInput = new JTextArea();
    private static JScrollPane statementInputScrollPane;
    
    private static void initStartUpWindow() {
        startUpWindow = new JFrame("Générateur de tests");
        startUpWindow.setBounds(getStartupWindowPositionX(),
                getStartupWindowPositionY(), STARTUP_WINDOW_WIDTH, STARTUP_WINDOW_HEIGHT);
        startUpWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUpWindow.setResizable(false);
        startUpWindow.setLayout(null);
        
        initStartupWindowButtons();
        initTestsListComboBox();
        importTests();
        addComponentsToStartupWindow();
        
        startUpWindow.setVisible(true);
    }
    
    private static void importTests() {
        String fileContent = FileReaderWriter.read();
        
        for (String test : fileContent.split("=====")) {
            if (test.contains("-----")) {
                testsList.add(importTest(test));
            }
        }
        updateTestListComboBox();
    }
    
    private static Test importTest(String test) {
        Test importingTest = new Test();
        int sectionIndex;
        int amountOfQuestions;
        
        String[] testSections = test.split("-----");
        importingTest.setTestName(testSections[0].split("\n")[1]);
        amountOfQuestions = Integer.parseInt(testSections[0].split("\n")[2]);
        
        for (int questionNumber = 1; questionNumber <= amountOfQuestions; questionNumber++) {
            sectionIndex = (questionNumber * 3) - 3;
            importingTest.save(importQuestion(
                    testSections[sectionIndex + 1],
                    testSections[sectionIndex + 2],
                    testSections[sectionIndex + 3], questionNumber));
        }
        return importingTest;
    }
    
    private static Question importQuestion(String questionStatement, String questionAnswerOptions,
                                           String questionAnswer, int questionNumber) {
        
        Question importingQuestion = new Question(questionNumber);
        
        importingQuestion.setQuestionStatement(questionStatement);
        
        importingQuestion = importQuestionAnswerOptions(importingQuestion, questionAnswerOptions);
        
        importingQuestion = importQuestionAnswer(importingQuestion, questionAnswer);
        
        return importingQuestion;
    }
    
    private static Question importQuestionAnswerOptions(Question importingQuestion, String
            questionAnswerOptions) {
        String[] questionAnswers;
        questionAnswers = questionAnswerOptions.split("<>");
        importingQuestion.setAnswerOptions(questionAnswers[0], questionAnswers[1],
                questionAnswers[2], questionAnswers[3]);
        return importingQuestion;
    }
    
    private static Question importQuestionAnswer(Question importingQuestion, String questionSection) {
        switch (questionSection) {
            case "0":
                importingQuestion.setAnswers(true, false, false, false);
                break;
            case "1":
                importingQuestion.setAnswers(false, true, false, false);
                break;
            case "2":
                importingQuestion.setAnswers(false, false, true, false);
                break;
            case "3":
                importingQuestion.setAnswers(false, false, false, true);
        }
        return importingQuestion;
    }
    
    private static void createNewTestButtonListener() {
        ActionListener createNewTestButtonListener = e -> initTestCreatorWindow();
        createNewTestButton.addActionListener(createNewTestButtonListener);
    }
    
    private static void addComponentsToStartupWindow() {
        startUpWindow.getContentPane().add(createNewTestButton);
        startUpWindow.getContentPane().add(passTestButton);
        startUpWindow.getContentPane().add(deleteTestButton);
        startUpWindow.getContentPane().add(createStartUpWindowBlackLine());
        startUpWindow.getContentPane().add(testsListComboBox);
    }
    
    private static void initStartupWindowButtons() {
        createNewTestButton = createStandardJButton("Créer un nouveau test", 150);
        createNewTestButtonListener();
        passTestButton = createStandardJButton("Passer le test sélectionné", -30);
        initPassTestButtonListener();
        deleteTestButton = createStandardJButton("Supprimer le test sélectionné", -80);
        initDeleteTestButtonListener();
    }
    
    private static void initDeleteTestButtonListener() {
        ActionListener deleteTestButtonListener = e -> {
            Object selectedTest;
            if (testsList.isEmpty()) {
                // TODO Error message
            } else {
                selectedTest = testsListComboBox.getSelectedItem();
                testsListComboBox.removeItem(selectedTest);
                testsList.remove(getTestWithTestName(selectedTest.toString()));
            }
        };
        deleteTestButton.addActionListener(deleteTestButtonListener);
    }
    
    private static Test getTestWithTestName(String testName) {
        Test matchingTest = null;
        for (Test test : testsList) {
            if (test.getTestName().equals(testName)) {
                matchingTest = test;
            }
        }
        return matchingTest;
    }
    
    private static void initPassTestButtonListener() {
        ActionListener passTestButtonListener = e -> {
            Object selectedTest;
            if (testsList.isEmpty()) {
                // TODO Error message
            } else {
                selectedTest = testsListComboBox.getSelectedItem();
                currentTest = getTestWithTestName(selectedTest.toString());
                currentQuestion = currentTest.getQuestionsList().get(0);
                initTesterWindow();
            }
        };
        passTestButton.addActionListener(passTestButtonListener);
    }
    
    private static void initTestsListComboBox() {
        testsListComboBox = new JComboBox<>();
        updateTestListComboBox();
        testsListComboBox.setEnabled(true);
        testsListComboBox.setBounds(
                (startUpWindow.getWidth() - LARGEUR_BOUTON) / 2,
                (startUpWindow.getHeight() / 2) - 40,
                LARGEUR_BOUTON,
                HAUT_BOUTON - 10);
    }
    
    private static void updateTestListComboBox() {
        for (Test test : testsList) {
            testsListComboBox.addItem(test.toString());
            testsListComboBox.setSelectedItem(test);
        }
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
        currentQuestion = new Question(questionsIndex);
        currentTest = new Test();
        
        testCreatorWindow = new JFrame(WINDOW_NAME_LABEL);
        testCreatorWindow.setSize(TEST_CREATOR_WINDOW_WIDTH, TEST_CREATOR_WINDOW_HEIGHT);
        testCreatorWindow.setLocation(getTestCreatorWindowPositionX(), getTestCreatorWindowPositionY());
        testCreatorWindow.setResizable(false);
        testCreatorWindow.setLayout(null);
        testCreatorWindow.setVisible(true);
        
        initHeaderPanel(CREATOR);
        initCenterPanel(CREATOR);
        initFooterPanel(CREATOR);
        
        addComponentsToTestCreatorWindow(CREATOR);
    }
    
    
    private static int getTestCreatorWindowPositionY() {
        return (int) ((getScreenHeight() / 2) - (TEST_CREATOR_WINDOW_HEIGHT
                / 2));
    }
    
    private static int getTestCreatorWindowPositionX() {
        return (int) ((getScreenWidth() / 2) - (TEST_CREATOR_WINDOW_WIDTH / 2));
    }
    
    private static void addComponentsToTestCreatorWindow(String user) {
        mainButtonsPanel.add(previousButton);
        if (user.equals(CREATOR)) {
            saveButtonPanel.add(saveButton);
            mainButtonsPanel.add(addButton);
            mainButtonsPanel.add(removeButton);
        } else {
            saveButtonPanel.add(correctTestButton);
        }
        mainButtonsPanel.add(nextButton);
        
        headerPanel.add(TEST_NAME_LABEL);
        headerPanel.add(testNameField);
        
        questionDataPanel.add(STATEMENT_LABEL);
        questionDataPanel.add(OPTIONS_STATEMENT_LABEL);
        
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
        
        questionIdPanel.add(QUESTION_LABEL);
        questionIdPanel.add(questionNumberLabel);
        
        centerPanel.add(questionIdPanel);
        centerPanel.add(questionDataPanel);
        
        testCreatorWindow.add(headerPanel);
        testCreatorWindow.add(centerPanel);
        
        footerPanel.add(mainButtonsPanel);
        footerPanel.add(saveButtonPanel);
        
        testCreatorWindow.getContentPane().add(footerPanel);
    }
    
    private static void initCenterPanel(String user) {
        centerPanel = new JPanel(null);
        centerPanel.setSize(510, 330);
        centerPanel.setLocation(18, 75);
        
        initQuestionIdPanel(user);
        initQuestionDataPanel(user);
    }
    
    private static void initHeaderPanel(String user) {
        headerPanel = new JPanel(null);
        headerPanel.setSize(510, 35);
        headerPanel.setLocation(18, (30));
        
        TEST_NAME_LABEL.setBounds(0, 0, 90, 30);
        
        
        testNameField.setBounds(95, 5, 415, 20);
        testNameField.setBackground(Color.WHITE);
        if (user.equals(TESTER)) {
            testNameField.setEnabled(false);
            testNameField.setText(currentTest.getTestName());
            testNameField.setDisabledTextColor(Color.BLACK);
        }
    }
    
    private static void initQuestionIdPanel(String user) {
        questionIdPanel = new JPanel(null);
        questionIdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        questionIdPanel.setSize(510, 40);
        questionIdPanel.setLocation(0, 0);
        
        QUESTION_LABEL.setLocation(10, 0);
        QUESTION_LABEL.setSize(90, 30);
        
        questionNumberLabel = new JLabel(Integer.toString(questionsIndex));
        questionNumberLabel.setSize(10, 30);
        questionNumberLabel.setLocation(90, 0);
        if (user.equals(TESTER)) {
            questionNumberLabel.setText(Integer.toString(currentQuestion.getQuestionNumber()));
        }
    }
    
    private static void initQuestionDataPanel(String user) {
        questionDataPanel = new JPanel(null);
        questionDataPanel.setSize(510, 290);
        questionDataPanel.setLocation(0, 39);
        questionDataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        STATEMENT_LABEL.setSize(90, 30);
        STATEMENT_LABEL.setLocation(20, 0);
        
        questionStatementInput.setSize(480, 50);
        questionStatementInput.setLocation(20, 25);
        questionStatementInput.setLineWrap(true);
        questionStatementInput.setWrapStyleWord(true);
        
        statementInputScrollPane = new JScrollPane(questionStatementInput);
        statementInputScrollPane.setSize(480, 50);
        statementInputScrollPane.setLocation(20, 25);
        statementInputScrollPane.setVerticalScrollBarPolicy(JScrollPane
                .VERTICAL_SCROLLBAR_AS_NEEDED);
        if (user.equals(TESTER)) {
            questionStatementInput.setEnabled(false);
            questionStatementInput.setText(currentQuestion.getQuestionStatement());
            questionStatementInput.setDisabledTextColor(Color.BLACK);
        }
        
        OPTIONS_STATEMENT_LABEL.setSize(420, 30);
        OPTIONS_STATEMENT_LABEL.setLocation(20, 90);
        
        initOptions(user);
    }
    
    private static void initOptions(String user) {
        option1Label.setSize(40, 30);
        option1Label.setLocation(20, 130);
        answer1Input = new JTextField();
        answer1Input.setSize(380, 20);
        answer1Input.setLocation(50, 137);
        boxAnswer1 = new JCheckBox();
        boxAnswer1.setLocation(440, 130);
        boxAnswer1.setSize(30, 30);
        
        option2Label.setSize(40, 30);
        option2Label.setLocation(20, 160);
        answer2Input = new JTextField();
        answer2Input.setSize(380, 20);
        answer2Input.setLocation(50, 167);
        boxAnswer2 = new JCheckBox();
        boxAnswer2.setLocation(440, 160);
        boxAnswer2.setSize(30, 30);
        
        option3Label.setSize(40, 30);
        option3Label.setLocation(20, 190);
        answer3Input = new JTextField();
        answer3Input.setSize(380, 20);
        answer3Input.setLocation(50, 197);
        boxAnswer3 = new JCheckBox();
        boxAnswer3.setLocation(440, 190);
        boxAnswer3.setSize(30, 30);
    
        option4Label.setSize(40, 30);
        option4Label.setLocation(20, 220);
        answer4Input = new JTextField();
        answer4Input.setSize(380, 20);
        answer4Input.setLocation(50, 227);
        boxAnswer4 = new JCheckBox();
        boxAnswer4.setLocation(440, 220);
        boxAnswer4.setSize(30, 30);
        if (user.equals(TESTER)) {
            answer1Input.setEnabled(false);
            answer1Input.setText(currentQuestion.getAnswerOption1());
            answer1Input.setDisabledTextColor(Color.BLACK);
            answer2Input.setEnabled(false);
            answer2Input.setText(currentQuestion.getAnswerOption2());
            answer2Input.setDisabledTextColor(Color.BLACK);
            answer3Input.setEnabled(false);
            answer3Input.setText(currentQuestion.getAnswerOption3());
            answer3Input.setDisabledTextColor(Color.BLACK);
            answer4Input.setEnabled(false);
            answer4Input.setText(currentQuestion.getAnswerOption4());
            answer4Input.setDisabledTextColor(Color.BLACK);
        }
        boxAnswersGroup = new ButtonGroup();
        boxAnswersGroup.add(boxAnswer1);
        boxAnswersGroup.add(boxAnswer2);
        boxAnswersGroup.add(boxAnswer3);
        boxAnswersGroup.add(boxAnswer4);
    }
    
    private static void initFooterPanel(String user) {
        footerPanel = new JPanel(null);
        footerPanel.setSize(510, 90);
        footerPanel.setLocation(18, 420);
        
        initMainButtonsPanel(user);
        initSaveButtonPanel(user);
    }
    
    private static void initMainButtonsPanel(String user) {
        if (user.equals(CREATOR)) {
            addButton = new JButton("+");
            initAddButtonListener();
            removeButton = new JButton("-");
            removeButton.setEnabled(false);
            initRemoveButtonListener();
            mainButtonsPanel = new JPanel(new GridLayout(0, 4, 20, 0));
            mainButtonsPanel.setLocation(90, 0);
            mainButtonsPanel.setSize(330, 15);
        } else {
            mainButtonsPanel = new JPanel(new GridLayout(0, 2, 20, 0));
            mainButtonsPanel.setLocation(172, 0);
            mainButtonsPanel.setSize(165, 15);
        }
        previousButton = new JButton("<");
        previousButton.setEnabled(false);
        initPreviousButtonListener(user);
        
        nextButton = new JButton(">");
        nextButton.setEnabled(false);
        initNextButtonListener(user);
    }
    
    private static void initRemoveButtonListener() {
        ActionListener removeButtonListener = e -> {
            if (anotherQuestionExist()) {
                Question questionToRemove = currentQuestion;
                setExistingQuestion();
                currentTest.removeQuestion(questionToRemove);
                System.out.print(questionsIndex);
                updateButtonsStatus();
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
    
    private static void initAddButtonListener() {
        ActionListener addButtonListener = e -> {
            if (currentQuestion.isQuestionComplete()) {
                if (isQuestionComplete()) {
                    saveCurrentQuestion();
                    questionsIndex++;
                    resetQuestionForm();
                    currentQuestion = new Question(questionsIndex);
                    updateButtonsStatus();
                }
            } else {
                // TODO Error message
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
        return !answer1Input.getText().equals("")
                && !answer2Input.getText().equals("")
                && !answer3Input.getText().equals("")
                && !answer4Input.getText().equals("");
    }
    
    private static boolean isTheQuestionWritten() {
        return !questionStatementInput.getText().equals("");
    }
    
    private static boolean isACheckBoxSelected() {
        return boxAnswer1.isSelected() || boxAnswer2.isSelected() ||
                boxAnswer3.isSelected() || boxAnswer4.isSelected();
    }
    
    private static void saveCurrentQuestion() {
        currentQuestion.setQuestionStatement(questionStatementInput.getText());
        currentQuestion.setAnswerOptions(answer1Input.getText(),
                answer2Input.getText(), answer3Input.getText(),
                answer4Input.getText());
        currentQuestion.setAnswers(boxAnswer1.isSelected(),
                boxAnswer2.isSelected(),
                boxAnswer3.isSelected(),
                boxAnswer4.isSelected());
        currentTest.save(currentQuestion);
    }
    
    private static void initNextButtonListener(String user) {
        ActionListener nextButtonListener = e -> {
            if (currentQuestion.isQuestionComplete()) {
                if (user.equals(CREATOR)) {
                    saveCurrentQuestion();
                } else {
                    saveCurrentAnswer();
                }
                setNextQuestion();
                updateButtonsStatus();
            } else {
                // TODO Error message
            }
        };
        nextButton.addActionListener(nextButtonListener);
    }
    
    private static void initPreviousButtonListener(String user) {
        ActionListener previousButtonListener = e -> {
            if (currentQuestion.isQuestionComplete()) {
                if (user.equals(CREATOR)) {
                    saveCurrentQuestion();
                } else {
                    saveCurrentAnswer();
                }
                setPreviousQuestion();
                updateButtonsStatus();
            } else {
                // TODO Error message
            }
        };
        previousButton.addActionListener(previousButtonListener);
    }
    
    private static void initSaveButtonPanel(String user) {
        saveButtonPanel = new JPanel(null);
        saveButtonPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        saveButtonPanel.setSize(510, 60);
        saveButtonPanel.setLocation(0, 25);
        saveButtonPanel.setVisible(true);
        
        if (user.equals(CREATOR)) {
            saveButton = new JButton("Sauvegarder le test");
            saveButton.setSize(200, 20);
            saveButton.setLocation((510 - 200) / 2, 20);
            initSaveButtonListener();
        } else if (user.equals(TESTER)) {
            correctTestButton = new JButton("Corriger le test");
            correctTestButton.setSize(200, 20);
            correctTestButton.setLocation((510 - 200) / 2, 20);
            initCorrectTestButtonListener();
        }
    }
    
    private static void initCorrectTestButtonListener() {
        ActionListener correctTestButtonListener = e -> {
            saveCurrentAnswer();
            correctTest();
        };
        correctTestButton.addActionListener(correctTestButtonListener);
        
    }
    
    private static String findTesterAnswer() {
        String answer = "0";
        if (boxAnswer1.isSelected()) {
            answer = "1";
        } else if (boxAnswer2.isSelected()) {
            answer = "1";
        } else if (boxAnswer3.isSelected()) {
            answer = "1";
        } else if (boxAnswer4.isSelected()) {
            answer = "1";
        }
        return answer;
    }
    
    private static void correctTest() {
        // TODO
    }
    
    private static void saveCurrentAnswer() {
        currentQuestion.setTesterAnswer(findTesterAnswer());
    }
    
    private static void initSaveButtonListener() {
        ActionListener saveButtonListener = e -> {
            if (currentTest.isComplete()) {
                if (currentQuestion.isQuestionComplete()) {
                    saveCurrentQuestion();
                    
                    currentTest.setTestName(testNameField.getText());
                    
                    testsList.add(currentTest);
                    updateTestListComboBox();
                } else {
                    // TODO Error question is invalid
                }
            } else {
                // TODO Error testName is invalid
            }
            
        };
        saveButton.addActionListener(saveButtonListener);
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
        return currentTest.hasPrevious(questionsIndex)
                || currentTest.hasNext(questionsIndex);
    }
    
    private static void initTesterWindow() {
        testCreatorWindow = new JFrame(WINDOW_NAME_LABEL);
        testCreatorWindow.setSize(TEST_CREATOR_WINDOW_WIDTH, TEST_CREATOR_WINDOW_HEIGHT);
        testCreatorWindow.setLocation(getTestCreatorWindowPositionX(), getTestCreatorWindowPositionY());
        testCreatorWindow.setResizable(false);
        testCreatorWindow.setLayout(null);
        testCreatorWindow.setVisible(true);
        
        initHeaderPanel(TESTER);
        initCenterPanel(TESTER);
        initFooterPanel(TESTER);
        
        addComponentsToTestCreatorWindow(TESTER);
    }
    
    public static void main(String[] args) {
        
        initStartUpWindow();
    }
}
