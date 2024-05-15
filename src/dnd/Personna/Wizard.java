package dnd.Personna;

public class Wizard extends Enemy {

    public Wizard(int position, String name){
        super(name, "wizard");
        this.lifePoints = 30;
        this.damage = 2;
        this.position = position;
    }

}
