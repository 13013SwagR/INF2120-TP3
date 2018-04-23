import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questionsList = new ArrayList<Question>();
    private String testName;

    public int getNumberOfQuestions(ArrayList<Question> questions){
        return questions.size();
    }
    
    public Test() {
    }
    
    public boolean isComplete() {
        boolean result = true;
        for (Question question : questionsList) {
            result = result && question.isQuestionComplete();
        }
        return result && hasAName();
    }
    
    private boolean hasAName() {
        return testName != null && testName.length() > 0;
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
        
        return hasMoreThanNQuestion(questionIndex);
    }
    
    public boolean hasPrevious(int questionIndex) {
        return hasMoreThanNQuestion(0) && !isFirstQuestion(questionIndex);
    }
    
    private boolean hasMoreThanNQuestion(int n) {
        return questionsList.size() > n;
    }
    
    private boolean isFirstQuestion(int questionIndex) {
        return 0 == questionIndex - 1;
    }
    
    public Question getNextQuestion(int questionIndex) {
        return this.questionsList.get(questionIndex);
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
    
    public void setQuestionsList(ArrayList<Question> questionsList) {
        this.questionsList = questionsList;
    }
    
    @Override
    public String toString() {
        return this.getTestName();
    }
}


