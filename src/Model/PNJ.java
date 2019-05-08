package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PNJ extends GameObject implements Directable, Activable{
    int direction = EAST;
    String name;
    int indep;
    boolean movable;
    List<Double> hunger = new ArrayList<>();
    private String time;
    private static JLabel lblClock = new JLabel("");
    public int timer;
    public PNJ(int x, int y, int indep,String name, Double hunger, boolean movable) {
        super(x, y, 0);
        this.indep = indep;
        this.name = name;
        this.hunger.add(0.0);
        this.hunger.add(100.0);
        this.hunger.add(0.0);
        this.movable = movable;
    }

    @Override
    public int getDirection() {
        return direction;
    }

        @Override
    public boolean isObstacle() {
        return true;
    }

    public void action(Game g, Player mainChar) {
        System.out.println("ACTION");
        Random rand = new Random();
        int movevalue = rand.nextInt(30);
        switch (movevalue){
            case 0:
                movePNJ(0,1);
                break;
            case 1:
                movePNJ(0,-1);
                break;
            case 2:
                movePNJ(1,0);
                break;
            case 3:
                movePNJ(-1,0);
                break;
        }
        g.update(mainChar);
    }
    public double getHunger() {
        return hunger.get(0);
    } public double getHungerMax() {
        return hunger.get(1);
    }public double getHungerMin(){
        return hunger.get(2);
    }
    public int getIndep(){
        return indep;
    }
    public Player setHunger(double val, Player mainChar){
        Double hung = getHunger();
        hung -= val;
        if(hung >= getHungerMax()/2 && indep == 0){
            mainChar.setFoodFridge(-1);
            hunger.set(0,hung-hung/2);
            System.out.println("PROUTA");
        }
        else if(hung >= getHungerMax()/2 && indep == 1){

          alerte(mainChar);

        }
        else{
            hunger.set(0,hung);
        }

        return mainChar;
    }
    private void alerte(Player mainChar){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Vous devez nourrir votre enfant\n Il vous reste : " + mainChar.getFoodFridge() + " snacks", "Attention", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            mainChar.setPosXY(getPosX(),getPosY());
            if (mainChar.getFoodFridge() == mainChar.getFoodFridgeMin()) {
                jop.showMessageDialog(null, "Vous n'avez plus de nourriture, vous devez payer 5e", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                mainChar.setMoney(-5);
                mainChar.setFoodFridge(1);
            }else{


            mainChar.setFoodFridge(-1);
            this.hunger.set(0,0.0);
            }
        }else{

        }
    }

    public void movePNJ(int x, int y) {

        if(this.movable) {

            int nextX = this.getPosX() + x;
            int nextY = this.getPosY() + y;

            boolean obstacle = false;
            for (GameObject object : Game.objects) {
                if (object != null) {
                    if (object.isAtPosition(nextX, nextY)) {
                        obstacle = object.isObstacle();
                    }
                    if (obstacle == true) {
                        break;
                    }
                }
            }
            this.rotate(x, y);
            if (obstacle == false) {
                System.out.println("move x" + x);
                System.out.println("move y" + y);
                this.move(x, y);
            }
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

    @Override
    public Player activate(Player mainChar, Game game) throws InterruptedException {
        if(indep == 1){
            this.movable = false;
            JOptionPane jop = new JOptionPane();
            Object[] options = {"Nourrir",
                    "Interagir"};
            int option = jop.showOptionDialog(null, "Que voulez-vous faire ?\n", "Choix", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            if (option == JOptionPane.YES_OPTION) {
                int option2 = jop.showConfirmDialog(null, "Vous devez nourrir votre enfant\n Il vous reste : " + mainChar.getFoodFridge() + " snacks", "Attention", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option2 == JOptionPane.YES_OPTION) {
                    if ((int) this.getHunger() > this.getHungerMin() && mainChar.getFoodFridge() > mainChar.getFoodFridgeMin()) {

                        final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);


                        final JDialog dialog = new JDialog();
                        dialog.setTitle("Vous donnez à manger");
                        dialog.setModal(true);
                        dialog.setLocationRelativeTo(null);
                        dialog.setContentPane(optionPane);
                        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                        dialog.pack();

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 4; i > 0; i--) {

                                    try {
                                        if (i == 0) {

                                        }
                                        time = (Integer.toString(i));
                                        System.out.println("te");
                                        lblClock.setText(time);
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                mainChar.setFoodFridge(-1);
                                hunger.set(0, 0.0);
                                dialog.dispose();
                            }

                        }).start();

                        dialog.setVisible(true);

                        //  t.join();
                        System.out.println("afterclock");

                        dialog.dispose();
                    } else if ((int) this.getHunger() == this.getHungerMin()) {
                        jop.showMessageDialog(null, "Votre enfant à déjà trop mangé", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                    } else if (mainChar.getFoodFridge() == mainChar.getFoodFridgeMin()) {
                        jop.showMessageDialog(null, "Vous n'avez plus de nourriture", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }else if(option == JOptionPane.NO_OPTION){
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);


                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous vous occupez de votre enfant");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                this.movable = false;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 5; i > 0; i--) {

                            try {
                                if (i == 0) {

                                }
                                time = (Integer.toString(i));
                                System.out.println("te");
                                lblClock.setText(time);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        mainChar.setSocial(2);
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);

                //  t.join();
                System.out.println("afterclock");
                this.movable = true;
                dialog.dispose();
            }
            this.movable = true;
            }else if (indep == 0){
            this.movable = false;
            JOptionPane jop = new JOptionPane();
            int option = jop.showConfirmDialog(null, "Voulez-vous discutez avec votre femme?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {

                    final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                    // Thread t = new SampleThread(lblClock, optionPane);
                    //  t.start();

                    final JDialog dialog = new JDialog();
                    dialog.setTitle("Discussion");
                    dialog.setModal(true);
                    dialog.setLocationRelativeTo(null);
                    dialog.setContentPane(optionPane);
                    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    dialog.pack();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for(int i=5 ;i>0;i--){

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
                            mainChar.setSocial(4);
                            dialog.dispose();
                        }

                    }).start();

                    dialog.setVisible(true);

                    //  t.join();
                    System.out.println("afterclock");

                    dialog.dispose();
                    //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);




            }
            this.movable = true;

        }



        return mainChar;
}
    }
