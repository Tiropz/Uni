package View;

import Model.GameObject;
import Model.Player;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public interface MapInterface {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width_screen = (int) screenSize.getWidth();
    int height_screen = (int) screenSize.getHeight();
    Player setObjects(ArrayList<GameObject> objects, Player mainChar, MapInterface currentMap);
    void redraw();
    ArrayList<GameObject> getObjects();
    void addKeyListener(KeyListener keyboard);
}
