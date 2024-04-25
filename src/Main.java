import dnd.Character;
import dnd.DefensiveStuff;
import dnd.OffensiveStuff;

public class Main {
    public static void main(String[] args) {
        Character mage = new Character();
        Character wizard = new Character("wizard");
        Character starter = new Character("starter", "human");
        OffensiveStuff weapon = new OffensiveStuff("wizard", 5,"fireball");
        DefensiveStuff armor = new DefensiveStuff("warrior", 3,"shield");
        System.out.println(mage);
        System.out.println(wizard);
        System.out.println(starter);
        System.out.println(weapon);
        System.out.println(armor);
    }
}
