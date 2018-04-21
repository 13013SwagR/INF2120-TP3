import java.io.*;


public class FileReaderWriter {
    
    private final static String FILE_NAME = "tests.txt";
    
    public static String read() {
        String fileContent;
        BufferedReader testsFile = null;
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
        while (testsFile.ready()) {
            fileContent.append(testsFile.readLine().trim());
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
    
    private static BufferedReader createFileReader() throws IOException {
        
        return new BufferedReader(new FileReader(FILE_NAME));
    }
    
    
}