package dnd.BoardGame;

import dnd.Personna.Character;

public class EmptyCase implements Case {
    private int position;
    private String description;
    private String interaction;

    public EmptyCase(int position, String description, String interaction) {
        this.position = position;
        this.description = description;
        this.interaction = interaction;
    }

    public String getDescription() {
        return "No Effect";
    }

    public int getPosition() {
        return position;
    }
    @Override
    public String interaction(Character character) {
        return "Nothing really happens...";
    }

}