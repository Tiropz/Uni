package Model;


public class Shower extends GameObject implements Activable {

    public Shower(int x, int y) {
        super(x, y);
    }
    @Override
    public Player activate(Player mainChar, Game game) {
        mainChar.wash(10, 10, mainChar, game);       //Call wash method for 10 sec and gives +10 Hygiene
        return mainChar;                                       //return mainChar
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
