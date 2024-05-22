package dnd.boardGame;

import dnd.GameDialog;
import dnd.personna.Character;

public class EmptyCase implements Case {
    private int position;
    private String description;


    public EmptyCase(int position, String description) {
        this.position = position;
        this.description = description;

    }

    public String getDescription() {
        return "a case with no effect";
    }

    public int getPosition() {
        return position;
    }
    @Override
    public String interaction(Character character , GameDialog dialog) {
        return "Nothing really happens...";
    }

}