package Model;

public class Door extends Block implements Activable {
    public Door(int x, int y) {
        super(x, y, 2);
    }

    @Override
    public Player activate(Player mainChar) {
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return false;
    }
}
