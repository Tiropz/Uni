package Model;

public class Fridge extends Block implements Activable {
    public Fridge(int x, int y) {
        super(x, y, 3);
    }

    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public Player activate(Player mainChar) {
        mainChar.hunger += 1;
        return mainChar;
    }
}
