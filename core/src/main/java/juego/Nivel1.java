package juego;

public class Nivel1 extends Nivel{
    public Nivel1(Jugador jugador)
    {
        super(1,1, jugador);
    }
    @Override
    protected void configurarNivel()
    {
        caramelo =new Caramelo(500,500);
        omNom= new OmNom(500,80);

        estrellas.add(new Estrella(500, 350));
        estrellas.add(new Estrella(500,250));
        estrellas.add(new Estrella(500,150));
        cuerdas.add(new Cuerda(500,600,100,caramelo));
    }
}
