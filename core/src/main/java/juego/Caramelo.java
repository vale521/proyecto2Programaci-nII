/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public class Caramelo extends Entidad {
    private float velocidadX;
    private float velocidadY;
    private boolean fueComido;
    private final float GRAVEDAD=0.4f;
    private int estrellasRecolectadas;
    private boolean libre;
    public Caramelo(float x, float y) {
        super(x, y, 40, 40);

        this.velocidadX = 0;
        this.velocidadY = 0;
        this.fueComido = false;
        this.estrellasRecolectadas = 0;
        this.libre=false;
    }

    @Override
    public void actualizar()
    {
        if(fueComido==true)
        {
            return;
        }
        if(libre==true)
        {
            aplicarGravedad();
            mover();
        }

    }

    @Override
    public void reiniciar()
    {
        this.fueComido = false;
        this.estrellasRecolectadas = 0;

        velocidadX=0;
        velocidadY=0;
    }

    public void mover()
    {
        x+=velocidadX;
        y+=velocidadY;
    }

    public void aplicarGravedad()
    {
        velocidadY-=GRAVEDAD;
    }

    public void recolectarEstrella()
    {
        estrellasRecolectadas++;
    }

    public void marcarComoComido()
    {
        fueComido = true;
    }

    public float getVelocidadX()
    {
        return velocidadX;
    }

    public void setVelocidadX(float velocidadX)
    {
        this.velocidadX = velocidadX;
    }

    public float getVelocidadY()
    {
        return velocidadY;
    }

    public void setVelocidadY(float velocidadY)
    {
        this.velocidadY = velocidadY;
    }

    public boolean isFueComido()
    {
        return fueComido;
    }

    public void setFueComido(boolean fueComido)
    {
        this.fueComido = fueComido;
    }

    public int getEstrellasRecolectadas()
    {
        return estrellasRecolectadas;
    }

    public void setEstrellasRecolectadas(int estrellasRecolectadas)
    {
        this.estrellasRecolectadas = estrellasRecolectadas;
    }

    public boolean isLibre()
    {
        return libre;
    }
    public void setLibre(boolean libre)
    {
        this.libre=libre;
    }
}
