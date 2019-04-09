package View;

import Model.GameObject;
import Model.Player;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Mouse;

public class Window extends JFrame {
    private Map map = new Map();

    private Status status = new Status();
    GridBagConstraints gc = new GridBagConstraints();
    public Window(String title) {
        super(title);
        this.setLayout(new GridBagLayout());
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = 25*20;
        gc.ipadx = 25*20;
        gc.weightx = 0.0;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(map,gc);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 0;
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(status,gc);
        this.pack();
        this.setVisible(true);
    }

    public void setGameObjects(ArrayList<GameObject> objects) {
        this.map.setObjects(objects);
        this.map.redraw();
    }

    public void update() {
        this.map.redraw();
        this.status.redraw();
    }

    public void setKeyListener(KeyListener keyboard) {
        this.map.addKeyListener(keyboard);
    }


    public int getMapSize() {
        return map.MAP_SIZE;
    }

    public void setPlayer(Player p) {
        status.setPlayer(p);
    }
}
