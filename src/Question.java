/*
 * Nom: Vincent Dansereau
 * Code Permanent: DANV03049005
 *
 * Nom: Mathieu Tremblay-Gravel
 * Code Permanent: TREM13079501
 *
 * Cours: INF1120
 * Professeur: Mélanie Lord
 *
 * Travail: TP3
 */

/**
 * Cette classe permet de creer des objets de types Question qui continnent des question a
 * choix multiples ainsi que la reponses a cette question
 */
public class Question {

    private int questionNumber;
    private String questionStatement;
    private String answerOption1;
    private String answerOption2;
    private String answerOption3;
    private String answerOption4;
    private boolean answer1;
    private boolean answer2;
    private boolean answer3;
    private boolean answer4;
    private String testerAnswer;

    /**
     * Constructeur
     * @param questionNumber
     */
    public Question(int questionNumber) {
        this.questionNumber = questionNumber;
        this.questionStatement = "";
        this.answerOption1 = "";
        this.answerOption2 = "";
        this.answerOption3 = "";
        this.answerOption4 = "";
        this.answer1 = false;
        this.answer2 = false;
        this.answer3 = false;
        this.answer4 = false;
        this.testerAnswer = "9";
    }

    /**
     * Methode qui retourne l'enonce de la question
     * @return
     */
    public String getQuestionStatement() {
        return questionStatement;
    }

    /**
     * Methode qui permet de modifier l'enponce de la question
     * @param questionStatement
     */
    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    /**
     * Methodes qui retourne les differentes possibilites de choix de reponse
     * @return
     */
    public String getAnswerOption1() {
        return answerOption1;
    }

    /**
     * Methode qui initialise les choix de reponses possibles
     * @param question1
     * @param question2
     * @param question3
     * @param question4
     */
    public void setAnswerOptions(String question1, String question2, String
            question3, String question4) {
        this.answerOption1 = question1;
        this.answerOption2 = question2;
        this.answerOption3 = question3;
        this.answerOption4 = question4;
    }
    
    public String getAnswerOption2() {
        return answerOption2;
    }
    
    public String getAnswerOption3() {
        return answerOption3;
    }
    
    public String getAnswerOption4() {
        return answerOption4;
    }

    /**
     * Methodes qui indique quelle est la bonne reponse (indique la boite a cocher qui correspond a la bonne reponse)
     * @return
     */
    public boolean isAnswer1() {
        return answer1;
    }

    /**
     * methode qui permet de definir quelle est la bonne reponse a l'enonce de la question
     * @param answer1
     * @param answer2
     * @param answer3
     * @param answer4
     */
    public void setAnswers(boolean answer1, boolean answer2, boolean answer3
            , boolean answer4) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }
    
    public boolean isAnswer2() {
        return answer2;
    }
    
    public boolean isAnswer3() {
        return answer3;
    }
    
    public boolean isAnswer4() {
        return answer4;
    }

    /**
     * Methode qui retourne la position  de la boite ou se trouve la bonne reponse
     * @return
     */
    public String getGoodAnswerNumber() {
        String answer = null;
        if (this.isAnswer1()) {
            answer = "0";
        } else if (this.isAnswer2()) {
            answer = "1";
        } else if (this.isAnswer3()) {
            answer = "2";
        } else if (this.isAnswer4()) {
            answer = "3";
        }
        return answer;
    }

    /**
     * Methode qui retourne index de la question dans le test
     * @return
     */
    public int getQuestionNumber() {
        return questionNumber;
    }

    /**
     * Methode qui permet de definir l'index de la question dans le test
     * @param questionNumber
     */
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    /**
     * Les methodes qui suivent permettent de de savoir si chaque champ de texte et boite reponse ont ete remplie
     * afin de s'assurer que la question est complete avant de l'enregistrer.
     * @return
     */
    public boolean isQuestionComplete() {
        return isAnswerOptionsComplete() && isAnswerSelected() && isQuestionStatementFilled();
    }
    
    public boolean isQuestionStatementFilled() {
        return questionStatement.replaceAll(" ", "").length() > 0
                && questionStatement.replaceAll(" ", "").length() < 500;
    }
    
    public boolean isAnswerSelected() {
        return answer1 || answer2 || answer3 || answer4;
    }
    
    public boolean isAnswerOptionsComplete() {
        return (answerOption1.replaceAll(" ", "").length() > 0) &&
                (answerOption2.replaceAll(" ", "").length() > 0) &&
                (answerOption3.replaceAll(" ", "").length() > 0) &&
                (answerOption4.replaceAll(" ", "").length() > 0) &&
                (answerOption1.replaceAll(" ", "").length() < 50) &&
                (answerOption2.replaceAll(" ", "").length() < 50) &&
                (answerOption3.replaceAll(" ", "").length() < 50) &&
                (answerOption4.replaceAll(" ", "").length() < 50);
    }

    /**
     * retourne la reponse donne par l'utilisateur
     * @return
     */
    public String getTesterAnswer() {
        return testerAnswer;
    }

    /**
     * Enregistre la reponse donnee par l'utilisateur
     * @param testerAnswer
     */
    public void setTesterAnswer(String testerAnswer) {
        this.testerAnswer = testerAnswer;
    }
}

