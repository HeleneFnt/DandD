package dnd.BoardGame;

import dnd.GameDialog;
import dnd.Personna.Character;

public class GreatHealthPotion implements Case {
    private int position;
    private String description;
    private int healingAmount;

    public GreatHealthPotion(int position, String description) {
        this.position = position;
        this.description = description;
        this.healingAmount = 5;
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
        return "You found a Great Health Potion and restored " + healingAmount + " health points!";
    }

}