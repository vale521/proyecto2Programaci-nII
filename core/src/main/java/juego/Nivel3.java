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
        omNom= new OmNom(560,180);//509.95718, 167.60994


        estrellas.add(new Estrella(488, 163));//488.7693, 163.15207
        estrellas.add(new Estrella(384,169)); //384.74658, 169.04115
        estrellas.add(new Estrella(395,510));//453.19598, 524.977
        cuerdas.add(new Cuerda(450,650,60,caramelo,-30));
        cuerdas.add(new Cuerda(625,650,25,caramelo, 20));
        cuerdas.add(new Cuerda(450,400,240,caramelo, 70));

    }
}
