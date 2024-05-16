package dnd.Personna;

import dnd.BoardGame.Case;
import dnd.GameDialog;
import dnd.Stuff.OffensiveStuff;
import dnd.Stuff.Spell;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
    public String interaction(Character character, GameDialog dialog) {
        dialog.notifyPlayerInfo(character.getName(), character.getHealthPoints(), character.getAttackStrength());
        dialog.notifyEnemyInfo(name, lifePoints, damage);

        while (lifePoints > 0 && character.getHealthPoints() > 0) {
            // Déterminer la force d'attaque totale du héros en prenant en compte les bonus
            int baseAttackStrength = character.getAttackStrength();
            int bonusAttackStrength = 0;
            String bonusSource = "";

            // Si le héros a un bonus d'attaque (ex : arme ou sort)
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

            // Notification de l'attaque du héros
            dialog.notifyHeroAttack(character.getName(), name, totalAttackStrength, bonusSource);
            lifePoints -= totalAttackStrength;
            dialog.notifyEnemyLifePoints(lifePoints, name);

            // Vérifier si l'ennemi est vaincu
            if (lifePoints <= 0) {
                return name + " is defeated!";
            }

            // L'ennemi attaque si le personnage est toujours en vie
            dialog.notifyEnemyAttack(name, damage);
            character.reduceLifePoints(damage);
            dialog.notifyRemainingHealth(character.getHealthPoints());

            // Vérifier si le personnage est vaincu
            if (character.getHealthPoints() <= 0) {
                return "You're dead!";
            }
        }

        // Si l'ennemi ou le personnage n'a plus de points de vie, on termine l'interaction
        return null;
    }
}

