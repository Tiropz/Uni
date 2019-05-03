package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Library extends JPanel implements MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> LibraryObjects = new ArrayList<GameObject>();
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

        System.out.println("PaintLibr");

        Image personnage_bas = new ImageIcon("src/Image/personnage_bas.png").getImage();
        Image personnage_droite = new ImageIcon("src/Image/personnage_droite.png").getImage();
        Image personnage_gauche = new ImageIcon("src/Image/personnage_gauche.png").getImage();


        Image sol = new ImageIcon("src/Image/sol_bibli.jpg").getImage();
        Image poubelle = new ImageIcon("src/Image/trash.png").getImage();
        Image plante = new ImageIcon("src/Image/plante.png").getImage();
        Image chaise_bas = new ImageIcon("src/Image/chaise_projet.png").getImage();
        Image chaise_haut = new ImageIcon("src/Image/chaise_haut.png").getImage();
        Image chaise_droite = new ImageIcon("src/Image/chaise_droite.png").getImage();
        Image chaise_gauche = new ImageIcon("src/Image/chaise_gauche.png").getImage();
        Image table = new ImageIcon("src/Image/table_cuisine.png").getImage();
        Image bibliothèque = new ImageIcon("src/Image/bibliothèque.png").getImage();
        Image bibliothèque_horizontal = new ImageIcon("src/Image/biblio_horizontal.png").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();
        Image porte = new ImageIcon("src/Image/porte.png").getImage();
        Image personnage = new ImageIcon("src/Image/personnage.png").getImage();


        super.paintComponent(g);
        for (int i = x_middle-(x_blocks/2); i < x_middle+(x_blocks/2)+2; i++) {
            for (int j = 1; j < y_blocks+1; j++) {
                int x = i;
                int y = j;
                g.drawImage(sol,x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
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

            g.drawImage(bibliothèque, i* BLOC_SIZE, 2 * BLOC_SIZE, BLOC_SIZE, 3 * BLOC_SIZE, null);
        }

        for (int i = x_middle-7; i < x_middle+7; i = i+5) {

            g.drawImage(poubelle, i* BLOC_SIZE, 13 * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(bibliothèque_horizontal, (i+1)* BLOC_SIZE, 13 * BLOC_SIZE, 3*BLOC_SIZE, BLOC_SIZE, null);

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

        for (GameObject object : this.LibraryObjects) {
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
        this.LibraryObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle+8,10);
        System.out.println("NbreLS " + this.LibraryObjects.size());
        return mainChar;
    }
    public ArrayList<GameObject> getObjects(){
        System.out.println("NbreLG " + this.LibraryObjects.size());
        return this.LibraryObjects;
    }

    public void redraw() {
        this.repaint();
    }
    private void construct() {
        this.LibraryObjects.clear();
        for (int i = x_middle-5; i < x_middle+8; i = i+3) { //bibliothèques verticales
            LibraryObjects.add(new BlockUnbreakable(i, 2));
            LibraryObjects.add(new BlockUnbreakable(i, 3));
            LibraryObjects.add(new BlockUnbreakable(i, 4));
        }

        LibraryObjects.add(new Door(x_middle+9, 9));
        LibraryObjects.add(new Door(x_middle+9, 10));

        for (int i = (x_middle - (x_blocks / 2) - 1); i < (x_middle + (x_blocks / 2) + 1); i++) {
            LibraryObjects.add(new BlockUnbreakable(i, 0));
            LibraryObjects.add(new BlockUnbreakable(i, y_blocks + 1));
        }
        for (int j = 0; j < y_blocks + 2; j++) {
            LibraryObjects.add(new BlockUnbreakable((x_middle - (x_blocks / 2) - 1), j));
            LibraryObjects.add(new BlockUnbreakable((x_middle + (x_blocks / 2) + 1), j));
        }

        for (int i = x_middle-7; i < x_middle+7; i = i+5) {


            LibraryObjects.add(new BlockUnbreakable(i, 13)); //pouvelle
            LibraryObjects.add(new BlockUnbreakable(i+1, 13)); //bibliothèques horizontales
            LibraryObjects.add(new BlockUnbreakable(i+2, 13));
            LibraryObjects.add(new BlockUnbreakable(i+3, 13));
            LibraryObjects.add(new Desk(i+1, 17)); //tables horizontales (celles tout en bas
            LibraryObjects.add(new Desk(i+2, 17));
            LibraryObjects.add(new Desk(i+3, 17));
        }
        LibraryObjects.add(new BlockUnbreakable((x_middle-2), 5)); //poubelle
        LibraryObjects.add(new BlockUnbreakable((x_middle+4), 5)); //poubelle
        LibraryObjects.add(new BlockUnbreakable((x_middle)-x_blocks/2, 3)); //plante

        for (int i = x_middle-1; i < x_middle+2; i++) {
            LibraryObjects.add(new Desk(i, 8)); //tables horizontales de 2 de large
            LibraryObjects.add(new Desk(i, 9));
        }

        for (int j = 7; j < 10; j++) {
            LibraryObjects.add(new Desk(x_middle-5, j)); //table verticale
            LibraryObjects.add(new Desk(x_middle-4, j));
        }
        LibraryObjects.add(new BlockUnbreakable((x_middle+x_blocks/2), 8)); //plante
        LibraryObjects.add(new BlockUnbreakable((x_middle+x_blocks/2), 11)); //plante

        for (int i = x_middle+4; i < x_middle+7; i++) {
            LibraryObjects.add(new Desk(i, 8)); //table horizontale de droite
            LibraryObjects.add(new Desk(i, 9));
        }

        LibraryObjects.add(new Desk((x_middle-6), 16)); //chaises
        LibraryObjects.add(new Desk((x_middle-4), 16));
        LibraryObjects.add(new Desk((x_middle-1), 16));
        LibraryObjects.add(new Desk((x_middle+6), 16));
        LibraryObjects.add(new Desk((x_middle+4), 16));
        LibraryObjects.add(new Desk((x_middle+1), 16));
        LibraryObjects.add(new BlockUnbreakable((x_middle+8), 17)); //poubelle
        LibraryObjects.add(new BlockUnbreakable((x_middle-8), 16)); //plante

        LibraryObjects.add(new Desk((x_middle-6), 7));
        LibraryObjects.add(new Desk((x_middle-6), 9));
        LibraryObjects.add(new Desk((x_middle-3), 7));
        LibraryObjects.add(new Desk((x_middle-3), 9));
        LibraryObjects.add(new Desk((x_middle-1), 7));
        LibraryObjects.add(new Desk((x_middle+1), 7));
        LibraryObjects.add(new Desk((x_middle-1), 10));
        LibraryObjects.add(new Desk((x_middle+1), 10));
        LibraryObjects.add(new Desk((x_middle+4), 7));
        LibraryObjects.add(new Desk((x_middle+6), 7));
        LibraryObjects.add(new Desk((x_middle+4), 10));
        LibraryObjects.add(new Desk((x_middle+6), 10));




    }



}
