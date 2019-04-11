package View;

import Model.GameObject;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public interface MapInterface {
    void setObjects(ArrayList<GameObject> objects);
    void redraw();
    ArrayList<GameObject> getObjects();
    void addKeyListener(KeyListener keyboard);
}
