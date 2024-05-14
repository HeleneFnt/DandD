package dnd.Personna;

public class Gobelin extends Enemy {

    public Gobelin(String name, int position, String description) {
        super(name, "gobelin");
        this.description = description;
        this.position = position;
        this.lifePoints = 6;
        this.damage = 1;
    }

    public Gobelin(int i, String gobelin) {
        super();
    }
}