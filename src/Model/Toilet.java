package Model;


public class Toilet extends GameObject implements Activable {

    public Toilet(int x, int y) {
        super(x, y);
    }

    @Override
    public Player activate(Player mainChar, Game game) {
        mainChar.pee(10, 3, mainChar, game);        //Call pee method for 3 sec and gives -10 Bladder
        return mainChar;                                      //return mainChar
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
