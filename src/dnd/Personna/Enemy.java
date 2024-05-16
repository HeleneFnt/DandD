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
        // Demander au joueur s'il veut attaquer ou fuir
        String choice = dialog.askForChoice();

        if (choice.equalsIgnoreCase("f")) {
            // Fuite : reculer d'un nombre de cases aléatoire entre 1 et 6
            int distance = (int) (Math.random() * 6) + 1;
            dialog.notifyFlee(character.getName(), distance);
            int newPosition = character.getPosition() - distance;
            character.setPosition(newPosition);
            // Afficher la nouvelle position du personnage
            dialog.notifyMovePosition(newPosition);
            // Terminer l'interaction
            return "!";
        }


        while (lifePoints > 0 && character.getHealthPoints() > 0) {
            // Tour du personnage
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

            // Tour de l'ennemi
            dialog.notifyThrowdice(); // Demande au joueur de lancer le dé
            int diceRoll = (int) (Math.random() * 6) + 1; // Jet de dé aléatoire entre 1 et 6
            dialog.notifyEnemyAttack(name, damage);
            character.reduceLifePoints(damage);
            dialog.notifyRemainingHealth(character.getHealthPoints());

            if (character.getHealthPoints() <= 0) {
                return "You're dead!";
            }

        }

        // Si l'ennemi ou le personnage n'a plus de points de vie, on termine l'interaction
        return null;
    }
}