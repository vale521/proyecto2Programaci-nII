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
    private ArrayList<Nivel> niveles;
//TODO: sacar configurarNivel para aqui. Envez de configurar nivel ponerle otro nombre configurarNiveldeComplejidad1
    private int nivelActual;

    public GestorNiveles(Jugador jugador) {

        niveles = new ArrayList<>();

        nivelActual = 1;

        cargarNiveles(jugador);
    }

    public void cargarNiveles(Jugador jugador)
    {
        niveles.add(new Nivel1(jugador));
        niveles.add(new Nivel2(jugador));
        niveles.add(new Nivel3(jugador));
        niveles.add(new Nivel4(jugador));
        niveles.add(new Nivel5(jugador));
    }


    public Nivel obtenerNivelActual()
    {

        return niveles.get(nivelActual - 1);
    }

    public void avanzarNivel()
    {

            nivelActual++;
    }

    public boolean ultimoNivelCompletado()
    {

        return nivelActual > niveles.size();
    }

    public ArrayList<Nivel> getNiveles() {
        return niveles;
    }

    public void setNiveles(ArrayList<Nivel> niveles) {
        this.niveles = niveles;
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }


}
