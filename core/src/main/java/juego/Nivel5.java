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
        caramelo =new Caramelo(430,500);
        omNom= new OmNom(640,150);//509.95718, 167.60994


        estrellas.add(new Estrella(488, 163));//488.7693, 163.15207
        estrellas.add(new Estrella(550,163)); //384.74658, 169.04115
        estrellas.add(new Estrella(670,425));//453.19598, 524.977
        cuerdas.add(new Cuerda(500,650,25,caramelo,-30));
        cuerdas.add(new Cuerda(500,350,195,caramelo, -500));
        cuerdas.add(new Cuerda(675,550,30,caramelo, 20));
        cuerdas.add(new Cuerda(675,450,40,caramelo, 100));
        cuerdas.add(new Cuerda(325,550,35,caramelo, 20));
        cuerdas.add(new Cuerda(325,450,35,caramelo, 20));
    }
}
