package Model;

import javax.swing.*;

public class Couch extends Block implements Activable {
    private static JLabel lblClock = new JLabel("");
    private String time;
    public Couch(int x, int y, int color) {
        super(x, y, color);
    }

    @Override
    public Player activate(Player mainChar, Game game) throws InterruptedException {
        mainChar.rest(10,10, mainChar);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
