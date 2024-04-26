import dnd.Game;
import dnd.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
        Game game = new Game();
        game.playTurn();
    }
}
