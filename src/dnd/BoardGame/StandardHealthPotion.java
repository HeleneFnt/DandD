package dnd.BoardGame;

import dnd.GameDialog;
import dnd.Personna.Character;

public class StandardHealthPotion implements Case {
    private int position;
    private String description;
    private int healingAmount;

    public StandardHealthPotion(int position, String description) {
        this.position = position;
        this.description = description;
        this.healingAmount = healingAmount;
    }

    public int getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String interaction(Character character, GameDialog dialog) {
        character.heal(healingAmount);
        return "You found a Standard Health Potion and restored " + healingAmount + " health points!";
    }

}
