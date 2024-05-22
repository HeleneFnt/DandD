package dnd.stuff;

public class Sword extends Weapon {
    private final int attackStrength;

    public Sword() {
        super("Sword", 5, "sharp and shiny sword.");
        this.attackStrength = 5;
    }


    @Override
    public int getAttackStrength() {
        return this.attackStrength;
    }


    public String getDescription() {
        return "Sword";
    }
}
