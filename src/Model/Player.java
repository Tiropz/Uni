package Model;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Player extends GameObject implements Directable {

    private int direction = EAST;
    private List<String> info = new ArrayList<>();
    String map;
    private List<Double> energy = new ArrayList<>();
    private List<Double> hunger = new ArrayList<>();
    private List<Double> bladder = new ArrayList<>();
    private List<Double> hygiene = new ArrayList<>();
    private List<Integer> food = new ArrayList<>();
    private List<Integer> foodFridge = new ArrayList<>();
    private List<Integer> xp = new ArrayList<>();
    private int lvl;
    private int intel;
    private int social;
    private int money;
    private int foodBasket;
    private String time;
    boolean hasWork;
    boolean hasApp;
    private static JLabel lblClock = new JLabel("");
    private int timer;

    //Constructor

    public Player(int x, int y, String name, String sex, String study, String cercle, String map, Double energy, Double hunger, Double bladder,Double hygiene, int nbreFood, int nbreFoodFridge, int xp, int xpCurrent, int xpNext, int lvl, int intel, int social, int money, int timer, int foodBasket, boolean hasWork, boolean hasApp) {
        super(x, y);
        this.info.add(name);
        this.info.add(sex);
        this.info.add(study);
        this.info.add(cercle);
        this.map = map;
        this.energy.add(energy);
        this.energy.add(energy);
        this.energy.add(0.0);
        this.hunger.add(0.0);
        this.hunger.add(0.0);
        this.hunger.add(hunger);
        this.bladder.add(0.0);
        this.bladder.add(bladder);
        this.bladder.add(0.0);
        this.hygiene.add(hygiene);
        this.hygiene.add(hygiene);
        this.hygiene.add(0.0);
        this.food.add(nbreFood);
        this.food.add(10);
        this.food.add(0);
        this.foodFridge.add(nbreFoodFridge);
        this.foodFridge.add(50);
        this.foodFridge.add(0);
        this.xp.add(xp);
        this.xp.add(xpCurrent);
        this.xp.add(xpNext);
        this.lvl = lvl;
        this.intel = intel;
        this.social = social;
        this.money = money;
        this.timer = timer;
        this.foodBasket = foodBasket;
        this.hasWork = hasWork;
        this.hasApp = hasApp;
    }

    void rotate(int x, int y) {
        if (x == 0 && y == -1)
            direction = NORTH;
        else if (x == 0 && y == 1)
            direction = SOUTH;
        else if (x == 1 && y == 0)
            direction = EAST;
        else if (x == -1 && y == 0)
            direction = WEST;
    }


    //////////////////////////////////////////////////////////////////////Life sim methods//////////////////////////////////////////////////////////////////////

    /*
    Each method works the same way. You get an option pane to confirm and then it checks variables min and max to see if you can
    do the action. Then it sets a timer and increments needed variables.
     */

    void work(int val, int timer, Player mainChar, Game g){
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous travailler ?\n", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
            final JDialog dialog = new JDialog();
            dialog.setTitle("Vous travaillez");
            dialog.setModal(true);
            dialog.setLocationRelativeTo(null);
            dialog.setContentPane(optionPane);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.pack();
            new Thread(() -> {
                for (int i = timer; i > 0; i--) {
                    try {
                        time = (Integer.toString(i));
                        lblClock.setText(time);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mainChar.setMoney(val);
                dialog.dispose();
            }).start();
            dialog.setVisible(true);
            upXp(5, mainChar, g);
            mainChar.setIntel(2);
            dialog.dispose();
        }
    }

    void eat(int val, int timer, Player mainChar, Game g) {
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous manger ?\n Il vous reste : " + mainChar.getFoodFridge() + " nourriture dans votre frigo", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if ((int) mainChar.getHunger() > mainChar.getHungerMin() && mainChar.getBladder() < mainChar.getBladderMax() && mainChar.getFoodFridge() > getFoodFridgeMin()) {
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous mangez");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(() -> {
                    for(int i=timer;i>0;i--){

                        try {
                            time = (Integer.toString(i));
                            lblClock.setText(time);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mainChar.setHunger(-val);
                    if(mainChar.getHunger() < mainChar.getHungerMin()){
                        mainChar.setHunger(-mainChar.getHunger());
                    }
                    mainChar.setBladder(0.5);
                    mainChar.setFoodFridge(-1);
                    dialog.dispose();
                }).start();
                dialog.setVisible(true);
                upXp(2, mainChar, g);
                dialog.dispose();

            } else if ((int) mainChar.getHunger() == mainChar.getHungerMin()) {
                JOptionPane.showMessageDialog(null, "Vous avez déjà trop mangé", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            } else if (mainChar.getBladder() == mainChar.getBladderMax()) {
                JOptionPane.showMessageDialog(null, "Vous devez aller aux toilettes", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            } else if (mainChar.getFoodFridge() == mainChar.getFoodFridgeMin()) {
                JOptionPane.showMessageDialog(null, "Vous n'avez plus de nourriture dans votre frigo", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void rest(int val, int timer, Player mainChar){
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous vous reposer ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getEnergy() < mainChar.getEnergyMax()) {
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous vous reposez");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(() -> {
                    for(int i=timer;i>0;i--){
                        try {
                            time = (Integer.toString(i));
                            lblClock.setText(time);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mainChar.setEnergy(val);
                    if(mainChar.getEnergy() > mainChar.getEnergyMax()) {
                        mainChar.setEnergy(getEnergyMax()-getEnergy());
                    }
                    dialog.dispose();
                }).start();
                dialog.setVisible(true);
                dialog.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Vous êtes déjà en forme !!", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void pee(double val, int timer, Player mainChar, Game g) {
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous aller aux toilettes ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getBladder() > mainChar.getBladderMin()) {
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous faites pipi");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(() -> {
                    for(int i=timer;i>0;i--){
                        try {
                            time = (Integer.toString(i));
                            lblClock.setText(time);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mainChar.setBladder(-val);
                    if(mainChar.getBladder() < mainChar.getBladderMin()) {
                        mainChar.setBladder(-mainChar.getBladder());
                    }
                    dialog.dispose();
                }).start();
                dialog.setVisible(true);
                upXp(2, mainChar, g);
                dialog.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Vous ne devez pas aller aux toilettes", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void makeFood(int val, int timer, Player mainChar, Game g){
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous faire à manger ?\n Il vous reste : " + mainChar.getFoodFridge() + " nourriture dans votre frigo", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFoodFridge() < mainChar.getFoodFridgeMax()) {
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous cuisinez");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(() -> {
                    for(int i=timer;i>0;i--){
                        try {
                            time = (Integer.toString(i));
                            lblClock.setText(time);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mainChar.setFoodFridge(val);
                    dialog.dispose();
                }).start();
                dialog.setVisible(true);
                upXp(2, mainChar, g);
                dialog.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Vous avez déjà trop de nourriture dans le frigo", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void wash(int val, int timer, Player mainChar, Game g){
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous vous laver ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getHygiene() < mainChar.getHygieneMax()) {
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous vous lavez");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(() -> {
                    for(int i=timer;i>0;i--){
                        try {
                            time = (Integer.toString(i));
                            lblClock.setText(time);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mainChar.setHygiene(val);
                    if(mainChar.getHygiene() > mainChar.getHygieneMax()){
                        mainChar.setHygiene(mainChar.getHygieneMax()-mainChar.getHygiene());
                    }
                    dialog.dispose();
                }).start();
                dialog.setVisible(true);
                upXp(2, mainChar, g);
                dialog.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Vous avez déjà propre", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void fillFridge(int timer, Player mainChar){
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous déposer votre nourriture ?\n Il vous reste : " + mainChar.getFoodFridge() + " nourriture dans votre frigo et "+mainChar.getFood()+ " nourriture sur vous", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFoodFridge() < mainChar.getFoodFridgeMax() && mainChar.getFood() > mainChar.getFoodMin()) {
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                final JDialog dialog = new JDialog();
                dialog.setTitle("Remplissage");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(() -> {
                    for(int i=timer ;i>0;i--){
                        try {
                            time = (Integer.toString(i));
                            lblClock.setText(time);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mainChar.setFoodFridge(mainChar.getFood());
                    mainChar.setFood(-mainChar.getFood());
                    dialog.dispose();
                }).start();
                dialog.setVisible(true);
                dialog.dispose();

            } else if(mainChar.getFoodFridge() == mainChar.getFoodFridgeMax()) {
                JOptionPane.showMessageDialog(null, "Vous avez déjà trop de nourriture dans le frigo", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }else if(mainChar.getFood() == mainChar.getFoodMin()) {
                JOptionPane.showMessageDialog(null, "Vous n'avez plus de nourriture sur vous", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void getFoodFromCounter(Player mainChar){
        SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 5, 1);
        JSpinner spinner = new JSpinner(sModel);
        int option = JOptionPane.showOptionDialog(null, spinner, "Prendre de la nourriture", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFood() + mainChar.getFoodBasket() + (int) spinner.getValue() <= mainChar.getFoodMax()) {

                mainChar.setFoodBasket((int)spinner.getValue());

            } else{
                JOptionPane.showMessageDialog(null, "Vous avez déjà trop de nourriture sur vous", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void pay(Player mainChar){
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous payer ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFoodBasket() != 0 && mainChar.getMoney() >= (mainChar.getFoodBasket()*3)) {

                mainChar.setMoney(getFoodBasket()*3);
                mainChar.setFood(mainChar.getFoodBasket());
                mainChar.setFoodBasket(-mainChar.getFoodBasket());


            } else if (mainChar.getMoney() < (mainChar.getFoodBasket()*3)){
                JOptionPane.showMessageDialog(null, "Vous n'avez pas assez d'argent", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }else if(mainChar.getFoodBasket() == 0){
                JOptionPane.showMessageDialog(null, "Vous n'avez rien dans votre panier", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void inv(Player mainChar, String map){
        if(map.equals("Supermarché")){
        JOptionPane.showMessageDialog(null, "Vous avez dans votre inventaire :\n" + "- " + mainChar.getFood()+ " nourriture\nEt dans votre panier :\n" + "- "+ mainChar.getFoodBasket()+ " nourriture", "Inventaire", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Vous avez dans votre inventaire :\n" + "- " + mainChar.getFood()+ " nourriture\n", "Inventaire", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //////////////////////////////////////////////////////////////////////Leveling methods//////////////////////////////////////////////////////////////////////


    private void upXp(int val, Player mainChar, Game g) {
        int newXp;
        int x = mainChar.xp.get(0);
        x += val;
        mainChar.xp.set(0, x);
        int xpCurrent = getXpCurrent();
        int xpNext = getXpNext();
        if (x >= xpCurrent) {
            newXp = x - xpCurrent;
            xpCurrent = xpCurrent + xpNext;
            xpNext = xpCurrent - xpNext;
            xpCurrent = xpCurrent - xpNext;
            xpNext = xpNext + xpCurrent;
            mainChar.xp.set(0, newXp);
            mainChar.xp.set(1, xpCurrent);
            mainChar.xp.set(2, xpNext);
            mainChar.lvl += 1;
            upLvl(mainChar, g);
        }
    }

    private void upLvl(Player mainChar, Game g){                    //This method checks what new option are available when leveling up
        if(mainChar.lvl >= 15 && mainChar.getSocial() >= 350){
            PNJ partner = null;
            Gson gson = new Gson();
            try {
                BufferedReader br = new BufferedReader(
                        new FileReader("partner.json"));
                partner = gson.fromJson(br, PNJ.class);
            } catch (FileNotFoundException ignored) { }
                int option = JOptionPane.showConfirmDialog(null, "Voulez-vous faire un enfant", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    if (partner != null) {
                        PNJ kid = new PNJ(mainChar.getPosX(),mainChar.getPosY(), 1, "Enfant", 0.0, true);
                        //convert the Java object to json
                        String jsonString = gson.toJson(kid);
                        //Write JSON String to file
                        FileWriter fileWriter = null;
                        try {
                            fileWriter = new FileWriter("kid.json");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            fileWriter.write(jsonString);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        g.reload(kid, partner);
                    } else {
                        JOptionPane.showMessageDialog(null, "Vous devez d'abord avoir un/une partenaire", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        }if(mainChar.lvl >= 10 && mainChar.getSocial() >= 150){
            PNJ partner = g.partner;
            Gson gson = new Gson();
            if (partner == null) {
                int option = JOptionPane.showConfirmDialog(null, "Voulez-vous avoir un partenaire", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    partner = new PNJ(mainChar.getPosX(), mainChar.getPosY(), 0, "Partner", 0.0, true);
                    //convert the Java object to json
                    String jsonString = gson.toJson(partner);
                    //Write JSON String to file
                    FileWriter fileWriter = null;
                    try {
                        fileWriter = new FileWriter("partner.json");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fileWriter.write(jsonString);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g.reload(null, partner);
                }
            }
        }if(mainChar.lvl >= 10 && mainChar.getIntel() >= 200){
            if (!hasWork) {
                int option = JOptionPane.showConfirmDialog(null, "Voulez-vous avoir un travail", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    mainChar.setHasWork(true);
                }
            }
        }if(mainChar.lvl >= 10){
            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous acheter un appartement", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
                if(mainChar.getMoney() >= 500){
                mainChar.setMoney(-500);
                mainChar.setHasApp(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Vous n'avez pas assez d'argent il faut 500 euros", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    //////////////////////////////////////////////////////////////////////Position and definition methods//////////////////////////////////////////////////////////////////////

    @Override
    public boolean isObstacle() {
        return true;
    }
    @Override
    public int getDirection() {
        return direction;
    }
    int getFrontX() {
        int delta = 0;
        if (direction % 2 == 0) {
            delta += 1 - direction;
        }
        return this.posX + delta;
    }
    int getFrontY() {
        int delta = 0;
        if (direction % 2 != 0) {
            delta += direction - 2;
        }
        return this.posY + delta;
    }
    public int getTimer(){return timer;}
    void setTimer(){
        if(timer == 86399){
            timer = 0;
        }
        else{
            timer += 1;
        }
    }
    public void setPosXY(int x,int y){posX = x; posY = y;}



    //////////////////////////////////////////////////////////////////////Getters and setters for gaming variables//////////////////////////////////////////////////////////////////////


    //Info Getters//
    public String getName(){return info.get(0);}
    public String getSex(){return info.get(1);}
    public String getStudy(){return info.get(2);}
    public String getCercle(){return info.get(3);}

    //Intel Getters and Setters//
    public int getIntel(){ return intel;}
    private void setIntel(int val){intel += val;}

    //Social Getters and Setters//
    public int getSocial(){return social;}
    void setSocial(int val){social += val;}

    //Money Getters and Setters//
    public int getMoney(){return money;}
    void setMoney(int val){
        money += val;
    }

    //Hygiene Getters and Setters//
    public double getHygiene(){return hygiene.get(0);}
    private double getHygieneMax(){return hygiene.get(1);}
    public double getHygieneMin(){return hygiene.get(2);}
    private void setHygiene(double val){
        double hyg = getHygiene();
        hyg += val;
        hygiene.set(0,hyg);
    }

    //Energy Getters and Setters//
    public double getEnergy() { return energy.get(0); }
    private double getEnergyMax(){
        return energy.get(1);
    }
    public double getEnergyMin(){
        return energy.get(2);
    }
    void setEnergy(double val){
        double ener = getEnergy();
        ener += val;
        energy.set(0,ener);
    }

    //Hunger Getters and Setters//
    public double getHunger() { return hunger.get(0); }
    public double getHungerMax() { return hunger.get(1); }
    private double getHungerMin() { return hunger.get(2); }
    void setHunger(double val){
        double hung = getHunger();
        hung += val;
        hunger.set(0,hung);
    }

    //Bladder Getters and Setters//
    public double getBladder() { return bladder.get(0); }
    private double getBladderMax() { return bladder.get(1); }
    private double getBladderMin() { return bladder.get(2); }
    private void setBladder(double val){
        double blad = getBladder();
        blad += val;
        bladder.set(0,blad);
    }

    //Food Getters and Setters//
    private int getFood(){ return food.get(0); }
    private int getFoodMax(){ return food.get(1); }
    private int getFoodMin(){ return food.get(2); }
    private void setFood(int val){
        int bouf = getFood();
        bouf += val;
        food.set(0,bouf);
    }

    //FoodFridge Getters and Setters//
    int getFoodFridge(){ return foodFridge.get(0); }
    private int getFoodFridgeMax(){ return foodFridge.get(1); }
    int getFoodFridgeMin(){ return foodFridge.get(2); }
    void setFoodFridge(int val){
        int bouf = getFoodFridge();
        bouf += val;
        foodFridge.set(0,bouf);
    }
    //FoodBasket Getters and Setters//
    int getFoodBasket(){return foodBasket;}
    private void setFoodBasket(int foodBasket){this.foodBasket += foodBasket;}

    //XP and LVL Getters//
    public int getXp(){ return xp.get(0);}
    public int getXpCurrent(){return xp.get(1);}
    private int getXpNext(){return xp.get(2);}
    public int getLvl(){return lvl;}

    //HasWork Getters and Setters//
    public boolean getHasWork(){return hasWork;}
    private void setHasWork(boolean hasWork){this.hasWork = hasWork;}

    //HasApp Getters and Setters//
    public boolean getHasApp(){return hasApp;}
    private void setHasApp(boolean hasApp){this.hasApp = hasApp;}
}