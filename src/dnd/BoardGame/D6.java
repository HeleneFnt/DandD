package dnd.BoardGame;

public class D6 implements Dice{
    public int throwDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
