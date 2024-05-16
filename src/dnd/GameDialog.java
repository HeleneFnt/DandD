package dnd;

import dnd.Personna.Enemy;

import java.util.Scanner;

public class GameDialog {
    private Scanner scanner;

    public GameDialog(Scanner scanner) {
        this.scanner = scanner;
    }


    public void notifyMovePosition(int currentPosition) {
        System.out.println("Your position: case " + currentPosition + " / 62");
    }

    public void notifyThrowdice() {
        System.out.println("Press Enter to roll the dice and move.");
        scanner.nextLine();
    }

//    public void notifyWhoWon(Character character, Enemy enemy, int lifePoints, int healthPoints) {
//        if(Character.getHealthPoints() > 0){
//            System.out.println("You win! \uD83D\uDCB0 ");
//        }
//    }


    public void notifyEndGame() {
        System.out.println("Game over! \uD83C\uDFC1 What would you like to do next?");
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '1' to start a new game \uD83D\uDCAB ");
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '2' to quit the game ╰┈➤\uD83D\uDEAA ");
    }

    public void notifyHeroAttack(String playerName, String enemyName, int damage, String bonusSource) {
        if (bonusSource != null && !bonusSource.isEmpty()) {
            System.out.println(playerName + " attacked  ⚔\uFE0F " + enemyName + " dealing " + damage + " damages with an increased attack from " + bonusSource + ".");
        } else {
            System.out.println(playerName + " attacked ⚔\uFE0F " + enemyName + " dealing " + damage + " damages.");
        }
    }



    public void notifyEnemyAttack(String name, int damage) {
        System.out.println(name + " attacked ⚔\uFE0F, dealing " + damage + " damage(s).");
    }

    public void notifyMessage(String message) {

    }
    public void notifyEnemyInfo(String enemyName, int lifePoints, int attackStrength) {
        System.out.println(enemyName + "'s HP: " + lifePoints);
        System.out.println(enemyName + "'s attack Strength: " + attackStrength);
    }

    public void notifyPlayerInfo(String playerName, int healthPoints, int attackStrength) {
        System.out.println(playerName + "'s HP: " + healthPoints);
        System.out.println(playerName + "'s attack Strength: " + attackStrength);
    }


    public void notifyRemainingHealth(int healthPoints) {
        if (healthPoints > 0) {
            System.out.println("Your remaining HP: " + healthPoints);
        }
    }


    public void notifyEnemyLifePoints(int lifePoints, String enemyName) {
        if (lifePoints > 0) {
            System.out.println(enemyName + "'s HP: " + lifePoints);
        }
    }


    public String askForChoice() {
        System.out.println("Tape 'A' to Attack or Tape 'F' to Flee?");
        return scanner.nextLine().trim(); // Récupère la saisie de l'utilisateur et la retourne après suppression des espaces inutiles
    }

    public void notifyFlee(String Playername, int distance) {
    System.out.println(Playername + "'s flee: " + distance + "case(s)");
    }
}
