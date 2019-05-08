package Model;


public class Fridge extends Block implements Activable {

    public Fridge(int x, int y) {

        super(x, y, 4);

    }

    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public Player activate(Player mainChar, Game game){
        mainChar.fillFridge(4, mainChar);
        return mainChar;
    }

}
