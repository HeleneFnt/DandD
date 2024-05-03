package dnd.Personna;

import dnd.Stuff.DefensiveStuff;
import dnd.Stuff.OffensiveStuff;

public class Warrior extends Character{
    private int healthPoints;
    private int attackStrength;

    // Constructeur pour un guerrier avec nom, points de vie et attaque
    public Warrior (String name) {
        super(name, "warrior"); // Appel du constructeur de la classe mère avec le type "warrior"
        this.healthPoints = (int) (Math.random() * (11 - 4)+5);
        this.attackStrength = (int) (Math.random() * (11 - 4)+5);
    }

    // Getters et Setters pour les attributs spécifiques au guerrier
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

    // Méthode toString pour afficher les informations du guerrier


    public String scream() {
        return "Waaah !!";
    }

    public void applyPotionEffect() {
        healthPoints += 5;
        System.out.println("You drank the potion and gained 10 health points.");
    }
}



