package dnd.Personna;

public class Wizard extends Enemy {

    public Wizard(String name, int position, String description){
        super(name, "wizard");
        this.lifePoints = 9;
        this.damage = 2;
        this.position = position;
        this.description = description;
    }

    public Wizard(int i, String wizard) {
        super();
    }
}
