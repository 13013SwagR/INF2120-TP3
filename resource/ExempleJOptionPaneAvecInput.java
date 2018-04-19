import javax.swing.JOptionPane;

/**
 * Cette classe un exemple de l'utilisation d'une fenetre surgissante JOptionPane
 * pour demander de l'information a l'utilisateur dans un champ texte.
 *
 * @author Melanie Lord
 * @version novembre 2013
 */
public class ExempleJOptionPaneAvecInput {

    //On utilise ici la methode de classe showInputDialog de JOptionPane,
    //avec 2 arguments. Les parametres sont les suivants :

    //1er param : la fenetre (JFrame) par-dessus laquelle on veut que la fenetre
    //            surgissante apparaisse (la fenetre surgissante est centree).
    //            Dans le cas de ces exemples, il n'y a pas de fenetre (JFrame)
    //            donc on donne la valeur null a ce parametre
    //2e  param : le message (associe au champ texte) a afficher dans la fenetre
    //            surgissante.
    //
    //NOTES : d'autres versions de cette methode (avec plus d'arguments) sont aussi
    //disponibles.


    public static void main (String [] args)  {
        String texteSaisi;

        //retourne null si l'option annuler est choisie ou si la fenetre est fermee
        //(peu importe le texte dans le chammp texte)
        //OU
        //retourne le texte qui est dans le champ texte, au clic du bonton OK,
        texteSaisi = JOptionPane.showInputDialog(null, "Nom : ");

        //affiche le texte saisi
        JOptionPane.showMessageDialog(null, texteSaisi);
    }
}
