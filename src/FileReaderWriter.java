import java.io.*;
import java.util.ArrayList;


public class FileReaderWriter {
    
    private final static String FILE_NAME = "tests.txt";

    public static String getFileName() {
        return FILE_NAME;
    }
    public static void printTest(Test test){
        String SPACING = "-----";
        String SQUARE = "<>";
        ArrayList<Question> currentTestQuestions = test.getQuestionsList();
        String testWriter = test.getTestName() + test.getNumberOfQuestions(currentTestQuestions);

        for(Question q : currentTestQuestions){
            testWriter += SPACING + q.getQuestionStatement()
                    + SPACING + q.getAnswerOption1()
                    + SQUARE + q.getAnswerOption2()
                    + SQUARE + q.getAnswerOption3()
                    + SQUARE + q.getAnswerOption4()
                    + SPACING + q.getGoodAnswerNumber();
        }
        testWriter += "=====";

    }

    public static String read() {
        String fileContent;
        BufferedReader testsFile;
        try {
            testsFile = createFileReader();
            fileContent = read(testsFile);
            testsFile.close();
        } catch (IOException e) {
            fileContent = "";
        }
        return fileContent;
    }
    
    public static boolean write(String fileContent) {
        PrintWriter file = createPrintWriter();
        if (isFileEmpty(file)) {
            return false;
        }
        file.println(fileContent);
        file.close();
        return true;
    }
    
    private static String read(BufferedReader testsFile) throws
                                                         IOException {
        StringBuilder fileContent = new StringBuilder();
        fileContent.append("\n");
        while (testsFile.ready()) {
            fileContent.append(testsFile.readLine().trim() + "\n");
        }
        return fileContent.toString();
    }
    
    private static boolean isFileEmpty(PrintWriter file) {
        return file == null;
    }
    
    private static PrintWriter createPrintWriter() {
        try {
            return new PrintWriter(new FileWriter(FILE_NAME));
        } catch (IOException e) {
            return null;
        }
    }
    
    private static BufferedReader createFileReader()  {
        BufferedReader reader = null;
        Boolean readerCreated = false;
        while (!readerCreated){
            try {
                reader = new BufferedReader(new FileReader(FILE_NAME));
                readerCreated = true;

            } catch (IOException e) {
                try {
                    File fichierTests = new File(FILE_NAME);
                    readerCreated = fichierTests.createNewFile();
                }catch(IOException x){
                    //TODO popUp file not created
                }

            }
        }
        return reader;
    }
    
    
}