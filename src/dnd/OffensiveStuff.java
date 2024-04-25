package dnd;

public class OffensiveStuff {
    private String type;
    private int attackStrength;
    private String name;

    public OffensiveStuff(String attack, int attackStrength, String name) {
    this.type=attack;
    this.attackStrength=attackStrength;
    this.name=name;
    }

// Getters & Setters
    public String getAttack() {
        return type;
    }

    public void setAttack(String attack) {
        this.type = attack;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", type: " + type + ", Attack: " + attackStrength ;
    }
}

