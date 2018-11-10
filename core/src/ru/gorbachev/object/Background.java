package ru.gorbachev.object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

    private Sprite backgroundTexture;
    private float weight;
    private float height;

    public Background (Sprite backgroundTexture,
                  float weight, float height) {
        this.backgroundTexture = backgroundTexture;
        this.weight = weight;
        this.height = height;

        initButton();
    }

    private void initButton() {
        backgroundTexture.setSize(weight*2, height*2);
        backgroundTexture.setPosition(-weight, -height);
    }

    public void render(SpriteBatch batch) {
        backgroundTexture.draw(batch);
    }
}
