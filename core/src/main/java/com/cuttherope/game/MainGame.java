package com.cuttherope.game;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends Game {
    @Override
    public void create()//hola valeria
    {
        System.out.println("ENTRO A CREATE");
        setScreen(new FirstScreen(this));
    }
}
