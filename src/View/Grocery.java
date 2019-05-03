package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grocery extends JPanel implements MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<GameObject> GroceryObjects = new ArrayList<GameObject>();
    public int width_screen;
    public int height_screen;
    private int BLOC_SIZE;
    private int y_blocks;
    private int x_middle;
    private int x_blocks;

    public Grocery() {
        this.y_blocks = 12;
        this.x_blocks = 20;
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setPreferredSize(new Dimension(width_screen, 2 * height_screen / 3));
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        System.out.println("coucou nicolas" + y_blocks);
        System.out.println(x_blocks);
        this.BLOC_SIZE = (Math.round(5 * height_screen / (9 * y_blocks)));


        x_middle = (Math.round(width_screen / (2 * BLOC_SIZE)));
        System.out.println(x_middle);
        System.out.println(screenSize.getWidth());
        construct();
    }


    public void paint(Graphics g) {
        Image sol_grocery = new ImageIcon("src/Image/sol_grocery.jpg").getImage();
        Image vegetables = new ImageIcon("src/Image/vegetables.png").getImage();
        Image bread = new ImageIcon("src/Image/bread.png").getImage();
        Image pasta = new ImageIcon("src/Image/pasta.png").getImage();
        Image meat = new ImageIcon("src/Image/meat.png").getImage();
        Image fruits = new ImageIcon("src/Image/fruits_projet.png").getImage();
        Image caisse = new ImageIcon("src/Image/cash_register.png").getImage();
        Image présentoir = new ImageIcon("src/Image/table_cuisine.png").getImage();
        Image personnage = new ImageIcon("src/Image/personnage.png").getImage();
        Image personnage_bas = new ImageIcon("src/Image/personnage_bas.png").getImage();
        Image personnage_droite = new ImageIcon("src/Image/personnage_droite.png").getImage();
        Image personnage_gauche = new ImageIcon("src/Image/personnage_gauche.png").getImage();
        Image brique = new ImageIcon("src/Image/brique.jpg").getImage();
        Image porte = new ImageIcon("src/Image/porte_horizontale.png").getImage();



        super.paintComponent(g);
        for (int i = x_middle - (x_blocks / 2); i < x_middle + (x_blocks / 2) + 2; i++) {
            for (int j = 1; j < y_blocks + 2; j++) {
                int x = i;
                int y = j;
                g.drawImage(sol_grocery, x * BLOC_SIZE, y * BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            }

        }

        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+3); i++) { //mur horizontal supérieur
            g.drawImage(brique, i*BLOC_SIZE, 0, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int i = (x_middle-(x_blocks/2)-1); i < x_middle-6; i++) {
            g.drawImage(brique, i*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        for (int i = x_middle-4; i < (x_middle+(x_blocks/2)+3); i++) {
            g.drawImage(brique, i*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }

        g.drawImage(porte, (x_middle-6)*BLOC_SIZE, (y_blocks+1)*BLOC_SIZE, 2*BLOC_SIZE, BLOC_SIZE, null);


        for (int j = 1;j< y_blocks+1; j++){
            g.drawImage(brique, (x_middle-11)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
            g.drawImage(brique, (x_middle+12)*BLOC_SIZE, j*BLOC_SIZE, BLOC_SIZE, BLOC_SIZE, null);
        }


        for (int j = 3; j < 10; j = j+6){
            g.drawImage(caisse, (x_middle-8)*BLOC_SIZE, j*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);
        }

        for (int i = x_middle-2; i < x_middle+2; i = i + 2){
            g.drawImage(pasta, i*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, 3*BLOC_SIZE, null);
            g.drawImage(pasta, i*BLOC_SIZE, 7*BLOC_SIZE, 2*BLOC_SIZE, 3*BLOC_SIZE, null);
        }
        g.drawImage(présentoir, (x_middle+4)*BLOC_SIZE, 5*BLOC_SIZE, 4*BLOC_SIZE, 4*BLOC_SIZE, null);
        g.drawImage(bread, (x_middle+4)*BLOC_SIZE, 5*BLOC_SIZE, 4*BLOC_SIZE, 4*BLOC_SIZE, null);

        g.drawImage(présentoir, (x_middle+6)*BLOC_SIZE, 1*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(présentoir, (x_middle+9)*BLOC_SIZE, 1*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);

        g.drawImage(meat, (x_middle+6)*BLOC_SIZE, 1*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);
        g.drawImage(meat, (x_middle+9)*BLOC_SIZE, 1*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);

        for (int j = 3; j < 11; j = j + 2){
            g.drawImage(vegetables, (x_middle+10)*BLOC_SIZE, j*BLOC_SIZE, 2*BLOC_SIZE, 2*BLOC_SIZE, null);

        }

        for (int i = x_middle+3; i <x_middle+10; i = i + 3 ){
            g.drawImage(présentoir, i*BLOC_SIZE, (y_blocks-1)*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);
            g.drawImage(fruits, i*BLOC_SIZE, (y_blocks-1)*BLOC_SIZE, 3*BLOC_SIZE, 2*BLOC_SIZE, null);
        }
        for (GameObject object : this.GroceryObjects) {
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

    public Player setObjects(ArrayList<GameObject> objects,Player mainChar, MapInterface currentMap) {

        this.GroceryObjects = new ArrayList<>(objects);
        mainChar.setPosXY(x_middle+1,y_blocks);
        return mainChar;
    }

    public ArrayList<GameObject> getObjects() {
        return this.GroceryObjects;
    }

    public void redraw() {
        this.repaint();
    }

    private void construct() {
        this.GroceryObjects.clear();

        for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+3); i++) { //mur horizontal supérieur
            GroceryObjects.add(new BlockUnbreakable(i, 0));
        }

        GroceryObjects.add(new Door(x_middle-6, y_blocks+1));
        GroceryObjects.add(new Door(x_middle-5, y_blocks+1));



        for (int i = (x_middle-(x_blocks/2)-1); i < x_middle-6; i++) { //mur inférieur
            GroceryObjects.add(new BlockUnbreakable(i, (y_blocks+1)));
        }


        for (int i = x_middle-4; i < (x_middle+(x_blocks/2)+3); i++) { //mur inférieur
            GroceryObjects.add(new BlockUnbreakable( i, (y_blocks+1)));
        }


        for (int j = 1;j< y_blocks+2; j++){
            GroceryObjects.add(new BlockUnbreakable( x_middle-11, j));  //murs grocery verticaux
            GroceryObjects.add(new BlockUnbreakable( x_middle+12, j));
        }

        for (int j = 3; j < 10; j = j+6){
            GroceryObjects.add(new BlockUnbreakable((x_middle-8), (j+1))); //2 caisses
            GroceryObjects.add(new BlockUnbreakable((x_middle-7), (j+1)));
            GroceryObjects.add(new BlockUnbreakable(x_middle-6, (j+1)));
            GroceryObjects.add(new BlockUnbreakable(x_middle-8, j));
            GroceryObjects.add(new BlockUnbreakable(x_middle-7, j));
            GroceryObjects.add(new BlockUnbreakable(x_middle-6, j));

        }

        for (int i = x_middle-2; i < x_middle+2; i ++){
            GroceryObjects.add(new BlockUnbreakable( i, 2)); //pates haut
            GroceryObjects.add(new BlockUnbreakable( i, 3));
            GroceryObjects.add(new BlockUnbreakable( i, 4));




            GroceryObjects.add(new BlockUnbreakable(i, 7));
            GroceryObjects.add(new BlockUnbreakable(i, 8)); //pates bas
            GroceryObjects.add(new BlockUnbreakable(i, 9));

        }


        for (int i = (x_middle+4); i < (x_middle+8); i++){
            for (int j = 5; j < 9; j++){
                GroceryObjects.add(new BlockUnbreakable(i, j)); //pain
            }
        }



        for (int i = (x_middle+6); i < (x_middle+12); i++){  //meat
            GroceryObjects.add(new BlockUnbreakable(i, 1));
            GroceryObjects.add(new BlockUnbreakable(i, 2));
        }

        for (int j = 3; j < y_blocks; j++){
            GroceryObjects.add(new BlockUnbreakable((x_middle+10), j));
            GroceryObjects.add(new BlockUnbreakable((x_middle+11), j)); //vegetables

        }



        for (int i = x_middle+3; i <x_middle+10; i ++ ){
            GroceryObjects.add(new BlockUnbreakable( i, (y_blocks)));
            GroceryObjects.add(new BlockUnbreakable( i, (y_blocks-1))); //fruits
        }



    }


    }