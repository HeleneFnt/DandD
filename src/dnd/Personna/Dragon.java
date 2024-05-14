package dnd.Personna;


public class Dragon extends Enemy {

    public Dragon(String name, int position, String description){
        super(name, "dragon");
        this.lifePoints = 6;
        this.damage = 4;
        this.position = position;
        this.description = description;
    }

    public Dragon(int i, String dragon) {
        super();
    }
}
