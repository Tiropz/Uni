package Model;


public class Register extends GameObject implements Activable {

    public Register(int x, int y) {

        super(x, y);

    }
    @Override
    public Player activate(Player mainChar, Game game){
        mainChar.pay(mainChar);                                     //Call pay method
        return mainChar;                                            //return mainChar
    }
    @Override
    public boolean isObstacle() {
        return true;
    }



}