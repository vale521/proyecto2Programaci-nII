/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.ArrayList;

/**
 *
 * @author valer
 */
public class NivelCutTheRope extends Juego {
    private ArrayList<Cuerda> cuerdas;
    private ArrayList<Estrella> estrellas;

    private Caramelo caramelo;
    private OmNom omNom;
//
//    private int movimientosPermitidos;
//    private int tiempoLimite;

    public NivelCutTheRope(int numeroNivel, int dificultad, Jugador jugador) {
        super(numeroNivel, dificultad, jugador);

        cuerdas = new ArrayList<>();
        estrellas = new ArrayList<>();
    }

    @Override
    public void iniciarNivel()
    {
        completado=false;
        cuerdas.clear();
        estrellas.clear();
        if(getNumeroNivel()==1)
        {
            configurarNivel1();
        }
        //agregado para nivel 2
        else if(getNumeroNivel()==2)
        {
            configurarNivel2();
        }
        //crear personaje (omnom), caramelo y configurar la dificultad falta
    }

    private void configurarNivel1()
    {
        caramelo =new Caramelo(500,500);
        omNom= new OmNom(500,80);

        estrellas.add(new Estrella(500, 350));
        estrellas.add(new Estrella(500,250));
        estrellas.add(new Estrella(500,150));
        cuerdas.add(new Cuerda(500,600,100,caramelo));
    }
    //agregado para nivel 2
    private void configurarNivel2()
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
//        cuerdas.add(new Cuerda(540,760,620,caramelo, -55));
    }
    @Override
    public void reiniciarNivel()
    {
        caramelo.reiniciar();
        for (Cuerda cuerda : cuerdas)
        {
            cuerda.reiniciar();
        }

        for (Estrella estrella : estrellas)
        {
            estrella.reiniciar();
        }
    }

    @Override
    public boolean verificarVictoria()
    {
        if(caramelo==null)
        {
            return false;
        }

        if(caramelo.isFueComido()==true)
        {
            completado=true;
            return true;
        }

        return false;
    }

    @Override
    public boolean verificarDerrota()
    {
        return caramelo.getY()<0;
    }
    public OmNom getOmNom()
    {
        return omNom;
    }

    public Caramelo getCaramelo()
    {
        return caramelo;
    }
    public ArrayList<Cuerda> getCuerdas()
    {
        return cuerdas;
    }

    public ArrayList<Estrella> getEstrellas()
    {
        return estrellas;
    }
}
