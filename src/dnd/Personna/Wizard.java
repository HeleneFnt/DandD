package dnd.Personna;

public class Wizard extends Enemy {
    private int lifePoints;
    private int damage;

    public Wizard(String name){
        super(name, "wizard");
        this.lifePoints = 9;
        this.damage = 2;
    }
    public int getDamage() {
        return damage;
    }

    @Override
    public String interaction(Character character) {
        if (character != null && character.getHealthPoints() > 0) {
            int characterHealthPoints = character.getHealthPoints();
            int damage = getDamage();
            int remainingHealth = characterHealthPoints - damage;

            if (remainingHealth > 0) {
                character.reduceLifePoints(damage);
                return "The wizard casts a spell! You lose " + damage + " health points. Your remaining health: " + remainingHealth;
            } else {
                return "The wizard casts a spell! You're dead !";
            }
        } else {
            return "The wizard casts a spell!";
        }
    }


}
