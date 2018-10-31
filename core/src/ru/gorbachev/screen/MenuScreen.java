package ru.gorbachev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import ru.gorbachev.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    private static float BUTTON_WIDTH = 400f;
    private static float BUTTON_HEIGHT = 100f;

    private TextureAtlas atlas;
    private Sprite backgroudRegion;

    private Sprite startButtonSprite;
    private Sprite exitButtonSprite;

    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas(Gdx.files.internal("StarGame.atlas"));
        backgroudRegion = new Sprite(atlas.findRegion("background"));
        startButtonSprite = new Sprite(atlas.findRegion("Start"));
        exitButtonSprite = new Sprite(atlas.findRegion("Exit"));

        backgroudRegion.setSize(2000, 2000);
        startButtonSprite.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        exitButtonSprite.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        backgroudRegion.setPosition(-1000, -1000);
        startButtonSprite.setPosition(-BUTTON_WIDTH/2,0);
        exitButtonSprite.setPosition(-BUTTON_WIDTH/2,-BUTTON_HEIGHT);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        backgroudRegion.draw(batch);
        startButtonSprite.draw(batch);
        exitButtonSprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if(Gdx.input.justTouched()) {
            // обработка касания по кнопке Stare
            if((touch.x>=startButtonSprite.getX()) && touch.x<= (startButtonSprite.getX()+startButtonSprite.getWidth()) && (touch.y>=startButtonSprite.getY()) && touch.y<=(startButtonSprite.getY()+startButtonSprite.getHeight()) ){
                System.out.println("Start");
            }
            // обработка касания по кнопке Exit
            else if((touch.x>=exitButtonSprite.getX()) && touch.x<= (exitButtonSprite.getX()+exitButtonSprite.getWidth()) && (touch.y>=exitButtonSprite.getY()) && touch.y<=(exitButtonSprite.getY()+exitButtonSprite.getHeight()) ){
                Gdx.app.exit(); // выход из приложения
            }
        }
        return false;
    }

    private void showMenu() {

    }
}
