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

    private int movimientosPermitidos;
    private int tiempoLimite;

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
    public boolean verificarVictoria() {
        return false;
    }

    @Override
    public boolean verificarDerrota() {
        return false;
    }
}
