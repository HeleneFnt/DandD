package dnd.Personna;

public class Gobelin extends Enemy {
    private int lifePoints;
    private int damage;

    public Gobelin(String description) {
        super("Gobelin", "gobelin");
        this.position = position;
        this.description = description;
        this.lifePoints = 6;
        this.damage = 1;
    }


    @Override
    public String interaction(Character character) {
        return "The goblin swings its club!";
    }
}
