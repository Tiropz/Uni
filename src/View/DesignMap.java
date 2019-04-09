package View;

import Model.BlockUnbreakable;
import Model.GameObject;

import java.util.ArrayList;

public class DesignMap {
    public Integer y_blocks;
    public Integer x_blocks;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    public DesignMap(Integer wm) {
        switch (wm) {

            case 1:
            for (int i = 10; i < 37; i++) {
                objects.add(new BlockUnbreakable(i, 3));
                objects.add(new BlockUnbreakable(i, 22));
            }
            for (int j = 3; j < 22; j++) {
                objects.add(new BlockUnbreakable(10, j));
                objects.add(new BlockUnbreakable(36, j));
            }
            for (int j = 4; j < 7; j++) {
                objects.add(new BlockUnbreakable(22, j));
            }
            for (int j = 9; j < 13; j++) {
                objects.add(new BlockUnbreakable(22, j));
            }
            this.y_blocks = 20;
            this.x_blocks = 37;
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

