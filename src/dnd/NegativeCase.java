package dnd;

public class NegativeCase implements Case {
        private int position;
        private String description;

    public NegativeCase(int position, String description) {
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
            return "Negative effect";
        }

        @Override
        public String openEffect() {
            return "Bad luck, meet this Gobelin";
        }
    }
