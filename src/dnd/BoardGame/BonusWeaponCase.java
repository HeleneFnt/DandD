package dnd.BoardGame;

import dnd.Personna.Character;
import dnd.Personna.Mage;
import dnd.Personna.Warrior;

import java.util.Random;

public class BonusWeaponCase implements Case {
        private int position;
        private String description;

    public BonusWeaponCase(int position, String description) {
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
        Random random = new Random();
        int characterType = random.nextInt(2);

        if (characterType == 0 && character instanceof Mage) {
            ((Mage) character).increaseAttack();
            return "You cast a spell! Your damage: " + character.getAttackStrength();
        } else if (characterType == 1 && character instanceof Warrior) {
            ((Warrior) character).increaseAttack();
            return "You wielded a powerful weapon! Your damage: " + character.getAttackStrength();
        } else {
            return "No bonus applied.";
        }
    }

}
