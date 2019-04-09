package View;

import Model.GameObject;
import Model.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Mouse;

public class Window extends JFrame {

    private Map map = new Map(2);
    private Status status = new Status();

    public Window(String title) {

        super(title);
        this.setLayout(new BorderLayout());
        // JFrame window = new JFrame("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1000, 1020);
        this.getContentPane().setBackground(Color.gray);
        this.add(map, BorderLayout.NORTH);
        this.add(status, BorderLayout.SOUTH);
        this.pack();
        // this.getContentPane().add(this.groupPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public ArrayList<GameObject> getObjects(Integer wm){
        return this.map.getObjects(wm);
    }

    public void update() {

        this.status.redraw();
        this.map.redraw();
    }

    public void setKeyListener(KeyListener keyboard) {
        this.map.addKeyListener(keyboard);
    }

    public void setGameObjects(ArrayList<GameObject> objects) {
        this.map.setObjects(objects);
        this.map.redraw();
    }
    public int getMapSize() {
        return map.MAP_WIDTH;
    }

    public void setPlayer(Player p) {
        status.setPlayer(p);
    }
}
