package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Appartement extends JPanel implements MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> appartementObjects = new ArrayList<GameObject>();
    public int width_screen;
    public int height_screen;
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;


    public Appartement() {
        this.y_blocks = 15;
        this.x_blocks = 27;
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2 * height_screen / 3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.BLOC_SIZE = (Math.round(5 * height_screen / (9 * y_blocks)));


        x_middle = (Math.round(width_screen / (2 * BLOC_SIZE)));
        System.out.println("salut nicolas" + x_middle);
        System.out.println(screenSize.getWidth());
        construct();
    }


    public void paint(Graphics g) {

        Image sol_appartement = new ImageIcon("src/Image/sol.jpg").getImage();
        Image cuisine1 = new ImageIcon("src/Image/kitchen_appartement.png").getImage();
        Image cuisine2 = new ImageIcon("src/Image/kitchen_appartement2.png").getImage();
        Image kicker = new ImageIcon("src/Image/kicker.png").getImage();
        Image lavabot_toilettes = new ImageIcon("src/Image/lavabot_appartement.png").getImage();
        Image lavabot_sdb = new ImageIcon("src/Image/lavabot_sdb.png").getImage();
        Image lit = new ImageIcon("src/Image/lit_appartement.png").getImage();
        Image frigo = new ImageIcon("src/Image/frigo_appartement.png").getImage();
        Image bureau = new ImageIcon("src/Image/desk_appartement.png").getImage();
        Image canape1 = new ImageIcon("src/Image/canape1.png").getImage();
        Image canape2 = new ImageIcon("src/Image/canape2.png").getImage();
        Image baignoire = new ImageIcon("src/Image/bain.png").getImage();
        Image armoire = new ImageIcon("src/Image/armoire_appartement.png").getImage();
        Image table_a_manger = new ImageIcon("src/Image/table_appartement.png").getImage();
        Image table_basse = new ImageIcon("src/Image/table_basse2.png").getImage();
        Image TV = new ImageIcon("src/Image/tele_appartement.png").getImage();
        Image toilettes = new ImageIcon("src/Image/toilettes_appartement.png").getImage();
        Image porte = new ImageIcon("src/Image/porte_horizontale.png").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();


        super.paintComponent(g);
        for (int i = x_middle - (x_blocks / 2); i < x_middle + (x_blocks / 2) + 3; i++) {
            for (int j = 1; j < y_blocks + 2; j++) {
                int x = i;
                int y = j;
                g.drawImage(sol_appartement, x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }

        }

        for (int i = x_middle-14; i < x_middle+16; i++){
            g.drawImage(brique, i * BLOC_SIZE,  0, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int j = 1; j< y_blocks+2; j++){
            g.drawImage(brique, (x_middle-14) * BLOC_SIZE,  j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(brique, (x_middle+15) * BLOC_SIZE,  j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int i = x_middle-14; i <x_middle-4; i++){
            g.drawImage(brique, i * BLOC_SIZE,  16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int i = x_middle-2; i <x_middle+16; i++){
            g.drawImage(brique, i * BLOC_SIZE,  16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int j = 11; j < 16; j++){
            g.drawImage(brique, (x_middle-5) * BLOC_SIZE,  j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int j = 10; j < 13; j++){
            g.drawImage(brique, (x_middle-2) * BLOC_SIZE,  j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }


        for (int j = 14; j < 16; j++){
            g.drawImage(brique, (x_middle-2) * BLOC_SIZE,  j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int i = x_middle-1; i < x_middle+2; i++){
            g.drawImage(brique, i * BLOC_SIZE,  10*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int j = 11; j < 16; j++){
            g.drawImage(brique, (x_middle+1) * BLOC_SIZE,  j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int i = x_middle+2; i < x_middle+5; i++){
            g.drawImage(brique, i * BLOC_SIZE,  11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int j = 10; j < 16; j++){
            g.drawImage(brique, (x_middle+7) * BLOC_SIZE,  j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }

        for (int i = x_middle+10; i < x_middle+15; i++){
            g.drawImage(brique, i * BLOC_SIZE,  10*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        }





        g.drawImage(bureau, (x_middle-3) * BLOC_SIZE, 1 * BLOC_SIZE,4* BLOC_SIZE, 3*BLOC_SIZE, null);
        g.drawImage(table_a_manger, (x_middle-12) * BLOC_SIZE, 3 * BLOC_SIZE,8* BLOC_SIZE, 4*BLOC_SIZE, null);
        g.drawImage(cuisine1, (x_middle-13) * BLOC_SIZE, 10 * BLOC_SIZE,2* BLOC_SIZE, 6*BLOC_SIZE, null);
        g.drawImage(cuisine2, (x_middle-11) * BLOC_SIZE, 15 * BLOC_SIZE,3* BLOC_SIZE, 1*BLOC_SIZE, null);
        g.drawImage(porte, (x_middle-4) * BLOC_SIZE, 16 * BLOC_SIZE,2* BLOC_SIZE, 1*BLOC_SIZE, null);
        g.drawImage(toilettes, (x_middle-1) * BLOC_SIZE, 14 * BLOC_SIZE,2* BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(lavabot_toilettes, (x_middle-1) * BLOC_SIZE, 11 * BLOC_SIZE,2* BLOC_SIZE, 1*BLOC_SIZE, null);
        g.drawImage(baignoire, (x_middle+2) * BLOC_SIZE, 12 * BLOC_SIZE,2* BLOC_SIZE, 4*BLOC_SIZE, null);
        g.drawImage(lavabot_sdb, (x_middle+6) * BLOC_SIZE, 13 * BLOC_SIZE,1* BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(armoire, (x_middle+8) * BLOC_SIZE, 12 * BLOC_SIZE,2* BLOC_SIZE, 4*BLOC_SIZE, null);
        g.drawImage(lit, (x_middle+12) * BLOC_SIZE, 12 * BLOC_SIZE,3* BLOC_SIZE, 4*BLOC_SIZE, null);
        g.drawImage(TV, (x_middle+13) * BLOC_SIZE, 3 * BLOC_SIZE,2* BLOC_SIZE, 3*BLOC_SIZE, null);
        g.drawImage(table_basse, (x_middle+9) * BLOC_SIZE, 3 * BLOC_SIZE,2* BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(canape1, (x_middle+3) * BLOC_SIZE, 1 * BLOC_SIZE,2* BLOC_SIZE, 5*BLOC_SIZE, null);
        g.drawImage(canape2, (x_middle+5) * BLOC_SIZE, 1 * BLOC_SIZE,3* BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(kicker, (x_middle+6) * BLOC_SIZE, 7 * BLOC_SIZE,4* BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(frigo, (x_middle-7) * BLOC_SIZE, 14 * BLOC_SIZE,2* BLOC_SIZE, 2*BLOC_SIZE, null);


        for (GameObject object : this.appartementObjects) {
            if (object != null) {
                int x = object.getPosX();
                int y = object.getPosY();

                if (object instanceof Player) {
                    int direction = ((Directable) object).getDirection();
                    Image perso = null;
                    switch (direction) {
                        case Directable.EAST:
                            perso = new ImageIcon("src/Image/personnage_droite.png").getImage();
                            break;
                        case Directable.NORTH:
                            perso = new ImageIcon("src/Image/personnage.png").getImage();
                            break;
                        case Directable.WEST:
                            perso = new ImageIcon("src/Image/personnage_gauche.png").getImage();
                            break;
                        case Directable.SOUTH:
                            perso = new ImageIcon("src/Image/personnage_bas.png").getImage();
                            break;
                    }
                    g.drawImage(perso,x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
                }
            }
        }












    }

    public Player setObjects(ArrayList<GameObject> objects, Player mainChar, MapInterface currentMap) {

        this.appartementObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle - 4, 15);
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

        for (int i = x_middle - 14; i < x_middle + 16; i++) { //mur horizontal supérieur
            appartementObjects.add(new BlockUnbreakable(i, 0));

        }

        for (int j = 1; j < y_blocks + 2; j++) {
            appartementObjects.add(new BlockUnbreakable(x_middle - 14, j)); //murs latéraux
            appartementObjects.add(new BlockUnbreakable(x_middle + 15, j));


        }

        for (int i = x_middle-14; i <x_middle-4; i++){
            appartementObjects.add(new BlockUnbreakable(i ,  16)); //mur horizontal inférieur

        }

        for (int i = x_middle-2; i <x_middle+16; i++){
            appartementObjects.add(new BlockUnbreakable(i ,  16)); //mur horizontal inférieur

        }

        for (int j = 11; j < 16; j++){
            appartementObjects.add(new BlockUnbreakable(x_middle-5,  j)); //mur porte d'netrée

        }

        for (int j = 10; j < 13; j++){
            appartementObjects.add(new BlockUnbreakable(x_middle-2,  j)); //mur entrée toilettes supérieur
        }

        for (int j = 14; j < 16; j++){
            appartementObjects.add(new BlockUnbreakable(x_middle-2,  j)); //mur entrée toilettes inférieur

        }

        for (int i = x_middle-1; i < x_middle+2; i++){
            appartementObjects.add(new BlockUnbreakable(i,  10)); //mur  toilettes supérieur

        }

        for (int j = 11; j < 16; j++){
            appartementObjects.add(new BlockUnbreakable(x_middle+1,  j)); //mur  toilettes droite

        }

        for (int i = x_middle+2; i < x_middle+5; i++){
            appartementObjects.add(new BlockUnbreakable(i,  11)); //mur sdb  supérieur

        }

        for (int j = 10; j < 16; j++){
            appartementObjects.add(new BlockUnbreakable(x_middle+7,  j)); //mur  entre sdb et chmabre

        }

        for (int i = x_middle+10; i < x_middle+15; i++){
            appartementObjects.add(new BlockUnbreakable(i,  10)); //mur horizontal chambre

        }

        for (int i = x_middle-3; i < x_middle+1; i++){
            for (int j = 1; j < 3; j++){
                appartementObjects.add(new Desk(i,  j));
                appartementObjects.add(new Desk(x_middle-2,  3));
                appartementObjects.add(new Desk(x_middle-1,  3));


            }

        }

        for (int i = x_middle-12; i < x_middle-4; i++){
            for (int j = 3; j < 7; j++){
                appartementObjects.add(new Table(i,  j));

            }

        }

        for (int i = x_middle-13; i < x_middle-11; i++){
            for (int j = 10; j < 16; j++){
                appartementObjects.add(new Kitchen(i,  j,0));
            }

        }

        for (int i = x_middle-11; i < x_middle-8; i++){
            appartementObjects.add(new Kitchen(i,  15,0));

        }

        for (int i = x_middle-4; i < x_middle-2; i++){
            appartementObjects.add(new Door(i,  16));

        }

        for (int i = x_middle-1; i < x_middle+1; i++){
            for (int j = 14; j < 16; j++){
                appartementObjects.add(new Toilet(i,  j));

            }

        }

        for (int i = x_middle+2; i < x_middle+4; i++){
            for (int j = 12; j < 16; j++){
                appartementObjects.add(new Shower(i,  j));
            }

        }

        appartementObjects.add(new BlockUnbreakable(x_middle-1,  11));  //lavabot toilettes
        appartementObjects.add(new BlockUnbreakable(x_middle,  11));

        appartementObjects.add(new BlockUnbreakable(x_middle+6,  14)); //lavabot sdb
        appartementObjects.add(new BlockUnbreakable(x_middle+6,  13));

        for (int j = 12; j < 16; j++){
            appartementObjects.add(new BlockUnbreakable(x_middle+9,  j)); //armoire chmabre
            appartementObjects.add(new BlockUnbreakable(x_middle+8,  j));
            }

        for (int i = x_middle+12; i < x_middle+15; i++){
          for (int j = 12; j < 16; j++) {
              appartementObjects.add(new Bed(i, j));
          }
        }

        for (int i = x_middle+13; i < x_middle+15; i++){
            for (int j = 3; j < 6; j++) {
                appartementObjects.add(new Tv(i, j,0));
            }
        }

        for (int i = x_middle+9; i < x_middle+11; i++){
            for (int j = 3; j < 5; j++) {
                appartementObjects.add(new BlockUnbreakable(i, j)); //table basse
            }
        }

        for (int i = x_middle+3; i < x_middle+5; i++){
            for (int j = 1; j < 6; j++) {
                appartementObjects.add(new Couch(i, j,0));
            }
        }

        for (int i = x_middle+5; i < x_middle+8; i++){
            for (int j = 1; j < 3; j++) {
                appartementObjects.add(new Couch(i, j,0));
            }
        }

        for (int i = x_middle+6; i < x_middle+10; i++){
            for (int j = 7; j < 9; j++) {
                appartementObjects.add(new BlockUnbreakable(i, j));
            }
        }

        for (int i = x_middle-7; i < x_middle-5; i++){
            for (int j = 14; j < 16; j++) {
                appartementObjects.add(new Fridge(i, j));
            }
        }


    }





}
