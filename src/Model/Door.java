package Model;

import javax.swing.*;

public class Door extends Block implements Activable {
    Object[] reachable;

    public Door(int x, int y) {
        super(x, y, 2);
    }

    @Override
    public Player activate(Player mainChar) {
        System.out.println("aahzahheaheazheaheazheah");
        return mainChar;

    }
    public String mapChange(String map){
        switch (map){
            case "Kot":
                reachable = new Object[]{"Bibliothèque"};
                break;
            case "Bibliothèque":
                reachable = new Object[]{"Kot"};
        }
       String test = (String) JOptionPane.showInputDialog(null, "Où voulez-vous aller ?", "Destinations",
                JOptionPane.QUESTION_MESSAGE, null, reachable, null);
       System.out.println(test);
        return  test;
}
    @Override
    public boolean isObstacle() {
        return true;
    }
}
