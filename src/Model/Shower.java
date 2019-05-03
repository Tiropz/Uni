package Model;

import javax.swing.*;

public class Shower extends Block implements Activable {
    private static JLabel lblClock = new JLabel("");
    private String time;
    public Shower(int x, int y) {
        super(x, y, 0);
    }

    @Override
    public Player activate(Player mainChar, Game game) throws InterruptedException {
        mainChar.wash(10, 3, mainChar, game);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
