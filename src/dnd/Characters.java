package dnd;

public class Characters {
    private String name;
    private int healthPoints;
    private int attackStrength;
    private  String offensiveStuff;
    private  String defensiveStuff;

    // Constructeur de personnages sans paramètres
//    public Character() {
//        this.name = "";
//        this.healthPoints = 0;
//        this.attackStrength = 0;
//        this.offensiveStuff = null;
//        this.defensiveStuff = null;
//    }
    // Constructeur de personnages avec nom
//    public Character(String name) {
//        this.name = name;
//        this.healthPoints = 0;
//        this.attackStrength = 0;
//        this.offensiveStuff = null;
//        this.defensiveStuff = null;
//    }
    // Constructeur de personnages avec nom et type
//    public Character(String name, String type) {
//        this.name = name;
//        this.healthPoints = 0;
//        this.attackStrength = 0;
//        this.offensiveStuff = null;
//        this.defensiveStuff = null;
//    }

    public Characters(String name, String type) {
        this.name = name;
        this.healthPoints = 0;
        this.attackStrength = 0;
        this.offensiveStuff = type;
        this.defensiveStuff = null;
    }

}
