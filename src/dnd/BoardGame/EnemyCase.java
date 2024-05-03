package dnd.BoardGame;

import dnd.Personna.Character;
import dnd.Personna.Enemy;
import dnd.Personna.Mage;

public abstract class EnemyCase implements Case {
        private int position;
        private String description;

    public EnemyCase(int position, String description) {
            this.position = position;
            this.description = description;
        }

    public String getDescription() {
        return description;
    }

    public int getPosition() {
            return position;
        }

    public String interaction(Enemy enemy) {
       String enemyName = enemy.getName();
       return "You encounter an enemy: " + enemyName;
    }
}
