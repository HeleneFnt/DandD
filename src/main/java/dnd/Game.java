package dnd;

import dnd.boardGame.*;
import dnd.personna.CharacterBeyondBoardException;
import dnd.personna.Enemy;
import dnd.personna.Character;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private final GameDialog dialog;
    private final Character hero;
    private final Board board;
    protected int currentPosition; // Pour suivre la position actuelle du joueur sur le plateau
    private final int FINAL_CASE = 62;
    private final Set<Integer> defeatedEnemies = new HashSet<>(); // Positions des ennemis vaincus

    public Game(GameDialog dialog, Character hero, Board board) {
        this.dialog = dialog;
        this.hero = hero;
        this.currentPosition = 1; // Départ du joueur à la case 1
        this.board = board;
    }

    // Méthode pour connaître la case spécifique du héros
    private Case getCurrentCase() {
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

            // Vérifier si le nouveau position dépasse la case finale
            if (newPosition > FINAL_CASE) {
                try {
                    throw new CharacterBeyondBoardException("Your character left the dungeon unexpectedly! \uD83E\uDEE1 ");
                } catch (CharacterBeyondBoardException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }

            currentPosition = newPosition;
            if (currentPosition == FINAL_CASE && hero.getHealthPoints() > 0) {
                System.out.println("Congratulations! You have reached the final case and won the game! \uD83C\uDFC6");
                break;
            }

            while (true) {
                Case currentCase = getCurrentCase();
                if (currentCase != null) {
                    dialog.notifyMovePosition(currentPosition);

                    // Vérifier si l'ennemi à cette position a déjà été vaincu
                    if (currentCase instanceof Enemy && defeatedEnemies.contains(currentPosition)) {
                        System.out.println("You have already defeated the enemy here!");
                        break; // Sortir de la boucle interne
                    }

                    System.out.println(currentCase.getDescription());
                    String interactionResult = currentCase.interaction(hero, dialog);
                    System.out.println(interactionResult);

                    if ("Flee".equals(interactionResult)) {
                        int stepsBack = d1.throwDice();
                        newPosition = Math.max(1, currentPosition - stepsBack);
                        dialog.notifyFlee(hero.getName(), stepsBack);
                        currentPosition = newPosition;
                        continue; // Recommencer la boucle pour interagir avec la nouvelle case
                    } else if ("You're dead!".equals(interactionResult)) {
                        // Si le joueur est vaincu, sortir de la boucle de jeu
                        return;
                    } else if (interactionResult != null && interactionResult.contains("defeated")) {
                        // Marquer l'ennemi comme vaincu
                        defeatedEnemies.add(currentPosition);
                    }
                } else {
                    System.out.println("Invalid current position!");
                }
                break; // Sortir de la boucle interne si l'interaction ne nécessite pas une fuite
            }
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
