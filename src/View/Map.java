package View;

import Model.BlockUnbreakable;
import Model.Directable;
import Model.GameObject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Controller.Mouse;

public class Map extends JPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public double height_screen;
    public double width_screen;
    private ArrayList<GameObject> objects = null;
    public final int MAP_WIDTH = 65;
    public final int MAP_HEIGHT = 27;
    private int BLOC_SIZE;
    public int valeur_moyenne_x;
    public int nombre_de_blocs_y = 20;

    public Map() {
        width_screen = screenSize.getWidth();
        height_screen = screenSize.getHeight();
        System.out.println(screenSize.getWidth());
        System.out.println(screenSize.getHeight());
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension((int)width_screen, (int)(2*height_screen/(3))));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);

    }

    public void paint(Graphics g) {

        BLOC_SIZE = (int) (long) (Math.round(3*height_screen/(5*nombre_de_blocs_y)));
        valeur_moyenne_x = (int) (long)((Math.round(width_screen/BLOC_SIZE))/2);
        System.out.println(valeur_moyenne_x);
        System.out.println(BLOC_SIZE);


        for (int i = valeur_moyenne_x-13; i < valeur_moyenne_x+14; i++) {
            for (int j = 1; j < nombre_de_blocs_y+1; j++) {
                int x = i;
                int y = j;
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 2, BLOC_SIZE - 2);
                g.setColor(Color.BLACK);
                g.drawRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE - 2, BLOC_SIZE - 2);
            }
        }

        for (int i = valeur_moyenne_x-13; i < valeur_moyenne_x+14; i++) {
            objects.add(new BlockUnbreakable(i, 0));
            objects.add(new BlockUnbreakable(i, nombre_de_blocs_y+1));
        }
        for (int j = 0; j < nombre_de_blocs_y; j++){
            objects.add(new BlockUnbreakable(valeur_moyenne_x-13, j));
            objects.add(new BlockUnbreakable(valeur_moyenne_x+14,j));
        }
        for (int j = 4; j <7; j++){
            objects.add(new BlockUnbreakable(22, j));
        }
        for (int j = 9; j <13; j++){
            objects.add(new BlockUnbreakable(22, j));
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

    public void redraw() {
        this.repaint();
    }

}
