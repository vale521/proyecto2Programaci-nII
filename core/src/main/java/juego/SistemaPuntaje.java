/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public class SistemaPuntaje {
 private int puntajeActual;

    public SistemaPuntaje() {

        puntajeActual = 0;
    }

    public void sumarPuntos(int puntos) 
    {

        puntajeActual += puntos;
    }

    public void restarPuntos(int puntos) 
    {

        puntajeActual -= puntos;

        if(puntajeActual < 0) 
        {
            puntajeActual = 0;
        }
    }

    public int calcularBonusTiempo(int segundosRestantes) 
    {

        return segundosRestantes * 10;
    }

    public int obtenerPuntajeActual() 
    {

        return puntajeActual;
    }

    public void reiniciarPuntaje() 
    {

        puntajeActual = 0;
    }
}
