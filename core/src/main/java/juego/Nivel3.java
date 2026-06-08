package juego;

public class Nivel3 extends Nivel{
    public Nivel3(Jugador jugador)
    {
        super(3,3, jugador);
    }
    @Override
    protected void configurarNivel()
    {
        System.out.println("Entro al nivel 3");
    }
}
