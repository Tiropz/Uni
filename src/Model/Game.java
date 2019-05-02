package Model;

import Controller.Keyboard;
import View.*;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.*;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

public class Game extends JFrame implements DeletableObserver {
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    ArrayList<GameObject> objectList = new ArrayList<GameObject>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private Player active_player = null;
    private Player mainChar;
    private StudentRoom kotMap = new StudentRoom();
    private Library libraryMap = new Library();
    private Jefke jefkeMap = new Jefke();
    private Status status = new Status(mainChar);
    public MapInterface gamemap;
    private String mapName;
    public int secondpassed = 0;
    Timer myTimer = new Timer();
    private int x_middle;
    private int width_screen;

    public Game(String title, Player mainChar) {
        super(title);
        this.mainChar = mainChar;
        this.mapName = this.mainChar.map;
        this.gamemap = whichMap(mapName);

        buildMap();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(0, 0, 1000, 1020);
        this.getContentPane().setBackground(Color.gray);
        this.add((Component) gamemap, BorderLayout.NORTH);
        this.add(status, BorderLayout.SOUTH);
        this.pack();
        // this.getContentPane().add(this.groupPanel, BorderLayout.CENTER);
        this.setVisible(true);

        players.add(mainChar);
        this.setPlayer(mainChar);
        active_player = mainChar;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            secondpassed++;
            System.out.println(secondpassed);
            mainChar.setHunger(-0.1);
            mainChar.setEnergy(0.01);
            mainChar.setTimer(1);
            status.redraw(mainChar);
            }
        };

        myTimer.schedule(task,1000,1000);
    }

    private MapInterface whichMap(String mapName) {
        MapInterface map;
        switch (mapName){
            case "Kot": map = kotMap;
            break;
            case "Bibliothèque": map = libraryMap;
            break;
            case "Jefke": map = jefkeMap;
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + mapName);
        }
        return map;
    }

    private void buildMap() {
        ArrayList<GameObject> removed = new ArrayList<GameObject>();
        this.objectList.clear();

        this.objectList = new ArrayList<GameObject>(getObjects());
        System.out.println("Objlist " + this.objectList.size());
        for(GameObject c:this.objectList){
            if(c instanceof Player){
                removed.add(c);
                System.out.println("FONCTIONNE");
            }
        }
        this.objectList.removeAll(removed);
        objects.clear();
        objects.add(this.mainChar);

        System.out.println("Objlist2 " + this.objectList.size());
        // Map building
        // use currInstance
        objects.addAll(objectList);
        System.out.println("Obj " + objects.size());
        this.setGameObjects(this.objects);
        Keyboard keyboard = new Keyboard(this);
        this.setKeyListener(keyboard);
    }


    private ArrayList<GameObject> getObjects(){
        System.out.println("called" + gamemap);

        return this.gamemap.getObjects();
    }
    public void movePlayer(int x, int y) {
        int nextX = active_player.getPosX() + x;
        int nextY = active_player.getPosY() + y;

        boolean obstacle = false;
        for (GameObject object : objects) {
            if (object.isAtPosition(nextX, nextY)) {
                obstacle = object.isObstacle();
            }
            if (obstacle == true) {
                break;
            }
        }
        active_player.rotate(x, y);
        if (obstacle == false) {
            active_player.move(x, y);
        }

        notifyView(this.mainChar);
    }

    public void action() throws InterruptedException {
        Activable aimedObject = null;
		for(GameObject object : objects){
			if(object.isAtPosition(active_player.getFrontX(),active_player.getFrontY())){
			    if(object instanceof Activable){
			        aimedObject = (Activable) object;
			    }
			}
		}
		if(aimedObject instanceof Door){
		    String switchMap = ((Door) aimedObject).mapChange(this.mapName);
		  if(switchMap != null) {
		      this.mapName = switchMap;
              this.mainChar.map = this.mapName;
              this.gamemap = whichMap(mapName);
              buildMap();
              System.out.println(this.gamemap);
              this.add((Component) gamemap, BorderLayout.NORTH);
              this.pack();
          }
        }
		if(aimedObject != null){
		    System.out.println("");
		    this.mainChar = aimedObject.activate(this.mainChar);
            notifyView(this.mainChar);
		}
        
    }
    public void close(){
        //…
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous quitter et sauvegarder ?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(option == JOptionPane.OK_OPTION){
            Gson gson = new Gson();

            //convert the Java object to json
            String jsonString = gson.toJson(mainChar);
            //Write JSON String to file
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("mainChar.json");
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
            this.dispose();
        }

        this.myTimer.cancel();
    }
    private void notifyView(Player actualPlayer) {
        this.update(actualPlayer);
    }

    public ArrayList<GameObject> getGameObjects() {
        return this.objects;
    }
    public Player getPlayer(){
        return this.mainChar;
    }
    @Override
    synchronized public void delete(Deletable ps, ArrayList<GameObject> loot) {
        objects.remove(ps);
        if (loot != null) {
            objects.addAll(loot);
        }
        notifyView(this.mainChar);
    }

    public void update(Player actualPlayer) {
        this.status.redraw(actualPlayer);
        this.gamemap.redraw();
    }
    public void playerPos() {
        System.out.println(active_player.getPosX() + ":" + active_player.getPosY());
        
    }



	public void sendPlayer(int x, int y) {
		Thread t = new Thread(new AStarThread(this, active_player, x,  y));
		t.start();
	}

    public void setKeyListener(KeyListener keyboard) {
        this.gamemap.addKeyListener(keyboard);
    }

    public void setGameObjects(ArrayList<GameObject> objects) {
        this.mainChar = this.gamemap.setObjects(objects, this.mainChar, this.gamemap);
        this.gamemap.redraw();
    }
    public void setPlayer(Player p) {
        status.setPlayer(p);
    }
}