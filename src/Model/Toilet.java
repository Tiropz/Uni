package Model;

import javax.swing.*;

public class Toilet extends Block implements Activable {
    private static JLabel lblClock = new JLabel("");
    private String time;
    public Toilet(int x, int y, int color) {
        super(x, y, color);
    }

    @Override
    public Player activate(Player mainChar) throws InterruptedException {
        mainChar.pee(-10, 3, mainChar);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
