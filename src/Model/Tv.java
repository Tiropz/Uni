package Model;

import javax.swing.*;

public class Tv extends Block implements Activable {
    public Tv(int x, int y, int color) {
        super(x, y, color);
    }

    @Override
    public Player activate(Player mainChar) throws InterruptedException {
        mainChar.rest(10,10, mainChar);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
