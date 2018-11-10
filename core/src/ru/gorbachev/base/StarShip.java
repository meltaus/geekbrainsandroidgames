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

    protected void initShip() {
        float shipWidth = width *resize_factor;
        float shipHeight = height*resize_factor;
        position.x = position.x - shipWidth/2;
        position.y = position.y - shipHeight/2;
        if (position.x < -width) {
            float tmp = -position.x - width;
            position.x = position.x + tmp;
        }
        if (position.x > width) {
            float tmp = position.x - width;
            position.x = position.x - tmp;
        }
        if (position.y < -height) {
            float tmp = -position.y - height;
            position.y = position.y + tmp;
        }
        if (position.y > height) {
            float tmp = position.y - height;
            position.y = position.y - tmp;
        }
        shipTexture.setSize(shipWidth, shipHeight);
        shipTexture.setPosition(position.x, position.y);
    }

    public void render(SpriteBatch batch) {
        shipTexture.draw(batch);
    }
}
