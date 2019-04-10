package View;

import Model.BlockUnbreakable;
import Model.Directable;
import Model.GameObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Controller.Mouse;

public class Map extends JPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    public final int MAP_WIDTH = 65;
    public int width_screen;
    public int height_screen;
    public final int MAP_HEIGHT = 40;
    private int BLOC_SIZE;
    private int test = 0;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;
    private ArrayList<GameObject> mapObjects;
    DesignMap actualMap;

    public Map(Integer wm) {
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2*height_screen/3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);

        switch (wm) {
            case 1:
                actualMap = new DesignMap(1);
                break;
            case 2:
                actualMap = new DesignMap(2);
                break;
        }
        this.y_blocks = actualMap.y_blocks;
        this.x_blocks = actualMap.x_blocks;
        this.BLOC_SIZE = (Math.round(3*height_screen/(5*y_blocks)));
        x_middle = (Math.round(width_screen/(2*BLOC_SIZE)));
        System.out.println(x_middle);
        System.out.println(screenSize.getWidth());
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        for (int i = x_middle-(x_blocks/2); i < x_middle+(x_blocks/2)+1; i++) {
            for (int j = 1; j < y_blocks+1; j++) {
                int x = i;
                int y = j;
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 2, BLOC_SIZE - 2);
                g.setColor(Color.BLACK);
                g.drawRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 2, BLOC_SIZE - 2);
            }
        }

        for (GameObject object : this.objects) {
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();

            if (color == 0) {
                g.setColor(Color.DARK_GRAY);
            } else if (color == 1) {
                g.setColor(Color.GRAY);
            } else if (color == 2) {
                g.setColor(Color.BLUE);
            } else if (color == 3) {
                g.setColor(Color.GREEN);
            } else if (color == 4) {
                g.setColor(Color.RED);
            } else if (color == 5) {
                g.setColor(Color.ORANGE);
            }

            g.fillRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 2, BLOC_SIZE - 2);
            g.setColor(Color.BLACK);
            g.drawRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 2, BLOC_SIZE - 2);

            // Decouper en fontions
            if(object instanceof Directable) {
                int direction = ((Directable) object).getDirection();

                int deltaX = 0;
                int deltaY = 0;

                switch (direction) {
                    case Directable.EAST:
                        deltaX = +(BLOC_SIZE-2)/2;
                        break;
                    case Directable.NORTH:
                        deltaY = -(BLOC_SIZE-2)/2;
                        break;
                    case Directable.WEST:
                        deltaX = -(BLOC_SIZE-2)/2;
                        break;
                    case Directable.SOUTH:
                        deltaY = (BLOC_SIZE-2)/2;
                        break;
                }

                int xCenter = x * BLOC_SIZE + (BLOC_SIZE-2)/2;
                int yCenter = y * BLOC_SIZE + (BLOC_SIZE-2)/2;
                g.drawLine(xCenter, yCenter, xCenter + deltaX, yCenter + deltaY);
            }
        }
    }

    public void setObjects(ArrayList<GameObject> objects) {

        this.objects = objects;
    }
    public ArrayList<GameObject> getObjects(Integer wm){
        actualMap = new DesignMap(wm);
        return this.actualMap.getObjects();
    }

    public void redraw() {
        this.repaint();
    }

}
