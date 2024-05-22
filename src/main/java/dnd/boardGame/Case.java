package dnd.boardGame;

import dnd.GameDialog;
import dnd.personna.Character;

public interface Case {
    int getPosition();
    String getDescription();
    String interaction(Character character, GameDialog dialog);
}