package dnd;

public class Game {
    private int currentPosition; // Pour suivre la position actuelle du joueur sur le plateau

    public Game() {
        this.currentPosition = 1; // Départ du joueur à la case 1
    }

    // Méthode pour jouer un tour
    public void playTurn() {
        while (currentPosition < 64) {
            // Lance le dé
            int diceRoll = (int) (Math.random() * 6) + 1;
            // Met à jour la position actuelle du joueur en fonction du résultat du dé
            currentPosition += diceRoll;
            System.out.println("Your position: case " + currentPosition + " / 64");
        }

        System.out.println("You win!");
    }
}

