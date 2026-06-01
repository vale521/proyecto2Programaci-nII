/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public class Estrella extends Entidad {
    private boolean recolectada;
    private int puntos;

    public Estrella(float x, float y) {
        super(x, y, 30, 30);

        this.recolectada = false;
        this.puntos = 100;
    }

    @Override
    public void actualizar()
    {
        //la estrella vibra o espera ser tocada
    }

    @Override
    public void reiniciar()
    {
        recolectada=false;
        activa=true;
    }

    public void recolectar()
    {
        recolectada=true;
        activa=false;
    }

    public boolean isRecolectada()
    {
        return recolectada;
    }

    public void setRecolectada(boolean recolectada)
    {
        this.recolectada = recolectada;
    }

    public int getPuntos()
    {
        return puntos;
    }

    public void setPuntos(int puntos)
    {
        this.puntos = puntos;
    }
}
