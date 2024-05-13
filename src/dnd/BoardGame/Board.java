package dnd.BoardGame;

import dnd.Personna.Enemy;
import dnd.Personna.Gobelin;
import dnd.Personna.Wizard;
import dnd.Personna.Dragon;

import java.util.ArrayList;

public class Board {
    private ArrayList<Case> cases;

    public Board() {
        this.cases = new ArrayList<>();
        initializeCases();
    }

    private void initializeCases() {
        cases.add(new EmptyCase(1, "No effect"));
        initializeRandomEnemyCase(2, "Mouhahaaaa !  Meet this enemy !");
        cases.add(new BonusWeaponCase(3, " Lucky you ! Here a new item !"));
        cases.add(new HealthPotionCase(4, "Lucky you ! Here a health potion !"));
    }

    private void initializeRandomEnemyCase(int position, String description) {
        Enemy enemy = createRandomEnemyCase(position, description);
        String interactionResult = enemy.interaction(null); // Passer null comme paramètre pour la méthode interaction car le personnage n'est pas nécessaire ici
        cases.add(enemy); // Ajoute l'ennemi à la liste de cases
    }


    private Enemy createRandomEnemyCase(int position, String description) {
        int randomEnemyType = (int) (Math.random() * 3);
        switch (randomEnemyType) {
            case 0:
                return new Gobelin("Gobelin");
            case 1:
                return new Wizard("Wizard");
            case 2:
                return new Dragon("Dragon");
            default:
                return new Gobelin("Default Gobelin"); // En cas d'erreur, retourne un gobelin par défaut
        }
    }


    public ArrayList<Case> getCases() {
        return cases;
    }
}
