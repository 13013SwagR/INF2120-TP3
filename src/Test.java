import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questionsList = new ArrayList<Question>();
    private String testName;
    
    public Test(String testName, ArrayList<Question> questionsList) {
        this.testName = testName;
        this.questionsList = questionsList;
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