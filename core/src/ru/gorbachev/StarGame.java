package ru.gorbachev;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	static Texture backtexture;
	static Sprite backSprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("spaceshipspr.png");
		backtexture = new Texture(Gdx.files.internal("background.png"));
		backSprite = new Sprite(backtexture);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		backSprite.setSize(1024, 1024);
		backSprite.setPosition(0,0f);
		backSprite.draw(batch);
		batch.draw(img, 150, 150);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
