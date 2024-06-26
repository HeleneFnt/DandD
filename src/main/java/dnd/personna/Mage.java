package dnd.personna;

import dnd.stuff.OffensiveStuff;

public class Mage extends Hero {

    public Mage(String name) {
        super(name, "Mage");
        this.healthPoints =  7;
        this.attackStrength = 12;
    }
    public OffensiveStuff getSpell() {
        return offensiveStuff;
    }

    public String scream() {
        return "I invoke the power of magic!";
    }

    public OffensiveStuff learnSpell(OffensiveStuff spell) {
        this.offensiveStuff = spell;
        return spell;
    }

}
