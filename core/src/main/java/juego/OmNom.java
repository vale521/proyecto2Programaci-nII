/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public class OmNom extends Entidad {
    private boolean comiendo;
    private float posicionInicialx, posicionInicialy;

    public OmNom(float x, float y)
    {
        super(x, y, 80, 80);

        this.comiendo = false;
        this.posicionInicialx=x;
        this.posicionInicialy=y;
    }

    @Override
    public void actualizar()
    {
        //verificaria si el caramelo esta cerca y si ya colisionó y llama a comer caramelo
    }

    @Override
    public void reiniciar()
    {
        comiendo=false;
        //que x e y vuelvan a sus posiciones iniciales
        x=this.posicionInicialx;
        y=this.posicionInicialy;
    }

    public void comerCaramelo(Caramelo caramelo) {
        if(caramelo!=null)
        {
            caramelo.marcarComoComido();
            comiendo=true;
        }
    }

    public boolean estaComiendo()
    {
        return comiendo;
    }
}
