package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Library extends JPanel implements MapInterface {
    private ArrayList<GameObject> libraryObjects = new ArrayList<>();
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;
    public Library() {                  //Constructor
        this.y_blocks = 17;
        this.x_blocks = 17;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width_screen = (int) screenSize.getWidth();
        int height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2* height_screen /3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.BLOC_SIZE = (Math.round(3* height_screen /(5*y_blocks)));  //Blocsize equation
        x_middle = (Math.round(width_screen /(2*BLOC_SIZE)));           //x_middle equation
        construct();
    }



    public void paint(Graphics g) {

        //Instantiation of all images for paint

        Image sol = new ImageIcon("src/Image/sol_bibli.jpg").getImage();
        Image poubelle = new ImageIcon("src/Image/trash.png").getImage();
        Image plante = new ImageIcon("src/Image/plante.png").getImage();
        Image chaise_bas = new ImageIcon("src/Image/chaise_projet.png").getImage();
        Image chaise_haut = new ImageIcon("src/Image/chaise_haut.png").getImage();
        Image chaise_droite = new ImageIcon("src/Image/chaise_droite.png").getImage();
        Image chaise_gauche = new ImageIcon("src/Image/chaise_gauche.png").getImage();
        Image table = new ImageIcon("src/Image/table_cuisine.png").getImage();
        Image bibliotheque = new ImageIcon("src/Image/bibliothèque.png").getImage();
        Image bibliotheque_horizontal = new ImageIcon("src/Image/biblio_horizontal.png").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();
        Image porte = new ImageIcon("src/Image/porte.png").getImage();

        super.paintComponent(g);

        //Painting at the right place

        for (int i = x_middle-(x_blocks/2); i < x_middle+(x_blocks/2)+2; i++) {
            for (int j = 1; j < y_blocks+1; j++) {
                g.drawImage(sol, i *BLOC_SIZE, j *BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }
        }
        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+2); i++) {
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
        for (int i = x_middle-5; i < x_middle+8; i = i+3) {
            g.drawImage(bibliotheque, i* BLOC_SIZE, 2 * BLOC_SIZE, BLOC_SIZE, 3 * BLOC_SIZE, null);
        }
        for (int i = x_middle-7; i < x_middle+7; i = i+5) {
            g.drawImage(poubelle, i* BLOC_SIZE, 13 * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(bibliotheque_horizontal, (i+1)* BLOC_SIZE, 13 * BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(table, (i+1)* BLOC_SIZE, 17 * BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, null);
        }

        g.drawImage(porte, (x_middle+(x_blocks/2)+1)*BLOC_SIZE, 9*BLOC_SIZE, BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(poubelle,(x_middle-2) * BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(poubelle,(x_middle+4) * BLOC_SIZE, 5*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(plante,((x_middle)-x_blocks/2) * BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(table,(x_middle-1) * BLOC_SIZE, 8*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null );
        g.drawImage(table,(x_middle+4) * BLOC_SIZE, 8*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null );
        g.drawImage(plante,(x_middle+x_blocks/2) * BLOC_SIZE, 8*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(plante,(x_middle+x_blocks/2) * BLOC_SIZE, 11*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(table,(x_middle-5) * BLOC_SIZE, 7*BLOC_SIZE, 2*BLOC_SIZE, 3*BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle-6) * BLOC_SIZE, 16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle-4) * BLOC_SIZE, 16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle-1) * BLOC_SIZE, 16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle+1) * BLOC_SIZE, 16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle+4) * BLOC_SIZE, 16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle+6) * BLOC_SIZE, 16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(poubelle,(x_middle+8) * BLOC_SIZE, 17*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(plante,(x_middle-8) * BLOC_SIZE, 16*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_droite,(x_middle-6) * BLOC_SIZE, 7*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_droite,(x_middle-6) * BLOC_SIZE, 9*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_gauche,(x_middle-3) * BLOC_SIZE, 7*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_gauche,(x_middle-3) * BLOC_SIZE, 9*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle-1) * BLOC_SIZE, 7*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle+1) * BLOC_SIZE, 7*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_haut,(x_middle-1) * BLOC_SIZE, 10*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_haut,(x_middle+1) * BLOC_SIZE, 10*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle+4) * BLOC_SIZE, 7*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_bas,(x_middle+6) * BLOC_SIZE, 7*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_haut,(x_middle+4) * BLOC_SIZE, 10*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
        g.drawImage(chaise_haut,(x_middle+6) * BLOC_SIZE, 10*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );

        //drawing of the player and PNJ

        for (GameObject object : this.libraryObjects) {
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
        this.libraryObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle+8,10);                           //Player start at the door
        System.out.println("NbreLS " + this.libraryObjects.size());
        return mainChar;
    }
    public ArrayList<GameObject> getObjects(){
        System.out.println("NbreLG " + this.libraryObjects.size());
        return this.libraryObjects;
    }

    public void redraw() {
        this.repaint();
    }
    private void construct() {                      //Add all the room objects to the Map list

        this.libraryObjects.clear();
        for (int i = x_middle-5; i < x_middle+8; i = i+3) { //bibliothèques verticales
            libraryObjects.add(new BlockUnbreakable(i, 2));
            libraryObjects.add(new BlockUnbreakable(i, 3));
            libraryObjects.add(new BlockUnbreakable(i, 4));
        }
        libraryObjects.add(new Door(x_middle+9, 9));
        libraryObjects.add(new Door(x_middle+9, 10));

        for (int i = (x_middle - (x_blocks / 2) - 1); i < (x_middle + (x_blocks / 2) + 1); i++) {
            libraryObjects.add(new BlockUnbreakable(i, 0));
            libraryObjects.add(new BlockUnbreakable(i, y_blocks + 1));
        }
        for (int j = 0; j < y_blocks + 2; j++) {
            libraryObjects.add(new BlockUnbreakable((x_middle - (x_blocks / 2) - 1), j));
            libraryObjects.add(new BlockUnbreakable((x_middle + (x_blocks / 2) + 1), j));
        }
        for (int i = x_middle-7; i < x_middle+7; i = i+5) {

            libraryObjects.add(new BlockUnbreakable(i, 13)); //pouvelle
            libraryObjects.add(new BlockUnbreakable(i+1, 13)); //bibliothèques horizontales
            libraryObjects.add(new BlockUnbreakable(i+2, 13));
            libraryObjects.add(new BlockUnbreakable(i+3, 13));
            libraryObjects.add(new Desk(i+1, 17,0)); //tables horizontales (celles tout en bas
            libraryObjects.add(new Desk(i+2, 17,0));
            libraryObjects.add(new Desk(i+3, 17,0));
        }

        for (int i = x_middle-1; i < x_middle+2; i++) {
            libraryObjects.add(new Desk(i, 8,0)); //tables horizontales de 2 de large
            libraryObjects.add(new Desk(i, 9,0));
        }
        for (int j = 7; j < 10; j++) {
            libraryObjects.add(new Desk(x_middle-5, j,0)); //table verticale
            libraryObjects.add(new Desk(x_middle-4, j,0));
        }

        for (int i = x_middle+4; i < x_middle+7; i++) {
            libraryObjects.add(new Desk(i, 8,0)); //table horizontale de droite
            libraryObjects.add(new Desk(i, 9,0));
        }

        libraryObjects.add(new BlockUnbreakable((x_middle+x_blocks/2), 8)); //plante
        libraryObjects.add(new BlockUnbreakable((x_middle+x_blocks/2), 11)); //plante
        libraryObjects.add(new BlockUnbreakable((x_middle-2), 5)); //poubelle
        libraryObjects.add(new BlockUnbreakable((x_middle+4), 5)); //poubelle
        libraryObjects.add(new BlockUnbreakable((x_middle)-x_blocks/2, 3)); //plante
        libraryObjects.add(new Desk((x_middle-6), 16,0)); //chaises
        libraryObjects.add(new Desk((x_middle-4), 16,0));
        libraryObjects.add(new Desk((x_middle-1), 16,0));
        libraryObjects.add(new Desk((x_middle+6), 16,0));
        libraryObjects.add(new Desk((x_middle+4), 16,0));
        libraryObjects.add(new Desk((x_middle+1), 16,0));
        libraryObjects.add(new BlockUnbreakable((x_middle+8), 17)); //poubelle
        libraryObjects.add(new BlockUnbreakable((x_middle-8), 16)); //plante
        libraryObjects.add(new Desk((x_middle-6), 7,0));
        libraryObjects.add(new Desk((x_middle-6), 9,0));
        libraryObjects.add(new Desk((x_middle-3), 7,0));
        libraryObjects.add(new Desk((x_middle-3), 9,0));
        libraryObjects.add(new Desk((x_middle-1), 7,0));
        libraryObjects.add(new Desk((x_middle+1), 7,0));
        libraryObjects.add(new Desk((x_middle-1), 10,0));
        libraryObjects.add(new Desk((x_middle+1), 10,0));
        libraryObjects.add(new Desk((x_middle+4), 7,0));
        libraryObjects.add(new Desk((x_middle+6), 7,0));
        libraryObjects.add(new Desk((x_middle+4), 10,0));
        libraryObjects.add(new Desk((x_middle+6), 10,0));




    }



}
