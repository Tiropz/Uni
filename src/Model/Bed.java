package Model;

public class Bed extends GameObject implements Activable {

    public Bed(int x, int y) {
        super(x, y);
    }                       //Bed constructor

    @Override
    public Player activate(Player mainChar, Game game)  {          //Call rest method for 30 sec and gives +30 Energy
        mainChar.rest(30,30, mainChar);                  //return mainChar
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
