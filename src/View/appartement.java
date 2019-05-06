package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class appartement extends JPanel implements MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> appartementObjects = new ArrayList<GameObject>();
    public int width_screen;
    public int height_screen;
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;

    public appartement() {
        this.y_blocks = 13;
        this.x_blocks = 17;
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2 * height_screen / 3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.BLOC_SIZE = (Math.round(5 * height_screen / (9 * y_blocks)));


        x_middle = (Math.round(width_screen / (2 * BLOC_SIZE)));
        System.out.println("salut" + x_middle);
        System.out.println(screenSize.getWidth());
        construct();
    }


    public void paint(Graphics g) {

        Image sol_appartement = new ImageIcon("src/Image/sol.jpg").getImage();




        super.paintComponent(g);
        for (int i = x_middle - (x_blocks / 2); i < x_middle + (x_blocks / 2) + 3; i++) {
            for (int j = 1; j < y_blocks + 2; j++) {
                int x = i;
                int y = j;
                g.drawImage(sol_appartement, x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }

        }

    }

    public Player setObjects(ArrayList<GameObject> objects, Player mainChar, MapInterface currentMap) {

        this.appartementObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle + 1, y_blocks);
        return mainChar;
    }

    public ArrayList<GameObject> getObjects() {
        return this.appartementObjects;
    }

    public void redraw() {
        this.repaint();
    }

    private void construct() {
        this.appartementObjects.clear();
    }
}
