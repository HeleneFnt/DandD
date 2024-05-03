package dnd.BoardGame;

public class BonusWeaponCase implements Case {
        private int position;
        private String description;

    public BonusWeaponCase(int position, String description) {
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
            return "Positive effect";
        }

        @Override
        public String openEffect() {
            return "You're lucky, here a potion/weapon !";
        }
    }
