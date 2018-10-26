package ru.gorbachev.object;

public class StarShip {
    private int startPositionX;
    private int startPositionY;

    public StarShip(int startPositionX, int startPositionY) {
        this.startPositionX = startPositionX;
        this.startPositionY = startPositionY;
    }

    public int getStartPositionX() {
        return startPositionX;
    }

    public void setStartPositionX(int startPositionX) {
        this.startPositionX = startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }

    public void setStartPositionY(int startPositionY) {
        this.startPositionY = startPositionY;
    }
}
