package Model;

import Controller.Keyboard;
import View.*;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;
import com.google.gson.Gson;

public class Game extends JFrame {
    static ArrayList<GameObject> objects = new ArrayList<>();
    private ArrayList<GameObject> objectList = new ArrayList<>();
    private List<PNJ> randPNJ = new ArrayList<>();
    private Player mainChar;
    private PNJ kid;
    private StudentRoom kotMap = new StudentRoom();
    private Library libraryMap = new Library();
    private Jefke jefkeMap = new Jefke();
    private Grocery groceryMap = new Grocery();
    private Work workMap = new Work();
    private Appartement appartementMap = new Appartement();
    private Status status = new Status(null);
    private MapInterface gamemap;
    private String mapName;
    private Timer myTimer = new Timer();
    private FileWriter fileWriterc = null;
    private FileWriter fileWriterp = null;
    private FileWriter fileWriterk = null;
    PNJ partner;

    public Game(String title, Player mainChar, PNJ partner, PNJ kid) {              //Constructor
        super(title);
        this.mainChar = mainChar;
        this.mapName = this.mainChar.map;
        this.gamemap = whichMap(mapName);
        this.partner = partner;
        this.kid = kid;
        Random rand = new Random();
        int nbrPNJ = rand.nextInt(15)+1;
        for(int i = 0;i<nbrPNJ;i++){                                              //Random creation of Jefke's PNJ's
            int randx = rand.nextInt(20)+1;
            int randy = rand.nextInt(8)+1;
            PNJ newPNJ = new PNJ(jefkeMap.x_middle-11+randx,randy,3,"PNJJEFKE",100.0,true);
            this.randPNJ.add(newPNJ);
        }
        buildMap();                                                             //Building the map at start
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(0, 0, 1000, 1020);
        this.getContentPane().setBackground(Color.gray);
        this.add((Component) gamemap, BorderLayout.NORTH);
        this.add(status, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        this.setPlayer(mainChar);


        TimerTask task = new TimerTask() {                                  //Setting Timer with call's for PNJ's
            @Override
            public void run() {
                if (gamemap == kotMap || gamemap == appartementMap) {
                    try {
                        partner.setHunger(-0.01, mainChar);
                        partner.action(Game.this, mainChar);
                    } catch (NullPointerException e) {
                        System.out.println("No partner");
                    }
                    try {
                        kid.action(Game.this, mainChar);
                        kid.setHunger(-0.01, mainChar);
                    } catch (NullPointerException e) {
                        System.out.println("No kid");
                    }
                }
                else if(gamemap == jefkeMap){
                    try{
                        for(PNJ jpnj : randPNJ){
                            jpnj.action(Game.this, mainChar);
                        }
                    }catch (NullPointerException e){
                        System.out.println("No PNJ");
                    }
                }
                mainChar.setHunger(0.01);
                mainChar.setEnergy(-0.001);
                mainChar.setTimer();
                notifyView(mainChar);
            }
        };
        myTimer.schedule(task,100,100);
    }

    private MapInterface whichMap(String mapName) {                         //Method to transform String name of the map to the MapInterface object
        MapInterface map;
        switch (mapName){
            case "Kot": map = kotMap;
                break;
            case "Bibliothèque": map = libraryMap;
                break;
            case "Jefke": map = jefkeMap;
                break;
            case "Supermarché": map = groceryMap;
                break;
            case "Travail": map = workMap;
                break;
            case "Appartement": map = appartementMap;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mapName);
        }
        return map;
    }

    private void buildMap() {                                       //Method to build the map by removing all the current object and putting the player and PNJ's into the new map
        ArrayList<GameObject> removed = new ArrayList<>();
        this.objectList.clear();
        this.objectList = new ArrayList<>(getObjects());
        for(GameObject c:this.objectList){
            if(c instanceof Directable){
                removed.add(c);
            }
        }
        this.objectList.removeAll(removed);
        objects.clear();
        objects.add(this.mainChar);
        if(gamemap == kotMap || gamemap == appartementMap){
        objects.add(this.partner);
        objects.add(this.kid);
        }
        else if(gamemap == jefkeMap){
            objects.addAll(randPNJ);
        }
        objects.addAll(objectList);
        this.setGameObjects(objects);
        Keyboard keyboard = new Keyboard(this);
        this.setKeyListener(keyboard);
    }

