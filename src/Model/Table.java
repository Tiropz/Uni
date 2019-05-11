package Model;


public class Table extends GameObject implements Activable {

    public Table(int x, int y) {
        super(x, y);
    }

    @Override
    public Player activate(Player mainChar, Game game){
        mainChar.eat(10,10, mainChar, game);    //Call eat method for 10 sec and gives -10 Hunger
        return mainChar;                                  //return mainChar
    }
    @Override
    public boolean isObstacle() {
        return true;
    }


}
