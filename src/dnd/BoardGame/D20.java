package dnd.BoardGame;

public class D20 implements Dice{
    public int throwDice() {
        return (int) (Math.random() * 20) + 1;
    }
}
