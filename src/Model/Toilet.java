package Model;

import javax.swing.*;

public class Toilet extends Block implements Activable {
    private static JLabel lblClock = new JLabel("");
    private String time;
    public Toilet(int x, int y) {
        super(x, y, 0);
    }

    @Override
    public Player activate(Player mainChar, Game game) throws InterruptedException {
        mainChar.pee(10, 3, mainChar, game);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
