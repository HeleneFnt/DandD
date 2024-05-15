package dnd.BoardGame;

import dnd.GameDialog;
import dnd.Personna.Character;


public interface Case {
    int getPosition();
    String getDescription();
    String interaction(Character character, GameDialog dialog);
}