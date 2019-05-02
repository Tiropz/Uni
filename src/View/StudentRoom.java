package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentRoom extends JPanel implements MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> StudentObjects = new ArrayList<GameObject>();
    public int width_screen;
    public int height_screen;
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;
    public StudentRoom() {
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
        System.out.println("testi"+ x_middle);
        System.out.println("prout" +screenSize.getWidth());
        construct();
    }



    public void paint(Graphics g) {
        System.out.println("PaintStud");
        Image sol = new ImageIcon("src/Image/sol_2.jpg").getImage();


        Image wall = new ImageIcon("src/Image/wall.jpg").getImage();
        super.paintComponent(g);
        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+1); i++) {
            g.setColor(Color.BLACK);
            g.drawImage(wall,i * BLOC_SIZE, 0, BLOC_SIZE, BLOC_SIZE, null );
            g.drawImage(wall,i * BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );

        }
        for (int j = 0; j < y_blocks+2; j++) {
            g.drawImage(wall,(x_middle-(x_blocks/2)-1)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE,null );
            g.drawImage(wall,(x_middle+(x_blocks/2)+1)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE,null );

        }
        for (int i = x_middle-(x_blocks/2); i < x_middle+(x_blocks/2)+2; i++) {
            for (int j = 1; j < y_blocks+1; j++) {
                Image sol_kot = new ImageIcon("src/Image/sol.jpg").getImage();
                g.drawImage(sol_kot, i*BLOC_SIZE, j*BLOC_SIZE,BLOC_SIZE, BLOC_SIZE, null);
            }
        }
        System.out.println(BLOC_SIZE);
       // System.out.println("Bonjour");


        Image frigo = new ImageIcon("src/Image/frigo_projet.png").getImage();
        g.drawImage(frigo, (x_middle-(x_blocks/2)+8)*BLOC_SIZE, BLOC_SIZE,2*BLOC_SIZE, 2*BLOC_SIZE, null);
        Image sofa_horizontal = new ImageIcon("src/Image/sofa.png").getImage();
        g.drawImage(sofa_horizontal, ((x_middle-(x_blocks/2)))*BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE*4, BLOC_SIZE*2, null);
        Image tv = new ImageIcon("src/Image/tv.png").getImage();
        g.drawImage(tv, (x_middle-(x_blocks/2))*BLOC_SIZE, 1*BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, null);
        Image table_basse = new ImageIcon("src/Image/table_basse.png").getImage();
        g.drawImage(table_basse, ((x_middle-(x_blocks/2))+1)*BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        Image plaque_cuisson = new ImageIcon("src/Image/plaque_cuisson.png").getImage();
        g.drawImage(plaque_cuisson, (x_middle+(x_blocks/2)-2)*BLOC_SIZE, 1*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);
        Image évier = new ImageIcon("src/Image/évier.png").getImage();
        g.drawImage(évier, (x_middle+(x_blocks/2)-1)*BLOC_SIZE, 3 *BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
        Image chaise = new ImageIcon("src/Image/chaise_projet.png").getImage();
        g.drawImage(chaise, (x_middle-(x_blocks/2)+7)*BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(chaise, (x_middle-(x_blocks/2)+6)*BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        Image table_cuisine = new ImageIcon("src/Image/table_cuisine.png").getImage();
        g.drawImage(table_cuisine, (x_middle-(x_blocks/2)+6)*BLOC_SIZE, 6*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
        Image douche = new ImageIcon("src/Image/douche.png").getImage();
        g.drawImage(douche, (x_middle-(x_blocks/2)+11)*BLOC_SIZE, 13*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
        Image lavabot = new ImageIcon("src/Image/lavabot_projet.png").getImage();
        g.drawImage(lavabot, (x_middle-(x_blocks/2)+10)*BLOC_SIZE, 14*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        Image lit = new ImageIcon("src/Image/lit_projet.png").getImage();
        g.drawImage(lit, (x_middle-(x_blocks/2)+7)*BLOC_SIZE, 12*BLOC_SIZE, 2*BLOC_SIZE, 3*BLOC_SIZE, null);
        Image toilettes = new ImageIcon("src/Image/toilettes.png").getImage();
        g.drawImage(toilettes, (x_middle-(x_blocks/2))*BLOC_SIZE, 13*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
        Image lavabot2 = new ImageIcon("src/Image/lavabot_projet2.png").getImage();
        g.drawImage(lavabot2, (x_middle-(x_blocks/2))*BLOC_SIZE, 12*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        Image armoire = new ImageIcon("src/Image/armoire.png").getImage();
        g.drawImage(armoire, (x_middle-(x_blocks/2)+4)*BLOC_SIZE, 13*BLOC_SIZE, BLOC_SIZE, 2*BLOC_SIZE, null);
        Image chaise2 = new ImageIcon("src/Image/chaise_projet2.png").getImage();
        g.drawImage(chaise2, (x_middle-(x_blocks/2)+1)*BLOC_SIZE, 9*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        Image bureau = new ImageIcon("src/Image/bureau_projet.png").getImage();
        g.drawImage(bureau, (x_middle-(x_blocks/2)+1)*BLOC_SIZE, 8*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
        Image porte = new ImageIcon("src/Image/porte.png").getImage();
        g.drawImage(porte, (x_middle+(x_blocks/2)+1)*BLOC_SIZE, 9*BLOC_SIZE, BLOC_SIZE, 2*BLOC_SIZE, null);


        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();
        g.drawImage(brique, (x_middle-(x_blocks/2)+5)*BLOC_SIZE, 1*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique, (x_middle-(x_blocks/2)+5)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        for (int i = (x_middle+(x_blocks/2)-2); i < (x_middle+(x_blocks/2)+1); i++) {
            g.drawImage(brique,i*BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }
        g.drawImage(brique,(x_middle+(x_blocks/2))*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-1)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-6)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-7)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-5)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-4)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-3)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-3)*BLOC_SIZE, 12*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-3)*BLOC_SIZE, 13*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-3)*BLOC_SIZE, 14*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-9)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-9)*BLOC_SIZE, 12*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-9)*BLOC_SIZE, 13*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-9)*BLOC_SIZE, 14*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-12)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,(x_middle+(x_blocks/2)-11)*BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        for (int j = 5; j < 9; j++) {
            g.drawImage(brique,((x_middle-(x_blocks/2)+5))*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }
        g.drawImage(brique,((x_middle-(x_blocks/2)+6))*BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,((x_middle-(x_blocks/2)+7))*BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+1); i++) {
            g.drawImage(brique, i*BLOC_SIZE, 0, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(brique, i*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int j = 0; j < 9; j++) {
            g.drawImage(brique, (x_middle-(x_blocks/2)-1)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(brique, (x_middle+(x_blocks/2)+1)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int j = 0; j < y_blocks+2; j++) {
            g.drawImage(brique, (x_middle-(x_blocks/2)-1)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int j = 11; j < y_blocks+2; j++) {

            g.drawImage(brique, (x_middle+(x_blocks/2)+1)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }



        for (GameObject object : this.StudentObjects) {
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();

            if (color == 0) {
                g.setColor(Color.DARK_GRAY);
            }
            /*else if (object instanceof Kitchen){
                Image kitchen = new ImageIcon("src/Image/kitchen_"+object.getColor()+".png").getImage();
                System.out.println("src/Image/kitchen_"+object.getColor()+".png");
                g.drawImage(kitchen, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }*/
            else if (color == 4) {
                // Image frigo = new ImageIcon("src/Image/frigo_h_d.png").getImage();
                //  g.drawImage(frigo, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            } else if (color == 5) {
                //  Image frigo = new ImageIcon("src/Image/frigo_b_g.png").getImage();
                //  g.drawImage(frigo, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }else if (color == 6) {

                //  Image frigo = new ImageIcon("src/Image/frigo_b_d.png").getImage();
                // g.drawImage(frigo, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }/*else if (color == 7) {
                Image canapé = new ImageIcon("src/Image/sofa.png").getImage();
                g.drawImage(frigo, x*BLOC_SIZE, y*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            }*/

           // g.fillRect(x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE );
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

    public Player setObjects(ArrayList<GameObject> objects, Player mainChar, MapInterface currentMap) {
        this.StudentObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle+(x_blocks/2),9);
        System.out.println("NbreSS " + this.StudentObjects.size());
        return mainChar;
    }
    public ArrayList<GameObject> getObjects(){
        System.out.println("NbreSG " + this.StudentObjects.size());

        return this.StudentObjects;
    }

    public void redraw() {
        this.repaint();
    }
    private void construct() {
        this.StudentObjects.clear();
        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+1); i++) {
            StudentObjects.add(new BlockUnbreakable(i, 0));
            StudentObjects.add(new BlockUnbreakable(i, y_blocks+1));
        }
        for (int j = 0; j < y_blocks+2; j++) {
            StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)-1), j));
        }
        for (int j = 0; j < y_blocks-5; j++) {
            StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)+1), j));

        }

        for (int j = 11; j < y_blocks; j++) {
            StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)+1), j));
        }
        StudentObjects.add(new Door((x_middle+(x_blocks/2)+1), 9));
        StudentObjects.add(new Door((x_middle+(x_blocks/2)+1), 10));

        StudentObjects.add(new Tv((x_middle-(x_blocks/2)+1), 1, 0)); //télé
        StudentObjects.add(new Tv((x_middle-(x_blocks/2)+2), 1, 0));
        StudentObjects.add(new Tv((x_middle-(x_blocks/2)), 1, 0));

        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 8)); //bureau + chaise
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 9));
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+2), 8));

        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+5), 1)); //mur vertical
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+5), 2));


        for (int i = (x_middle-(x_blocks/2)+10); i < (x_middle+(x_blocks/2)+1); i++) {
            StudentObjects.add(new Kitchen(i, 1, i - (x_middle-(x_blocks/2)+10)+1)); //cuisine
            StudentObjects.add(new Kitchen(i, 2, i - (x_middle-(x_blocks/2)+10)+4));
        }
        for (int j = 3; j < 5; j++) {
            StudentObjects.add(new Kitchen((x_middle+(x_blocks/2)-1), j, j+4)); //suite cuisine
            StudentObjects.add(new Kitchen((x_middle+(x_blocks/2)), j, j + 6));
            System.out.println(j+4);
            System.out.println(j+6);


        }
        StudentObjects.add(new Fridge((x_middle-(x_blocks/2)+8), 1)); //frigo
        StudentObjects.add(new Fridge((x_middle-(x_blocks/2)+9), 1));
        StudentObjects.add(new Fridge((x_middle-(x_blocks/2)+8), 2));
        StudentObjects.add(new Fridge((x_middle-(x_blocks/2)+9), 2));






        for (int i = (x_middle+(x_blocks/2)-2); i < (x_middle+(x_blocks/2)+1); i++) {
            StudentObjects.add(new BlockUnbreakable(i, 8));//mur horizontal à côté en haut de la porte d'enntrée
        }


        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 11)); //mur horizontal à côté en bas de la porte d'enntrée
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 11));

        for (int j = 12; j < 15; j++) {
            StudentObjects.add(new Bed((x_middle+(x_blocks/2)-4), j)); //lit + mur
            StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-3), j));
            StudentObjects.add(new Bed((x_middle+(x_blocks/2)-5), j));
        }
        for (int i = (x_middle+(x_blocks/2)-5); i <(x_middle+(x_blocks/2)-2); i++) { // mur au dessus du lit
            StudentObjects.add(new BlockUnbreakable(i, 11));
        }

        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-6), 11)); //mur chambre
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-7), 11));

        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 11)); //mur salle de douche

        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 13)); //toilettes
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 13));
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 14));
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 14));

        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-2), 14));



        for (int j = 11; j < 15; j++) {
            StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)), j)); //douche+mur
        }


        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+4), 14));
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+4), 13)); //armoire chmabre

        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 14)); //douche
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 13));

        for (int j = 11; j < 15; j++) {
            StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1)+2, j)); //mur entre chambre et douche
        }

        //StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 7));
        //StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+2), 7));
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 3)); //table basse

        //StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+3), 5));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+1), 5, 7)); //canapé horizontal
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+2), 5, 7));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)), 5, 7));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+3), 5, 7));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+1), 6, 7)); //canapé horizontal
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+2), 6, 7));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)), 6, 7));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+3), 6, 7));
        //StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)), 5));
        //StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+3), 6)); //canapé
        //StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 6));
        //StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+2), 6));
        //StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)), 6));



        for (int j = 5; j < 9; j++) {
            StudentObjects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+5)), j)); //mur entre salon et cuisine
        }

        for (int j = 5; j < 9; j++) {
            StudentObjects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+6)), j)); //  chaises + table dans cuisine + mur horizontal
            StudentObjects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+7)), j));
        }
    }
}
