package Model;


public class FoodCounter extends GameObject implements Activable {

    public FoodCounter(int x, int y) {      //FoodCounter constructor

        super(x, y);

    }
    @Override
    public Player activate(Player mainChar, Game game){         //Call getFoodFromCounter method
        mainChar.getFoodFromCounter(mainChar);                  //return mainChar
        return mainChar;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }



}