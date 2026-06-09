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

        caramelo = new Caramelo(520,420);
        omNom = new OmNom(700,120);
        estrellas.add(new Estrella(220, 430));
        estrellas.add(new Estrella(170, 250));
        estrellas.add(new Estrella(520, 120));
        cuerdas.add(new Cuerda(300, 620, 260, caramelo, -45));
        cuerdas.add(new Cuerda(560, 620, 210, caramelo, 15));
        cuerdas.add(new Cuerda(300, 300, 320, caramelo, 60));

    }
}
