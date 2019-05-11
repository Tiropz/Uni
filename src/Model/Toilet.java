package Model;


public class Toilet extends GameObject implements Activable {

    public Toilet(int x, int y) {
        super(x, y);
    }

    @Override
    public Player activate(Player mainChar, Game game) {
        mainChar.pee(10, 3, mainChar, game);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
