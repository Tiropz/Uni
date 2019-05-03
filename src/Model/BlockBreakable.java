package Model;

import java.util.ArrayList;

public class BlockBreakable extends Block implements Deletable, Activable {

    private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();
    private int lifepoints = 0;
    public BlockBreakable(int X, int Y, int lifepoints) {
        super(X, Y, 1);
        this.lifepoints = lifepoints; 
    }
    
    public Player activate(Player mainChar, Game game){
        if (lifepoints == 1){
            crush();
        }
        else {
            lifepoints--;
            this.color = lifepoints + 2; // pour éviter de retourner au gris
        }
        return mainChar;
    }


    public void crush(){
        notifyDeletableObserver();
    }
    // //////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void attachDeletable(DeletableObserver po) {
        observers.add(po);
    }

    @Override
    public void notifyDeletableObserver() {
        int i = 0;
        for (DeletableObserver o : observers) {
            i++;
            o.delete(this, null);
        }
    }

    @Override
    public boolean isObstacle() {
        return true;
    }

}
