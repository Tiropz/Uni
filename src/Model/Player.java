package Model;

public class Player extends GameObject implements Directable {


    int direction = EAST;
    String name;
    String sex;
    String hair;
    String height;
    String map;
    double energy;
    double hunger;
    double bladder;
    int nbreFood;
    double san;

    public Player(int x, int y, String name, String sex, String hair, String height,String map, Double energy,  Double hunger, Double bladder, int nbreFood, Double san){
        super(x, y, 2);
        this.name = name;
        this.sex = sex;
        this.hair = hair;
        this.height = height;
        this.map = map;
        this.energy = energy;
        this.hunger = hunger;
        this.bladder = bladder;
        this.nbreFood = nbreFood;
        this.san = san;
    }

    public void move(int X, int Y) {
        this.posX = this.posX + X;
        this.posY = this.posY + Y;
    }

    public void rotate(int x, int y) {
        if(x == 0 && y == -1)
            direction = NORTH;
        else if(x == 0 && y == 1)
            direction = SOUTH;
        else if(x == 1 && y == 0)
            direction = EAST;
        else if(x == -1 && y == 0)
            direction = WEST;
    }

   // //////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean isObstacle() {
        return false;
    }

    @Override
    public int getDirection() {
    return direction;
    }

    public int getFrontX() {
        int delta = 0;
        if (direction % 2 == 0){
            delta += 1 - direction;
        }
        return this.posX + delta;
    }

    public int getFrontY() {
        int delta = 0;
        if (direction % 2 != 0){
            delta += direction - 2;
        }
        return this.posY + delta;
    }

    public double getEnergy() {
        return energy;
    }
    public double getHunger() {
        return hunger;
    }
    public double getBladder() {
        return bladder;
    }
}
