/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author valer
 */
public class ResultadoPartida implements Serializable {
    private LocalDateTime fecha;
    private int nivelAlcanzado;
    private int puntajeObtenido;
    private int cantidadEstrellasRecolectadas;
    private LocalDateTime fechaHoraInicioPartida;
    private LocalDateTime fechaHoraFinalPartida;
    private boolean victoria;
    private float tiempoSegundos;
    private int vidasRestantes;
    private int fallos;
    public ResultadoPartida()
    {
        this.fecha= LocalDateTime.now();

    }

    public Duration getTiempoPartida()
    {
        //dias, horas, mins
        Duration tiempoDuracionPartida= Duration.between(fechaHoraInicioPartida, fechaHoraFinalPartida);
        return tiempoDuracionPartida;
    }

    public int calcularPuntaje()
    {
        int base = cantidadEstrellasRecolectadas*1000;
        int bonusTiempo= (int) Math.max(0,500-tiempoSegundos*5);
        if(victoria==true)
        {
            return base+bonusTiempo;
        }
        return 0;
    }
    public float getTiempoSegundos() {
        return tiempoSegundos;
    }

    public void setTiempoSegundos(float tiempoSegundos) {
        this.tiempoSegundos = tiempoSegundos;
        this.puntajeObtenido= calcularPuntaje();
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getNivelAlcanzado() {
        return nivelAlcanzado;
    }

    public void setNivelAlcanzado(int nivelAlcanzado) {
        this.nivelAlcanzado = nivelAlcanzado;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public int getCantidadEstrellasRecolectadas() {
        return cantidadEstrellasRecolectadas;
    }

    public void setCantidadEstrellasRecolectadas(int cantidadEstrellasRecolectadas) {
        this.cantidadEstrellasRecolectadas = cantidadEstrellasRecolectadas;
        this.puntajeObtenido=calcularPuntaje();
    }

    public LocalDateTime getFechaHoraInicioPartida() {
        return fechaHoraInicioPartida;
    }

    public void setFechaHoraInicioPartida(LocalDateTime fechaHoraInicioPartida) {
        this.fechaHoraInicioPartida = fechaHoraInicioPartida;
    }

    public LocalDateTime getFechaHoraFinalPartida() {
        return fechaHoraFinalPartida;
    }

    public void setFechaHoraFinalPartida(LocalDateTime fechaHoraFinalPartida) {
        this.fechaHoraFinalPartida = fechaHoraFinalPartida;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }

    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public void setVidasRestantes(int vidasRestantes) {
        this.vidasRestantes = vidasRestantes;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }
}
