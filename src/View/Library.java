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
        this.y_blocks = 14;
        this.x_blocks = 13;
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

        Image sol = new ImageIcon("src/Image/table1.png").getImage();



        super.paintComponent(g);
        for (int i = x_middle-(x_blocks/2); i < x_middle+(x_blocks/2)+1; i++) {
            for (int j = 1; j < y_blocks+1; j++) {
                int x = i;
                int y = j;
                g.drawImage(sol,x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }
        }


        Image frigo = new ImageIcon("src/Image/fridge.png").getImage();
        g.drawImage(frigo, (x_middle-(x_blocks/2)+8)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE*2, BLOC_SIZE*2, null);
        for (GameObject object : this.objects) {
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();

            if (color == 0) {
                g.setColor(Color.DARK_GRAY);
            } /* else if (object instanceof Fridge) {
                Image frigo = new ImageIcon("src/Image/frigo_"+object.getColor()+".png").getImage();
                System.out.println("src/Image/frigo_"+object.getColor()+".png");
                g.drawImage(frigo, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }
           */
            else if (object instanceof Kitchen){
                Image kitchen = new ImageIcon("src/Image/kitchen_"+object.getColor()+".png").getImage();
                System.out.println("src/Image/kitchen_"+object.getColor()+".png");
                g.drawImage(kitchen, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }else if (color == 4) {
                // Image frigo = new ImageIcon("src/Image/frigo_h_d.png").getImage();
                //  g.drawImage(frigo, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            } else if (color == 5) {
                //  Image frigo = new ImageIcon("src/Image/frigo_b_g.png").getImage();
                //  g.drawImage(frigo, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }else if (color == 6) {

                //  Image frigo = new ImageIcon("src/Image/frigo_b_d.png").getImage();
                // g.drawImage(frigo, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }

            //g.fillRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE , BLOC_SIZE);
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
        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+1); i++) {
            objects.add(new BlockUnbreakable(i, 0));
            objects.add(new BlockUnbreakable(i, y_blocks+1));
        }
        for (int j = 0; j < y_blocks+2; j++) {
            objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)-1), j));
            objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)+1), j));
        }
        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 1)); //télé
        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+2), 1));

        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+5), 1)); //mur vertical
        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+5), 2));

        for (int i = (x_middle-(x_blocks/2)+10); i < (x_middle+(x_blocks/2)+1); i++) {
            objects.add(new Kitchen(i, 1, i - (x_middle-(x_blocks/2)+10)+1)); //cuisine
            objects.add(new Kitchen(i, 2, i - (x_middle-(x_blocks/2)+10)+4));
        }
        for (int j = 3; j < 5; j++) {
            objects.add(new Kitchen((x_middle+(x_blocks/2)-1), j, j+4)); //suite cuisine
            objects.add(new Kitchen((x_middle+(x_blocks/2)), j, j + 6));
            System.out.println(j+4);
            System.out.println(j+6);


        }
        objects.add(new Fridge((x_middle-(x_blocks/2)+8), 1,1)); //frigo
        objects.add(new Fridge((x_middle-(x_blocks/2)+9), 2,4));
        objects.add(new Fridge((x_middle-(x_blocks/2)+8), 2, 3));
        objects.add(new Fridge((x_middle-(x_blocks/2)+9), 1,2));




        for (int i = (x_middle+(x_blocks/2)-2); i < (x_middle+(x_blocks/2)+1); i++) {
            objects.add(new BlockUnbreakable(i, 8)); //mur horizontal à côté en haut de la porte d'enntrée
        }


        objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 11)); //mur horizontal à côté en bas de la porte d'enntrée
        objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 11));

        for (int j = 11; j < 15; j++) {
            objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-4), j)); //lit + mur
            objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-3), j));
            objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-5), j));
        }

        objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-6), 11)); //mur chambre
        objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-7), 11));

        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 11)); //mur salle de douche

        objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 13)); //toilettes
        objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 13));
        objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 14));
        objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 14));



        for (int j = 11; j < 15; j++) {
            objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)), j)); //douche+mur
        }


        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+4), 14));
        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+4), 13)); //armoire chmabre

        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 14)); //douche
        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 13));

        for (int j = 11; j < 15; j++) {
            objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1)+2, j)); //mur entre chambre et douche
        }

        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 7)); //canapé horizontal
        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+2), 7));

        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 5)); //table basse
        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 4));

        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+3), 5)); //canapé vertical
        objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+3), 4));

        for (int j = 5; j < 9; j++) {
            objects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+5)), j)); //mur entre salon et cuisine
        }

        for (int j = 5; j < 9; j++) {
            objects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+6)), j)); //  chaises + table dans cuisine + mur horizontal
            objects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+7)), j));
        }
    }
}
