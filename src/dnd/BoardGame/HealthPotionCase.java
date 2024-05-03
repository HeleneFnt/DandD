package dnd.BoardGame;

import dnd.Personna.Character;
import dnd.Personna.Mage;
import dnd.Personna.Warrior;

import java.util.Random;

public class HealthPotionCase implements Case {
    private int position;
    private String description;

    public HealthPotionCase(int position, String description) {
        this.position = position;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getPosition() {
        return position;
    }
    public String interaction(Character character) {
        Random random= new Random();
        int potionType = random.nextInt(2);
        if (character instanceof Mage || character instanceof Warrior) {
            // Appliquer les effets des potions en fonction du type de personnage
            if (potionType == 0) {
                character.useStandardHealthPotion();
                return "Your HP : " + character.getHealthPoints();
            } else {
                character.useGreatHealthPotion();
                return"Your HP : " + character.getHealthPoints();
            }
        } else {
            return "You can't have Potion effect!";
        }
    }

}