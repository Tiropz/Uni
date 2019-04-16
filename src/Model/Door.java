package Model;

import View.Library;

public class Door extends Block implements Activable {
    private Library libraryMap = new Library();

    public Door(int x, int y) {
        super(x, y, 2);
    }

    @Override
    public Player activate(Player mainChar) {
        return mainChar;
    }
public Library mapChange(){

        return  libraryMap;
}
    @Override
    public boolean isObstacle() {
        return true;
    }
}
