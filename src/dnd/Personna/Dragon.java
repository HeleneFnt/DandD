package dnd.Personna;


public class Dragon extends Enemy {

    public Dragon(String name){
        super(name, "dragon");
        this.lifePoints = 6;
        this.damage = 4;
    }


//    @Override
//    public String interaction(Character character) {
//        if (character != null && character.getHealthPoints() > 0) {
//            int characterHealthPoints = character.getHealthPoints();
//            int damage = getDamage();
//            int remainingHealth = characterHealthPoints - damage;
//
//            if (remainingHealth > 0) {
//                character.reduceLifePoints(damage);
//                return "The mighty dragon attacks! You lose " + damage + " health points. Your remaining health: " + remainingHealth;
//            } else {
//                return "The mighty dragon attacks! You're dead !";
//            }
//        } else {
//            return "The mighty dragon attacks!";
//        }
//
//    }
}
