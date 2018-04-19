import javax.swing.JOptionPane;

/**
 * Cette classe montre differents exemples de l'utilisation de fenetres
 * surgissantes JOptionPane pour demander une confirmation a l'utilisateur.
 *
 * @author Melanie Lord
 * @version novembre 2013
 */
public class ExemplesJOptionPaneAvecConfirmation {

    //On utilise ici la methode de classe showConfirmDialog de JOptionPane,
    //avec 4 arguments. Les parametres sont les suivants :

    //1er param : la fenetre (JFrame) par-dessus laquelle on veut que la fenetre
    //            surgissante apparaisse (la fenetre surgissante est centree).
    //            Dans le cas de ces exemples, il n'y a pas de fenetre (JFrame)
    //            donc on donne la valeur null a ce parametre
    //2e  param : le message a afficher dans la fenetre surgissante.
    //3e  param : le titre de la fenetre surgissante.
    //4e  param : le type d'options (YES_NO_OPTION, YES_NO_CANCEL_OPTION, ou OK_CANCEL_OPTION)

    //NOTES : d'autres versions de cette methode sont aussi disponibles.

    //La methode showConfirmDialog retourne un entier representant la reponse choisie
    //par l'utilisateur. Voici certaines constantes associees aux reponses possibles :
    //OK_OPTION : si l'utilisateur a clique le bouton OK
    //CANCEL_OPTION : si l'utilisateur a clique le bouton Annuler
    //YES_OPTION : si l'utilisateur a clique sur le bouton Oui
    //NO_OPTION : si l'utilisateur a clique sur le bouton Non


    private static void afficherOptionChoisie (int option) {

        if (option == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "L'utilisateur a choisi ANNULER");

        } else if (option == JOptionPane.YES_OPTION)  {  //YES_OPTION = OK_OPTION
            JOptionPane.showMessageDialog(null, "L'utilisateur a choisi OUI ou OK");

        } else if (option == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "L'utilisateur a choisi NON");

        } else if (option == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "L'utilisateur a choisi de fermer la fenetre");
        }
    }

    public static void main (String [] args)  {
        int option;


        //TEST 1
      /*
      option = JOptionPane.showConfirmDialog(null,
                                    "Ceci est un message avec\nles options OK / CANCEL.",
                                     "CONFIRMATION",
                                    JOptionPane.OK_CANCEL_OPTION);
      //affiche la reponse choisie
      afficherOptionChoisie(option);
      */

/*
        //TEST 2
        option = JOptionPane.showConfirmDialog(null,
                "Ceci est un message avec\nles options YES / NO.",
                "CONFIRMATION",
                JOptionPane.YES_NO_OPTION);
        //affiche la reponse choisie
        afficherOptionChoisie(option);
*/


      //TEST 3
      option = JOptionPane.showConfirmDialog(null,
                                    "Ceci est un message avec\nles options YES / NO / CANCEL.",
                                    "CONFIRMATION",
                                    JOptionPane.YES_NO_CANCEL_OPTION);
      //affiche la reponse choisie
      afficherOptionChoisie(option);



    }




}
