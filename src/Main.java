import dnd.Character;

public class Main {
    public static void main(String[] args) {
        Character mage = new Character();
        Character wizard = new Character("wizard");
        Character starter = new Character("starter", "human");
        System.out.println(mage);
        System.out.println(wizard);
        System.out.println(starter);

    }
}
