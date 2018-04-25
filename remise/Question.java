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
    
    public String getQuestionStatement() {
        return questionStatement;
    }
    
    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }
    
    public String getAnswerOption1() {
        return answerOption1;
    }
    
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
    
    public boolean isAnswer1() {
        return answer1;
    }
    
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
    
    public int getQuestionNumber() {
        return questionNumber;
    }
    
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }
    
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
    
    public String getTesterAnswer() {
        return testerAnswer;
    }
    
    public void setTesterAnswer(String testerAnswer) {
        this.testerAnswer = testerAnswer;
    }
}

