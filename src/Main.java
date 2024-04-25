import dnd.Characters;

public class Main {
    public static void main(String[] args) {
//        Character warrior = new Character("Fidavar", 10, 10, "weapon", "shield");
//        Character mage = new Character("Klastomi", 6, 15, "spell", "potion");
        Characters characters = new Characters("Klastomi", "potion");
        System.out.println(characters);
        System.out.println();
    }

}
