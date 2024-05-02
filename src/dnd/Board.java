package dnd;

import java.util.ArrayList;

public class Board {
    private ArrayList<Case> cases;

    public Board() {
        this.cases = new ArrayList<>();
        initializeCases();
    }

    private void initializeCases() {

        cases.add(new EmptyCase(1, "No Effect"));
        cases.add(new NegativeCase(2, "Bad luck, meet this enemy"));
        cases.add(new PositiveCase(3, " Lucky you ! Here a new weapon"));
        cases.add(new PositiveCase(4, "Lucky you ! Here a potion"));

    }



    public ArrayList<Case> getCases() {
        return cases;
    }
}
