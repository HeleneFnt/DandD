package dnd.BoardGame;

import java.util.ArrayList;

public class Board {
    private ArrayList<Case> cases;

    public Board() {
        this.cases = new ArrayList<>();
        initializeCases();
    }

    private void initializeCases() {

        cases.add(new EmptyCase(1, "No effect"));
        cases.add(new EnemyCase(2, "Mouhahaaaa !  Meet this enemy !"));
        cases.add(new BonusWeaponCase(3, " Lucky you ! Here a new item !"));
        cases.add(new HealthPotionCase(4, "Lucky you ! Here a health potion !"));

    }

    public ArrayList<Case> getCases() {
        return cases;
    }
}
