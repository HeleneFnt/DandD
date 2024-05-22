package dnd.personna;

import dnd.stuff.OffensiveStuff;

public class Mage extends Character {

    public Mage(String name) {
        super(name, "mage");
        this.healthPoints = (int) (Math.random() * (7 - 3)) + 3;
        this.attackStrength = (int) (Math.random() * (16 - 8)) + 8;
    }

    public String scream() {
        return "I invoke the power of magic!";
    }

    public OffensiveStuff learnSpell(OffensiveStuff spell) {
        this.offensiveStuff = spell;
        return spell;
    }

    public OffensiveStuff getSpell() {
        return offensiveStuff;
    }


}
