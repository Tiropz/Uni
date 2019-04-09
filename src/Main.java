import Controller.Keyboard;
import Controller.Mouse;
import Model.Game;
import Model.Player;
import View.Window;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main extends JFrame {

    public Main(){



        this.setVisible(true);
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        Player mainChar = null;
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("mainChar.json"));
            mainChar = gson.fromJson(br, Player.class);
        } catch (FileNotFoundException e) {
            MenuSelection menu = new MenuSelection(null, "Menu", true);
            MenuInfo Info = menu.showInfo();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, Info.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
            mainChar = new Player(3, 4);
        }

        Window window = new Window("Uni");


        Game game = new Game(window, mainChar);
        Keyboard keyboard = new Keyboard(game);
        Mouse mouse = new Mouse(game);
        window.setKeyListener(keyboard);
        window.setMouseListener(mouse);
    }
}