package juego;

public class Nivel4 extends Nivel{
    public Nivel4(Jugador jugador)
    {
        super(4,4, jugador);
    }
    @Override
    protected void configurarNivel()
    {
        System.out.println("Entro al nivel 4");
    }
}
