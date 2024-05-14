package dnd.Stuff;

public class Weapon extends OffensiveStuff{
    private String type;
    private int damage;
    private String name;

    public Weapon(String attack, int damage, String name) {
        super(attack, damage, name);
        this.damage = damage;
        this.name = name;
    }

    public Weapon() {
        super();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", type: " + type + ", Damages: " + damage;
    }
}

