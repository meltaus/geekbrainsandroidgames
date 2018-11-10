package ru.gorbachev.object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

    private Sprite backgroundTexture;
    private float width;
    private float height;

    public Background (Sprite backgroundTexture,
                       float width, float height) {
        this.backgroundTexture = backgroundTexture;
        this.width = width;
        this.height = height;

        initButton();
    }

    private void initButton() {
        backgroundTexture.setSize(width *2, height*2);
        backgroundTexture.setPosition(-width, -height);
    }

    public void render(SpriteBatch batch) {
        backgroundTexture.draw(batch);
    }
}
