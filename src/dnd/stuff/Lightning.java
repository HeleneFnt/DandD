package dnd.stuff;

import dnd.boardGame.Case;
import dnd.GameDialog;
import dnd.personna.Character;

public class Lightning extends Spell implements Case {
    public Lightning() {
        super ("Lightning", 2, "Lightning");
    }

//    public Lightning(int i, String lightning) {
//        super();
//    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Lightning ⚡";
    }

    @Override
    public String interaction(Character character, GameDialog dialog) {
        return "";
    }

}
