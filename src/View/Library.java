package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Library extends JPanel implements MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    public int width_screen;
    public int height_screen;
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;
    public Library() {
        this.y_blocks = 17;
        this.x_blocks = 17;
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2*height_screen/3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.BLOC_SIZE = (Math.round(3*height_screen/(5*y_blocks)));
        x_middle = (Math.round(width_screen/(2*BLOC_SIZE)));
        System.out.println(x_middle);
        System.out.println(screenSize.getWidth());
        construct();
    }



    public void paint(Graphics g) {



        Image sol = new ImageIcon("src/Image/sol_bibli.jpg").getImage();
        Image poubelle = new ImageIcon("src/Image/trash.png").getImage();
        Image plante = new ImageIcon("src/Image/plante.png").getImage();
        Image chaise_bas = new ImageIcon("src/Image/chaise_projet.png").getImage();
        Image chaise_haut = new ImageIcon("src/Image/chaise_haut").getImage();
        Image chaise_droite = new ImageIcon("src/Image/chaise_droite.png").getImage();
        Image chaise_gauche = new ImageIcon("src/Image/chaise_gauche.png").getImage();
        Image table = new ImageIcon("src/Image/table_cuisine.png").getImage();
        Image bibliothèque = new ImageIcon("src/Image/bibliothèque.png").getImage();

        super.paintComponent(g);
        for (int i = x_middle-(x_blocks/2); i < x_middle+(x_blocks/2)+1; i++) {
            for (int j = 1; j < y_blocks+1; j++) {
                int x = i;
                int y = j;
                g.drawImage(sol,x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }
        }
        for (int i = x_middle-5; i < x_middle+8; i = i+3) {
            g.drawImage(bibliothèque, i* BLOC_SIZE, 2 * BLOC_SIZE, BLOC_SIZE, 3 * BLOC_SIZE, null);
        }

        for (int i = x_middle-7; i < x_middle+7; i = i+5) {
            g.drawImage(poubelle, i* BLOC_SIZE, 9 * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(biblio, i* BLOC_SIZE, 9 * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        g.drawImage(poubelle,(x_middle-2) * BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(poubelle,(x_middle+4) * BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(plante,((x_middle)-x_blocks/2) * BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(table,(x_middle-1) * BLOC_SIZE, 8*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null );
        g.drawImage(table,(x_middle+4) * BLOC_SIZE, 8*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null );
        g.drawImage(plante,(x_middle+x_blocks/2) * BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(plante,(x_middle+x_blocks/2) * BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(table,(x_middle-5) * BLOC_SIZE, 7*BLOC_SIZE, 2*BLOC_SIZE, 3*BLOC_SIZE, null );









        for (GameObject object : this.objects) {
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();

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
                g.setColor(Color.BLACK);
                g.drawLine(xCenter, yCenter, xCenter + deltaX, yCenter + deltaY);
            }
        }
    }

    public void setObjects(ArrayList<GameObject> objects) {

        this.objects = objects;
    }
    public ArrayList<GameObject> getObjects(){
        return this.objects;
    }

    public void redraw() {
        this.repaint();
    }
    private void construct() {
        for (int i = (x_middle - (x_blocks / 2) - 1); i < (x_middle + (x_blocks / 2) + 1); i++) {
            objects.add(new BlockUnbreakable(i, 0));
            objects.add(new BlockUnbreakable(i, y_blocks + 1));
        }
        for (int j = 0; j < y_blocks + 2; j++) {
            objects.add(new BlockUnbreakable((x_middle - (x_blocks / 2) - 1), j));
            objects.add(new BlockUnbreakable((x_middle + (x_blocks / 2) + 1), j));
        }

    }



}
