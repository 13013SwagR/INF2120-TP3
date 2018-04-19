import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class FileWriter {
    private Tester writable;
    public static final String OUTPUT_PATH = "";
    private PrintStream out;
    
    public static void writeFile(Tester writable) {
        FileWriter fileWriter = new FileWriter(writable);
        
        fileWriter.print();
        fileWriter.closes();
    }
    
    private FileWriter(Tester writable) {
        this.writable = writable;
        if (!new File(OUTPUT_PATH).exists()) {
            if (createOutputFile()) {
                return;
            }
        }
        String filePath = OUTPUT_PATH + writable.getFileName();
        try {
            out = new PrintStream(new FileOutputStream(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found: " + filePath);
        }
    }
    
    private static boolean createOutputFile() {
        boolean success = true;
        File theDir = new File(OUTPUT_PATH);
        try {
            theDir.mkdir();
        } catch (SecurityException se) {
            System.out.println("Cannot create output dir name: " + OUTPUT_PATH);
            success = false;
        }
        
        return success;
    }
    
    
    private void print() {
        if (out != null) {
            out.print(writable.getContents());
        }
    }
    
    private void closes() {
        System.setOut(System.out);
    }
}