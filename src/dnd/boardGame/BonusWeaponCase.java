package dnd.boardGame;

import dnd.GameDialog;
import dnd.personna.Character;
import dnd.personna.Mage;
import dnd.personna.Warrior;
import dnd.stuff.*;

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
            return applyWeaponBonus((Warrior) character, dialog);
        } else if (bonusType == 1 && character instanceof Mage) {
            return applySpellBonus((Mage) character, dialog);
        } else {
            return "No bonus applied.";
        }
    }

    private String applyWeaponBonus(Warrior warrior, GameDialog dialog) {
        Weapon newWeapon = getRandomWeapon();
        int previousAttackStrength = warrior.getAttackStrength(); // Force d'attaque de base du guerrier

        if (warrior.getWeapon() == null || newWeapon.getAttackStrength() > warrior.getWeapon().getAttackStrength()) {
            warrior.equipWeapon(newWeapon);
            int totalAttackStrength = previousAttackStrength + newWeapon.getAttackStrength(); // Force d'attaque totale du guerrier
            String message = "You wielded a " + newWeapon.getName() + "! Your damage increased by " +
                    "(+" + newWeapon.getAttackStrength() + "). Your total attack strength is now " + totalAttackStrength + " points.";
            dialog.notifyMessage(message);
            return message;
        } else {
            String message = "No better weapon found.";
            dialog.notifyMessage(message);
            return message;
        }
    }

    private String applySpellBonus(Mage mage, GameDialog dialog) {
        Spell newSpell = getRandomSpell();
        OffensiveStuff currentSpell = mage.getSpell();
        int previousAttackStrength = mage.getAttackStrength(); // Force d'attaque de base du mage

        if (currentSpell == null || newSpell.getAttackStrength() > currentSpell.getAttackStrength()) {
            mage.learnSpell(newSpell);
            int totalAttackStrength = previousAttackStrength + newSpell.getAttackStrength(); // Force d'attaque totale du mage
            String message = "You learned " + newSpell.getName() + "! Your damage increased by " +
                    "(+" + newSpell.getAttackStrength() + "). Your total attack strength is now " + totalAttackStrength + " points.";
            dialog.notifyMessage(message);
            return message;
        } else {
            String message = "No better spell found.";
            dialog.notifyMessage(message);
            return message;
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
