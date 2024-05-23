package dnd.personna;

import dnd.stuff.DefensiveStuff;
import dnd.stuff.OffensiveStuff;

public abstract class Hero {

    protected String type;
    protected String name;
    protected int healthPoints;
    protected int attackStrength;
    protected OffensiveStuff offensiveStuff;
    protected DefensiveStuff defensiveStuff;
    protected int position;

    // Constructeur de personnages sans paramètres
    public Hero() {
        this.name = "";
        this.healthPoints = 10; // Valeur par défaut
        this.attackStrength = 10; // Valeur par défaut
    }

    // Constructeur de personnages avec nom
    public Hero(String name) {
        this();
        this.name = name;
    }

    // Constructeur de personnages avec nom et type
    public Hero(String name, String type) {
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

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public OffensiveStuff getOffensiveStuff() {
        return offensiveStuff;
    }

    public void setOffensiveStuff(OffensiveStuff offensiveStuff) {
        this.offensiveStuff = offensiveStuff;
    }

    public DefensiveStuff getDefensiveStuff() {
        return defensiveStuff;
    }

    public void setDefensiveStuff(DefensiveStuff defensiveStuff) {
        this.defensiveStuff = defensiveStuff;
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
}
