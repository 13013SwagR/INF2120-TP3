import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questionsList = new ArrayList<Question>();
    private String testName;
    
    public Test(String testName) {
        this.testName = testName;
    }
    
    public boolean hasAName() {
        return testName.replaceAll(" ", "").length() > 0
                && testName.replaceAll(" ", "").length() < 50;
    }
    
    public void save(Question question) {
        if (isAQuestion(question)) {
            int questionIndex = this.questionsList.indexOf(question);
            this.questionsList.set(questionIndex, question);
        } else {
            this.questionsList.add(question);
        }
    }
    
    public void removeQuestion(Question question) {
        this.questionsList.remove(question);
    }
    
    public boolean isAQuestion(Question question) {
        return this.questionsList.contains(question);
    }
    
    public boolean hasNext(int questionIndex) {
        
        return hasMoreThanNQuestion(questionIndex + 1);
    }
    
    public boolean hasPrevious(int questionIndex) {
        return hasMoreThanNQuestion(0) && !isFirstQuestion(questionIndex);
    }
    
    private boolean hasMoreThanNQuestion(int n) {
        return questionsList.size() > n;
    }
    
    private boolean isFirstQuestion(int questionIndex) {
        return 0 == questionIndex;
    }
    
    public Question getNextQuestion(int questionIndex) {
        return this.questionsList.get(questionIndex + 1);
    }
    
    public Question getPreviousQuestion(int questionIndex) {
        return this.questionsList.get(questionIndex - 1);
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
    
    public void resetQuestionsNumber() {
        for (Question question : this.questionsList) {
            question.setQuestionNumber(this.questionsList.indexOf(question));
        }
    }
    
    public void addQuestion(Question question, int questionNumber) {
        this.questionsList.add(questionNumber, question);
    }
    
    @Override
    public String toString() {
        return this.getTestName();
    }
}


