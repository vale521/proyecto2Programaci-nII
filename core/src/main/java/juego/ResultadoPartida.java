/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author valer
 */
public class ResultadoPartida {
    private LocalDateTime fecha;
    private int nivelAlcanzado;
    private int puntajeObtenido;
    private int cantidadEstrellasRecolectadas;
    private LocalDateTime fechaHoraInicioPartida;
    private LocalDateTime fechaHoraFinalPartida;
    private boolean victoria;


    public ResultadoPartida()
    {

    }

    public Duration getTiempoPartida()
    {
        //dias, horas, mins
        Duration tiempoDuracionPartida= Duration.between(fechaHoraInicioPartida, fechaHoraFinalPartida);
        return tiempoDuracionPartida;
    }
}
