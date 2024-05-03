package dnd.BoardGame;

import dnd.Personna.Character;

public class BonusWeaponCase implements Case {
        private int position;
        private String description;

    public BonusWeaponCase(int position, String description) {
            this.position = position;
            this.description = description;
        }

    public String getDescription() {
        return description;
    }

    @Override
    public String interaction(Character character) {
        return "weapon";
    }

    public int getPosition() {
            return position;
        }

}
