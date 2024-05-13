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
        cases.add(new EnemyCase(2, "Mouhahaaaa !  Meet this enemy !")); // Vous pouvez également utiliser un texte générique ici
        cases.add(new BonusWeaponCase(3, " Lucky you ! Here a new item !"));
        cases.add(new HealthPotionCase(4, "Lucky you ! Here a health potion !"));
    }

    private void initializeRandomEnemyCase(int position, String description) {
        Enemy enemy = createRandomEnemyCase(position, description);
        cases.add(enemy);
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
