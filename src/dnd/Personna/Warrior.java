package dnd.Personna;

import dnd.Stuff.DefensiveStuff;
import dnd.Stuff.OffensiveStuff;

import java.util.Random;

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
        int weaponType = random.nextInt(2);

        if (weaponType==0) {
            attackStrength +=3;
            System.out.println("You posses a club now ! Attack incresed by 3 points.");
        }else {
            attackStrength +=5;
            System.out.println("You posses a sword ! Attack increased by 5 points.");
        }
    }


}



