package com.cuttherope.game;

import com.badlogic.gdx.Game;
import juego.Jugador;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends Game {
    
    private Jugador jugador;
    private int nivelSeleccionado=1;

    public MainGame() {
    }
    
    public MainGame(Jugador jugador, int nivelSeleccionado)
    {
        this.jugador= jugador;
        this.nivelSeleccionado= nivelSeleccionado;
    }
    @Override
    public void create()//hola valeria
    {
        if(jugador!=null)
        {
             setScreen(new FirstScreen(jugador, this, nivelSeleccionado));
        }
        else
        {
            setScreen(new FirstScreen(this));
        }
        
    }
}
