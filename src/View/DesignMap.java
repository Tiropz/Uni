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
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    public DesignMap(Integer wm) {
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();

        switch (wm) {

            case 1:
                this.y_blocks = 20;
                this.x_blocks = 37;
                x_middle = (int)(Math.round(3*height_screen/(5*y_blocks)));
            for (int i = (x_middle-(x_blocks/2)-1); i < (x_middle+(x_blocks/2)+1); i++) {
                objects.add(new BlockUnbreakable(i, 0));
                objects.add(new BlockUnbreakable(i, y_blocks+1));
            }
            for (int j = 0; j < y_blocks+2; j++) {
                objects.add(new BlockUnbreakable((x_middle-(x_blocks/2)-1), j));
                objects.add(new BlockUnbreakable((x_middle+(x_blocks/2)+1), j));
            }


            break;
            case 2:
                for (int i = 2; i < 37; i++) {
                    objects.add(new BlockUnbreakable(i, 3));
                    objects.add(new BlockUnbreakable(i, 22));
                }
                for (int j = 3; j < 22; j++) {
                    objects.add(new BlockUnbreakable(2, j));
                    objects.add(new BlockUnbreakable(36, j));
                }
                for (int j = 4; j < 7; j++) {
                    objects.add(new BlockUnbreakable(22, j));
                }
                for (int j = 9; j < 13; j++) {
                    objects.add(new BlockUnbreakable(22, j));
                }
                this.y_blocks = 20;
                break;

        }
    }
    public ArrayList<GameObject> getObjects(){
        return this.objects;
    }
}

