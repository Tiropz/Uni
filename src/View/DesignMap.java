package View;

import Model.BlockUnbreakable;
import Model.GameObject;

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
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 1));
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+2), 1));

                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+5), 1));
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+5), 2));

                for (int i = (x_middle-(x_blocks/2)+8); i < (x_middle+(x_blocks/2)+1); i++) {
                    objects.add(new BlockUnbreakable(i, 1));
                    objects.add(new BlockUnbreakable(i, 2));
                }

                for (int j = 3; j < 7; j++) {
                    objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), j));
                    objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), j));
                }

                for (int i = (x_middle+(x_blocks/2)-2); i < (x_middle+(x_blocks/2)+1); i++) {
                    objects.add(new BlockUnbreakable(i, 8));
                }

                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 9));
                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 10));

                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 11));
                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 11));

                for (int j = 11; j < 15; j++) {
                    objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-4), j));
                    objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-3), j));
                    objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-5), j));
                }

                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-6), 11));
                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-7), 11));

                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)), 11));
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 11));

                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 13));
                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 13));
                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)), 14));
                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-1), 14));

                for (int j = 12; j < 15; j++) {
                    objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)-4), j));
                }


                for (int j = 11; j < 15; j++) {
                    objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)), j));
                }

                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+4), 14));
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+4), 13));

                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 14));
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 13));

                for (int j = 11; j < 15; j++) {
                    objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1)+2, j));
                }

                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 7));
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+2), 7));

                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 5));
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+1), 4));

                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+3), 5));
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)+3), 4));

                for (int j = 5; j < 9; j++) {
                    objects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+5)), j));
                }

                for (int j = 6; j < 9; j++) {
                    objects.add(new BlockUnbreakable(((x_middle-(x_blocks/2)+6)), j));
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

