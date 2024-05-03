package dnd.Personna;

import dnd.Stuff.DefensiveStuff;
import dnd.Stuff.OffensiveStuff;

import java.util.Random;

public class Mage extends Character {
    private int healthPoints;
    private int attackStrength;

    // Constructeur pour un mage avec nom, points de vie et attaque
    public Mage(String name) {
        super(name, "mage");
        this.healthPoints = (int) (Math.random() * (7 - 3)) + 3;
        this.attackStrength = (int) (Math.random() * (16 - 8)) + 8;

        // Initialisez les objets offensiveStuff et defensiveStuff ici si nécessaire
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


    public String scream() {
        return "Youhou ! ";
    }

    public void useGreatHealthPotion() {
        healthPoints += 5;
        System.out.println("You drank the potion and gained 5 health points.");
    }
    public void useStandardHealthPotion(){
        healthPoints += 2;
        System.out.println("You drank the potion and gained 2 health points.");
            }

    public void increaseAttack() {
        Random random = new Random();
        int spellType = random.nextInt(2);

        if (spellType == 0) {
            attackStrength += 2;
            System.out.println("You learn Lightning Bolt! Attack increased by 2 points.");
        } else {
            attackStrength += 7;
            System.out.println("You learn Fireball! Attack increased by 7 points.");
        }
    }

}