package dnd;

public class DefensiveStuff {
    private String defense;
    private int defenseValue;
    private String name;

    public DefensiveStuff(String defense, int defenseValue, String name) {
        this.defense = defense;
        this.defenseValue = defenseValue;
        this.name = name;
    }
    // Getters & Setters
    public String getDefense() {
        return defense;
    }
    public void setDefense(String defense) {
        this.defense = defense;
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
}
