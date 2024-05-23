package dnd.personna;

import dnd.stuff.OffensiveStuff;

public class Mage extends Hero {

    public Mage(String name) {
        super(name, "mage");
        this.healthPoints =  7;
        this.attackStrength = 12;
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
