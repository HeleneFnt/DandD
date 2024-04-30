package dnd.Personna;

import dnd.Stuff.OffensiveStuff;
import dnd.Stuff.DefensiveStuff;

public class Character {
    private String type;
    private String name;
    private int healthPoints;
    private int attackStrength;
    private OffensiveStuff offensiveStuff;
    private DefensiveStuff defensiveStuff;



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
        if (type.equals("warrior")) {
            this.healthPoints = 8 + (int) (Math.random() * (11 - 8)); // Entre 8 et 10
            this.attackStrength = 8 + (int) (Math.random() * (16 - 8)); // Entre 8 et 15
            this.offensiveStuff = new OffensiveStuff("Weapon", 5, "Sword");
            this.defensiveStuff = new DefensiveStuff("Protection", 10, "Shield");
        } else if (type.equals("mage")) {
            this.healthPoints = 3 + (int) (Math.random() * (7 - 3)); // Entre 3 et 6
            this.attackStrength = 8 + (int) (Math.random() * (16 - 8)); // Entre 8 et 15
            this.offensiveStuff = new OffensiveStuff("Spell", 15, "Fireball");
            this.defensiveStuff = new DefensiveStuff("Potion", 8, "Philter");
        }
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
}
