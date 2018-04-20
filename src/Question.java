import java.util.ArrayList;

public class Question {
    private String questionStatement;
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    
    public Question() {
        this.questionStatement = "";
        this.question1 = "";
        this.question2 = "";
        this.question3 = "";
        this.question4 = "";
    }
    
    public String getQuestionStatement() {
        return questionStatement;
    }
    
    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }
    
    public String getQuestion1() {
        return question1;
    }
    
    public void setQuestion1(String question1) {
        this.question1 = question1;
    }
    
    public String getQuestion2() {
        return question2;
    }
    
    public void setQuestion2(String question2) {
        this.question2 = question2;
    }
    
    public String getQuestion3() {
        return question3;
    }
    
    public void setQuestion3(String question3) {
        this.question3 = question3;
    }
    
    public String getQuestion4() {
        return question4;
    }
    
    public void setQuestion4(String question4) {
        this.question4 = question4;
    }
}
