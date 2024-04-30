package dnd.Personna;

public class Warrior extends Character{
    private int healthPoints;
    private int attackStrength;

    // Constructeur pour un guerrier avec nom, points de vie et attaque
    public Warrior (String name, int healthPoints, int attackStrength) {
        super(name, "warrior"); // Appel du constructeur de la classe mère avec le type "warrior"
        this.healthPoints = healthPoints;
        this.attackStrength = attackStrength;
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
    @Override
    public String toString() {
        return super.toString() + ", Health Points: " + healthPoints + ", Attack Strength: " + attackStrength;
    }
}


