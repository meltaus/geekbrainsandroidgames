package ru.gorbachev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gorbachev.Start2DGame;
import ru.gorbachev.base.Base2DScreen;
import ru.gorbachev.object.Background;
import ru.gorbachev.object.Button;

public class MenuScreen extends Base2DScreen {

    private Start2DGame start2DGame;

    private Button startButton;
    private Button exitButton;
    private TextureAtlas buttonAtlas;

    public MenuScreen (Start2DGame start2DGame) {
        this.start2DGame = start2DGame;
    }

    @Override
    public void show() {
        super.show();
        background = new Background(new Sprite(backgroundAtlas.findRegion("deepspace1")),
                screenWeight, screenHeight);

        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttonYelow.atlas"));
        startButton = new Button(new Sprite(buttonAtlas.findRegion("StartButton")),
                new Vector2(-150,0) ,screenWeight*4, screenHeight, 0.09f);
        exitButton = new Button(new Sprite(buttonAtlas.findRegion("ExitButton")),
                new Vector2(-150, 1.5f * (startButton.getButtonTexture().getY() - startButton.getButtonTexture().getHeight())),
                screenWeight*4, screenHeight, 0.09f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        startButton.render(batch);
        exitButton.render(batch);
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

    private void showMenu() {

    }
}
