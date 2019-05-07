package Model;


public class FoodCounter extends Block implements Activable {

    public FoodCounter(int x, int y) {

        super(x, y, 4);

    }

    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public Player activate(Player mainChar, Game game){
        mainChar.getFoodFromCounter(mainChar);
        return mainChar;
    }

}