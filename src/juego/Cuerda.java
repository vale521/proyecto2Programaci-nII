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

    public Cuerda(float x, float y, float longitud, Caramelo caramelo) {
        super(x, y, 10, 100);

        this.longitud = longitud;
        this.caramelo = caramelo;
        this.cortada = false;
    }

    @Override
    public void actualizar() 
    {
        if(estaCortada()==true)
        {
            return;
        }
        
        if(caramelo!=null)
        {
            //está conectado, impide que caiga libremente
        }
    }

    @Override
    public void reiniciar() 
    {
        cortada=false;
    }

    public void cortar() {
        cortada = true;
    }

    public boolean estaCortada() {
        return cortada;
    }
}
