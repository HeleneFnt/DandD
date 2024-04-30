package dnd;

import java.util.Scanner;

public class Game {
    private int currentPosition; // Pour suivre la position actuelle du joueur sur le plateau

    public Game() {
        this.currentPosition = 1; // Départ du joueur à la case 1
    }

    // Méthode pour jouer un tour
    public void playTurn() {
        Scanner scanner = new Scanner(System.in);

        while (currentPosition < 64) {
            // Lance le dé
            int diceRoll = (int) (Math.random() * 6) + 1;
            // Met à jour la position actuelle du joueur en fonction du résultat du dé
            currentPosition += diceRoll;

            // Affichage de la position du personnage
            System.out.println("Your position: case " + currentPosition + " / 64");

//            // Affichage du plateau et de la position du personnage
//            displayBoard(currentPosition);

            // Attente de l'entrée utilisateur pour lancer le dé
            System.out.println("Press Enter to roll the dice and move.");
            scanner.nextLine();
        }

        System.out.println("You win! \uD83D\uDCB0 ");
        System.out.println("Game over! \uD83C\uDFC1 What would you like to do next?");
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '1' to start a new game \uD83D\uDCAB ");
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '2' to quit the game \uD83D\uDC4B ");

        int restartChoice = scanner.nextInt();
        switch (restartChoice) {
            case 1:
                // Redémarrer une nouvelle partie
                playTurn(); // Appel récursif de la méthode playTurn() pour démarrer une nouvelle partie
                break;
            case 2:
                // Quitter le jeu
                System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! \uD83D\uDEAB");
        }
    }

//    // Méthode pour afficher le plateau et la position du personnage
//    private void displayBoard(int currentPosition) {
//        // Affichage du plateau
//        System.out.println("╔════════════════════════╗");
//        for (int i = 0; i < 8; i++) {
//            System.out.print("║");
//            for (int j = 0; j < 8; j++) {
//                int cellNumber = i * 8 + j + 1;
//                if (cellNumber == currentPosition) {
//                    System.out.print(" X "); // Position actuelle du personnage
//                } else {
//                    System.out.print(" - "); // Autres cases du plateau
//                }
//            }
//            System.out.println("║");
//        }
//        System.out.println("╚════════════════════════╝");
//    }
}
