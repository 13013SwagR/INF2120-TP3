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
    
    public int getQuestionNumber() {
        return questionNumber;
    }
    
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }
    
    public boolean isQuestionComplete() {
        return isAnswerOptionsComplete() && isAnswerSelected() && isQuestionStatementFilled();
    }
    
    private boolean isQuestionStatementFilled() {
        return this.questionStatement.length() > 0;
    }
    
    private boolean isAnswerSelected() {
        return answer1 || answer2 || answer3 || answer4;
    }
    
    private boolean isAnswerOptionsComplete() {
        return answerOption1.length() > 0 &&
                answerOption2.length() > 0 &&
                answerOption3.length() > 0 && answerOption4.length() > 0;
    }
}

