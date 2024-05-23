package dnd.personna;

import dnd.stuff.OffensiveStuff;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name, "warrior");
        this.healthPoints = 11;
        this.attackStrength = 6;
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
