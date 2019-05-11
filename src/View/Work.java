package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Work extends JPanel implements MapInterface {
    private ArrayList<GameObject> workObjects = new ArrayList<>();
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;

    public Work() {                         //Constructor
        this.y_blocks = 13;
        this.x_blocks = 17;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width_screen = (int) screenSize.getWidth();
        int height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2 * height_screen / 3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.BLOC_SIZE = (Math.round(5 * height_screen / (9 * y_blocks)));      //Blocsize equation
        x_middle = (Math.round(width_screen / (2 * BLOC_SIZE)));                //x_middle equation
        construct();
    }


    public void paint(Graphics g) {

        //Instantiation of all images for paint

        Image sol_travail = new ImageIcon("src/Image/sol_bibli.jpg").getImage();
        Image poubelle = new ImageIcon("src/Image/trash.png").getImage();
        Image plante = new ImageIcon("src/Image/plante.png").getImage();
        Image bureau1 = new ImageIcon("src/Image/bureau1.png").getImage();
        Image bureau2 = new ImageIcon("src/Image/bureau2.png").getImage();
        Image bureau3 = new ImageIcon("src/Image/bureau3.png").getImage();
        Image bureau_complet1 = new ImageIcon("src/Image/bureau_complet1.png").getImage();
        Image bureau_complet2 = new ImageIcon("src/Image/bureau_complet2.png").getImage();
        Image support_bureau = new ImageIcon("src/Image/table_cuisine.png").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();
        Image chaise_bureau_haut = new ImageIcon("src/Image/chaise_bureau_haut.png").getImage();
        Image chaise_bureau_bas = new ImageIcon("src/Image/chaise_bureau_bas.png").getImage();
        Image livres_horizontaux = new ImageIcon("src/Image/biblio_horizontal.png").getImage();
        Image bureau_special = new ImageIcon("src/Image/bureau_special.png").getImage();
        Image livres = new ImageIcon("src/Image/bibliothèque.png").getImage();
        Image porte = new ImageIcon("src/Image/porte.png").getImage();

        super.paintComponent(g);

        //Painting at the right place

        for (int i = x_middle - (x_blocks / 2); i < x_middle + (x_blocks / 2) + 3; i++) {
            for (int j = 1; j < y_blocks + 2; j++) {
                g.drawImage(sol_travail, i * BLOC_SIZE, j * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }
        }
        for (int i =x_middle-9; i < x_middle+11; i++){
            g.drawImage(brique,i * BLOC_SIZE, 0, BLOC_SIZE,BLOC_SIZE, null );
            g.drawImage(brique,i * BLOC_SIZE, 15*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        }
        for (int j = 1; j< 15; j++){
            g.drawImage(brique,(x_middle-9) * BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        }
        for (int j = 1; j< 8; j++){
            g.drawImage(brique,(x_middle+10) * BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        }
        for (int j = 10; j< 15; j++){
            g.drawImage(brique,(x_middle+10) * BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        }
        for (int j = 1; j < 6; j++){
            g.drawImage(brique,(x_middle+3) * BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        }
        for (int i = x_middle+6; i < x_middle+10; i++){
            g.drawImage(brique,i * BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        }

        g.drawImage(porte,(x_middle+10) * BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(bureau_complet1,(x_middle-6) * BLOC_SIZE, 2*BLOC_SIZE, 4*BLOC_SIZE,3* BLOC_SIZE, null );
        g.drawImage(support_bureau,(x_middle-6) * BLOC_SIZE, 7*BLOC_SIZE, 2*BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(bureau1,(x_middle-6) * BLOC_SIZE, 7*BLOC_SIZE, 2*BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(chaise_bureau_haut,(x_middle-6) * BLOC_SIZE, 9*BLOC_SIZE, 2*BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(poubelle,(x_middle-7) * BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(support_bureau,(x_middle-4) * BLOC_SIZE, 7*BLOC_SIZE, 2*BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(bureau3,(x_middle-4) * BLOC_SIZE, 7*BLOC_SIZE, 2*BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(chaise_bureau_bas,(x_middle-4) * BLOC_SIZE, 6*BLOC_SIZE, 2*BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(plante,(x_middle-2) * BLOC_SIZE, 7*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(livres,x_middle * BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE,3* BLOC_SIZE, null );
        g.drawImage(poubelle,x_middle * BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(chaise_bureau_bas,(x_middle-4) * BLOC_SIZE, 6*BLOC_SIZE, 2*BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(support_bureau,(x_middle-6) * BLOC_SIZE, 11*BLOC_SIZE, 2*BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(bureau2,(x_middle-6) * BLOC_SIZE, 11*BLOC_SIZE, 2*BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(chaise_bureau_haut,(x_middle-6) * BLOC_SIZE, 13*BLOC_SIZE, 2*BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(plante,(x_middle-7) * BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(support_bureau,(x_middle-1) * BLOC_SIZE, 11*BLOC_SIZE, 2*BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(bureau3,(x_middle-1) * BLOC_SIZE, 11*BLOC_SIZE, 2*BLOC_SIZE,2* BLOC_SIZE, null );
        g.drawImage(chaise_bureau_bas,(x_middle-1) * BLOC_SIZE, 10*BLOC_SIZE, 2*BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(poubelle,(x_middle-2) * BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(poubelle,(x_middle+3) * BLOC_SIZE, 12*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(livres_horizontaux,(x_middle+4) * BLOC_SIZE, 12*BLOC_SIZE, 3*BLOC_SIZE,BLOC_SIZE, null );
        g.drawImage(bureau_complet2,(x_middle+3) * BLOC_SIZE, 8*BLOC_SIZE, 4*BLOC_SIZE,3* BLOC_SIZE, null );
        g.drawImage(bureau_special,(x_middle+6) * BLOC_SIZE, 2*BLOC_SIZE, 3*BLOC_SIZE,2* BLOC_SIZE, null );

        //drawing of the player and PNJ

        for (GameObject object : this.workObjects) {
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

        this.workObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle + 1, y_blocks);           //Player start at the door
        return mainChar;
    }

    public ArrayList<GameObject> getObjects() {
        return this.workObjects;
    }

    public void redraw() {
        this.repaint();
    }

    private void construct() {                  //Add all the room objects to the Map list
        this.workObjects.clear();

        for (int i = x_middle-9; i < x_middle+11; i++){
            workObjects.add(new BlockUnbreakable(i, 0)); //mur horizontal supérieur
            workObjects.add(new BlockUnbreakable(i, 15)); //mur horizontal inférieur
        }
        for (int j = 1; j< 15; j++){
            workObjects.add(new BlockUnbreakable(x_middle-9, j)); //mur vertical gauche
        }
        for (int j = 1; j< 8; j++){
            workObjects.add(new BlockUnbreakable(x_middle+10, j)); //mur vertical droite
        }
        for(int j =8; j<10; j++){
            workObjects.add(new Door(x_middle+10,j));
        }
        for (int j = 10; j< 15; j++){
            workObjects.add(new BlockUnbreakable(x_middle+10, j)); //mur vertical droite
        }
        for (int j = 8; j< 10; j++){
            workObjects.add(new BlockUnbreakable(x_middle+10, j)); //mur vertical droite
        }
        for (int j = 1; j< 6; j++){
            workObjects.add(new BlockUnbreakable(x_middle+3, j)); //mur vertical bureau
        }
        for (int i = x_middle+6; i < x_middle+11; i++){
            workObjects.add(new BlockUnbreakable(i,5 ));    //mur horizontal bureau
        }
        for (int i = x_middle+6; i < x_middle+9; i++){
            for (int j = 2; j < 4; j++){
                workObjects.add(new Desk(i,j,30)); //bureau en haut a droite
            }
        }
        for (int i = x_middle+3; i < x_middle+7; i++){
            for (int j = 8; j < 11; j++){
                workObjects.add(new BlockUnbreakable(i,j )); //bureau avec gens a droite
            }
        }
        for (int i = x_middle+3; i< x_middle+8; i++){
            workObjects.add(new BlockUnbreakable(i, 12)); //poubelle+biblio+plante horizontale bas
        }
        for (int j = 10; j< 13; j++){
            workObjects.add(new BlockUnbreakable(x_middle-1, j));  //bureau bas milieu + chaise
            workObjects.add(new BlockUnbreakable(x_middle, j));
        }
        for (int j = 11; j< 14; j++){
            workObjects.add(new BlockUnbreakable(x_middle-5, j));  //bureau bas gauche + chaise
            workObjects.add(new BlockUnbreakable(x_middle-6, j));
        }
        for (int i  = x_middle-6; i< x_middle-2; i++){
            workObjects.add(new BlockUnbreakable(i, 8));  //bureau milieu gauche
            workObjects.add(new BlockUnbreakable(i, 7));
        }
        for (int i = x_middle-6; i < x_middle-2; i++){
            for (int j = 2; j < 5; j++){
                workObjects.add(new BlockUnbreakable(i,j )); //bureau avec gens a gauche
            }
        }
        for (int j = 2; j < 6; j++){
            workObjects.add(new BlockUnbreakable(x_middle,j )); //biblio+poubelle
        }

        workObjects.add(new BlockUnbreakable(x_middle-2, 11)); // poubelle a coté du bureau
        workObjects.add(new BlockUnbreakable(x_middle-7, 11)); // poubelle a coté du bureau
        workObjects.add(new BlockUnbreakable(x_middle-6, 9)); //chaise
        workObjects.add(new BlockUnbreakable(x_middle-5, 9));
        workObjects.add(new BlockUnbreakable(x_middle-4, 6));//chaise
        workObjects.add(new BlockUnbreakable(x_middle-3, 6));
        workObjects.add(new BlockUnbreakable(x_middle-7, 8)); //poubelle
        workObjects.add(new BlockUnbreakable(x_middle-2, 7)); //plante

    }
}

