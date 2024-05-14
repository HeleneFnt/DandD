package dnd.Stuff;

import dnd.BoardGame.Case;
import dnd.GameDialog;
import dnd.Personna.Character;

public class Club extends Weapon implements Case {
    public Club() {
        super ("Club",3, "Sword");
    }

    public Club(int i, String club) {
        super();
    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String interaction(Character character, GameDialog dialog) {
        return "";
    }
}
