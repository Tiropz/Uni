package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Jefke extends JPanel implements MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> JefkeObjects = new ArrayList<GameObject>();
    public int width_screen;
    public int height_screen;
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;

    public Jefke() {
        this.y_blocks = 13;
        this.x_blocks = 22;
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2 * height_screen / 3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        System.out.println("coucou" + y_blocks);
        System.out.println(x_blocks);
        System.out.println(x_middle);
        this.BLOC_SIZE = (Math.round(5 * height_screen / (9 * y_blocks)));


        x_middle = (Math.round(width_screen / (2 * BLOC_SIZE)));
        System.out.println(screenSize.getWidth());
        construct();
    }


    public void paint(Graphics g) {

        Image sol_jefke = new ImageIcon("src/Image/sol_jefke.jpg").getImage();
        Image pompe_bière = new ImageIcon("src/Image/pompe_biere.png").getImage();
        Image bar = new ImageIcon("src/Image/sol_2.jpg").getImage();
        Image banquette = new ImageIcon("src/Image/banc.png").getImage();
        Image banc = new ImageIcon("src/Image/banc.jpg").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();
        Image personnage = new ImageIcon("src/Image/personnage.png").getImage();
        Image porte_horizontale = new ImageIcon("src/Image/porte_horizontale.png").getImage();
        Image personnage_bas = new ImageIcon("src/Image/personnage_bas.png").getImage();
        Image personnage_droite = new ImageIcon("src/Image/personnage_droite.png").getImage();
        Image personnage_gauche = new ImageIcon("src/Image/personnage_gauche.png").getImage();



        super.paintComponent(g);
        for (int i = x_middle - (x_blocks / 2); i < x_middle + (x_blocks / 2) + 2; i++) {
            for (int j = 1; j < y_blocks + 2; j++) {
                int x = i;
                int y = j;
                g.drawImage(sol_jefke, x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }

        }

        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+3); i++) { //mur horizontal supérieur
            g.drawImage(brique, i*BLOC_SIZE, 0, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int i = (x_middle-(x_blocks/2)-1); i < x_middle+1; i++) {
            g.drawImage(brique, i*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int i = x_middle+3; i < (x_middle+(x_blocks/2)+3); i++) {
            g.drawImage(brique, i*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int j = 1;j< y_blocks+1; j++){
            g.drawImage(brique, (x_middle-12)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(brique, (x_middle+13)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int i = x_middle-11; i < x_middle
                ; i++){
            g.drawImage(bar, (i*BLOC_SIZE), (y_blocks-4)*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE,null);
        }
        for (int j = y_blocks-3; j < y_blocks+1; j++){
            g.drawImage(bar, (x_middle-1)*BLOC_SIZE, j*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE,null);
        }

        for (int i = x_middle-8; i < x_middle-4; i = i + 3){
            g.drawImage(pompe_bière, i*BLOC_SIZE, (y_blocks-2)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
        }



            g.drawImage(banc, (x_middle+11)*BLOC_SIZE, (y_blocks-3)*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
            g.drawImage(banquette, (x_middle+11)*BLOC_SIZE, (y_blocks-1)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banquette, (x_middle+11)*BLOC_SIZE, (y_blocks-4)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banquette, (x_middle+11)*BLOC_SIZE, (y_blocks-9)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banc, (x_middle+11)*BLOC_SIZE, (y_blocks-11)*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
            g.drawImage(banquette, (x_middle+11)*BLOC_SIZE, (y_blocks-12)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(porte_horizontale, (x_middle+1)*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);




        for (GameObject object : this.JefkeObjects) {
            if(object != null){
            int x = object.getPosX();
            int y = object.getPosY();
            int color = object.getColor();

            if (object instanceof Directable) {
                int direction = ((Directable) object).getDirection();

                int deltaX = 0;
                int deltaY = 0;

                switch (direction) {
                    case Directable.EAST:
                        g.drawImage(personnage_droite, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
                        deltaX = +(BLOC_SIZE - 2) / 2;
                        break;
                    case Directable.NORTH:
                        g.drawImage(personnage, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
                        deltaY = -(BLOC_SIZE - 2) / 2;
                        break;
                    case Directable.WEST:
                        g.drawImage(personnage_gauche, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
                        deltaX = -(BLOC_SIZE - 2) / 2;
                        break;
                    case Directable.SOUTH:
                        g.drawImage(personnage_bas, x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null );
                        deltaY = (BLOC_SIZE - 2) / 2;
                        break;
                }

                int xCenter = x * BLOC_SIZE + (BLOC_SIZE - 2) / 2;
                int yCenter = y * BLOC_SIZE + (BLOC_SIZE - 2) / 2;

                //g.setColor(Color.BLUE);
                //g.drawLine(xCenter, yCenter, xCenter + deltaX, yCenter + deltaY);
            }
        }
            }
    }


    public Player setObjects(ArrayList<GameObject> objects,Player mainChar, MapInterface currentMap) {

        this.JefkeObjects = new ArrayList<>(objects);
        return mainChar;
    }

    public ArrayList<GameObject> getObjects() {
        return this.JefkeObjects;
    }

    public void redraw() {
        this.repaint();
    }

    private void construct() {
        this.JefkeObjects.clear();
        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+3); i++) { //mur horizontal supérieur
            JefkeObjects.add(new BlockUnbreakable(i, 0));
        }

        for (int i = (x_middle-(x_blocks/2)-1); i < 19; i++) {
            JefkeObjects.add(new BlockUnbreakable(i, (y_blocks+1)));
        }


        for (int i = 21; i < (x_middle+(x_blocks/2)+3); i++) {
            JefkeObjects.add(new BlockUnbreakable( i, (y_blocks+1)));
        }


        for (int j = 1;j< y_blocks+1; j++){
            JefkeObjects.add(new BlockUnbreakable( x_middle-12, j));  //murs jefke verticaux
            JefkeObjects.add(new BlockUnbreakable( x_middle+13, j));
        }

        for (int i = 7; i < x_middle; i++){  // mur bar horizontal
            JefkeObjects.add (new BlockUnbreakable (i, (y_blocks-4)));
        }


        for (int j = y_blocks-3; j < y_blocks+1; j++){    //mur bar
            JefkeObjects.add (new BlockUnbreakable(x_middle-1, j));
        }


        for (int j =(y_blocks-4); j < (y_blocks); j++ ){
            JefkeObjects.add(new BlockUnbreakable((x_middle+11), j)); //banc + banquette en haut a droite
            JefkeObjects.add(new BlockUnbreakable((x_middle+12), j));
        }

        for (int j =(y_blocks-12); j < (y_blocks-8); j++ ){ //banc + bnaquette en bas a droite
            JefkeObjects.add(new BlockUnbreakable((x_middle+11), j));
            JefkeObjects.add(new BlockUnbreakable((x_middle+12), j));
        }

        for (int i = x_middle+1; i<x_middle+3; i++){
            JefkeObjects.add(new Door(i, y_blocks+1));
        }

    }
}