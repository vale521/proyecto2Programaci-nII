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
        NivelCutTheRope nivel = new NivelCutTheRope(numeroNivel,1);
        nivel.iniciarNivel();
        nivelActual = nivel;
    }

    @Override
    public void actualizar()
    {
        if(juegoTerminado)
        {
            return;
        }

        if(!(nivelActual instanceof NivelCutTheRope))
        {
            return;
        }

        NivelCutTheRope nivel =
            (NivelCutTheRope) nivelActual;

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
