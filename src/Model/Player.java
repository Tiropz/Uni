package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player extends GameObject implements Directable {


    int direction = EAST;
    List<String> info = new ArrayList<>();
    String map;
    List<Double> energy = new ArrayList<>();
    List<Double> hunger = new ArrayList<>();
    List<Double> bladder = new ArrayList<>();
    List<Double> hygene = new ArrayList<>();
    List<Integer> food = new ArrayList<>();
    List<Integer> xp = new ArrayList<>();
    int lvl;
    int intel;
    int social;
    int money;
    private String time;
    private static JLabel lblClock = new JLabel("");


    public Player(int x, int y, String name, String sex, String study, String cercle, String map, Double energy, Double hunger, Double bladder,Double hygene, int nbreFood,int xp, int xpCurrent, int xpNext, int lvl, int intel, int social, int money) {
        super(x, y, 2);
        this.info.add(name);
        this.info.add(sex);
        this.info.add(study);
        this.info.add(cercle);
        this.map = map;
        this.energy.add(energy);
        this.energy.add(energy);
        this.energy.add(0.0);
        this.hunger.add(0.0);
        this.hunger.add(hunger);
        this.hunger.add(0.0);
        this.bladder.add(0.0);
        this.bladder.add(bladder);
        this.bladder.add(0.0);
        this.hygene.add(hygene);
        this.hygene.add(hygene);
        this.hygene.add(0.0);
        this.food.add(nbreFood);
        this.food.add(10);
        this.food.add(0);
        this.xp.add(0);
        this.xp.add(10);
        this.xp.add(15);
        this.lvl = lvl;
        this.intel = intel;
        this.social = social;
        this.money = money;    }

    public void move(int X, int Y) {
        this.posX = this.posX + X;
        this.posY = this.posY + Y;
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

    public void eat(int val, int timer, Player mainChar) {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous manger ?\n Il vous reste : " + mainChar.getFood() + " snacks", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getHunger() < mainChar.getHungerMax() && mainChar.getBladder() < mainChar.getBladderMax() && mainChar.getFood() > getFoodMin()) {

                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);


                final JDialog dialog = new JDialog();
                dialog.setTitle("Message");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=timer;i>0;i--){

                            try {
                                if(i==0){

                                }
                                time = (Integer.toString(i));
                                System.out.println("te");
                                lblClock.setText(time);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Double hung = mainChar.getHunger();
                        hung -= val;
                        mainChar.hunger.set(0,hung);
                        if(mainChar.getHunger() < mainChar.getHungerMin()){
                            mainChar.hunger.set(0,mainChar.getHungerMin());
                        }
                        Double blad = mainChar.getBladder();
                        blad += val;
                        mainChar.bladder.set(0,blad);
                        int bouf = mainChar.getFood();
                        bouf -= 1;
                        mainChar.food.set(0,bouf);
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);

                //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
                //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else if (mainChar.getHunger() == mainChar.getHungerMin()) {
                jop.showMessageDialog(null, "Vous avez déjà trop mangé", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            } else if (mainChar.getBladder() == mainChar.getBladderMax()) {
                jop.showMessageDialog(null, "Vous devez aller aux toilettes", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            } else if (mainChar.getFood() == mainChar.getFoodMin()) {
                jop.showMessageDialog(null, "Vous n'avez plus de nourriture", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }

        upXp(6);
    }
    public Player rest(int val, int timer, Player mainChar){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous regarder la TV ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getEnergy() < mainChar.getEnergyMax()) {

                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                // Thread t = new SampleThread(lblClock, optionPane);
                //  t.start();

                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous vous reposez");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=timer;i>0;i--){

                            try {
                                if(i==0){

                                }
                                time = (Integer.toString(i));
                                System.out.println("te");
                                lblClock.setText(time);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Double ener = mainChar.getEnergy();
                        ener += val;
                        mainChar.energy.set(0,ener);
                        if(mainChar.getEnergy() > mainChar.getEnergyMax()) {
                            mainChar.energy.set(0,100.0);
                        }
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);

                //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
                //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else {
                jop.showMessageDialog(null, "Vous êtes déjà en forme !!", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
        return mainChar;
    }
    public Player pee(double val, int timer, Player mainChar) {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous aller aux toilettes ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getBladder() < mainChar.getEnergyMax()) {

                System.out.println("fini1");
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                System.out.println("fini2");
                // Thread t = new SampleThread(lblClock, optionPane);
                //  t.start();

                final JDialog dialog = new JDialog();
                dialog.setTitle("Message");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=timer;i>0;i--){

                            try {
                                if(i==0){

                                }
                                time = (Integer.toString(i));
                                System.out.println("te");
                                lblClock.setText(time);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Double blad = mainChar.getBladder();
                        blad += val;
                        mainChar.bladder.set(0,blad);
                        if(mainChar.getBladder() < mainChar.getBladderMin()) {
                            mainChar.bladder.set(0,mainChar.getBladderMin());
                        }
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);

                //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
                //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else {
                jop.showMessageDialog(null, "Vous ne devez pas aller aux toilettes", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
       return mainChar;
    }
    public Player makeFood(int val, int timer, Player mainChar){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous faire à manger ?\n Il vous reste : " + mainChar.getFood() + " snacks", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFood() < mainChar.getFoodMax()) {

                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                // Thread t = new SampleThread(lblClock, optionPane);
                //  t.start();

                final JDialog dialog = new JDialog();
                dialog.setTitle("Message");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=timer;i>0;i--){

                            try {
                                if(i==0){

                                }
                                time = (Integer.toString(i));
                                System.out.println("te");
                                lblClock.setText(time);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        int bouf = mainChar.getFood();
                        bouf += val;
                        mainChar.food.set(0,bouf);
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);

                //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
                //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else {
                jop.showMessageDialog(null, "Vous avez déjà trop de nourriture", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
        return mainChar;
    }
    public void upXp(int val){
        int newXp;
        int x = xp.get(0);
        x += val;
        xp.set(0,x);
        int xpCurrent = getXpCurrent();
        int xpNext = getXpNext();
        if(x >= xpCurrent){
            newXp = x - xpCurrent;
            xpCurrent = xpCurrent + xpNext;
            xpNext = xpCurrent - xpNext;
            xpCurrent = xpCurrent - xpNext;
            xpNext = xpNext + xpCurrent;
            this.xp.set(0,newXp);
            this.xp.set(1,xpCurrent);
            this.xp.set(2,xpNext);
            this.lvl +=1;
        }

    }


    // //////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean isObstacle() {
        return false;
    }

    @Override
    public int getDirection() {
        return direction;
    }

    public int getFrontX() {
        int delta = 0;
        if (direction % 2 == 0) {
            delta += 1 - direction;
        }
        return this.posX + delta;
    }

    public int getFrontY() {
        int delta = 0;
        if (direction % 2 != 0) {
            delta += direction - 2;
        }
        return this.posY + delta;
    }


    public int getIntel(){ return intel;}
    public int getSocial(){return social;}
    public int getMoney(){return money;}
    public double getHygene(){return hygene.get(0);}
    public double getEnergy() {
        return energy.get(0);
    }
    public double getEnergyMax(){
        return energy.get(1);
    }
    public double getEnergyMin(){
        return energy.get(2);
    }
    public double getHunger() {
        return hunger.get(0);
    }
    public double getHungerMax() {
        return hunger.get(1);
    }
    public double getHungerMin() {
        return hunger.get(2);
    }
    public double getBladder() {
        return bladder.get(0);
    }
    public double getBladderMax() {
        return bladder.get(1);
    }
    public double getBladderMin() {
        return bladder.get(2);
    }

    public int getFood(){ return food.get(0); }
    public int getFoodMax(){ return food.get(1); }
    public int getFoodMin(){ return food.get(2); }

    public int getXp(){ return xp.get(0);}
    public int getXpCurrent(){return xp.get(1);}
    public int getXpNext(){return xp.get(2);}
    public int getLvl(){return lvl;}
}