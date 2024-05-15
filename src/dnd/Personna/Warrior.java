package dnd.Personna;

import dnd.Stuff.OffensiveStuff;
import java.util.Random;
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, "warrior");
        this.healthPoints = (int) (Math.random() * (11 - 4) + 5);
        this.attackStrength = (int) (Math.random() * (11 - 4) + 5);
    }

    public String scream() {
        return "Waaah !!";
    }

    public void useGreatHealthPotion() {
        healthPoints += 5;
        System.out.println("You drank the potion and gained 5 health points.");
    }

    public void useStandardHealthPotion() {
        healthPoints += 2;
        System.out.println("You drank the potion and gained 2 health points.");
    }

    public void increaseAttack() {
        Random random = new Random();
        int weaponType = random.nextInt(2);

        if (weaponType == 0) {
            attackStrength += 3;
            System.out.println("You posses a club now ! Attack increased by 3 points.");
        } else {
            attackStrength += 5;
            System.out.println("You posses a sword ! Attack increased by 5 points.");
        }
    }

    public OffensiveStuff getWeapon() {
        return offensiveStuff;
    }

    public void equipWeapon(OffensiveStuff newWeapon) {
        this.offensiveStuff = newWeapon;
    }
}
