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
        float anclajeIzqX=330;
        float anclajeInqY=620;
        float anclajeDerX=460;
        float anclajeDerY=620;
        caramelo =new Caramelo(430,500);
        omNom= new OmNom(750,80);

        estrellas.add(new Estrella(155, 430));
        estrellas.add(new Estrella(155,250));
        estrellas.add(new Estrella(430,620));
        cuerdas.add(new Cuerda(280,650,240,caramelo,-20));
        cuerdas.add(new Cuerda(580,650,220,caramelo, 20));
        cuerdas.add(new Cuerda(200,350,240,caramelo, 55));
    }
}
