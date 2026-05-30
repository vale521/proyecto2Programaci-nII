/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public class CutTheRopeGame extends Juego {
    private OmNom omNom; //animalito verde
    private Caramelo caramelo;
    private GestorNiveles gestorNiveles;
    private SistemaPuntaje sistemaPuntaje;
    //timer

    public CutTheRopeGame(Usuario jugadorActual) {
        super("Cut The Rope", jugadorActual);

        this.gestorNiveles = new GestorNiveles();
        this.sistemaPuntaje = new SistemaPuntaje();
    }

    @Override
    public void iniciarJuego() 
    {
        cargarNivel(1);
        sistemaPuntaje.reiniciarPuntaje();
        juegoTerminado=false;
    }

    @Override
    public void pausarJuego() 
    {
        
    }

    @Override
    public void finalizarJuego() 
    
    {

    }

    @Override
    public void cargarNivel(int numeroNivel) 
    {

    }

    @Override
    public void actualizar() {

    }

    @Override
    public boolean verificarVictoria() {
        return false;
    }

    @Override
    public boolean verificarDerrota() {
        return false;
    }
}
