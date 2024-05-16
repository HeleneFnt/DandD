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
    protected int position;

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

    public String interaction() {
        return null;
    }


    // Méthode pour l'utilisation de la potion de vie
    public void heal(int amount) {
        this.healthPoints += amount;
    }

    public void reduceLifePoints(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    public int getPosition() {
    return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }
}
