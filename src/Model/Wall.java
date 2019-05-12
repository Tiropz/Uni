package Model;

public class Wall extends GameObject {

    public Wall(int X, int Y) {
        super(X, Y);
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
