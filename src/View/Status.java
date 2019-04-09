package View;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JPanel;

import Model.GameObject;
import Model.Player;
import com.google.gson.Gson;

public class Status extends JPanel {
    Gson gson = new Gson();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width_screen;
    public int height_screen;
    public int height_status;
    private Player p;
    private int BAR_LENGTH = 60;
    private int BAR_WIDTH = 20;
    private int AVATAR_SIZE = 100;
    private Player mainChar;
    private int energy;

    public Status(Player mainChar) {
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        height_status = 1*height_screen/5;
        this.setPreferredSize(new Dimension(width_screen, height_status));
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader("mainChar.json"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        this.mainChar = gson.fromJson(br, Player.class);
        this.energy = (int) this.mainChar.getEnergy();
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Energi74e" +" : " + this.energy, 0, height_status/4);
        g.drawString("Energie" +" : " + this.energy, 0, height_status/2);
        g.drawString("Energie" +" : " + this.energy, 0, 3*height_status/4);
        // draw avatar

    }
    public void redraw() {
        this.repaint();
    }

    public void setPlayer(Player p2) {
        this.p = p2;
    }
}
