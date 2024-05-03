package dnd.BoardGame;

import dnd.Personna.Character;
import dnd.Personna.Mage;
import dnd.Personna.Warrior;

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
        if (character instanceof Mage) {
            ((Mage) character).increaseAttack();
            return "Your damage: " + ((Mage) character).getAttackStrength();
        } else if (character instanceof Warrior) {
            ((Warrior) character).increaseAttack();
            return "Your damage: " + ((Warrior) character).getAttackStrength();
        } else {
            return "Invalid character type!";
        }
    }

}
