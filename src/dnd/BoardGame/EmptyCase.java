package dnd.BoardGame;

public class EmptyCase implements Case {
    private int position;
    private String description;

    public EmptyCase(int position, String description) {
        this.position = position;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getEffect() {
        return "No effect";
    }

    @Override
    public String openEffect() {
        return "Nothing really happens";
    }
}