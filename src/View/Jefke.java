package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Jefke extends JPanel implements MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    public int width_screen;
    public int height_screen;
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;

    public Jefke() {
        this.y_blocks = 13;
        this.x_blocks = 22;
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2 * height_screen / 3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.BLOC_SIZE = (Math.round(5 * height_screen / (9 * y_blocks)));
        x_middle = (Math.round(width_screen / (2 * BLOC_SIZE)));
        System.out.println("coucou" + x_middle);
        System.out.println("coucou" + y_blocks);
        System.out.println(screenSize.getWidth());
        construct();
    }


    public void paint(Graphics g) {

        Image sol_jefke = new ImageIcon("src/Image/sol_jefke.jpg").getImage();
        Image pompe_bière = new ImageIcon("src/Image/pompe_biere.png").getImage();
        Image bar = new ImageIcon("src/Image/sol_2.jpg").getImage();
        Image banquette = new ImageIcon("src/Image/banc.png").getImage();
        Image banc = new ImageIcon("src/Image/banc.jpg").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();

        super.paintComponent(g);
        for (int i = x_middle - (x_blocks / 2); i < x_middle + (x_blocks / 2) + 2; i++) {
            for (int j = 1; j < y_blocks + 1; j++) {
                int x = i;
                int y = j;
                g.drawImage(sol_jefke, x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }

        }

        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+2); i++) {
            g.drawImage(brique, i*BLOC_SIZE, 0, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(brique, i*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int i = 6; i < x_middle-1; i++){
            g.drawImage(bar, (i*BLOC_SIZE), (y_blocks-4)*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE,null);
        }
        for (int j = y_blocks-3; j < y_blocks+1; j++){
            g.drawImage(bar, (x_middle-2)*BLOC_SIZE, j*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE,null);
        }

        for (int i = 8; i < 12; i = i + 3){
            g.drawImage(pompe_bière, i*BLOC_SIZE, (y_blocks-2)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
        }


            g.drawImage(banc, 28*BLOC_SIZE, (y_blocks-3)*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
            g.drawImage(banquette, 28*BLOC_SIZE, (y_blocks-1)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banquette, 28*BLOC_SIZE, (y_blocks-4)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banquette, 28*BLOC_SIZE, (y_blocks-9)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banc, 28*BLOC_SIZE, (y_blocks-11)*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
            g.drawImage(banquette, 28*BLOC_SIZE, (y_blocks-12)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);



        for (GameObject object : this.objects) {
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();

            if (object instanceof Directable) {
                int direction = ((Directable) object).getDirection();

                int deltaX = 0;
                int deltaY = 0;

                switch (direction) {
                    case Directable.EAST:
                        deltaX = +(BLOC_SIZE - 2) / 2;
                        break;
                    case Directable.NORTH:
                        deltaY = -(BLOC_SIZE - 2) / 2;
                        break;
                    case Directable.WEST:
                        deltaX = -(BLOC_SIZE - 2) / 2;
                        break;
                    case Directable.SOUTH:
                        deltaY = (BLOC_SIZE - 2) / 2;
                        break;
                }

                int xCenter = x * BLOC_SIZE + (BLOC_SIZE - 2) / 2;
                int yCenter = y * BLOC_SIZE + (BLOC_SIZE - 2) / 2;
                g.setColor(Color.BLACK);
                g.drawLine(xCenter, yCenter, xCenter + deltaX, yCenter + deltaY);
            }
        }
    }


    public void setObjects(ArrayList<GameObject> objects) {

        this.objects = objects;
    }

    public ArrayList<GameObject> getObjects() {
        return this.objects;
    }

    public void redraw() {
        this.repaint();
    }

    private void construct() {
        objects.add(new BlockUnbreakable(2, 9));
    }
}