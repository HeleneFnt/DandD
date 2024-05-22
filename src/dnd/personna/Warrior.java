package dnd.personna;

import dnd.stuff.OffensiveStuff;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, "warrior");
        this.healthPoints = (int) (Math.random() * (11 - 4) + 5);
        this.attackStrength = (int) (Math.random() * (11 - 4) + 5);
    }

    public String scream() {
        return "For honor and glory!";
    }

    public OffensiveStuff getWeapon() {
        return offensiveStuff;
    }


    public void equipWeapon(OffensiveStuff newWeapon) {
        this.offensiveStuff = newWeapon;
        this.attackStrength = attackStrength + newWeapon.getAttackStrength();
    }
}
