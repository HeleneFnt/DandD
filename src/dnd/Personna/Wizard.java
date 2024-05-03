package dnd.Personna;

public class Wizard extends Enemy{
    private int lifePoints;
    private int damage;

    public Wizard(String name){
        super(name, "wizard");
        this.lifePoints = 9;
        this.damage = 2;
    }

}
