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

    private int estrellasRecolectadas;

    public Caramelo(float x, float y) {
        super(x, y, 40, 40);

        this.velocidadX = 0;
        this.velocidadY = 0;
        this.fueComido = false;
        this.estrellasRecolectadas = 0;
    }

    @Override
    public void actualizar() {
        
    }

    @Override
    public void reiniciar() {
        this.fueComido = false;
        this.estrellasRecolectadas = 0;
    }

    public void mover() {

    }

    public void aplicarGravedad() {

    }

    public void recolectarEstrella() {
        estrellasRecolectadas++;
    }

    public void marcarComoComido() {
        fueComido = true;
    }
}
