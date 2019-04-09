package View;

import Model.GameObject;
import Model.Player;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Mouse;

public class Window {
    private Map map = new Map();

    private Status status = new Status();
    private JPanel groupPanel = new JPanel(new BorderLayout());
    public Window(String title) {
        JFrame window = new JFrame("Uni");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1200, 1000);
        window.getContentPane().setBackground(Color.gray);
        groupPanel.add(this.map, BorderLayout.NORTH);
        groupPanel.add(this.status, BorderLayout.SOUTH);
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
