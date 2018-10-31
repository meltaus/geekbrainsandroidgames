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
    private Vector2 posStart;
    private Vector2 posExit;

    private TextureAtlas atlas;
    private TextureAtlas.AtlasRegion startRegion;
    private TextureAtlas.AtlasRegion exitRegion;
    private TextureAtlas.AtlasRegion backgroudRegion;

    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas(Gdx.files.internal("StarGame.atlas"));
        startRegion = atlas.findRegion("Start");
        exitRegion = atlas.findRegion("Exit");
        backgroudRegion = atlas.findRegion("background");
        posStart = new Vector2(-0.2f, 0.1f);
        posExit = new Vector2(-0.2f, 0f);
        pos = new Vector2(0,0);
        touch = new Vector2(-1, -1);
        v = new Vector2();
        buf = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touch);
        if (posStart.x <= touch.x && posStart.y <= touch.y) {
            if (touch.x <= (posStart.x + (Math.abs(posStart.x) * 2)) && (touch.y <= (posStart.y + (Math.abs(posStart.y) * 2)))) {
                System.out.println("Start");
            }
        }
        if (posExit.x <= touch.x && posExit.y <= touch.y) {
            if (touch.x <= (posExit.x + (Math.abs(posExit.x) * 2)) && (touch.y <= (posExit.y + (Math.abs(posStart.y) * 2)))) {
                System.out.println("Exit");
            }
        }
        batch.begin();
        batch.draw(backgroudRegion, -1, -1, 2f, 2f);
        batch.draw(startRegion, posStart.x, posStart.y, 0.4f, 0.1f);
        batch.draw(exitRegion, posExit.x, posExit.y, 0.4f, 0.1f);
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