    public void movePlayer(int x, int y) {                        //Simple method to move the player
        int nextX = mainChar.getPosX() + x;
        int nextY = mainChar.getPosY() + y;

        boolean obstacle = false;
        for (GameObject object : objects) {
            if (object != null) {
                if (object.isAtPosition(nextX, nextY)) {
                    obstacle = object.isObstacle();
                }
                if (obstacle) {
                    break;
                }
            }
        }
        mainChar.rotate(x, y);
        if (!obstacle) {
            mainChar.move(x, y);
        }
        notifyView(this.mainChar);
    }

    public void showInv(){                                       //Call the invetory method of the player and pass the name of the map
        this.mainChar.inv(this.mainChar, mapName);
    }

    public void action() throws InterruptedException {          //Method to call activate if activable is in front or call door method if it's a door
        Activable aimedObject = null;
		for(GameObject object : objects){
		    if(object != null) {
                if (object.isAtPosition(mainChar.getFrontX(), mainChar.getFrontY())) {
                    if (object instanceof Activable) {
                        aimedObject = (Activable) object;
                    }
                }
            }
		}
		if(aimedObject instanceof Door){                                                        //Checking for doors
		    String switchMap = ((Door) aimedObject).mapChange(this.mapName, this.mainChar);
		  if(switchMap != null) {
		      this.mapName = switchMap;
              this.mainChar.map = this.mapName;
              this.gamemap = whichMap(mapName);
              buildMap();
              this.add((Component) gamemap, BorderLayout.NORTH);
              this.pack();
          }
        }
		if(aimedObject != null){
		    this.mainChar = aimedObject.activate(this.mainChar, Game.this);
            notifyView(this.mainChar);
		}

    }

    void reload(PNJ kid, PNJ partner){                      //Method to save and reload after adding a family member
        myTimer.cancel();
        this.partner = partner;
        this.kid = kid;
        Gson gson = new Gson();

        //convert the Java object to json
        String jsonStringk = gson.toJson(kid);
        String jsonStringp = gson.toJson(partner);
        String jsonStringc = gson.toJson(mainChar);
        //Write JSON String to file
        try {
            fileWriterc = new FileWriter("mainChar.json");
            fileWriterp = new FileWriter("partner.json");
            fileWriterk = new FileWriter("kid.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriterc.write(jsonStringc);
            fileWriterp.write(jsonStringp);
            fileWriterk.write(jsonStringk);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriterc.close();
            fileWriterp.close();
            fileWriterk.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dispose();
        this.myTimer.cancel();
        new Game("Uni", this.mainChar, this.partner, this.kid);
    }

    public void close(){                                                    //Method to save upon close into JSON
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter et sauvegarder ?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(option == JOptionPane.OK_OPTION){
            Gson gson = new Gson();
            //Convert the Java object to json
            String jsonStringk = gson.toJson(kid);
            String jsonStringp = gson.toJson(partner);
            String jsonStringc = gson.toJson(mainChar);
            //Write JSON String to file
            FileWriter fileWriterc = null;
            FileWriter fileWriterp = null;
            FileWriter fileWriterk = null;
            try {
                fileWriterc = new FileWriter("mainChar.json");
                fileWriterp = new FileWriter("partner.json");
                fileWriterk = new FileWriter("kid.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriterc.write(jsonStringc);
                fileWriterp.write(jsonStringp);
                fileWriterk.write(jsonStringk);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriterc.close();
                fileWriterp.close();
                fileWriterk.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.dispose();
        }
        this.myTimer.cancel();
    }

    void notifyView(Player actualPlayer) {
        this.status.redraw(actualPlayer);
        this.gamemap.redraw();
    }

    private ArrayList<GameObject> getObjects(){ return this.gamemap.getObjects(); }
    public Player getPlayer(){
        return this.mainChar;
    }

    private void setKeyListener(KeyListener keyboard) {
        this.gamemap.addKeyListener(keyboard);
    }

    private void setGameObjects(ArrayList<GameObject> objects) {
        this.mainChar = this.gamemap.setObjects(objects, this.mainChar, this.gamemap);
        this.gamemap.redraw();
    }
    public void setPlayer(Player p) {
        status.setPlayer(p);
    }
}