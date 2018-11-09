package ru.gorbachev;

import com.badlogic.gdx.Game;

import ru.gorbachev.screen.MenuScreen;

public class Start2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
