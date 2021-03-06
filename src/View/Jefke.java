package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Jefke extends JPanel implements MapInterface {
    private ArrayList<GameObject> jefkeObjects = new ArrayList<>();
    private int BLOC_SIZE;
    private int y_blocks;
    public int x_middle;
    private int x_blocks;

    public Jefke() {                        //Constructor
        this.y_blocks = 13;
        this.x_blocks = 22;
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2 * height_screen / 3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.BLOC_SIZE = (Math.round(5 * height_screen / (9 * y_blocks)));  //Blocsize equation
        x_middle = (Math.round(width_screen / (2 * BLOC_SIZE)));            //x_middle equation
        construct();
    }


    public void paint(Graphics g) {

        //Instantiation of all images for paint

        Image sol_jefke = new ImageIcon("src/Image/sol_jefke.jpg").getImage();
        Image pompe_biere = new ImageIcon("src/Image/pompe_biere.png").getImage();
        Image bar = new ImageIcon("src/Image/sol_2.jpg").getImage();
        Image banquette = new ImageIcon("src/Image/banc.png").getImage();
        Image banc = new ImageIcon("src/Image/banc.jpg").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();
        Image porte_horizontale = new ImageIcon("src/Image/porte_horizontale.png").getImage();

        super.paintComponent(g);

        //Painting at the right place

        for (int i = x_middle - (x_blocks / 2); i < x_middle + (x_blocks / 2) + 2; i++) {
            for (int j = 1; j < y_blocks + 2; j++) {
                g.drawImage(sol_jefke, i * BLOC_SIZE, j * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }
        }
        for (int i = x_middle-11; i < x_middle; i++){
            g.drawImage(bar, (i*BLOC_SIZE), (y_blocks-4)*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE,null);
        }
        for (int j = y_blocks-3; j < y_blocks+1; j++){
            g.drawImage(bar, (x_middle-1)*BLOC_SIZE, j*BLOC_SIZE,BLOC_SIZE,BLOC_SIZE,null);
        }
        for (int i = x_middle-8; i < x_middle-4; i = i + 3){
            g.drawImage(pompe_biere, i*BLOC_SIZE, (y_blocks-2)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
        }

            g.drawImage(banc, (x_middle+11)*BLOC_SIZE, (y_blocks-3)*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
            g.drawImage(banquette, (x_middle+11)*BLOC_SIZE, (y_blocks-1)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banquette, (x_middle+11)*BLOC_SIZE, (y_blocks-4)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banquette, (x_middle+11)*BLOC_SIZE, (y_blocks-9)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(banc, (x_middle+11)*BLOC_SIZE, (y_blocks-11)*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);
            g.drawImage(banquette, (x_middle+11)*BLOC_SIZE, (y_blocks-12)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(porte_horizontale, (x_middle+1)*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);

        //drawing of the player and PNJ

        for (GameObject object : this.jefkeObjects) {
            if (object != null) {
                int x = object.getPosX();
                int y = object.getPosY();
                if(object instanceof Wall){
                    g.drawImage(brique,x*BLOC_SIZE, y*BLOC_SIZE, BLOC_SIZE,BLOC_SIZE, null );
                }
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
                }else if(object instanceof PNJ) {
                    if (((PNJ) object).getIndep() == 3) {
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
                        g.drawImage(perso, x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
                    }
                }
            }
        }
    }

    public Player setObjects(ArrayList<GameObject> objects,Player mainChar, MapInterface currentMap) {

        this.jefkeObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle+1,y_blocks);         //Player start at the door
        return mainChar;
    }

    public ArrayList<GameObject> getObjects() {
        return this.jefkeObjects;
    }

    public void redraw() {
        this.repaint();
    }

    private void construct() {                  //Add all the room objects to the Map list
        this.jefkeObjects.clear();
        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+3); i++) { //mur horizontal supérieur
            jefkeObjects.add(new Wall(i, 0));
        }
        for (int i = (x_middle-(x_blocks/2)-1); i < 18; i++) {
            jefkeObjects.add(new Wall(i, (y_blocks+1)));
        }
        for (int i = 20; i < (x_middle+(x_blocks/2)+3); i++) {
            jefkeObjects.add(new Wall(i, (y_blocks+1)));
        }
        for (int j = 1;j< y_blocks+1; j++){
            jefkeObjects.add(new Wall( x_middle-12, j));  //murs jefke verticaux
            jefkeObjects.add(new Wall( x_middle+13, j));
        }
        for (int i = 7; i < x_middle; i++){  // mur bar horizontal
            jefkeObjects.add (new BlockUnbreakable (i, (y_blocks-4)));
        }
        for (int j = y_blocks-3; j < y_blocks+1; j++){    //mur bar
            jefkeObjects.add (new BlockUnbreakable(x_middle-1, j));
        }
        for (int j =(y_blocks-4); j < (y_blocks); j++ ){
            jefkeObjects.add(new BlockUnbreakable((x_middle+11), j)); //banc + banquette en haut a droite
            jefkeObjects.add(new BlockUnbreakable((x_middle+12), j));
        }
        for (int j =(y_blocks-12); j < (y_blocks-8); j++ ){ //banc + bnaquette en bas a droite
            jefkeObjects.add(new BlockUnbreakable((x_middle+11), j));
            jefkeObjects.add(new BlockUnbreakable((x_middle+12), j));
        }
        for (int i = x_middle+1; i<x_middle+3; i++){
            jefkeObjects.add(new Door(i, y_blocks+1));
        }

    }
}