package dnd.personna;

import dnd.GameDialog;
import dnd.boardGame.Case;
import dnd.stuff.OffensiveStuff;
import dnd.stuff.Spell;

public abstract class Enemy implements Case {
    protected String type;
    protected String name;
    protected int lifePoints;
    protected int damage;
    protected int position;

    // Constructeur d'ennemi avec nom et type
    public Enemy(String name, String type, int lifePoints, int damage, int position) {
        this.name = name;
        this.type = type;
        this.lifePoints = lifePoints;
        this.damage = damage;
        this.position = position;
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


    @Override
    public int getPosition() {

        return position;
    }

    @Override
    public String getDescription() {

        return "Enemy case";
    }

    @Override
    public String interaction(Hero hero, GameDialog dialog) {
        dialog.notifyPlayerInfo(hero.getName(), hero.getHealthPoints(), hero.getAttackStrength());
        dialog.notifyEnemyInfo(name, lifePoints, damage);

        while (lifePoints > 0 && hero.getHealthPoints() > 0) {
            // Demander le choix du joueur : attaquer ou fuir
            String choice = dialog.askForChoice();

            if (choice.equalsIgnoreCase("F")) {
                // Fuir

                return "Flee";  // Indiquer que le joueur a choisi de fuir
            } else if (choice.equalsIgnoreCase("A")) {
                // Attaque du héros
                int baseAttackStrength = hero.getAttackStrength();
                int bonusAttackStrength = 0;
                String bonusSource = "";

                if (hero instanceof Warrior) {
                    Warrior warrior = (Warrior) hero;
                    if (warrior.getWeapon() != null) {
                        bonusAttackStrength = warrior.getWeapon().getAttackStrength();
                        bonusSource = warrior.getWeapon().getName();
                    }
                } else if (hero instanceof Mage) {
                    Mage mage = (Mage) hero;
                    OffensiveStuff learnedSpell = mage.learnSpell(new Spell());
                    if (learnedSpell != null) {
                        bonusAttackStrength = learnedSpell.getAttackStrength();
                        bonusSource = learnedSpell.getName();
                    }
                }

                int totalAttackStrength = baseAttackStrength + bonusAttackStrength;

                dialog.notifyHeroAttack(hero.getName(), name, totalAttackStrength, bonusSource);
                lifePoints -= totalAttackStrength;
                dialog.notifyEnemyLifePoints(lifePoints, name);

                if (lifePoints <= 0) {
                    return name + " is defeated! Remaining health: " + hero.getHealthPoints();
                }

                dialog.notifyEnemyAttack(name, damage);
                hero.reduceLifePoints(damage);
                dialog.notifyRemainingHealth(hero.getHealthPoints());

                if (hero.getHealthPoints() <= 0) {
                    return "You're dead!";
                }
            } else {
                dialog.notifyInvalidChoice();
            }
        }

        return null;
    }

}
