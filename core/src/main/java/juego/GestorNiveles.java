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
    private int nivelActual;

    public GestorNiveles(Jugador jugador) {
        niveles = new ArrayList<>();
        nivelActual = 1;
        cargarNiveles(jugador);
    }

    public GestorNiveles(Jugador jugador, PartidaProgreso progreso) {

        niveles = new ArrayList<>();
        cargarNiveles(jugador);
        if(progreso!=null && progreso.isHayPartidaGuardada())
        {
            this.nivelActual=progreso.getNivelActual();
            if(this.nivelActual<1)
            {
                this.nivelActual=1;
            }
            if(this.nivelActual>niveles.size())//TODO: cambiar condicion despues esta no me gusta
            {
                this.nivelActual=niveles.size();
            }

        }
        else
        {
            this.nivelActual=1;
        }
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
