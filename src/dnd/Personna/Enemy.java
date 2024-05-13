package dnd.Personna;

import dnd.BoardGame.Case;

public abstract class Enemy implements Case {
    protected String type;
    protected String name;
    protected int lifePoints;
    protected int damage;
    protected int position;
    protected String description;


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

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "";
    }

    public abstract String interaction(Character character);
}