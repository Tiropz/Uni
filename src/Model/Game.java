package Model;

import View.*;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import com.google.gson.Gson;

public class Game extends JFrame implements DeletableObserver {
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private Player active_player = null;
    private Player mainChar;
    private StudentRoom kotMap = new StudentRoom();
    private Library libraryMap = new Library();
    private Status status = new Status(mainChar);
    public MapInterface gamemap;

    public Game(String title, Player mainChar) {
        super(title);
        buildMap(kotMap);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(0, 0, 1000, 1020);
        this.getContentPane().setBackground(Color.gray);
        this.add((Component) gamemap, BorderLayout.NORTH);
        this.add(status, BorderLayout.SOUTH);
        this.pack();
        // this.getContentPane().add(this.groupPanel, BorderLayout.CENTER);
        this.setVisible(true);
        this.mainChar = mainChar;
        objects.add(mainChar);
        players.add(mainChar);
        this.setPlayer(mainChar);
        active_player = mainChar;


    }
    private void buildMap(MapInterface newmap) {
        ArrayList<GameObject> objectList = this.getObjects(newmap);
        // Map building
        for (int i = 0; i < objectList.size(); i++) {
            objects.add(objectList.get(i));
            // use currInstance
        }
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
            // use currInstance
        }
        this.gamemap = newmap;
        this.setGameObjects(this.objects, newmap);
    }


    public ArrayList<GameObject> getObjects(MapInterface newmap){
        return newmap.getObjects();
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
        this.mainChar.hunger -= 0.1;
        this.mainChar.energy -= 0.01;
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
		if(aimedObject != null){
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

    public void setGameObjects(ArrayList<GameObject> objects, MapInterface currentMap) {
        currentMap.setObjects(objects);
        currentMap.redraw();
    }
    public void setPlayer(Player p) {
        status.setPlayer(p);
    }
}