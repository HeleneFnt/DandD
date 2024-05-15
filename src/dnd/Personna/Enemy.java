package dnd.Personna;

import dnd.BoardGame.Case;
import dnd.GameDialog;

public abstract class Enemy implements Case {
    protected String type;
    protected String name;
    protected int lifePoints;
    protected int damage;
    protected int position;



    // Constructeur d'ennemi  avec nom et type
    public Enemy(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Enemy() {

    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Enemy case";
    }

    @Override
    public String interaction(Character character, GameDialog dialog) {
        dialog.notifyPlayerInfo(character.getName(), character.getHealthPoints(), character.getAttackStrength());
        dialog.notifyEnemyInfo(name, lifePoints, damage);
        while (lifePoints > 0 && character.getHealthPoints() > 0) {
            // Notification de l'attaque du héros

            dialog.notifyHeroAttack(character.getName(), name, character.getAttackStrength());
            lifePoints -= character.getAttackStrength();
            dialog.notifyEnemyLifePoints(lifePoints, name);

            // Vérifier si l'ennemi est vaincu
            if (lifePoints <= 0) {
                return "You won ! Enemy defeats";
            }

            // L'ennemi attaque si le personnage est toujours en vie
            dialog.notifyEnemyAttack(name, damage);
            character.reduceLifePoints(damage);
            dialog.notifyRemainingHealth(character.getHealthPoints());

            // Vérifier si le personnage est vaincu
            if (character.getHealthPoints() <= 0) {
                return "You're dead !";
            }
        }

        // Si l'ennemi ou le personnage n'a plus de points de vie, on termine l'interaction
        return null;
    }

}
