package ru.gorbachev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gorbachev.base.Base2DScreen;

public class GameScreen extends Base2DScreen {

    private Vector2 pos;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 buf;

    private TextureAtlas atlas;
    private TextureAtlas.AtlasRegion shipRedion;
    private TextureAtlas.AtlasRegion backgroudRegion;


    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas(Gdx.files.internal("StarGame.atlas"));
        shipRedion = atlas.findRegion("spaceshipspr");
        backgroudRegion = atlas.findRegion("background");
        pos = new Vector2(0,0);
        touch = new Vector2();
        v = new Vector2();
        buf = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touch);
        if (buf.sub(pos).len() > v.len()) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
        batch.begin();
        batch.draw(backgroudRegion, -1, -1, 2f, 2f);
        batch.draw(shipRedion, pos.x, pos.y, 0.1f, 0.1f);
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
