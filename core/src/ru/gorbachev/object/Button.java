package ru.gorbachev.object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button {

    private Sprite buttonTexture;
    private Vector2 position;
    private float width;
    private float height;
    private float resize_factor;

    public Button(Sprite buttonTexture, Vector2 position,
                  float width, float height, float resize_factor) {
        this.buttonTexture = buttonTexture;
        this.position = position;
        this.width = width;
        this.height = height;
        this.resize_factor = resize_factor;

        initButton();
    }

    private void initButton() {
        buttonTexture.setSize(width *resize_factor, height*resize_factor);
        buttonTexture.setPosition(position.x, position.y);
    }

    public void render(SpriteBatch batch) {
        buttonTexture.draw(batch);
    }

    public Sprite getButtonTexture() {
        return buttonTexture;
    }

    public boolean isMy(Vector2 touch) {
        boolean result = false;
        if (touch.x >= buttonTexture.getX() && touch.x <= (buttonTexture.getX() + buttonTexture.getWidth())) {
            if (touch.y >= buttonTexture.getY() && touch.y <= (buttonTexture.getY() + buttonTexture.getHeight())) {
                result = true;
            }
        }
        return result;
    }
}
