package Model;

import View.MapInterface;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Player extends GameObject implements Directable {


    int direction = EAST;
    List<String> info = new ArrayList<>();
    String map;
    List<Double> energy = new ArrayList<>();
    List<Double> hunger = new ArrayList<>();
    List<Double> bladder = new ArrayList<>();
    List<Double> hygiene = new ArrayList<>();
    List<Integer> food = new ArrayList<>();
    List<Integer> foodFridge = new ArrayList<>();
    List<Integer> xp = new ArrayList<>();
    int lvl;
    int intel;
    int social;
    int money;
    int foodBasket;
    private String time;
    boolean hasWork;
    boolean hasApp;
    private static JLabel lblClock = new JLabel("");
    public int timer;


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
        this.hunger.add(hunger);
        this.hunger.add(0.0);
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
        this.xp.add(0);
        this.xp.add(10);
        this.xp.add(15);
        this.lvl = lvl;
        this.intel = intel;
        this.social = social;
        this.money = money;
        this.timer = timer;
        this.foodBasket = foodBasket;
        this.hasWork = hasWork;
        this.hasApp = hasApp;
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
    public void work(int val, int timer, Player mainChar, Game g){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous travailler ?\n", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {

            final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);


            final JDialog dialog = new JDialog();
            dialog.setTitle("Vous travaillez");
            dialog.setModal(true);
            dialog.setLocationRelativeTo(null);
            dialog.setContentPane(optionPane);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.pack();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = timer; i > 0; i--) {


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
                    mainChar.setMoney(val);
                    dialog.dispose();
                }

            }).start();

            dialog.setVisible(true);
            upXp(5, mainChar, g);
            mainChar.setIntel(2);
            //  t.join();
            System.out.println("afterclock");
            dialog.dispose();
            //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);


        }


    }
    public void eat(int val, int timer, Player mainChar, Game g) {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous manger ?\n Il vous reste : " + mainChar.getFoodFridge() + " nourriture dans votre frigo", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
                        mainChar.setHunger(-val);
                        if(mainChar.getHunger() < mainChar.getHungerMin()){
                            mainChar.setHunger(-mainChar.getHunger());
                        }
                        mainChar.setBladder(0.5);
                        mainChar.setFoodFridge(-1);
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);
                upXp(2, mainChar, g);
                //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
                //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else if ((int) mainChar.getHunger() == mainChar.getHungerMin()) {
                jop.showMessageDialog(null, "Vous avez déjà trop mangé", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            } else if (mainChar.getBladder() == mainChar.getBladderMax()) {
                jop.showMessageDialog(null, "Vous devez aller aux toilettes", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            } else if (mainChar.getFoodFridge() == mainChar.getFoodFridgeMin()) {
                jop.showMessageDialog(null, "Vous n'avez plus de nourriture dans votre frigo", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }


    }
    public Player rest(int val, int timer, Player mainChar){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous vous reposer ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
                        mainChar.setEnergy(val);
                        if(mainChar.getEnergy() > mainChar.getEnergyMax()) {
                            mainChar.setEnergy(getEnergyMax()-getEnergy());
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
    public Player pee(double val, int timer, Player mainChar, Game g) {
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous aller aux toilettes ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getBladder() > mainChar.getBladderMin()) {

                System.out.println("fini1");
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                System.out.println("fini2");
                // Thread t = new SampleThread(lblClock, optionPane);
                //  t.start();

                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous pissez");
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
                        mainChar.setBladder(-val);
                        if(mainChar.getBladder() < mainChar.getBladderMin()) {
                            System.out.println("PRTGERGEGEGERG");
                            mainChar.setBladder(-mainChar.getBladder());

                        }
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);
                upXp(2, mainChar, g);
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
    public Player makeFood(int val, int timer, Player mainChar, Game g){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous faire à manger ?\n Il vous reste : " + mainChar.getFoodFridge() + " nourriture dans votre frigo", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFoodFridge() < mainChar.getFoodFridgeMax()) {

                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                // Thread t = new SampleThread(lblClock, optionPane);
                //  t.start();

                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous cuisinez");
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
                        mainChar.setFoodFridge(1);
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);
                upXp(2, mainChar, g);
                //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
                //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else {
                jop.showMessageDialog(null, "Vous avez déjà trop de nourriture dans le frigo", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
        return mainChar;
    }
    public Player wash(int val, int timer, Player mainChar, Game g){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous vous laver ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getHygiene() < mainChar.getHygieneMax()) {

                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                // Thread t = new SampleThread(lblClock, optionPane);
                //  t.start();

                final JDialog dialog = new JDialog();
                dialog.setTitle("Vous vous lavez");
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
                        mainChar.setHygiene(val);
                        if(mainChar.getHygiene() > mainChar.getHygieneMax()){
                            mainChar.setHygiene(mainChar.getHygieneMax()-mainChar.getHygiene());
                        }
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);
                upXp(2, mainChar, g);
                //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
                //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else {
                jop.showMessageDialog(null, "Vous avez déjà propre", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
        return mainChar;
    }
    public Player fillFridge(int timer, Player mainChar){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous déposer votre nourriture ?\n Il vous reste : " + mainChar.getFoodFridge() + " nourriture dans votre frigo et "+mainChar.getFood()+ " nourriture sur vous", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFoodFridge() < mainChar.getFoodFridgeMax() && mainChar.getFood() > mainChar.getFoodMin()) {

                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                // Thread t = new SampleThread(lblClock, optionPane);
                //  t.start();

                final JDialog dialog = new JDialog();
                dialog.setTitle("Remplissage");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=timer ;i>0;i--){

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
                        mainChar.setFoodFridge(mainChar.getFood());
                        mainChar.setFood(-mainChar.getFood());
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);

                //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
                //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else if(mainChar.getFoodFridge() == mainChar.getFoodFridgeMax()) {
                jop.showMessageDialog(null, "Vous avez déjà trop de nourriture dans le frigo", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }else if(mainChar.getFood() == mainChar.getFoodMin()) {
                jop.showMessageDialog(null, "Vous n'avez plus de nourriture sur vous", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
        return mainChar;
    }


    public Player getFoodFromCounter(Player mainChar){
        SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 5, 1);
        JSpinner spinner = new JSpinner(sModel);
        JOptionPane jop = new JOptionPane();
        int option = JOptionPane.showOptionDialog(null, spinner, "Prendre de la nourriture", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFood() + mainChar.getFoodBasket() + (int) spinner.getValue() <= mainChar.getFoodMax()) {

                mainChar.setFoodBasket((int)spinner.getValue());
            } else{
                jop.showMessageDialog(null, "Vous avez déjà trop de nourriture sur vous", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
        return mainChar;
    }

    public Player pay(Player mainChar){
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous payer ?", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.getFoodBasket() != 0 && mainChar.getMoney() >= (mainChar.getFoodBasket()*3)) {

                mainChar.setFood(mainChar.getFoodBasket());
                mainChar.setFoodBasket(-mainChar.getFoodBasket());
            } else if (mainChar.getMoney() < (mainChar.getFoodBasket()*3)){
                jop.showMessageDialog(null, "Vous n'avez pas assez d'argent", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }else if(mainChar.getFoodBasket() == 0){
                jop.showMessageDialog(null, "Vous n'avez rien dans votre panier", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
        return mainChar;
    }


    public void inv(Player mainChar, String map){
        System.out.println(map);
        if(map.equals("Supermarché")){

        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, "Vous avez dans votre inventaire :\n" + "- " + mainChar.getFood()+ " nourriture\nEt dans votre panier :\n" + "- "+ mainChar.getFoodBasket()+ " nourriture", "Inventaire", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Vous avez dans votre inventaire :\n" + "- " + mainChar.getFood()+ " nourriture\n", "Inventaire", JOptionPane.INFORMATION_MESSAGE);

        }
        }

    public void upXp(int val, Player mainChar, Game g) {
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
    public void upLvl(Player mainChar, Game g){

        if(mainChar.lvl >= 15 && mainChar.getSocial() >= 350){
            PNJ partner = null;
            Gson gson = new Gson();
            try {

                BufferedReader br = new BufferedReader(
                        new FileReader("partner.json"));
                partner = gson.fromJson(br, PNJ.class);
            } catch (FileNotFoundException e) {

            }
                JOptionPane jop = new JOptionPane();
                int option = jop.showConfirmDialog(null, "Voulez-vous faire un enfant", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
                        jop.showMessageDialog(null, "Vous devez d'abord avoir un/une partenaire", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                    }


                }

        }if(mainChar.lvl >= 10 && mainChar.getSocial() >= 150){
            PNJ partner = g.partner;
            Gson gson = new Gson();
            System.out.println(partner);
            if (partner == null) {
                JOptionPane jop = new JOptionPane();
                int option = jop.showConfirmDialog(null, "Voulez-vous avoir un partenaire", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
        }
        if(mainChar.lvl >= 10 && mainChar.getIntel() >= 200){
            if (!hasWork) {
                JOptionPane jop = new JOptionPane();
                int option = jop.showConfirmDialog(null, "Voulez-vous avoir un travail", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    mainChar.setHasWork(true);
                }
            }
        }
        if(mainChar.lvl >= 10){
            JOptionPane jop = new JOptionPane();
            int option = jop.showConfirmDialog(null, "Voulez-vous acheter un appartement", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
                if(mainChar.getMoney() >= 500){

                mainChar.setMoney(-500);
                mainChar.setHasApp(true);
                }else{
                    jop.showMessageDialog(null, "Vous n'avez pas assez d'argent il faut 500 euros", "Attention !", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    // //////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean isObstacle() {
        return true;
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
    public int getTimer(){return timer;}
    public void setTimer(int val){
        if(timer == 86399){
            timer = 0;
        }
        else{
            timer += val;
        }
    }
    public void setPosXY(int x,int y){posX = x; posY = y;}
    public String getName(){return info.get(0);}
    public String getSex(){return info.get(1);}
    public String getStudy(){return info.get(2);}
    public String getCercle(){return info.get(3);}
    public int getIntel(){ return intel;}
    public void setIntel(int val){intel += val;}
    public int getSocial(){return social;}
    public void setSocial(int val){social += val;}
    public int getMoney(){return money;}
    public void setHygiene(double val){
        double hyg = getHygiene();
        hyg += val;
        hygiene.set(0,hyg);
    }
    public double getHygiene(){return hygiene.get(0);}
    public double getHygieneMax(){return hygiene.get(1);}
    public double getHygieneMin(){return hygiene.get(2);}
    public double getEnergy() {
        return energy.get(0);
    }
    public void setEnergy(double val){
        Double ener = getEnergy();
        ener += val;
        energy.set(0,ener);
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
    public void setHunger(double val){
    Double hung = getHunger();
    hung += val;
    hunger.set(0,hung);
    }
    public double getHungerMax() {
        return hunger.get(1);
    }
    public double getHungerMin() {
        return hunger.get(2);
    }
    public void setBladder(double val){
        Double blad = getBladder();
        blad += val;
        bladder.set(0,blad);
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
    public void setMoney(int val){
        money += val;
    }

    public void setFood(int val){
        int bouf = getFood();
        bouf += val;
        food.set(0,bouf);
    }
    public int getFood(){ return food.get(0); }
    public int getFoodMax(){ return food.get(1); }
    public int getFoodMin(){ return food.get(2); }
    public int getFoodFridge(){ return foodFridge.get(0); }
    public int getFoodFridgeMax(){ return foodFridge.get(1); }
    public int getFoodFridgeMin(){ return foodFridge.get(2); }
    public void setFoodFridge(int val){
        int bouf = getFoodFridge();
        bouf += val;
        foodFridge.set(0,bouf);
    }
    public int getXp(){ return xp.get(0);}
    public int getXpCurrent(){return xp.get(1);}
    public int getXpNext(){return xp.get(2);}
    public int getLvl(){return lvl;}
    public int getFoodBasket(){return foodBasket;}
    public void setFoodBasket(int foodBasket){this.foodBasket += foodBasket;}
    public boolean getHasWork(){return hasWork;}
    public void setHasWork(boolean hasWork){this.hasWork = hasWork;}
    public boolean getHasApp(){return hasApp;}
    public void setHasApp(boolean hasApp){this.hasApp = hasApp;}
}