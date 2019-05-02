package View;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.*;

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
    private int hunger;
    private int bladder;
    private int xp;
    private int xpCurrent;
    private int lvl;
    private int intel;
    private int social;
    private int money;
    private int hygene;
    private String name;
    private String cercle;
    private String study;
    private String sex;
    private int timer;
    private int hours;
    private int minutes;
    private int seconds;

    public Status(Player mainChar) {
        width_screen = (int) screenSize.getWidth();
        height_screen = (int) screenSize.getHeight();
        height_status = height_screen/5;
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

    }

    public void paint(Graphics g) {

        this.energy = (int) this.mainChar.getEnergy();
        this.hunger = (int) this.mainChar.getHunger();
        this.bladder = (int) this.mainChar.getBladder();
        this.xp = this.mainChar.getXp();
        this.lvl = this.mainChar.getLvl();
        this.xpCurrent = this.mainChar.getXpCurrent();
        this.intel = this.mainChar.getIntel();
        this.money = this.mainChar.getMoney();
        this.social = this.mainChar.getSocial();
        this.hygene = (int) this.mainChar.getHygene();
        this.study = this.mainChar.getStudy();
        this.name = this.mainChar.getName();
        this.sex = this.mainChar.getSex();
        this.cercle = this.mainChar.getCercle();

        this.timer = this.mainChar.getTimer();

        this.hours = timer/3600;
        this.timer -= this.hours*3600;
        this.minutes = this.timer/60;
        this.timer -= this.minutes*60;
        this.seconds = this.timer;

        super.paintComponent(g);
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        Image cercleImage = new ImageIcon("src/Image/"+this.study+".png").getImage();
        g.drawImage(cercleImage,0, 0,height_status, height_status, null);

        g.drawString(this.name, height_status + 10, 1*height_status/5);
        g.drawString(this.sex, height_status + 10, 2*height_status/5);
        g.drawString(this.study, height_status + 10, 3*height_status/5);
        g.drawString(this.cercle, height_status + 10, 4*height_status/5);

        g.drawString(this.hours+":"+this.minutes+":"+this.seconds, height_status+200, height_status/2);

        g.drawString("Energie" +" : " + this.energy, 2*width_screen/5, height_status/4);
        g.drawString("Faim" +" : " + this.hunger, 2*width_screen/5, height_status/2);
        g.drawString("Vessie" +" : " + this.bladder, 2*width_screen/5, 3*height_status/4);
        // draw avatar
        g.drawString("Level" +" : " + this.lvl, 3*width_screen/5, height_status/2);
        g.drawString("XP" +" : " + this.xp + "/" + this.xpCurrent, 3*width_screen/5, height_status/4);
        g.drawString("Argent" +" : " + this.money, 3*width_screen/5, 3*height_status/4);

        g.drawString("Intelligence" +" : " + this.intel, 4*width_screen/5, height_status/4);
        g.drawString("Sociabilité" +" : " + this.social, 4*width_screen/5, height_status/2);
        g.drawString("Hygiène" +" : " + this.hygene, 4*width_screen/5, 3*height_status/4);
    }
    public void redraw(Player actualPlayer) {
        this.mainChar = actualPlayer;
        this.repaint();
    }

    public void setPlayer(Player p2) {
        this.p = p2;
    }
}
