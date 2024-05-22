package dnd.personna;

import dnd.GameDialog;
import dnd.boardGame.Case;
import dnd.stuff.OffensiveStuff;
import dnd.stuff.Spell;
import dnd.personna.Character;

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

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getLifePoints() {
//        return lifePoints;
//    }
//
//    public void setLifePoints(int lifePoints) {
//        this.lifePoints = lifePoints;
//    }
//
//    public int getDamage() {
//        return damage;
//    }
//
//    public void setDamage(int damage) {
//        this.damage = damage;
//    }

    @Override
    public int getPosition() {
        return position;
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
            // Demander le choix du joueur : attaquer ou fuir
            String choice = dialog.askForChoice();

            if (choice.equalsIgnoreCase("F")) {
                // Fuir

                return "Flee";  // Indiquer que le joueur a choisi de fuir
            } else if (choice.equalsIgnoreCase("A")) {
                // Attaque du héros
                int baseAttackStrength = character.getAttackStrength();
                int bonusAttackStrength = 0;
                String bonusSource = "";

                if (character instanceof Warrior) {
                    Warrior warrior = (Warrior) character;
                    if (warrior.getWeapon() != null) {
                        bonusAttackStrength = warrior.getWeapon().getAttackStrength();
                        bonusSource = warrior.getWeapon().getName();
                    }
                } else if (character instanceof Mage) {
                    Mage mage = (Mage) character;
                    OffensiveStuff learnedSpell = mage.learnSpell(new Spell());
                    if (learnedSpell != null) {
                        bonusAttackStrength = learnedSpell.getAttackStrength();
                        bonusSource = learnedSpell.getName();
                    }
                }

                int totalAttackStrength = baseAttackStrength + bonusAttackStrength;

                dialog.notifyHeroAttack(character.getName(), name, totalAttackStrength, bonusSource);
                lifePoints -= totalAttackStrength;
                dialog.notifyEnemyLifePoints(lifePoints, name);

                if (lifePoints <= 0) {
                    return name + " is defeated! Remaining health: " + character.getHealthPoints();
                }

                dialog.notifyEnemyAttack(name, damage);
                character.reduceLifePoints(damage);
                dialog.notifyRemainingHealth(character.getHealthPoints());

                if (character.getHealthPoints() <= 0) {
                    return "You're dead!";
                }
            } else {
                dialog.notifyInvalidChoice();
            }
        }

        return null;
    }
//
//    public int getHealthPoints() {
//        return lifePoints;
//    }
}
