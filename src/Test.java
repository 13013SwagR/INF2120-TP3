import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questionsList = new ArrayList<Question>();
    private String testName;
    
    public Test() {}
    
    public void addQuestion(Question question) {
        this.questionsList.add(question);
    }
    public String getTestName() {
        return testName;
    }
    
    public void setTestName(String testName) {
        this.testName = testName;
    }
    
    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }
    
    public void setQuestionsList(ArrayList<Question> questionsList) {
        this.questionsList = questionsList;
    }
}