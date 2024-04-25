package dnd;

public class Character {
    private String type;
    private String name;
    private int healthPoints;
    private int attackStrength;
    private String offensiveStuff;
    private String defensiveStuff;

    // Constructeur de personnages sans paramètres
    public Character() {
        this.name = "";
        this.healthPoints = 0;
        this.attackStrength = 0;
        this.offensiveStuff = null;
        this.defensiveStuff = null;
    }

    // Constructeur de personnages avec nom
    public Character(String name) {
        this.name = name;
        this.healthPoints = 0;
        this.attackStrength = 0;
        this.offensiveStuff = null;
        this.defensiveStuff = null;
    }

    // Constructeur de personnages avec nom et type
    public Character(String name, String type) {
        this.name = name;
        this.type = type;
        this.healthPoints = 0;
        this.attackStrength = 0;
        this.offensiveStuff = null;
        this.defensiveStuff = null;

    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public String getOffensiveStuff() {
        return offensiveStuff;
    }

    public void setOffensiveStuff(String offensiveStuff) {
        this.offensiveStuff = offensiveStuff;
    }

    public String getDefensiveStuff() {
        return defensiveStuff;
    }

    public void setDefensiveStuff(String defensiveStuff) {
        this.defensiveStuff = defensiveStuff;
    }


    @Override // surcharge de la méthode tiString()
    public String toString() {
        return "Name: " + name + ", HP: " + healthPoints + ", Attack: " + attackStrength +
                ", Offensive Stuff: " + offensiveStuff + ", Defensive Stuff: " + defensiveStuff;
    }
}