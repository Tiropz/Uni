package Model;

import javax.swing.*;

public class Kitchen extends Block implements Activable {
    private static JLabel lblClock = new JLabel("");
    private String time;
    public Kitchen(int x, int y, int color) {
        super(x, y, color);
    }

    @Override
    public Player activate(Player mainChar) {
        mainChar.makeFood(1,10, mainChar);
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
