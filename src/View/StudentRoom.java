package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentRoom extends JPanel implements MapInterface {
    private ArrayList<GameObject> StudentObjects = new ArrayList<>();
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;
    public StudentRoom() {                      //Constructor
        this.y_blocks = 14;
        this.x_blocks = 13;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width_screen = (int) screenSize.getWidth();
        int height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2* height_screen /3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.BLOC_SIZE = (Math.round(3* height_screen /(5*y_blocks)));     //Blocsize equation
        x_middle = (Math.round(width_screen /(2*BLOC_SIZE)));              //x_middle equation
        System.out.println("testi"+ x_middle);
        System.out.println("prout" + screenSize.getWidth());
        construct();
    }







    public void paint(Graphics g) {

        //Instantiation of all images for paint

        Image wall = new ImageIcon("src/Image/wall.jpg").getImage();
        Image frigo = new ImageIcon("src/Image/frigo_projet.png").getImage();
        Image sofa_horizontal = new ImageIcon("src/Image/sofa.png").getImage();
        Image tv = new ImageIcon("src/Image/tv.png").getImage();
        Image table_basse = new ImageIcon("src/Image/table_basse.png").getImage();
        Image plaque_cuisson = new ImageIcon("src/Image/plaque_cuisson.png").getImage();
        Image evier = new ImageIcon("src/Image/evier.png").getImage();
        Image chaise = new ImageIcon("src/Image/chaise_projet.png").getImage();
        Image table_cuisine = new ImageIcon("src/Image/table_cuisine.png").getImage();
        Image douche = new ImageIcon("src/Image/douche.png").getImage();
        Image lavabot = new ImageIcon("src/Image/lavabot_projet.png").getImage();
        Image lit = new ImageIcon("src/Image/lit_projet.png").getImage();
        Image toilettes = new ImageIcon("src/Image/toilettes.png").getImage();
        Image lavabot2 = new ImageIcon("src/Image/lavabot_projet2.png").getImage();
        Image armoire = new ImageIcon("src/Image/armoire.png").getImage();
        Image chaise2 = new ImageIcon("src/Image/chaise_projet2.png").getImage();
        Image bureau = new ImageIcon("src/Image/bureau_projet.png").getImage();
        Image porte = new ImageIcon("src/Image/porte.png").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();

        super.paintComponent(g);

        //Painting at the right place

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
        for (int i = (x_middle+(x_blocks/2)-2); i < (x_middle+(x_blocks/2)+1); i++) {
            g.drawImage(brique,i*BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }
        for (int j = 5; j < 9; j++) {
            g.drawImage(brique,((x_middle-(x_blocks/2)+5))*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }
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

        g.drawImage(tv, (x_middle-(x_blocks/2))*BLOC_SIZE, BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(sofa_horizontal, ((x_middle-(x_blocks/2)))*BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE*4, BLOC_SIZE*2, null);
        g.drawImage(plaque_cuisson, (x_middle+(x_blocks/2)-2)*BLOC_SIZE, BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(table_basse, ((x_middle-(x_blocks/2))+1)*BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(frigo, (x_middle-(x_blocks/2)+8)*BLOC_SIZE, BLOC_SIZE,2*BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(armoire, (x_middle-(x_blocks/2)+4)*BLOC_SIZE, 13*BLOC_SIZE, BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(lavabot2, (x_middle-(x_blocks/2))*BLOC_SIZE, 12*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(porte, (x_middle+(x_blocks/2)+1)*BLOC_SIZE, 9*BLOC_SIZE, BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(bureau, (x_middle-(x_blocks/2)+1)*BLOC_SIZE, 8*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(chaise2, (x_middle-(x_blocks/2)+1)*BLOC_SIZE, 9*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(armoire, (x_middle-(x_blocks/2)+4)*BLOC_SIZE, 13*BLOC_SIZE, BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(toilettes, (x_middle-(x_blocks/2))*BLOC_SIZE, 13*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(lit, (x_middle-(x_blocks/2)+7)*BLOC_SIZE, 12*BLOC_SIZE, 2*BLOC_SIZE, 3*BLOC_SIZE, null);
        g.drawImage(lavabot, (x_middle-(x_blocks/2)+10)*BLOC_SIZE, 14*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(douche, (x_middle-(x_blocks/2)+11)*BLOC_SIZE, 13*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(table_cuisine, (x_middle-(x_blocks/2)+6)*BLOC_SIZE, 6*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(chaise, (x_middle-(x_blocks/2)+6)*BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(chaise, (x_middle-(x_blocks/2)+7)*BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(evier, (x_middle+(x_blocks/2)-1)*BLOC_SIZE, 3 *BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);

        g.drawImage(brique,((x_middle-(x_blocks/2)+6))*BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique,((x_middle-(x_blocks/2)+7))*BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
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
        g.drawImage(brique, (x_middle-(x_blocks/2)+5)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        g.drawImage(brique, (x_middle-(x_blocks/2)+5)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);

        //drawing of the player and PNJ

        for (GameObject object : this.StudentObjects) {
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
                }else if(object instanceof PNJ){
                    if(((PNJ) object).getIndep() == 0){
                        int direction = ((Directable) object).getDirection();

                        Image perso = null;
                        switch (direction) {
                            case Directable.EAST:
                                perso = new ImageIcon("src/Image/personnage_fille_droite.png").getImage();
                                break;
                            case Directable.NORTH:
                                perso = new ImageIcon("src/Image/personnage_fille_haut.png").getImage();
                                break;
                            case Directable.WEST:
                                perso = new ImageIcon("src/Image/personnage_fille_gauche.png").getImage();
                                break;
                            case Directable.SOUTH:
                                perso = new ImageIcon("src/Image/personnage_fille_bas.png").getImage();
                                break;
                        }
                        g.drawImage(perso,x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
                    }else{
                        int direction = ((Directable) object).getDirection();

                        Image perso = null;
                        switch (direction) {
                            case Directable.EAST:
                                perso = new ImageIcon("src/Image/personnage_kid_droite.png").getImage();
                                break;
                            case Directable.NORTH:
                                perso = new ImageIcon("src/Image/personnage_kid_haut.png").getImage();
                                break;
                            case Directable.WEST:
                                perso = new ImageIcon("src/Image/personnage_kid_gauche.png").getImage();
                                break;
                            case Directable.SOUTH:
                                perso = new ImageIcon("src/Image/personnage_kid_bas.png").getImage();
                                break;
                        }
                        g.drawImage(perso,x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
                    }
                }
            }
        }
    }

    public Player setObjects(ArrayList<GameObject> objects, Player mainChar, MapInterface currentMap) {
        this.StudentObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle+(x_blocks/2),9);             //Player start at the door
        return mainChar;
    }
    public ArrayList<GameObject> getObjects(){
        return this.StudentObjects;
    }

    public void redraw() {
        this.repaint();
    }

    private void construct() {                   //Add all the room objects to the Map list
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
        for (int i = (x_middle-(x_blocks/2)+10); i < (x_middle+(x_blocks/2)+1); i++) {
            StudentObjects.add(new Kitchen(i, 1)); //cuisine
            StudentObjects.add(new Kitchen(i, 2));
        }
        for (int j = 3; j < 5; j++) {
            StudentObjects.add(new Kitchen((x_middle+(x_blocks/2)-1), j)); //suite cuisine
            StudentObjects.add(new Kitchen((x_middle+(x_blocks/2)), j));
        }
        for (int i = (x_middle+(x_blocks/2)-2); i < (x_middle+(x_blocks/2)+1); i++) {
            StudentObjects.add(new BlockUnbreakable(i, 8));//mur horizontal à côté en haut de la porte d'enntrée
        }
        for (int j = 12; j < 15; j++) {
            StudentObjects.add(new Bed((x_middle+(x_blocks/2)-4), j)); //lit + mur
            StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-3), j));
            StudentObjects.add(new Bed((x_middle+(x_blocks/2)-5), j));
        }
        for (int i = (x_middle+(x_blocks/2)-5); i <(x_middle+(x_blocks/2)-2); i++) { // mur au dessus du lit
            StudentObjects.add(new BlockUnbreakable(i, 11));
        }
        for (int j = 11; j < 15; j++) {
            StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)), j)); //douche+mur
        }
        for (int j = 11; j < 15; j++) {
            StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1)+2, j)); //mur entre chambre et douche
        }
        for (int j = 5; j < 9; j++) {
            StudentObjects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+5)), j)); //mur entre salon et cuisine
        }
        for (int j = 5; j < 9; j++) {
            StudentObjects.add(new Table(((x_middle-(x_blocks/2)+6)), j)); //  chaises + table dans cuisine + mur horizontal
            StudentObjects.add(new Table(((x_middle-(x_blocks/2)+7)), j));
        }

        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-6), 11)); //mur chambre
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-7), 11));
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 11)); //mur salle de douche
        StudentObjects.add(new Shower((x_middle+(x_blocks/2)), 13)); //Douche
        StudentObjects.add(new Shower((x_middle+(x_blocks/2)-1), 13));
        StudentObjects.add(new Shower((x_middle+(x_blocks/2)), 14));
        StudentObjects.add(new Shower((x_middle+(x_blocks/2)-1), 14));
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 3)); //table basse
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-2), 14));
        StudentObjects.add(new Fridge((x_middle-(x_blocks/2)+8), 1)); //frigo
        StudentObjects.add(new Fridge((x_middle-(x_blocks/2)+9), 1));
        StudentObjects.add(new Fridge((x_middle-(x_blocks/2)+8), 2));
        StudentObjects.add(new Fridge((x_middle-(x_blocks/2)+9), 2));
        StudentObjects.add(new Door((x_middle+(x_blocks/2)+1), 9));
        StudentObjects.add(new Door((x_middle+(x_blocks/2)+1), 10)); //porte
        StudentObjects.add(new Tv((x_middle-(x_blocks/2)+1), 1)); //télé
        StudentObjects.add(new Tv((x_middle-(x_blocks/2)+2), 1));
        StudentObjects.add(new Tv((x_middle-(x_blocks/2)), 1));
        StudentObjects.add(new Desk((x_middle-(x_blocks/2)+1), 8,10)); //bureau + chaise
        StudentObjects.add(new Desk((x_middle-(x_blocks/2)+1), 9,10));
        StudentObjects.add(new Desk((x_middle-(x_blocks/2)+2), 8,10));
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+5), 1)); //mur vertical
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+5), 2));
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 11)); //mur horizontal à côté en bas de la porte d'enntrée
        StudentObjects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 11));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+1), 5)); //canapé horizontal
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+2), 5));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)), 5));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+3), 5));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+1), 6)); //canapé horizontal
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+2), 6));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)), 6));
        StudentObjects.add(new Couch((x_middle-(x_blocks/2)+3), 6));
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+4), 14));
        StudentObjects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+4), 13)); //armoire chmabre
        StudentObjects.add(new Toilet((x_middle-(x_blocks/2)+1), 14)); //toilette
        StudentObjects.add(new Toilet((x_middle-(x_blocks/2)+1), 13));

    }
}
