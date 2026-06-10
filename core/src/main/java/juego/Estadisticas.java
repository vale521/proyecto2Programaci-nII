/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.List;

/**
 *hacer una clase que contenga datos  necesarios para calcular estadistica.
 * @author valer
 */
public class Estadisticas {
    private PersistenciaPartidas persistenciaPartidas;
    private PersistenciaJugador persistenciaJugador;

    public void Estadisticas()
    {
        this.persistenciaPartidas=new PersistenciaPartidas();
        this.persistenciaJugador= new PersistenciaJugador();

    }

    public int getTotalPartidasJugadas(String username)
    {
        return persistenciaPartidas.obtenerPartidas(username).size();
    }

    public int getNivelesCompletados(String username)
    {
        int cantNivelesCompletados =0;
        for (ResultadoPartida resultado: persistenciaPartidas.obtenerPartidas(username))
        {
            if(resultado.isVictoria()==true)
            {
                cantNivelesCompletados++;
            }
        }
        return cantNivelesCompletados;
    }

    private float getTiempoPorNivel(String username)
    {
        List<ResultadoPartida> partidas= persistenciaPartidas.obtenerPartidas(username);
        float totalTiempo=0;
        int nivelCompletados=0;
        for (ResultadoPartida resultado: partidas)
        {
            if(resultado.isVictoria()==true)
            {
                totalTiempo+= resultado.getTiempoSegundos();
                nivelCompletados++;
            }
        }
        if(nivelCompletados==0)
        {
            return 0;
        }
        else
        {
            return totalTiempo/nivelCompletados;
        }
    }
}
