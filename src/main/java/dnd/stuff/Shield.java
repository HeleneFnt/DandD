package dnd.stuff;

import dnd.GameDialog;

public abstract class Shield extends DefensiveStuff {
    private String type;
    private int defenseValue;
    private String name;

    public Shield(String type, int defenseValue, String name) {
        super(type, defenseValue, name);
        this.type = type;
        this.defenseValue = defenseValue;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", type: " + type + ", Defense: " + defenseValue ;
    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String interaction(Character character, GameDialog dialog) {
        return "";
    }
}
