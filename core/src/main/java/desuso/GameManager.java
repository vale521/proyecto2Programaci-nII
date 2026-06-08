/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public class GameManager {
    private Juego juegoActual;
    private Usuario usuarioActual;
    private boolean juegoActivo;
    private boolean juegoPausado;

    public GameManager() {
        this.juegoActivo=false;
        this.juegoPausado=false;
    }

    public void iniciarJuego(Juego juego)
    {
        this.juegoActual= juego;
        this.usuarioActual= juego.getJugadorActual();
        juegoActivo=true;
        juegoPausado=false;
        juegoActual.iniciarJuego();
    }

    public void actualizar()
    {
        if(juegoActivo==false)
        {
            System.out.println("No hay un juego activo.");
            return;
        }
        if (juegoPausado==true)
        {
            System.out.println("El juego está pausado.");
            return;
        }
        if(juegoActual.isJuegoTerminado()==true)
        {

            System.out.println("El juego ya terminó");
            return;
        }
        juegoActual.actualizar();
    }
    public void terminarJuego()
    {
        juegoActual.finalizarJuego();
    }

    public void cambiarNivel()
    {
    }

    public void guardarProgreso()
    {

    }

    public void cargarProgreso()
    {
        if(usuarioActual==null || juegoActual==null)
        {
            return;
        }

    }

    public Juego getJuegoActual()
    {
        return juegoActual;
    }

    public Usuario getUsuarioActual()
    {
        return usuarioActual;
    }

    public boolean isJuegoActivo()
    {
        return juegoActivo;
    }

    public boolean isJuegoPausado()
    {
        return juegoPausado;
    }


}
