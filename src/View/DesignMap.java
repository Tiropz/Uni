package View;

import Model.BlockUnbreakable;
import Model.Fridge;
import Model.GameObject;
import Model.Kitchen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class DesignMap {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width_screen;
    public int height_screen;
    private int x_middle;
    public Integer y_blocks;
    public Integer x_blocks;
    public Integer BLOC_SIZE;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    public DesignMap(Integer wm) {
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();

        switch (wm) {

            case 1:
                this.y_blocks = 14;
                this.x_blocks = 13;
                this.BLOC_SIZE = (Math.round(3*height_screen/(5*y_blocks)));
                x_middle = (Math.round(width_screen/(2*BLOC_SIZE)));
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
                    objects.add(new Kitchen(i, 1)); //cuisine
                    objects.add(new Kitchen(i, 2));
                }
                for (int j = 3; j < 7; j++) {
                    objects.add(new Kitchen((x_middle+(x_blocks/2)-1), j)); //suite cuisine + armoire
                    objects.add(new Kitchen((x_middle+(x_blocks/2)), j));
                }
                objects.add(new Fridge((x_middle-(x_blocks/2)+8), 1)); //frigo
                objects.add(new Fridge((x_middle-(x_blocks/2)+9), 2));
                objects.add(new Fridge((x_middle-(x_blocks/2)+8), 2));
                objects.add(new Fridge((x_middle-(x_blocks/2)+9), 1));




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



                break;
            case 2:
                this.y_blocks = 16;
                this.x_blocks = 28;
                this.BLOC_SIZE = (Math.round(3*height_screen/(5*y_blocks)));
                x_middle = (Math.round(width_screen/(2*BLOC_SIZE)));
                for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+1); i++) {
                    objects.add(new BlockUnbreakable(i, 0));
                    objects.add(new BlockUnbreakable(i, y_blocks+1));
                }
                for (int j = 0; j < y_blocks+2; j++) {
                    objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)-1), j));
                    objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)+1), j));
                }
                break;

        }
    }
    public ArrayList<GameObject> getObjects(){
        return this.objects;
    }
}

