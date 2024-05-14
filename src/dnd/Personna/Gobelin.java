package dnd.Personna;

public class Gobelin extends Enemy {

    public Gobelin(String description) {
        super("Gobelin", "gobelin");
        this.description = description;
        this.lifePoints = 6;
        this.damage = 1;
    }


//            if (character != null && character.getHealthPoints() > 0) {
//                int characterHealthPoints = character.getHealthPoints();
//                int damage = getDamage();
//                int remainingHealth = characterHealthPoints - damage;
//
//                if (remainingHealth > 0) {
//                    character.reduceLifePoints(damage);
//                    return "The goblin swings its club! You lose " + damage + " health points. Your remaining health: " + remainingHealth;
//                } else {
//                    return "The goblin swings its club! You're dead!";
//                }
//            } else {
//                return "The goblin swings its club!";
//            }}

}