import Controller.Keyboard;
import Model.Game;
import Model.Player;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main extends JFrame {

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
            BufferedReader br = null;
            try {
                br = new BufferedReader(
                        new FileReader("mainChar.json"));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            mainChar = gson.fromJson(br, Player.class);

        }

        Game game = new Game("Uni", mainChar);

    }
}