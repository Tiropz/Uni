package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Model.Player;

public class Status extends JPanel {
    private Player p;
    private int BAR_LENGTH = 60;
    private int BAR_WIDTH = 20;
    private int AVATAR_SIZE = 100;

    public Status() {
        this.setPreferredSize(new Dimension(450, 100));
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        // draw avatar

    }
    public void redraw() {
        this.repaint();
    }

    public void setPlayer(Player p2) {
        this.p = p2;
    }
}
