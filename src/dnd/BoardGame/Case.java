package dnd.BoardGame;

import dnd.GameDialog;
import dnd.Personna.Character;

import javax.swing.*;

public interface Case {
    int getPosition();
    String getDescription();
    String interaction(Character character, GameDialog dialog);
}