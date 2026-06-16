/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desuso;

import desuso.Juego;
import juego.Caramelo;
import juego.Cuerda;
import juego.Estrella;
import juego.GestorNiveles;
import juego.Jugador;
import juego.Nivel;
import juego.OmNom;
import juego.SistemaPuntaje;

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

    public CutTheRopeGame(Jugador jugadorActual, GestorNiveles gestorNiveles) {
        super("Cut The Rope");

       // this.gestorNiveles = new GestorNiveles();
        this.sistemaPuntaje = new SistemaPuntaje();
        this.gestorNiveles= gestorNiveles;
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
        //Nivel nivel = new Nivel(numeroNivel,1);
        //nivel.iniciarNivel();
        //nivelActual = nivel;
    }

    @Override
    public void actualizar()
    {
        if(juegoTerminado)
        {
            return;
        }

        if(!(nivelActual instanceof Nivel))
        {
            return;
        }

        Nivel nivel =
            (Nivel) nivelActual;

        Caramelo caramelo = nivel.getCaramelo();

        if(caramelo == null)
        {
            return;
        }

        for(Cuerda cuerda : nivel.getCuerdas())
        {
            cuerda.actualizar();
        }

        caramelo.actualizar();

        for(Estrella estrella : nivel.getEstrellas())
        {
            if(estrella.isRecolectada())
            {
                continue;
            }

            float dx =
                caramelo.getX() - estrella.getX();

            float dy =
                caramelo.getY() - estrella.getY();

            double distancia =
                Math.sqrt(dx * dx + dy * dy);

            if(distancia < 40)
            {
                estrella.recolectar();
                caramelo.recolectarEstrella();
            }
        }

        OmNom omNom = nivel.getOmNom();

        if(omNom != null)
        {
            float dx =
                caramelo.getX() - omNom.getX();

            float dy =
                caramelo.getY() - omNom.getY();

            double distancia =
                Math.sqrt(dx * dx + dy * dy);

            if(distancia < 50)
            {
                omNom.comerCaramelo(caramelo);
            }
        }

        if(nivel.verificarVictoria())
        {
            juegoTerminado = true;
        }

        if(nivel.verificarDerrota())
        {
            juegoTerminado = true;
        }
    }

    @Override
    public boolean verificarVictoria()
    {
        return false;
    }

    @Override
    public boolean verificarDerrota()
    {
        return false;
    }


}
