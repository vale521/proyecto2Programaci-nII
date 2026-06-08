package juego;

public class Nivel2 extends Nivel{
    public Nivel2(Jugador jugador)
    {
        super(2,2, jugador);
    }
    @Override
    protected void configurarNivel()
    {
        System.out.println("entro al 2");
        float anclajeIzqX=330;
        float anclajeInqY=620;
        float anclajeDerX=460;
        float anclajeDerY=620;
        caramelo =new Caramelo(390,460);
        omNom= new OmNom(460,100);

        estrellas.add(new Estrella(560, 370));
        estrellas.add(new Estrella(460,310));
        estrellas.add(new Estrella(460,230));
        cuerdas.add(new Cuerda(anclajeIzqX,anclajeInqY,150,caramelo,0));
        cuerdas.add(new Cuerda(anclajeDerX,anclajeDerY,250,caramelo, -20));
    }
}
