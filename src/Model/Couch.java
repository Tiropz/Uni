package Model;


public class Couch extends GameObject implements Activable {

    public Couch(int x, int y) {
        super(x, y);
    }               //Couch constructor

    @Override
    public Player activate(Player mainChar, Game game) {     //Call rest method for 10 sec and gives +10 Energy
        mainChar.rest(10,10, mainChar);             //return mainChar
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
