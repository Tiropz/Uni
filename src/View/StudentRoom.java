package View;

import Model.BlockUnbreakable;
import Model.GameObject;

import java.util.ArrayList;

public class StudentRoom {
    private ArrayList<GameObject> objects = null;
    public void main(String[] args) {
        for (int i = 10; i < 37; i++) {
            objects.add(new BlockUnbreakable(i, 3));
            objects.add(new BlockUnbreakable(i, 22));
        }
        for (int j = 3; j < 22; j++){
            objects.add(new BlockUnbreakable(10, j));
            objects.add(new BlockUnbreakable(36,j));
        }
        for (int j = 4; j <7; j++){
            objects.add(new BlockUnbreakable(22, j));
        }
        for (int j = 9; j <13; j++){
            objects.add(new BlockUnbreakable(22, j));
        }
    }

}
