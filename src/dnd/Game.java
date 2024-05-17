// Game.java
package dnd;

import dnd.BoardGame.*;
import dnd.Personna.Character;
import dnd.Personna.CharacterBeyondBoardException;
import dnd.Personna.Enemy;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final GameDialog dialog;
    private final Character hero;
    private final Board board;
    protected int currentPosition; // Pour suivre la position actuelle du joueur sur le plateau
    private final int FINAL_CASE = 62;

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

    public void playTurn() {
        Scanner scanner = new Scanner(System.in);
        Dice d1 = new D6();

        while (currentPosition < FINAL_CASE && hero.getHealthPoints() > 0) {
            dialog.notifyThrowDice();

            int diceRoll = d1.throwDice();
            System.out.println("You rolled a " + diceRoll + "!");

            int newPosition = currentPosition + diceRoll;
            if (newPosition > FINAL_CASE) {
                newPosition = FINAL_CASE;
            }

            if (newPosition > FINAL_CASE) {
                try {
                    throw new CharacterBeyondBoardException("Your character left the dungeon unexpectedly! \uD83E\uDEE1 ");
                } catch (CharacterBeyondBoardException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }

            Case currentCase = getCurrentCase();
            if (currentCase != null) {
                dialog.notifyMovePosition(newPosition);
                System.out.println(currentCase.getDescription());
                String interactionResult = currentCase.interaction(hero, dialog);
                System.out.println(interactionResult);

                if ("Flee".equals(interactionResult)) {
                    newPosition =  currentPosition - d1.throwDice();
                    dialog.notifyMovePosition(newPosition);
                }

            } else {
                System.out.println("Invalid current position!");
            }

            currentPosition = newPosition;
        }

        dialog.notifyEndGame();

        int restartChoice = scanner.nextInt();
        switch (restartChoice) {
            case 1:
                currentPosition = 1;
                playTurn();
                dialog.notifyPlayerInfo(hero.getName(), hero.getHealthPoints(), hero.getAttackStrength());
                break;
            case 2:
                System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                break;
            default:
                System.out.println("Invalid choice! \uD83D\uDEAB");
        }
    }

}