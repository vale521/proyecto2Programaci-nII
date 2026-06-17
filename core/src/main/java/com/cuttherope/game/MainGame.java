package com.cuttherope.game;

import com.badlogic.gdx.Game;
import juego.AppContext;
import juego.Jugador;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends Game {
//
    private Jugador jugador;
    private int nivelSeleccionado;
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
        AppContext.registrarMainGame(this);
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

    public void cambiarNivel(Jugador jugador, int numeroNivel)
    {
        this.jugador= jugador;
        this.nivelSeleccionado= numeroNivel;
        setScreen(new FirstScreen(jugador, this, numeroNivel));

    }
    @Override
    public void dispose()
    {
        AppContext.limpiar();
        super.dispose();
    }
}
