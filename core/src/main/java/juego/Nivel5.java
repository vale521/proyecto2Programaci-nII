package juego;

public class Nivel5 extends Nivel{
    public Nivel5(Jugador jugador)
    {
        super(5,5, jugador);
    }
    @Override
    protected void configurarNivel()
    {
        System.out.println("Entro al nivel 5");
    }
}
