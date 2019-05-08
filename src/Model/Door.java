package Model;

import javax.swing.*;

public class Door extends Block implements Activable {
    Object[] reachable;

    public Door(int x, int y) {
        super(x, y, 2);
    }

    @Override
    public Player activate(Player mainChar, Game game) {
        System.out.println("aahzahheaheazheaheazheah");
        return mainChar;

    }
    public String mapChange(String map, Player mainChar){
        String test = null;
        switch (map){
            case "Kot":
                reachable = new Object[]{"Bibliothèque","Jefke","Supermarché","Appartement"};
                break;
            case "Bibliothèque":
                reachable = new Object[]{"Kot","Jefke","Supermarché"};
                break;
            case "Jefke":
                reachable = new Object[]{"Kot"};
                break;
            case "Supermarché":
                reachable = new Object[]{"Kot","Jefke","Bibliothèque"};
                break;


        }
        if(mainChar.getFoodBasket() == 0){
        test = (String) JOptionPane.showInputDialog(null, "Où voulez-vous aller ?", "Destinations",
                JOptionPane.QUESTION_MESSAGE, null, reachable, null);
        }else{
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Vous devez d'abord payer", "Attention!", JOptionPane.INFORMATION_MESSAGE);
        }

        return  test;
}
    @Override
    public boolean isObstacle() {
        return true;
    }
}
