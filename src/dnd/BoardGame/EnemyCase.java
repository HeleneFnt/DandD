package dnd.BoardGame;

import dnd.Personna.Character;
import dnd.Personna.Enemy;
import dnd.Personna.Mage;

public  class EnemyCase implements Case {
        private int position;
        private String description;

    public EnemyCase(int position, String description) {
            this.position = position;
            this.description = description;
        }

    public String getDescription() {
        return description;
    }

    @Override
    public String interaction(Character character) {
        return "";
    }

    public int getPosition() {
            return position;
        }


}
