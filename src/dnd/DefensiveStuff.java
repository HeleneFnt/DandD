package dnd;

public class DefensiveStuff {
    private String type;
    private int defenseValue;
    private String name;

    public DefensiveStuff(String defense, int defenseValue, String name) {
        this.type = defense;
        this.defenseValue = defenseValue;
        this.name = name;
    }
    // Getters & Setters
    public String getDefense() {
        return type;
    }
    public void setDefense(String defense) {
        this.type = defense;
    }
    public int getDefenseValue() {
        return defenseValue;
    }
    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", type: " + type + ", Defense: " + defenseValue ;

    }
}
