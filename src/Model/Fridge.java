package Model;


public class Fridge extends GameObject implements Activable {

    public Fridge(int x, int y) {

        super(x, y);

    }
    @Override
    public Player activate(Player mainChar, Game game){
        mainChar.fillFridge(4, mainChar);                  //Call fillFridge method for 4 sec
        return mainChar;                                        //return mainChar
    }
    @Override
    public boolean isObstacle() {
        return true;
    }



}
