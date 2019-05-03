package Model;

import javax.swing.*;

public class Bed extends Block implements Activable {
    private static JLabel lblClock = new JLabel("");
    private String time;
    public Bed(int x, int y) {
        super(x, y, 0);
    }

    @Override
    public Player activate(Player mainChar, Game game) throws InterruptedException {
        mainChar.rest(30,30, mainChar);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
