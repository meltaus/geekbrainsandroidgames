package ru.gorbachev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gorbachev.base.Base2DScreen;
import ru.gorbachev.object.Background;
import ru.gorbachev.object.PlayerShip;

public class GameScreen extends Base2DScreen {

    private PlayerShip playerShip;
    private static TextureAtlas shipAtlas;

    @Override
    public void show() {
        super.show();

        shipAtlas = new TextureAtlas(Gdx.files.internal("ship.atlas"));
        playerShip = new PlayerShip(new Sprite(shipAtlas.findRegion("shipblue1")),
                new Vector2(0, -screenWidth/2 + 50), screenWidth, screenHeight, 0.09f);

        background = new Background(new Sprite(backgroundAtlas.findRegion("deepspace2")),
                screenWidth, screenHeight);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        playerShip.render(batch);
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
