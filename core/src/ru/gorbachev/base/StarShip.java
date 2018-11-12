package ru.gorbachev.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarShip {
    protected Sprite shipTexture;
    protected float width;
    protected float height;
    protected float resize_factor;

    protected Vector2 pos;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 buf;

    private float shipWidth;
    private float shipHeight;

    private boolean stat;

    protected void initShip() {
        shipWidth = width *resize_factor;
        shipHeight = height*resize_factor;
        touch = new Vector2(pos);
        v = new Vector2();
        buf = new Vector2();
        stat = false;
    }

    public void render(SpriteBatch batch) {
        if (stat) {
            if (checkShipInScreen()) {
                buf.set(touch);
                if (buf.sub(pos).len() > v.len()) {
                    pos.add(v);
                } else {
                    pos.set(touch);
                }
            }
        }
        batch.draw(shipTexture, pos.x - (shipWidth/2), pos.y - (shipHeight/2), shipWidth, shipHeight);
    }

    public void moveShip(Vector2 newPosition, float deltaV, boolean stat) {
        this.touch = new Vector2(newPosition);
        v.set(touch.cpy().sub(pos).scl(deltaV*0.01f));
        this.stat = stat;
    }
    public void stopShip(boolean stat) {
        this.stat = stat;
    }

    private boolean checkShipInScreen() {
        boolean result = true;
        if (pos.x == -Gdx.graphics.getWidth() || pos.x + shipTexture.getWidth() == Gdx.graphics.getWidth()) {
            result = false;
        }
        if (pos.y == -Gdx.graphics.getHeight() || pos.y + shipTexture.getHeight() == Gdx.graphics.getHeight()) {
            result = false;
        }
        return result;
    }
}
