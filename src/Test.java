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

/**
 * Classe Test: permet de créer un nouveau questionnaire qui sera ajouté
 * à la liste des autrees questionnaires déjà créés.
 *  questionsList: ArrayList regroupant l'ensemble des questions du test
 *  testName: le nom du test
 */
public class Test {
    private ArrayList<Question> questionsList = new ArrayList<>();
    private String testName;

    /**
     * Retourne le nombre de questions se trouvant dans le test
     * @return
     */
    public int getNumberOfQuestions() {
        return this.questionsList.size();
    }

    /**
     * Retourne si oui on non l'utilisateur a repondu a toute les questions du test
     * @return
     */
    public boolean allQuestionsAreAnswered() {
        boolean result = true;
        for (Question question : this.questionsList) {
            result = result && (!question.getTesterAnswer().equals("9"));
        }
        return result;
    }

    /**
     * Initialise le nom du test
     * @param testName
     */
    public Test(String testName) {
        this.testName = testName;
    }

    /**
     * Confirme si le test a un nom
     * @return
     */
    public boolean hasAName() {
        return testName.replaceAll(" ", "").length() > 0
                && testName.replaceAll(" ", "").length() < 50;
    }

    /**
     * sauvegarde la question modifie si elle existait deja ou l'ajoute si elle n'etait pas deja
     * contenu dans le test
     * @param question
     */
    public void save(Question question) {
        if (isAQuestion(question)) {
            int questionIndex = this.questionsList.indexOf(question);
            this.questionsList.set(questionIndex, question);
        } else {
            this.questionsList.add(question);
        }
    }

    /**
     * supprime un question du test
     * @param question
     */
    public void removeQuestion(Question question) {
        this.questionsList.remove(question);
    }

    /**
     * confirme si la question passe en parametre est presente dans le test
     * @param question
     * @return
     */
    private boolean isAQuestion(Question question) {
        return this.questionsList.contains(question);
    }

    /**
     * permet de sovoir si la question est le derniere du test ou non
     * @param questionIndex
     * @return
     */
    public boolean hasNext(int questionIndex) {
        
        return hasMoreThanNQuestion(questionIndex + 1);
    }

    /**
     * permet de soavoir la question a l'index est la premiere de la liste
     * @param questionIndex
     * @return
     */
    public boolean hasPrevious(int questionIndex) {
        return hasMoreThanNQuestion(0) && !isFirstQuestion(questionIndex);
    }

    /**
     * permet de savoir si le test possede plus de question que l'entier en parametre
     * @param n
     * @return
     */
    private boolean hasMoreThanNQuestion(int n) {
        return questionsList.size() > n;
    }

    /**
     * permet de savoir si la question est la premiere du test
     * @param questionIndex
     * @return
     */
    private boolean isFirstQuestion(int questionIndex) {
        return 0 == questionIndex;
    }

    /**
     * retourne la question suivante
     * @param questionIndex
     * @return
     */
    public Question getNextQuestion(int questionIndex) {
        return this.questionsList.get(questionIndex + 1);
    }

    /**
     * retourne la question precedente
     * @param questionIndex
     * @return
     */
    public Question getPreviousQuestion(int questionIndex) {
        return this.questionsList.get(questionIndex - 1);
    }

    /**
     * retourne le nom du test
     * @return
     */
    public String getTestName() {
        return testName;
    }

    /**
     * permet de definir le nom du test
     * @param testName
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * retourne la liste de question
     * @return
     */
    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }

    /**
     * met a jour le nombre de question presentes dans la liste
     */
    public void resetQuestionsNumber() {
        for (Question question : this.questionsList) {
            question.setQuestionNumber(this.questionsList.indexOf(question));
        }
    }

    /**
     * met a jour la reponsee donne par l'utilisateur
     */
    public void resetTesterAnswers() {
        for (Question question : this.questionsList) {
            question.setTesterAnswer("9");
        }
    }

    /**
     * ajoute une question a la liste a la position de son index
     * @param question
     * @param questionNumber
     */
    public void addQuestion(Question question, int questionNumber) {
        this.questionsList.add(questionNumber, question);
    }

    /**
     * to stringe or not to stringe
     * @return
     */
    @Override
    public String toString() {
        return this.getTestName();
    }
}


