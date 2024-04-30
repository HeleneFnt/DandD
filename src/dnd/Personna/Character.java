package dnd.Personna;

import dnd.Stuff.OffensiveStuff;
import dnd.Stuff.DefensiveStuff;

public abstract class Character {
    private String type;
    private String name;
    private int healthPoints;
    private int attackStrength;
    protected OffensiveStuff offensiveStuff;
    protected DefensiveStuff defensiveStuff;

    // Constructeur de personnages sans paramètres
    public Character() {
        this.name = "";
        this.healthPoints = 10; // Valeur par défaut
        this.attackStrength = 10; // Valeur par défaut
        this.type = "";
        this.offensiveStuff = new OffensiveStuff("", 0, ""); // Initialisation par défaut
        this.defensiveStuff = new DefensiveStuff("", 0, ""); // Initialisation par défaut
    }

    // Constructeur de personnages avec nom
    public Character(String name) {
        this();
        this.name = name;
    }

    // Constructeur de personnages avec nom et type
    public Character(String name, String type) {
        this(name);
        this.type = type;
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

    public int getAttackStrength() {
        return attackStrength;
    }


    @Override // surcharge de la méthode tiString()
    public String toString() {
        return "Name: " + name + ", HP: " + healthPoints + ", Attack: " + attackStrength +
                ", Offensive Stuff: " + offensiveStuff + ", Defensive Stuff: " + defensiveStuff;
    }

    public abstract String hurler();
}
