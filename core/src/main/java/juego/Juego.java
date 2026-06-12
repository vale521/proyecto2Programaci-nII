/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public abstract class Juego {
    protected int numeroNivel;
    protected boolean desbloqueado;
    protected boolean completado;
    protected Jugador jugador;
    protected int dificultad;

    public Juego() {
    }

    
    public Juego(int numeroNivel, int dificultad, Jugador jugador) {
        this.numeroNivel = numeroNivel;
        this.dificultad = dificultad;

        this.desbloqueado = false;
        this.completado = false;
    }

    public abstract void iniciarNivel();

    public abstract void reiniciarNivel();

    public abstract boolean verificarVictoria();

    public abstract boolean verificarDerrota();

    public int getNumeroNivel() {
        return numeroNivel;
    }

    public void setNumeroNivel(int numeroNivel) {
        this.numeroNivel = numeroNivel;
    }

    public boolean isDesbloqueado() {
        return desbloqueado;
    }

    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

}
