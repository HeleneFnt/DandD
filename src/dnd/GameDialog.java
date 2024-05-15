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
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '2' to quit the game \uD83D\uDC4B ");
    }

    public void notifyHeroAttack(String playerName, String enemyName, int damage) {
        System.out.println(playerName + " attacked a " + enemyName + " and dealing " + damage + " damages.");
    }


    public void notifyEnemyAttack(String name, int damage) {
        System.out.println(name + " attacked, dealing " + damage + " damage(s).");
    }

    public void notifyMessage(String message) {

    }
    public void notifyEnemyInfo(String enemyName, int lifePoints, int attackStrength) {
        System.out.println("Enemy: " + enemyName);
        System.out.println("HP: " + lifePoints);
        System.out.println("Attack Strength: " + attackStrength);
    }

    public void notifyPlayerInfo(String playerName, int healthPoints, int attackStrength) {
        System.out.println("Your Player: " + playerName);
        System.out.println("HP: " + healthPoints);
        System.out.println("Attack Strength: " + attackStrength);
    }


    public void notifyRemainingHealth(int healthPoints) {
        if (healthPoints > 0) {
            System.out.println("Your remaining HP: " + healthPoints);
        }
    }


    public void notifyEnemyLifePoints(int lifePoints, String enemyName) {
        if (lifePoints > 0) {
            System.out.println(enemyName + " HP: " + lifePoints);
        }
    }


}
