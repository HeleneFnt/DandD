package dnd.BoardGame;

// Classe abstraite représentant un objet utilisable par les personnages
public abstract class HealthPotionCase {
    private String name;
    private int healingAmount;

    public String getName() {
        return name;
    }
    public int getHealingAmount() {
        return healingAmount;
    }

}
