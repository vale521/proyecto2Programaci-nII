package com.cuttherope.game;

import com.badlogic.gdx.Game;
import juego.Jugador;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends Game {
//
    private final Jugador jugador;
    private final int nivelSeleccionado;
//    public static Jugador jugadorPendiente =null;
//    public static int nivelPendiente=1;
    public MainGame() {
        this.jugador= null;
        this.nivelSeleccionado=1;
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
//        else if(jugadorPendiente!=null)
//        {
//            setScreen(new FirstScreen(jugadorPendiente, this, nivelPendiente));
//        }
        else
        {
            setScreen(new FirstScreen(this));
        }
    }
}
