package dnd;

public class Color {
    public class Colors {
        public final String ANSI_RESET = "\u001B[0m";
        public final String ANSI_RED = "\u001B[31m";
        public final String ANSI_GREEN = "\u001B[32m";
        public final String ANSI_YELLOW = "\u001B[33m";
        public final String ANSI_BLUE = "\u001B[34m";
        public final String ANSI_PURPLE = "\u001B[35m";
        public final String ANSI_CYAN = "\u001B[36m";
        public final String ANSI_WHITE = "\u001B[37m";

        public String randomColor() {
            String[] colors = {ANSI_RED, ANSI_GREEN, ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE};
            return colors[(int) (Math.random() * colors.length)];
        }

        public String colored(String color, String text) {
            return color + text + ANSI_RESET;
        }
    }
}
