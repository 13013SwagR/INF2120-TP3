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
            testsFile = reader;
            StringBuilder fileContent1 = new StringBuilder();
            fileContent1.append("\n");
            while (testsFile.ready()) {
                fileContent1.append(testsFile.readLine().trim()).append("\n");
            }
            fileContent = fileContent1.toString();
            testsFile.close();
        } catch (Exception e) {
            fileContent = "";
        }
        return fileContent;
    }
    
    public static void write(String fileContent) {
        PrintWriter result;
        try {
            result = new PrintWriter(new FileWriter(FILE_NAME));
        } catch (IOException e) {
            result = null;
        }
        PrintWriter file = result;
        file.print(fileContent);
        file.close();
    }
    
    
}