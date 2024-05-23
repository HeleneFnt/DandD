package dnd.stuff;

import dnd.GameDialog;
import dnd.boardGame.Case;
import dnd.personna.Hero;


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
    public String interaction(Hero hero, GameDialog dialog) {
        return "";
    }

}
