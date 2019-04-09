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
                this.y_blocks = 20;
                this.x_blocks = 37;
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

