package Model;

public class Tv extends GameObject implements Activable {
    public Tv(int x, int y) {
        super(x, y);
    }

    @Override
    public Player activate(Player mainChar, Game game){
        mainChar.rest(10,10, mainChar);             //Call rest method for 10 sec and gives +10 Energy
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
