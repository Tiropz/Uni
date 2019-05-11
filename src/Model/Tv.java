package Model;

public class Tv extends GameObject implements Activable {
    public Tv(int x, int y) {
        super(x, y);
    }

    @Override
    public Player activate(Player mainChar, Game game){
        mainChar.rest(10,10, mainChar);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
