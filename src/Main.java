import Controller.Keyboard;
import Controller.Mouse;
import Model.Game;
import View.Window;

import javax.swing.*;


public class Main extends JFrame {

    public Main(){

        MenuSelection menu = new MenuSelection(null, "Menu", true);
        MenuInfo Info = menu.showInfo();
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, Info.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);

        this.setVisible(true);
    }

    public static void main(String[] args) {

        Main fen = new Main();
        Window window = new Window("Game");


        Game game = new Game(window);
        Keyboard keyboard = new Keyboard(game);
        Mouse mouse = new Mouse(game);
        window.setKeyListener(keyboard);
        window.setMouseListener(mouse);
    }
}