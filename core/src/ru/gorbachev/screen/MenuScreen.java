package ru.gorbachev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gorbachev.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private Vector2 pos;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 buf;

    private TextureAtlas atlas;
    private TextureAtlas.AtlasRegion startRegion;
    private TextureAtlas.AtlasRegion exitRegion;



    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas(Gdx.files.internal("StarGame.atlas"));
        startRegion = atlas.findRegion("Start");
        exitRegion = atlas.findRegion("Exit");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(startRegion, -0.2f, 0.1f, 0.4f, 0.1f);
        batch.draw(exitRegion, -0.2f, 0, 0.4f, 0.1f);
        batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        this.touch = touch;
        v.set(touch.cpy().sub(pos).scl(0.01f));
        return false;
    }
}
