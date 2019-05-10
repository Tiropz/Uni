package Model;

public class Desk extends Block implements Activable {
    int val;
    public Desk(int x, int y, int val) {
        super(x, y, 0);
        this.val = val;
    }

    @Override
    public Player activate(Player mainChar, Game game) throws InterruptedException {
        mainChar.work(val,10, mainChar, game);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
