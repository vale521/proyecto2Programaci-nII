/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public abstract class Entidad {
    protected float x;
    protected float y;

    protected float ancho;
    protected float alto;

    protected boolean activa;

    public Entidad(float x, float y, float ancho, float alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.activa = true;
    }

    public abstract void actualizar();

    public abstract void reiniciar();

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getAncho()
    {
        return ancho;
    }

    public void setAncho(float ancho)
    {
        this.ancho = ancho;
    }

    public float getAlto()
    {
        return alto;
    }

    public void setAlto(float alto)
    {
        this.alto = alto;
    }

    public boolean isActiva()
    {
        return activa;
    }

    public void setActiva(boolean activa)
    {
        this.activa = activa;
    }


}
