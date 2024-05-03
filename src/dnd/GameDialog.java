package dnd;

import java.util.Scanner;

public class GameDialog {
    private Scanner scanner;

    public GameDialog(Scanner scanner) {
        this.scanner = scanner;
    }


    public void notifyMovePosition(int currentPosition) {
        System.out.println("Your position: case " + currentPosition + " / 4");
    }

    public void notifyThrowdice() {
        System.out.println("Press Enter to roll the dice and move.");
        scanner.nextLine();
    }

    public void notifyEndGame() {
        System.out.println("You win! \uD83D\uDCB0 ");
        System.out.println("Game over! \uD83C\uDFC1 What would you like to do next?");
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '1' to start a new game \uD83D\uDCAB ");
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '2' to quit the game \uD83D\uDC4B ");
    }
}
