package ru.gorbachev.object;

import com.badlogic.gdx.math.Vector2;

public class StarShip {
    private int positionX;
    private int positionY;

    public StarShip(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Vector2 getPosition() {
        return new Vector2(positionX, positionY);
    }
}
