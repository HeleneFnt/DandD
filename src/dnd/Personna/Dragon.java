package dnd.Personna;


public class Dragon extends Enemy {

    public Dragon(int position, String name){
        super(name, "dragon");
        this.lifePoints = 50;
        this.damage = 4;
        this.position = position;
    }

}
