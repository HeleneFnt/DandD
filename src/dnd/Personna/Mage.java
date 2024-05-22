package dnd.Personna;

import dnd.Stuff.OffensiveStuff;
import dnd.Stuff.Spell;

import java.util.Random;

public class Mage extends Character {

    public Mage(String name) {
        super(name, "mage");
        this.healthPoints = (int) (Math.random() * (7 - 3)) + 3;
        this.attackStrength = (int) (Math.random() * (16 - 8)) + 8;
    }

    public String scream() {
        return "I invoke the power of magic!";
    }

//    public void useGreatHealthPotion() {
//        healthPoints += 5;
//        System.out.println("You drank the potion and gained 5 health points.");
//    }
//
//    public void useStandardHealthPotion() {
//        healthPoints += 2;
//        System.out.println("You drank the potion and gained 2 health points.");
//    }

//    public void increaseAttack() {
//        Random random = new Random();
//        int spellType = random.nextInt(2);
//
//        if (spellType == 0) {
//            attackStrength += 2;
//            System.out.println("You learn Lightning Bolt! Attack increased by 2 points.");
//        } else {
//            attackStrength += 7;
//            System.out.println("You learn Fireball! Attack increased by 7 points.");
//        }
//    }

    public OffensiveStuff learnSpell(OffensiveStuff spell) {
        this.offensiveStuff = spell;
        return spell;
    }

    public OffensiveStuff getSpell() {
        return offensiveStuff;
    }


}
