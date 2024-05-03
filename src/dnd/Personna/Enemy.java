package dnd.Personna;

public abstract class Enemy {
    protected String type;
    protected String name;
    protected int lifePoints;
    protected int damage;


    // Constructeur d'ennemi  avec nom et type
    public Enemy (String name, String type) {
        this.name= name;
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

    public int getLifePoints() {
        return lifePoints;
    }
    public int getDamage() {
        return damage;
    }

    public abstract String interaction(Character character);
}