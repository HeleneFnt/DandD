package dnd.BoardGame;

// Classe abstraite représentant un objet utilisable par les personnages
public abstract class HealthPotionCase {
    private String name;
    private int healingAmount;

    public void HealthPotion(String name, int healingAmount) {
        this.name = name;
        this.healingAmount = healingAmount;
    }

    public HealthPotionCase(String standardHealthPotion, int i) {
    }

    public String getName() {
        return name;
    }
    public int getHealingAmount() {
        return healingAmount;
    }

}
