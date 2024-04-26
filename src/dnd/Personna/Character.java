package dnd.Personna;

public class Character {
    private String type;
    private String name;
    private int healthPoints;
    private int attackStrength;
    private String offensiveStuff;
    private String defensiveStuff;

    // Constructeur de personnages sans paramètres
    public Character() {
        this.name = "";
        this.healthPoints = 10;
        this.attackStrength = 10;
    }

    // Constructeur de personnages avec nom
    public Character(String name) {
        this();
        this.name = name;
    }

    // Constructeur de personnages avec nom et type
    public Character(String name, String type) {
        this(name);
        this.type = type;
        if (type.equals("warrior")) {
            this.offensiveStuff = new String("Sword");
            this.defensiveStuff = new String("Shield");
        } else if (type.equals("mage")){
            this.offensiveStuff = new String("Fireball");
            this.defensiveStuff = new String("Potion");
    }
}
    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public String getOffensiveStuff() {
        return offensiveStuff;
    }

    public void setOffensiveStuff(String offensiveStuff) {
        this.offensiveStuff = offensiveStuff;
    }

    public String getDefensiveStuff() {
        return defensiveStuff;
    }

    public void setDefensiveStuff(String defensiveStuff) {
        this.defensiveStuff = defensiveStuff;
    }


    @Override // surcharge de la méthode tiString()
    public String toString() {
        return "Name: " + name + ", HP: " + healthPoints + ", Attack: " + attackStrength +
                ", Offensive Stuff: " + offensiveStuff + ", Defensive Stuff: " + defensiveStuff;
    }
}