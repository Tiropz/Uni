package View;

import Model.Game;
import Model.GameObject;
import Model.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Mouse;
import com.google.gson.Gson;

public class Window extends JFrame {
    Player mainChar;
    private Map map = new Map(1);
    private Status status = new Status(mainChar);

    public Window(String title) {

        super(title);
        this.setLayout(new BorderLayout());
        // JFrame window = new JFrame("Game");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

    public void update(Player actualPlayer) {

        this.status.redraw(actualPlayer);
        this.map.redraw();
    }

    public void setKeyListener(KeyListener keyboard) {
        this.map.addKeyListener(keyboard);
    }

    public void setGameObjects(ArrayList<GameObject> objects) {
        this.map.setObjects(objects);
        this.map.redraw();
    }
    public void setPlayer(Player p) {
        status.setPlayer(p);
    }
}
