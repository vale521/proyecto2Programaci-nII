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
        caramelo =new Caramelo(430,500);
        omNom= new OmNom(560,180);//509.95718, 167.60994


        estrellas.add(new Estrella(488, 163));//488.7693, 163.15207
        estrellas.add(new Estrella(359,420)); //384.74658, 169.04115
        estrellas.add(new Estrella(505,445));//453.19598, 524.977
        cuerdas.add(new Cuerda(500,650,25,caramelo,-30));
        cuerdas.add(new Cuerda(500,350,200,caramelo, 70));
        cuerdas.add(new Cuerda(675,500,30,caramelo, 20));
        cuerdas.add(new Cuerda(325,500,35,caramelo, 20));

    }
}
