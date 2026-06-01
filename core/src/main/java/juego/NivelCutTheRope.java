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
public class NivelCutTheRope extends Nivel {
    private ArrayList<Cuerda> cuerdas;
    private ArrayList<Estrella> estrellas;

    private Caramelo caramelo;
    private OmNom omNom;
//
//    private int movimientosPermitidos;
//    private int tiempoLimite;

    public NivelCutTheRope(int numeroNivel, int dificultad) {
        super(numeroNivel, dificultad);

        cuerdas = new ArrayList<>();
        estrellas = new ArrayList<>();
    }

    @Override
    public void iniciarNivel()
    {
        completado=false;
        cuerdas.clear();
        estrellas.clear();
        caramelo =new Caramelo(500,500);
        omNom= new OmNom(500,80);

        estrellas.add(new Estrella(500, 350));
        estrellas.add(new Estrella(500,250));
        estrellas.add(new Estrella(500,150));
        cuerdas.add(new Cuerda(500,600,100,caramelo));
        //crear personaje (omnom), caramelo y configurar la dificultad falta
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
