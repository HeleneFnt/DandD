// Game.java
package dnd;

import dnd.BoardGame.Board;
import dnd.BoardGame.Case;
import dnd.BoardGame.D1;
import dnd.Personna.Character;
import dnd.Personna.CharacterBeyondBoardException;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final GameDialog dialog;
    private final Character hero;
    private final Board board;
    protected int currentPosition; // Pour suivre la position actuelle du joueur sur le plateau
    private final int FINAL_CASE = 4;

    public Game(GameDialog dialog, Character hero, Board board) {
        this.dialog = dialog;
        this.hero = hero;
        this.currentPosition = 1; // Départ du joueur à la case 1
        this.board = board;

    }

    // méthode pour connaitre la case spécifique du héro
    public Case getCurrentCase() {
        ArrayList<Case> cases = board.getCases();
        if (currentPosition >= 1 && currentPosition <= cases.size()) {
            return cases.get(currentPosition - 1); // Les indices commencent à partir de 0
        } else {
            return null; // Retourne null si la position est invalide
        }
    }

    // Méthode pour jouer un tour
    public void playTurn() {
        Scanner scanner = new Scanner(System.in);
        D1 d1 = new D1();

        while (currentPosition < FINAL_CASE) {
            // Lance le dé
            int diceRoll = d1.throwDice();
//            int diceRoll = (int) (Math.random() * 6) + 1;
            // Met à jour la position actuelle du joueur en fonction du résultat du dé
            currentPosition += diceRoll;

            // Vérifie si le joueur est hors du plateau
            if (currentPosition > FINAL_CASE) {
                try {
                    throw new CharacterBeyondBoardException("Your character left the dungeon unexpectedly! \uD83E\uDEE1 ");
                } catch (CharacterBeyondBoardException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }

            // Récupérer les informations sur la case actuelle
            Case currentCase = getCurrentCase();
            if (currentCase != null) {
                System.out.println("You are on: " + currentCase.getDescription());
            } else {
                System.out.println("Invalid current position!");
            }

            // Affichage de la position du personnage
            dialog.notifyMovePosition(currentPosition);

            // Attente de l'entrée utilisateur pour lancer le dé
            dialog.notifyThrowdice();
        }

        dialog.notifyEndGame();

        int restartChoice = scanner.nextInt();
        switch (restartChoice) {
            case 1:
                // Redémarrer une nouvelle partie
                playTurn(); // Appel récursif de la méthode playTurn() pour démarrer une nouvelle partie
                break;
            case 2:
                // Quitter le jeu
                System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                break;
            default:
                System.out.println("Invalid choice! \uD83D\uDEAB");
        }
    }
}
