package ru.gorbachev.base;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarShip {
    protected Sprite shipTexture;
    protected Vector2 position;
    protected float width;
    protected float height;
    protected float resize_factor;
    private Vector2 newPosition;
    private float deltaV;

    protected void initShip() {
        float shipWidth = width *resize_factor;
        float shipHeight = height*resize_factor;
        position.x = position.x - shipWidth/2;
        position.y = position.y - shipHeight/2;
        if (position.x <= -width) {
            float tmp = -position.x - width;
            position.x = position.x + tmp;
        }
        if (position.x >= width) {
            float tmp = position.x - width;
            position.x = position.x - tmp;
        }
        if ((position.y - shipHeight/2) <= -height) {
            float tmp = -position.y - height;
            position.y = position.y + tmp;
        }
        if (position.y + shipHeight/2 >= height) {
            float tmp = position.y - height;
            position.y = position.y - tmp;
        }
        shipTexture.setSize(shipWidth, shipHeight);
        shipTexture.setPosition(position.x, position.y);
        newPosition = position;
    }

    public void render(SpriteBatch batch) {
        shipTexture.draw(batch);
    }

    private void setSubPosition() {
        float x = 0,y = 0;
        if (position.x < newPosition.x) {
            x = 5 * deltaV;
        }
        if (position.x > newPosition.x) {
            x = -5 * deltaV;
        }
        if (position.y < newPosition.y) {
            y = 5 * deltaV;
        }
        if (position.y > newPosition.y) {
            y = -5 * deltaV;
        }
        Vector2 tmp = position;
        tmp.sub(x,y);
    }

    public void moveShip(Vector2 newPosition, float deltaV) {
        this.newPosition = newPosition;
        this.deltaV = deltaV;
    }
}
