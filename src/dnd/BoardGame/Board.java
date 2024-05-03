package dnd.BoardGame;

import java.util.ArrayList;

public class Board {
    private ArrayList<Case> cases;

    public Board() {
        this.cases = new ArrayList<>();
        initializeCases();
    }

    private void initializeCases() {

        cases.add(new EmptyCase(1, "", "nothing"));
        cases.add(new EnemyCase(2, "gdf"));
        cases.add(new BonusWeaponCase(3, " Lucky you ! Here a new weapon"));
        cases.add(new BonusProtectionCase(4, "Lucky you ! Here a potion"));

    }

    public ArrayList<Case> getCases() {
        return cases;
    }
}
