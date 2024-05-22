package dnd;

import java.util.Scanner;

public class GameDialog {
    private Scanner scanner;

    public GameDialog(Scanner scanner) {
        this.scanner = scanner;
    }

    public void notifyMovePosition(int currentPosition) {
        System.out.println("Your position: case " + currentPosition + " / 62");
    }


    public void notifyThrowDice() {
        System.out.println("Press Enter to roll the dice and move.");
        scanner.nextLine();
    }

    public void notifyEndGame() {
        System.out.println("Game over! 🏁 What would you like to do next?");
        System.out.println("👨‍💻 Type '1' to start a new game ✨ ");
        System.out.println("👨‍💻 Type '2' to quit the game ╰┈➤🚪 ");
    }

    public void notifyHeroAttack(String playerName, String enemyName, int damage, String bonusSource) {
        if (bonusSource != null && !bonusSource.isEmpty()) {
            System.out.println(playerName + " attacked ⚔️ " + enemyName + " dealing " + damage + " damage with an increased attack from " + bonusSource + ".");
        } else {
            System.out.println(playerName + " attacked ⚔️ " + enemyName + " dealing " + damage + " damage.");
        }
    }

    public void notifyEnemyAttack(String name, int damage) {
        System.out.println(name + " attacked ⚔️, dealing " + damage + " damage.");
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
        System.out.println("Type 'A' to Attack or 'F' to Flee:");
        return scanner.nextLine().trim();
    }

    public void notifyFlee(String playerName, int distance) {
        System.out.println(playerName + " has moved back: " + distance + " square(s).");
    }

    public void notifyInvalidChoice() {
        System.out.println("Invalid choice! Please type 'A' to Attack or 'F' to Flee.");
    }

    public void notifyMessage(String message) {
    }

}
