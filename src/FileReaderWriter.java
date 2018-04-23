/*
  Nom: Vincent Dansereau
  Code Permanent: DANV03049005
 
  Nom: Mathieu Tremblay-Gravel
  Code Permanent: TREM13079501
 
  Cours: INF1120
  Professeur: Mélanie Lord
 
  Travail: TP3
 */
import java.io.*;

public class FileReaderWriter {
    
    private final static String FILE_NAME = "tests.txt";

    public static String read() {
        String fileContent;
        BufferedReader testsFile;
        try {
            testsFile = createFileReader();
            fileContent = read(testsFile);
            testsFile.close();
        } catch (Exception e) {
            fileContent = "";
        }
        return fileContent;
    }
    
    public static void write(String fileContent) {
        PrintWriter file = createPrintWriter();
        file.print(fileContent);
        file.close();
    }
    
    private static String read(BufferedReader testsFile) throws
                                                         IOException {
        StringBuilder fileContent = new StringBuilder();
        fileContent.append("\n");
        while (testsFile.ready()) {
            fileContent.append(testsFile.readLine().trim()).append("\n");
        }
        return fileContent.toString();
    }
    
    private static PrintWriter createPrintWriter() {
        try {
            return new PrintWriter(new FileWriter(FILE_NAME));
        } catch (IOException e) {
            return null;
        }
    }
    
    
    private static BufferedReader createFileReader () throws IOException {
        BufferedReader reader = null;
        Boolean readerCreated = false;
        while (!readerCreated){
            try {
                reader = new BufferedReader(new FileReader(FILE_NAME));
                readerCreated = true;
            } catch (IOException e) {
                    File fichierTests = new File(FILE_NAME);
                    readerCreated = fichierTests.createNewFile();
            }
        }
        return reader;
    }
    
    
}