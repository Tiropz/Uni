package Model;

public abstract class GameObject {
    int posX;
    int posY;

    public GameObject(int X, int Y) {
        this.posX = X;
        this.posY = Y;
    }

    void move(int X, int Y) {
        this.posX = this.posX + X;
        this.posY = this.posY + Y;
    }
    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    boolean isAtPosition(int x, int y) {
        return this.posX == x && this.posY == y;
    }

    public abstract boolean isObstacle();
}
