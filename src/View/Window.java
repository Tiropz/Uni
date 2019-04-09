package View;

import Model.GameObject;
import Model.Player;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Mouse;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.HORIZONTAL;

public class Window {
    private Map map = new Map();

    private Status status = new Status();
    private JPanel groupPanel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    public Window(String title) {
        JFrame window = new JFrame("Uni");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1200, 1000);
        window.getContentPane().setBackground(Color.gray);
        c.fill = BOTH;
        c.ipadx = 100;
        c.gridy = 0;
        c.gridx = 0;
        groupPanel.add(this.map, c);
        c.fill = HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        groupPanel.add(this.status, c);
        window.add(this.groupPanel);
        window.setVisible(true);

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
