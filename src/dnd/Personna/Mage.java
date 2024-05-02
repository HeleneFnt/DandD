package dnd.Personna;

import dnd.Stuff.DefensiveStuff;
import dnd.Stuff.OffensiveStuff;

public class Mage extends Character {
    private int healthPoints;
    private int attackStrength;

    // Constructeur pour un mage avec nom, points de vie et attaque
    public Mage(String name, int healthPoints, int attackStrength) {
        super(name, "mage"); // Appel du constructeur de la classe mère avec le type "mage"
        this.healthPoints = healthPoints;
        this.attackStrength = attackStrength;

//        this.offensiveStuff = new OffensiveStuff("Spell", 15, "Fireball");
//        this.defensiveStuff = new DefensiveStuff("Potion", 8, "Philter");
    }

    // Getters et Setters pour les attributs spécifiques au mage
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

    // Méthode toString pour afficher les informations du mage
    @Override
    public String toString() {
        return super.toString() + ", Health Points: " + healthPoints + ", Attack Strength: " + attackStrength;
    }

    @Override
    public String hurler() {
        return "Youhou";
    }
}
