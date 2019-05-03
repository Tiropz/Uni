package Model;

public class Desk extends Block implements Activable {
    public Desk(int x, int y) {
        super(x, y, 0);
    }

    @Override
    public Player activate(Player mainChar, Game game) throws InterruptedException {
        mainChar.work(10,10, mainChar, game);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
