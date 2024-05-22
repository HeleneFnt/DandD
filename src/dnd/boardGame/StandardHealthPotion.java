package dnd.boardGame;

import dnd.GameDialog;
import dnd.personna.Character;

public class StandardHealthPotion implements Case {
    private int position;
    private String description;
    private int healingAmount;

    public StandardHealthPotion(int position, String description) {
        this.position = position;
        this.description = description;
        this.healingAmount = 2;
    }

    public int getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String interaction(Character character, GameDialog dialog) {
        int previousHealth = character.getHealthPoints(); // Obtenez les points de vie avant la guérison
        character.heal(healingAmount); // Guérissez le personnage
        int totalHealth = previousHealth + healingAmount; // Obtenez les points de vie après la guérison

        // Construisez le message en utilisant les points de vie restaurés et totaux
        String message = "You found a Standard Health Potion and restored " + healingAmount + " health points! " +
                "Your total health is now " + totalHealth + " points.";
        dialog.notifyMessage(message); // Afficher le message dans le dialogue du jeu
        return message; // Renvoyer le message pour une utilisation éventuelle
    }
}
