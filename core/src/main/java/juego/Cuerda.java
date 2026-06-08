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
    private float anclajeX; //es el punto fijo de donde se sostiene el caramelo osea el eje/origen
    private float anclajeY;
    private double angulo;//para controlar que tnta inclinacion tendrá la cuerda y cambia posicion caramelo
    private double velocidadAngular;//cuentos angulos cambia por actualizacion
    private double aceleracionAngular;//cambia la velocidad
    private final double GRAVEDAD=0.4;
    
    public Cuerda(float x, float y, float longitud, Caramelo caramelo)
    {
        super(x, y, 10, 100);
        this.anclajeY=y;
        this.anclajeX=x;
        this.longitud = longitud;
        this.caramelo = caramelo;
        this.cortada = false;
        this.angulo=Math.toRadians(30);//era30
        this.velocidadAngular=0;
        this.aceleracionAngular=0;
    }
//agregado para resolver nivel 2
    public Cuerda(float x, float y, float longitud, Caramelo caramelo, double anguloInicial)
    {
        super(x, y, 10, 100);
        this.anclajeY=y;
        this.anclajeX=x;
        this.longitud = longitud;
        this.caramelo = caramelo;
        this.cortada = false;
        this.angulo=Math.toRadians(anguloInicial);//pasa angulo a radianes
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

        aceleracionAngular =(-GRAVEDAD / longitud)* Math.sin(angulo)/*cuanto jala la gravedad*/;
        velocidadAngular += aceleracionAngular;
        velocidadAngular *= 0.995;/*amortiguamiento*/
        angulo += velocidadAngular;//angulo cambia para que la cuerda oscile

        float nuevoX =(float)(anclajeX+ longitud* Math.sin(angulo));
        float nuevoY =(float)(anclajeY-longitud* Math.cos(angulo));
//          modficado para el nivel 2
//        caramelo.setX(nuevoX);
//        caramelo.setY(nuevoY);
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
        caramelo.setVelocidadY(-1);
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
    //modficado para el nivel 2
    public float getPosicionCarameloX()
    {
        return (float)(anclajeX+longitud*Math.sin(angulo));
    }
    
    public float getPosicionCarameloY()
    {
        return (float)(anclajeY-longitud*Math.cos(angulo));
    }
}
