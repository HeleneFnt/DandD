package dnd.boardGame;

import dnd.GameDialog;
import dnd.personna.Hero;

public interface Case {
    int getPosition();
    String getDescription();
    String interaction(Hero hero, GameDialog dialog);
}