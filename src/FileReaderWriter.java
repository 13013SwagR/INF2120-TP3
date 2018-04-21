import java.io.*;
import java.util.Locale;


public class FileReaderWriter {
    public final static String testsFileName = "tests.txt";
    
    public static  String FileReaderWriter() {
         BufferedReader testsFileInput;
         PrintWriter out;
         String ligne1Produits;
         String ligne2Produits;
        double prix = 0;
        double prixReduit;
        try {    //ouvrir les flux (lecture et ecriture)
            testsFileInput = new BufferedReader(new FileReader(testsFileName));  //Creer un objet FileReader
            out = new PrintWriter(new FileWriter(testsFileName));
            //On suppose que les fichiers en lecture sont bien formes.
            while (testsFileInput.ready()) {     //ecrire la ligne lue dans le fichier de copie
                ligne1Produits = testsFileInput.readLine().trim();
                ligne2Produits = testsFileInput.readLine().trim();
                try {
                    prix = Double.parseDouble(ligne2Produits);
                } catch (NumberFormatException nfe) {
                    rabais = 0; //si erreur format, on n'accorde aucun rabais
                }
                if (rabais
                        > 0) {  //on n'ecrit que les produits avec rabais (> 0)
                    prixReduit = prix - prix * rabais / 100;
                    out.println(ligne1Produits);
                    out.printf(Locale.ENGLISH, "%-1.2f\n", prixReduit); //ou simplement utiliser un println ici.
                }
            }
            testsFileInput.close(); //fermer les flux
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("le fichier ne peut etre lu.");
        } catch (IOException e) {
            System.out.println("Erreur d'entree / sortie.");
        } finally {
//close everything.
        }
    }
    
    
}