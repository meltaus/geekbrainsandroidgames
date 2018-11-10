package ru.gorbachev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import ru.gorbachev.base.Base2DScreen;
import ru.gorbachev.object.Background;

public class GameScreen extends Base2DScreen {

    @Override
    public void show() {
        super.show();
        background = new Background(new Sprite(backgroundAtlas.findRegion("deepspace2")),
                screenWeight, screenHeight);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }
}
