package dnd.Stuff;

public class Club extends Weapon {
    private final int attackStrength;

    public Club() {
        super("Club", 3, "sturdy wooden club.");
        this.attackStrength = 3;
    }

    @Override
    public int getAttackStrength() {
        return this.attackStrength;
    }

    public String getDescription() {
        return "Blunt";
    }
}
