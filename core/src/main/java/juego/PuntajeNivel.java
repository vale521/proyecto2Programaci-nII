package juego;

import java.io.Serializable;

public class PuntajeNivel implements Serializable{
    int nivel;
    int puntaje;

    public PuntajeNivel(int puntaje, int nivel) {
        this.puntaje = puntaje;
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
