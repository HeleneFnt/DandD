package dnd.Stuff;

public class Sword extends OffensiveStuff{
    private String type;
    private int damage;
    private String name;

    public Sword(String attack, int damage, String name) {
        super(attack, damage, name);
        this.damage = damage;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", type: " + type + ", Damage: " + damage;
    }
}

