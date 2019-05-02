package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PNJ extends GameObject implements Directable {
    int direction = EAST;
    String name;
    boolean indep;
    List<Double> hunger = new ArrayList<>();
    private String time;
    private static JLabel lblClock = new JLabel("");
    public int timer;
    public PNJ(int X, int Y, boolean indep,String name, Double hunger) {
        super(X, Y, 0);
        this.indep = indep;
        this.name = name;
        this.hunger.add(0.0);
        this.hunger.add(100.0);
        this.hunger.add(0.0);
    }

    @Override
    public int getDirection() {
        return 0;
    }

        @Override
    public boolean isObstacle() {
        return true;
    }

    public void action(Player mainChar) {

        Random rand = new Random();
        int movevalue = rand.nextInt(4);
        switch (movevalue){
            case 0:
                movePNJ(0,1);
                break;
            case 1:
                movePNJ(0,-1);
            case 2:
                movePNJ(1,0);
            case 3:
                movePNJ(-1,0);
        }
    }
    public double getHunger() {
        return hunger.get(0);
    }
    public Player setHunger(double val, Player mainChar){
        Double hung = getHunger();
        hung -= val;
        if(hung >= hunger.get(1)/2){
            mainChar.setFood(-1);
            hunger.set(0,hung-hung/2);
            System.out.println("PROUTA");
        }
        else{
            hunger.set(0,hung);
        }

        return mainChar;
    }
    public void movePNJ(int x, int y) {
        int nextX = this.getPosX() + x;
        int nextY = this.getPosY() + y;

        boolean obstacle = false;
        for (GameObject object : Game.objects) {
            if (object.isAtPosition(nextX, nextY)) {
                obstacle = object.isObstacle();
            }
            if (obstacle == true) {
                break;
            }
        }
        this.rotate(x, y);
        if (obstacle == false) {
            this.move(x, y);
        }

    }
    public void rotate(int x, int y) {
        if (x == 0 && y == -1)
            direction = NORTH;
        else if (x == 0 && y == 1)
            direction = SOUTH;
        else if (x == 1 && y == 0)
            direction = EAST;
        else if (x == -1 && y == 0)
            direction = WEST;
    }
}
