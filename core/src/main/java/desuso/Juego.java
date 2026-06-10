/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desuso;

import juego.Usuario;

/**
 *
 * @author valer
 */
public abstract class Juego {
    protected String nombreJuego;
    protected Usuario jugadorActual;
    protected juego.Juego nivelActual;
    protected boolean juegoTerminado;
    protected int puntajeTotal;

    public Juego(String nombreJuego, Usuario jugadorActual)
    {
        this.nombreJuego = nombreJuego;
        this.jugadorActual = jugadorActual;
        this.puntajeTotal = 0;
        this.juegoTerminado = false;
    }

    public abstract void iniciarJuego();

    public abstract void pausarJuego();

    public abstract void finalizarJuego();

    public abstract void cargarNivel(int numeroNivel);

    public abstract void actualizar();

    public abstract boolean verificarVictoria();

    public abstract boolean verificarDerrota();

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public Usuario getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Usuario jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public juego.Juego getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(juego.Juego nivelActual) {
        this.nivelActual = nivelActual;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        this.juegoTerminado = juegoTerminado;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }


}
