/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public class Cuerda extends Entidad {
    private Caramelo caramelo;
    private boolean cortada;
    private float longitud;
    private float anclajeX;
    private float anclajeY;
    private double angulo;
    private double velocidadAngular;
    private double aceleracionAngular;
    private final double GRAVEDAD=0.4;
    public Cuerda(float x, float y, float longitud, Caramelo caramelo)
    {
        super(x, y, 10, 100);
        this.anclajeY=y;
        this.anclajeX=x;
        this.longitud = longitud;
        this.caramelo = caramelo;
        this.cortada = false;
        this.angulo=Math.toRadians(30);
        this.velocidadAngular=0;
        this.aceleracionAngular=0;
    }

    @Override
    public void actualizar()
    {
        if(estaCortada()==true)
        {
            return;
        }

        aceleracionAngular =(-GRAVEDAD / longitud)* Math.sin(angulo);

        velocidadAngular += aceleracionAngular;

        velocidadAngular *= 0.995;

        angulo += velocidadAngular;

        float nuevoX =(float)(anclajeX+ longitud* Math.sin(angulo));

        float nuevoY =(float)(anclajeY-longitud* Math.cos(angulo));

        caramelo.setX(nuevoX);
        caramelo.setY(nuevoY);
    }

    @Override
    public void reiniciar()
    {
        cortada=false;
        angulo=Math.toRadians(30);
        velocidadAngular=0;
        aceleracionAngular=0;
    }

    public void cortar()
    {
        cortada = true;
        caramelo.setLibre(true);
        caramelo.setVelocidadY(-4);
    }

    public boolean estaCortada()
    {
        return cortada;
    }

    public Caramelo getCaramelo()
    {
        return caramelo;
    }

    public void setCaramelo(Caramelo caramelo)
    {
        this.caramelo = caramelo;
    }

    public boolean isCortada()
    {
        return cortada;
    }

    public void setCortada(boolean cortada)
    {
        this.cortada = cortada;
    }

    public float getLongitud()
    {
        return longitud;
    }

    public void setLongitud(float longitud)
    {
        this.longitud = longitud;
    }

    public float getAnclajeX()
    {
        return anclajeX;
    }

    public void setAnclajeX(float anclajeX)
    {
        this.anclajeX = anclajeX;
    }

    public float getAnclajeY()
    {
        return anclajeY;
    }

    public void setAnclajeY(float anclajeY)
    {
        this.anclajeY = anclajeY;
    }
}
