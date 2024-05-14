package dnd.BoardGame;

import dnd.GameDialog;
import dnd.Personna.Character;
import dnd.Personna.Mage;
import dnd.Personna.Warrior;
import dnd.Stuff.*;

import java.util.Random;

public class BonusWeaponCase implements Case {
    private final int position;
    private final String description;

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
    public String interaction(Character character, GameDialog dialog) {
        Random random = new Random();
        int bonusType = random.nextInt(2);

        if (bonusType == 0 && character instanceof Warrior) {
            return applyWeaponBonus((Warrior) character);
        } else if (bonusType == 1 && character instanceof Mage) {
            return applySpellBonus((Mage) character);
        } else {
            return "No bonus applied.";
        }
    }

    private String applyWeaponBonus(Warrior warrior) {
        Weapon newWeapon = getRandomWeapon();
        if (warrior.getWeapon() == null || newWeapon.getAttackStrength() > warrior.getWeapon().getAttackStrength()) {
            warrior.equipWeapon(newWeapon);
            return "You wielded a " + newWeapon.getName() + "! Your damage: " + warrior.getAttackStrength();
        } else {
            return "No better weapon found.";
        }
    }

    private String applySpellBonus(Mage mage) {
        Spell newSpell = getRandomSpell();
        if (mage.getSpell() == null || newSpell.getAttackStrength() > mage.getSpell().getAttackStrength()) {
            mage.learnSpell(newSpell);
            return "You learned " + newSpell.getName() + "! Your damage: " + mage.getAttackStrength();
        } else {
            return "No better spell found.";
        }
    }

    private Weapon getRandomWeapon() {
        Random random = new Random();
        int weaponType = random.nextInt(2);

        return switch (weaponType) {
            case 0 -> new Club();
            case 1 -> new Sword();
            default -> new Club();
        };
    }

    private Spell getRandomSpell() {
        Random random = new Random();
        int spellType = random.nextInt(2);

        return switch (spellType) {
            case 0 -> new Lightning();
            case 1 -> new Fireball();
            default -> new Lightning();
        };
    }
}
