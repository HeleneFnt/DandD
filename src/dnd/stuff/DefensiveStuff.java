package dnd.stuff;

import dnd.GameDialog;
import dnd.personna.Character;

public abstract class DefensiveStuff {
    protected String type;
    protected int defenseValue;
    protected String name;

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

    public abstract int getPosition();

    public abstract String getDescription();

    public abstract String interaction(Character character, GameDialog dialog);
}
