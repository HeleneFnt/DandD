package dnd.Personna;


public class Dragon extends Enemy {
    private int lifePoints;
    private int damage;

    public Dragon(String name){
        super(name, "dragon");
        this.lifePoints = 6;
        this.damage = 1;
    }

    @Override
    public String interaction(Character character) {
        return "The mighty dragon attacks!";
    }
}
