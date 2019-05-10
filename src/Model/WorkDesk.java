package Model;

public class WorkDesk extends Block implements Activable {
    public WorkDesk(int x, int y) {
        super(x, y, 0);
    }

    @Override
    public Player activate(Player mainChar, Game game) throws InterruptedException {
        mainChar.work(30,10, mainChar, game);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
