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
import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questionsList = new ArrayList<>();
    private String testName;
    
    public int getNumberOfQuestions() {
        return this.questionsList.size();
    }
    
    public boolean allQuestionsAreAnswered() {
        boolean result = true;
        for (Question question : this.questionsList) {
            result = result && (!question.getTesterAnswer().equals("9"));
        }
        return result;
    }
    
    Test(String testName) {
        this.testName = testName;
    }
    
    public boolean hasAName() {
        return testName.replaceAll(" ", "").length() > 0
                && testName.replaceAll(" ", "").length() < 50;
    }
    
    public void save(Question question) {
        if (this.questionsList.contains(question)) {
            int questionIndex = this.questionsList.indexOf(question);
            this.questionsList.set(questionIndex, question);
        } else {
            this.questionsList.add(question);
        }
    }
    
    public void removeQuestion(Question question) {
        this.questionsList.remove(question);
    }
    
    public boolean hasNext(int questionIndex) {
        
        return hasMoreThanNQuestion(questionIndex + 1);
    }
    
    public boolean hasPrevious(int questionIndex) {
        return hasMoreThanNQuestion(0) && !(0 == questionIndex);
    }
    
    private boolean hasMoreThanNQuestion(int n) {
        return questionsList.size() > n;
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
    
    public void resetTesterAnswers() {
        for (Question question : this.questionsList) {
            question.setTesterAnswer("9");
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


