package dnd.Personna;

public class Gobelin extends Enemy {

    public Gobelin(int position, String name) {
        super(name, "gobelin");
        this.position = position;
        this.lifePoints = 20;
        this.damage = 1;
    }


}