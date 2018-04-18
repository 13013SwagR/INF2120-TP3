import javax.swing.*;

public class TestCreator {
    public JFrame testCreatorWindow;
    public JButton previousButton;
    public JButton nextButton;
    public JButton addButton;
    public JButton removeButton;
    public JButton saveButton;
    
    // TODO: Créer une fenêtre.
    
    public TestCreator () {
        this.testCreatorWindow  = new JFrame("Fenêtre de création de testes");
        this.testCreatorWindow.setSize(380, 360);
    
        this.previousButton = new JButton("<");
        this.nextButton = new JButton(">");
        this.addButton = new JButton("+");
        this.removeButton = new JButton("-");
        this.saveButton = new JButton("Sauvegarder le test");
    }
    
    
    
    /** TODO: Bouton [ < ] :
    Ce bouton sert à revenir à la question qui précède la question courante. Il doit être désactivé
    lorsque la question courante est la première question de ce test.
    
    Lorsqu’on clique sur ce bouton (s’il est actif) :
            1) Si les champs de la question courante sont valides, on affiche la question précédente.
            2) Si les champs de la question courante sont invalides, on affiche un message d’erreur
            dans une fenêtre surgissante, et la question courante reste
            inchangée.*/
    
   /** TODO:Bouton [ > ]
   Ce bouton sert à aller à la question qui suit la question courante. Il doit être désactivé lorsque
    la question courante est la dernière question de ce test.
    
    Lorsqu’on clique sur ce bouton (s’il est actif) :
             1) Si les champs de la question courante sont valides, on affiche la question suivante.
             2) Si les champs de la question courante sont invalides, on affiche un message d’erreur
             dans une fenêtre surgissante, et la question courante reste
             inchangée.*/
   
    /** TODO:Bouton [ + ]
    Ce bouton sert à ajouter une question au test courant.
    Lorsqu’on clique sur ce bouton :
            1) Si les champs de la question courante sont valides, on affiche une nouvelle question
            (dont tous les champs sont vides et les cases décochées) tout de suite après la
            question courante (le numéro de toutes les questions suivantes augmente de 1, sauf si
            la question courante était la dernière, et que dans ce cas, on ajoute à la fin).
            
            2) Si les champs de la question courante sont invalides, on affiche un message d’erreur
                dans une fenêtre surgissante, la question courante reste
                inchangée, et l’ajout est annulé.*/
    /** TODO: Bouton [ - ]
    Ce bouton sert à supprimer une question. Il doit être désactivé lorsqu’il n’y a aucune ou
    seulement une question dans le test courant.
    
    Lorsqu’on clique sur ce bouton (s’il est actif), la question courante est supprimée, et l’on affiche
    la question qui venait juste après la question supprimée. Aussi, le numéro des questions qui
    venaient après la question supprimée diminue de 1.*/
    
    /** TODO: Bouton [ Sauvegarder le test ]
    Ce bouton sert à sauvegarder le test courant.
    
    Lorsqu’on clique sur ce bouton :
            1) Si le nom du test n’est pas valide, ou si la question courante n’est pas valide, le
            programme affiche un message d’erreur dans une fenêtre surgissante,selon le cas,
            l’enregistrement est annulé, et la fenêtre demeure inchangée. Notez que le programme
            n’affiche qu’un seul message d’erreur, dans cet ordre : 1) nom du test invalide, et 2)
            champ(s) de la question courante invalide(s) (voir précision #5
            pour les champs de la question invalides).
            
            2) Si le nom du test, et la question courante sont valides :
            - Le test est sauvegardé dans le fichier tests.txt ainsi que dans
              la liste déroulante de la fenêtre #1.
            - La fenêtre #2 se ferme.
            - Un message de confirmation de l’enregistrement est affiché.*/
    
    
}
