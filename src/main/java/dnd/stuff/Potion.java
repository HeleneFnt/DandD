package dnd.stuff;

public abstract class Potion extends DefensiveStuff {
    private String type ;
    private int defenseValue;
    private String name;

    public Potion(String type, int defenseValue, String name) {
        super (type, defenseValue, name);
        this.type = type;
        this.defenseValue = defenseValue;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", type: " + type + ", Defense: " + defenseValue ;
    }
}
