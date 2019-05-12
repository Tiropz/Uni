package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PNJ extends GameObject implements Directable, Activable{
    private static JLabel lblClock = new JLabel("");
    private int direction = EAST;
    private String name;
    private int indep;
    private boolean movable;
    private List<Double> hunger = new ArrayList<>();
    private String time;

    public PNJ(int x, int y, int indep,String name, Double hunger, boolean movable) {       //Constructor
        super(x, y);
        this.indep = indep;
        this.name = name;
        this.hunger.add(hunger);
        this.hunger.add(100.0);
        this.hunger.add(0.0);
        this.movable = movable;
    }

    @Override
    public int getDirection() { return direction; }

    @Override
    public boolean isObstacle() {
        return true;
    }

    void action(Game g, Player mainChar) {                      //Call the movePNJ method based on a random value
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
        g.notifyView(mainChar);
    }

    private void movePNJ(int x, int y) {
        if(this.movable) {
            int nextX = this.getPosX() + x;
            int nextY = this.getPosY() + y;

            boolean obstacle = false;
            for (GameObject object : Game.objects) {
                if (object != null) {
                    if (object.isAtPosition(nextX, nextY)) {
                        obstacle = object.isObstacle();
                    }
                    if (obstacle) {
                        break;
                    }
                }
            }
            this.rotate(x, y);
            if (!obstacle) {
                this.move(x, y);
            }
        }
    }

    private void rotate(int x, int y) {
        if (x == 0 && y == -1)
            direction = NORTH;
        else if (x == 0 && y == 1)
            direction = SOUTH;
        else if (x == 1 && y == 0)
            direction = EAST;
        else if (x == -1 && y == 0)
            direction = WEST;
    }

    private void alerte(Player mainChar){                   //Method to tell the player that his child is hungry

        int option = JOptionPane.showConfirmDialog(null, "Vous devez nourrir votre enfant\n Il vous reste : " + mainChar.getFoodFridge() + " snacks", "Attention", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            mainChar.setPosXY(getPosX(),getPosY());
            if (mainChar.getFoodFridge() == mainChar.getFoodFridgeMin()) {
                JOptionPane.showMessageDialog(null, "Vous n'avez plus de nourriture, vous devez payer 5e", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                mainChar.setMoney(-5);
                mainChar.setFoodFridge(1);
            }else{
                mainChar.setFoodFridge(-1);
                this.hunger.set(0,0.0);
            }
        }
    }



    ///////////////////////Getters and Setters/////////////////////


    private double getHunger() {
        return hunger.get(0);
    }
    private double getHungerMax() {
        return hunger.get(1);
    }
    private double getHungerMin(){
        return hunger.get(2);
    }
    public int getIndep(){
        return indep;
    }
    void setHunger(double val, Player mainChar){
        double hung = getHunger();
        hung -= val;
        if(hung >= getHungerMax()/2 && indep == 0){
            if (mainChar.getFoodFridge() == mainChar.getFoodFridgeMin()) {
                mainChar.setMoney(-5);
                mainChar.setFoodFridge(1);
            }
            mainChar.setFoodFridge(-1);
            hunger.set(0,hung-hung/2);
        }
        else if(hung >= getHungerMax()/2 && indep == 1){

            alerte(mainChar);

        }
        else{
            hunger.set(0,hung);
        }
    }


    //Everything happens here. This method handles the different interaction between the player and the PNJ

    @Override
    public Player activate(Player mainChar, Game game) {
        if(indep == 1){
            this.movable = false;
            Object[] options = {"Nourrir","Interagir"};
            int option = JOptionPane.showOptionDialog(null, "Que voulez-vous faire ?\n", "Choix", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            if (option == JOptionPane.YES_OPTION) {
                int option2 = JOptionPane.showConfirmDialog(null, "Vous devez nourrir votre enfant\n Il vous reste : " + mainChar.getFoodFridge() + " snacks", "Attention", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
                        new Thread(() -> {
                            for (int i = 4; i > 0; i--) {
                                try {
                                    time = (Integer.toString(i));

                                    lblClock.setText(time);
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            mainChar.setFoodFridge(-1);
                            hunger.set(0, 0.0);
                            dialog.dispose();
                        }).start();
                        dialog.setVisible(true);
                        dialog.dispose();

                    } else if ((int) this.getHunger() == this.getHungerMin()) {
                        JOptionPane.showMessageDialog(null, "Votre enfant à déjà trop mangé", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                    } else if (mainChar.getFoodFridge() == mainChar.getFoodFridgeMin()) {
                        JOptionPane.showMessageDialog(null, "Vous n'avez plus de nourriture", "Attention !", JOptionPane.INFORMATION_MESSAGE);
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
                new Thread(() -> {
                    for (int i = 5; i > 0; i--) {
                        try {
                            time = (Integer.toString(i));
                            lblClock.setText(time);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mainChar.setSocial(2);
                    dialog.dispose();
                }).start();
                dialog.setVisible(true);
                this.movable = true;
                dialog.dispose();

            }

            this.movable = true;

        }else if (indep == 0){
            this.movable = false;
            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous discutez avec votre partenaire?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
                    final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                    final JDialog dialog = new JDialog();
                    dialog.setTitle("Discussion");
                    dialog.setModal(true);
                    dialog.setLocationRelativeTo(null);
                    dialog.setContentPane(optionPane);
                    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    dialog.pack();
                    new Thread(() -> {
                        for(int i=5 ;i>0;i--){
                            try {
                                time = (Integer.toString(i));
                                lblClock.setText(time);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        mainChar.setSocial(4);
                        dialog.dispose();
                    }).start();
                    dialog.setVisible(true);
                    dialog.dispose();
            }
            this.movable = true;
        }
        return mainChar;
    }
}
