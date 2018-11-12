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

    private Vector2 pos;
    private Vector2 v;
    private Vector2 buf;

    private float shipWidth;
    private float shipHeight;

    protected void initShip() {
        shipWidth = width *resize_factor;
        shipHeight = height*resize_factor;
        buf = new Vector2();
        newPosition = new Vector2();
        v = new Vector2();
        pos = new Vector2(position.x, position.y);
    }

    public void render(SpriteBatch batch) {
        buf.set(newPosition);
        if (buf.sub(pos).len() > v.len()) {
            pos.add(v);
        } else {
            pos.set(newPosition);
        }
        batch.draw(shipTexture, pos.x - (shipWidth/2), pos.y - (shipHeight/2), shipWidth, shipHeight);
    }

    public void moveShip(Vector2 newPosition, float deltaV) {
        this.newPosition = newPosition;
        this.deltaV = deltaV;
        v.set(newPosition.cpy().sub(pos).scl(0.01f));
    }
}
