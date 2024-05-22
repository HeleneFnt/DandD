package dnd.boardGame;

import dnd.GameDialog;
import dnd.personna.Character;

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

    @Override
    public String interaction(Character character , GameDialog dialog) {
        return "You encountered an enemy!";
    }

}