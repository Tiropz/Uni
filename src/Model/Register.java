package Model;


public class Register extends Block implements Activable {

    public Register(int x, int y) {

        super(x, y, 4);

    }

    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public Player activate(Player mainChar, Game game){
        mainChar.pay(mainChar);
        return mainChar;
    }

}