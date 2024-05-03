package dnd.Personna;

public class Gobelin extends Enemy{
    private int lifePoints;
    private int damage;

    public Gobelin(String name){
        super(name, "gobelin");
        this.lifePoints = 6;
        this.damage = 1;
    }
}
