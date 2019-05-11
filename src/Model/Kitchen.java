package Model;

public class Kitchen extends GameObject implements Activable {

    public Kitchen(int x, int y) {
        super(x, y);
    }

    @Override
    public Player activate(Player mainChar, Game game) {
        mainChar.makeFood(1,10, mainChar, game);        //Call makeFood method for 10 sec and gives +1 foodFridge
        return mainChar;                                           //return mainChar
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
