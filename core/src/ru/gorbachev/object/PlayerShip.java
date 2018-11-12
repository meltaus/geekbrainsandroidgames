package ru.gorbachev.object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.gorbachev.base.StarShip;

public class PlayerShip extends StarShip {

    public PlayerShip(Sprite shipTexture, Vector2 position,
                  float width, float height, float resize_factor) {
        this.shipTexture = shipTexture;
        this.pos = position;
        this.width = width;
        this.height = height;
        this.resize_factor = resize_factor;

        if (position.y <= height) {
            initShip();
        }
    }

}
