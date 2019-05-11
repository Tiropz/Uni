package Model;

public class Desk extends GameObject implements Activable {
    private int val;
    public Desk(int x, int y, int val) {                     //Desk constructor !!!!(note : he takes val)
        super(x, y);
        this.val = val;
    }
    @Override
    public Player activate(Player mainChar, Game game){     //Call work method for 10 sec and gives +val Money
        mainChar.work(val,10, mainChar, game);          //return mainChar
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
