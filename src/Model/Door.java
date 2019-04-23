package Model;

import javax.swing.*;

public class Door extends Block implements Activable {

    public Door(int x, int y) {
        super(x, y, 2);
    }

    @Override
    public Player activate(Player mainChar) {
        System.out.println("aahzahheaheazheaheazheah");
        return mainChar;

    }
    public String mapChange(String mapNbr){
       String test = (String) JOptionPane.showInputDialog(null, "Où voulez-vous aller ?", "Destinations",
                JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Bibliothèque",
                        "Kot" }, "Joe");
       System.out.println(test);
        return  test;
}
    @Override
    public boolean isObstacle() {
        return true;
    }
}
