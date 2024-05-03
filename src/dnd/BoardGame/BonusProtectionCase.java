package dnd.BoardGame;

import dnd.Personna.Character;
import dnd.Personna.Mage;
import dnd.Personna.Warrior;

public class BonusProtectionCase implements Case {
    private int position;
    private String description;

    public BonusProtectionCase(int position, String description) {
        this.position = position;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String interaction(Character character) {
        if (character instanceof Mage) {
            character.applyPotionEffect();
            return "Your HP : " + character.getHealthPoints();
        } else if (character instanceof Warrior) {
            character.applyPotionEffect();
            return "Your HP : " + character.getHealthPoints();
        }
        return "You can't have Potion effect!";
    }
}