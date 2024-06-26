package dnd.stuff;

public class Spell extends OffensiveStuff {
    private String type;
    private int damage;
    private String name;

    public Spell(String attack, int damage, String name) {
        super(attack, damage, name);
        this.damage = damage;
        this.name = name;
    }

    public Spell() {
        super();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", type: " + type + ", Damages: " + damage;
    }
}
