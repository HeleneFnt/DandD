package dnd.Personna;

import dnd.Stuff.OffensiveStuff;
import dnd.Stuff.DefensiveStuff;

public abstract class Character {

    protected String type;
    protected String name;
    protected int healthPoints;
    protected int attackStrength;
    protected OffensiveStuff offensiveStuff;
    protected DefensiveStuff defensiveStuff;

    // Constructeur de personnages sans paramètres
    public Character() {
        this.name = "";
        this.healthPoints=10; // Valeur par défaut
        this.attackStrength = 10; // Valeur par défaut
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


    public abstract String scream();


    public abstract void useStandardHealthPotion();

    public abstract void useGreatHealthPotion();

    public abstract void increaseAttack();

    public String interaction() {
        return null;
    }

    public void reduceLifePoints(int damage) {
        healthPoints = getHealthPoints() - damage;
    }

    public int getLifePoints() {
        return healthPoints;
    }

    public int attack(){
        return attackStrength;
    }
}
