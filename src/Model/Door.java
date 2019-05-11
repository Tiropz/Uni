package Model;


import javax.swing.*;

public class Door extends GameObject implements Activable {
    private Object[] reachable;

    public Door(int x, int y) {     //Door constructor
        super(x, y);
    }

    @Override
    public Player activate(Player mainChar, Game game) {
                                                            //return mainChar
        return mainChar;

    }
    String mapChange(String map, Player mainChar){
        String test = null;
        if(mainChar.hasApp && mainChar.hasWork){
            switch (map){
            case "Kot":
                reachable = new Object[]{"Bibliothèque","Jefke","Supermarché","Appartement","Travail"};
                break;
            case "Bibliothèque":
                reachable = new Object[]{"Appartement","Jefke","Supermarché","Travail"};
                break;
            case "Jefke":
                reachable = new Object[]{"Appartement"};
                break;
            case "Supermarché":
                reachable = new Object[]{"Appartement","Jefke","Bibliothèque","Travail"};
                break;
            case "Appartement":
                reachable = new Object[]{"Jefke","Bibliothèque","Supermarché","Travail"};
                break;
            case "Travail":
                reachable = new Object[]{"Jefke","Bibliothèque","Supermarché","Appartement"};
                break;

            }
        }else if(mainChar.hasApp){
            switch (map){
                case "Kot":
                    reachable = new Object[]{"Bibliothèque","Jefke","Supermarché","Appartement"};
                    break;
                case "Bibliothèque":
                    reachable = new Object[]{"Appartement","Jefke","Supermarché"};
                    break;
                case "Jefke":
                    reachable = new Object[]{"Appartement"};
                    break;
                case "Supermarché":
                    reachable = new Object[]{"Appartement","Jefke","Bibliothèque"};
                    break;
                case "Appartement":
                    reachable = new Object[]{"Jefke","Bibliothèque","Supermarché"};
                    break;

            }
        }else if(mainChar.hasWork){
            switch (map){
                case "Kot":
                    reachable = new Object[]{"Bibliothèque","Jefke","Supermarché","Travail"};
                    break;
                case "Bibliothèque":
                    reachable = new Object[]{"Kot","Jefke","Supermarché","Travail"};
                    break;
                case "Jefke":
                    reachable = new Object[]{"Kot"};
                    break;
                case "Supermarché":
                    reachable = new Object[]{"Kot","Jefke","Bibliothèque","Travail"};
                    break;
                case "Travail":
                    reachable = new Object[]{"Jefke","Bibliothèque","Supermarché","Kot"};
                    break;

            }
        }else{
            switch (map){
                case "Kot":
                    reachable = new Object[]{"Bibliothèque","Jefke","Supermarché"};
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
                case "Appartement":
                    reachable = new Object[]{"Kot","Jefke","Bibliothèque","Supermarché"};
                    break;

            }
        }

        if(mainChar.getFoodBasket() == 0){
        test = (String) JOptionPane.showInputDialog(null, "Où voulez-vous aller ?", "Destinations",
                JOptionPane.QUESTION_MESSAGE, null, reachable, null);
        }else{
            JOptionPane.showMessageDialog(null, "Vous devez d'abord payer", "Attention!", JOptionPane.INFORMATION_MESSAGE);
        }

        return  test;
}
    @Override
    public boolean isObstacle() {
        return true;
    }
}
