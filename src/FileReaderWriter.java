import java.io.*;


public class FileReaderWriter {
    
    private final static String FILE_NAME = "tests2.txt";
    
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
    
    public static BufferedReader createFileReader()  {
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