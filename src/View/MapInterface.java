package View;

import Model.GameObject;
import Model.Player;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public interface MapInterface {
    Player setObjects(ArrayList<GameObject> objects, Player mainChar, MapInterface currentMap);
    void redraw();
    ArrayList<GameObject> getObjects();
    void addKeyListener(KeyListener keyboard);
}
