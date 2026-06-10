package juego;

import java.io.Serializable;

public class PartidaProgreso implements Serializable {
    private int nivelActual;
    private int estrellasRecolectadas;
    private float tiempoTranscurridoSegundos;
    private boolean hayPartidaGuardada;


    public PartidaProgreso(int nivelActual, int estrellasRecolectadas, float tiempoTranscurridoSegundos)
    {
        this.nivelActual = nivelActual;
        this.estrellasRecolectadas = estrellasRecolectadas;
        this.tiempoTranscurridoSegundos = tiempoTranscurridoSegundos;
        this.hayPartidaGuardada = true;
    }

    public PartidaProgreso()
    {
        this.nivelActual = 1;
        this.estrellasRecolectadas = 0;
        this.tiempoTranscurridoSegundos = 0;
        this.hayPartidaGuardada = false;
    }

    public int getEstrellasRecolectadas()
    {
        return estrellasRecolectadas;
    }

    public void setEstrellasRecolectadas(int estrellasRecolectadas)
    {
        this.estrellasRecolectadas = estrellasRecolectadas;
    }

    public int getNivelActual()
    {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual)
    {
        this.nivelActual = nivelActual;
    }

    public float getTiempoTranscurridoSegundos()
    {
        return tiempoTranscurridoSegundos;
    }

    public void setTiempoTranscurridoSegundos(float tiempoTranscurridoSegundos)
    {
        this.tiempoTranscurridoSegundos = tiempoTranscurridoSegundos;
    }

    public boolean isHayPartidaGuardada()
    {
        return hayPartidaGuardada;
    }

    public void setHayPartidaGuardada(boolean hayPartidaGuardada)
    {
        this.hayPartidaGuardada = hayPartidaGuardada;
    }
}
