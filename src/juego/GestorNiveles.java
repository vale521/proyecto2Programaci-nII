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
public class GestorNiveles {
    private ArrayList<NivelCutTheRope> niveles;

    private int nivelActual;

    public GestorNiveles() {

        niveles = new ArrayList<>();

        nivelActual = 1;

        cargarNiveles();
    }

    public void cargarNiveles() 
    {

        niveles.add(new NivelCutTheRope(1, 1));
        niveles.add(new NivelCutTheRope(2, 2));
        niveles.add(new NivelCutTheRope(3, 3));
        niveles.add(new NivelCutTheRope(4, 4));
        niveles.add(new NivelCutTheRope(5, 5));
    }

    public NivelCutTheRope obtenerNivelActual() 
    {

        return niveles.get(nivelActual - 1);
    }

    public void avanzarNivel() 
    {

        if(nivelActual < niveles.size()) 
        {
            nivelActual++;
        }
    }

    public boolean ultimoNivelCompletado() 
    {

        return nivelActual == niveles.size();
    }

    public ArrayList<NivelCutTheRope> getNiveles() {
        return niveles;
    }

    public void setNiveles(ArrayList<NivelCutTheRope> niveles) {
        this.niveles = niveles;
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }
    
    
}
