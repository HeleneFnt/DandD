package dnd;

public class OffensiveStuff {
    private String attack;
    private int attackStrength;
    private String name;

    public OffensiveStuff(String attack, int attackStrength, String name) {
    this.attack=attack;
    this.attackStrength=attackStrength;
    this.name=name;
    }

// Getters & Setters
    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
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
}

