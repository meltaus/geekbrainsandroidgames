package ru.gorbachev;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.gorbachev.object.StarShip;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	static Texture backtexture;
	static Sprite backSprite;
	private static StarShip starShip;
	private Vector2 currentPosition;
	private Vector2 nextPosition;

	@Override
	public void create () {
		starShip = new StarShip(0, 0);
		currentPosition = starShip.getPosition();
		nextPosition = new Vector2(0,0);
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
		//Отрисовывем задник
		backSprite.setSize(1024, 1024);
		backSprite.setPosition(0,0f);
		backSprite.draw(batch);
		//Обрабатываем изменение позиции объекта
		changePosition();
		//Отрисовывем объект
		batch.draw(img, currentPosition.x, currentPosition.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}



	//Изменение позиции объекта
	private void changePosition() {
		if (currentPosition != nextPosition) {
			int tmpX = 0;
			int tmpY = 0;
			if (nextPosition.x != currentPosition.x && nextPosition.x > currentPosition.x) {
				tmpX++;
			} else if (nextPosition.x != currentPosition.x && nextPosition.x < currentPosition.x) {
				tmpX--;
			}
			if (nextPosition.y != currentPosition.y && nextPosition.y > currentPosition.y) {
				tmpY++;
			} else if (nextPosition.y != currentPosition.y && nextPosition.y < currentPosition.y) {
				tmpY--;
			}
			currentPosition.add(new Vector2(tmpX,tmpY));
		}
	}
}
