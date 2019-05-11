package Model;

public class BlockUnbreakable extends GameObject {

    public BlockUnbreakable(int X, int Y) {
        super(X, Y);
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
