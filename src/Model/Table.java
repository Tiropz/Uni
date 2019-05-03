package Model;

import static java.lang.Thread.sleep;

public class Table extends Block implements Activable {

    int nbreFoodIn;
    public Table(int x, int y) {

        super(x, y, 4);

    }

    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public Player activate(Player mainChar, Game game){

        mainChar.eat(10,10, mainChar, game);
        return mainChar;
    }

}
