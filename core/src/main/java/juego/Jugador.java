/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import java.time.Duration;

/**
 *Serializable: dice qu el obj puede convertirse en una secuencia de bytes y guardarse en un archivo o enviarse por una red.
 * @author valer
 */
public class Jugador implements Serializable {
    //crear clase persistencia de un jugador que le datos jugador, para saber si existe por username, modificar datos del jugador ->crear archivo tmb
    //crear clase persistencia de partidas que almacene todas las partidas, obtenga todas las partidas de un jugador, agregar nueva partida. ->crear archivo tmb
    //estado partida
    private String username;
    private String nombreCompleto;
    private String contraseña;
    private LocalDateTime fechaRegistro;
    private ImageIcon avatar;
    private int posicionRanking;//no está en constructor
    private int puntajeGeneral;
    private ArrayList<Jugador> amigos;//no está en constructor
    private LocalDateTime ultimaSesionInciada;
    private int nivelPartidaActual;
    private PuntajeNivel[] puntajes;
    private PreferenciasJuego preferenciasJuego;
    private Duration tiempoTotal;
    private ArrayList<ResultadoPartida> historial;
    private boolean activo;

    public Jugador() {
        this.puntajes=new PuntajeNivel[5];
        this.historial= new ArrayList<>();
        this.preferenciasJuego=new PreferenciasJuego();
        this.amigos= new ArrayList<>();
        this.tiempoTotal=Duration.ZERO;
        this.nivelPartidaActual=1;
    }

    public Jugador(String username, String nombreCompleto, String contraseña, ImageIcon avatar)
    {
        this.username = username;
        this.nombreCompleto = nombreCompleto;
        this.contraseña = contraseña;
        this.avatar = avatar;
        this.fechaRegistro= LocalDateTime.now();
        this.puntajeGeneral=0;
        this.nivelPartidaActual=1;
        this.puntajes=new PuntajeNivel[5];
        this.historial= new ArrayList<>();
        this.preferenciasJuego=new PreferenciasJuego();
        this.amigos= new ArrayList<>();
        this.tiempoTotal=Duration.ZERO;
        this.activo=true;
    }

    public Duration calcularTiempoInactividad()
    {
        //dias, horas, mins
        Duration duracionEntreSesiones= Duration.between(ultimaSesionInciada, LocalDateTime.now());
        return duracionEntreSesiones;
    }


    public void sumarTiempoJugado(LocalDateTime inició)
    {
        //dias, horas, mins
        Duration tiempoJugado= Duration.between(inició, LocalDateTime.now()/*el tiempo actual de la llamada*/);
        tiempoTotal=tiempoTotal.plus(tiempoJugado);
    }

    public String getTiempoTotalJugado()
    {
        return String.format("%d días, %d horas, %d minutos", tiempoTotal.toDaysPart(), tiempoTotal.toHoursPart(), tiempoTotal.toMinutesPart());
    }

    public String getTiempoTiempoInactividad()
    {
        Duration inactividad= calcularTiempoInactividad();
        return String.format("%d días, %d horas, %d minutos", inactividad.toDaysPart(), inactividad.toHoursPart(), inactividad.toMinutesPart());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public int getPosicionRanking() {
        return posicionRanking;
    }

    public void setPosicionRanking(int posicionRanking) {
        this.posicionRanking = posicionRanking;
    }

    public int getPuntajeGeneral() {
        return puntajeGeneral;
    }

    public void setPuntajeGeneral(int puntajeGeneral) {
        this.puntajeGeneral = puntajeGeneral;
    }

    public List<Jugador> getAmigos()
    {
        return amigos;
    }

    public void setAmigos(ArrayList<Jugador> amigos)
    {
        this.amigos = amigos;
    }

    public LocalDateTime getUltimaSesionInciada()
    {
        return ultimaSesionInciada;
    }

    public void setUltimaSesionInciada(LocalDateTime ultimaSesionInciada)
    {
        this.ultimaSesionInciada = ultimaSesionInciada;
    }

    public int getNivelPartidaActual()
    {
        return nivelPartidaActual;
    }

    public void setNivelPartidaActual(int nivelPartidaActual)
    {
        this.nivelPartidaActual = nivelPartidaActual;
    }

    public boolean isActivo()
    {
        return activo;
    }

    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }

    public LocalDateTime getFechaRegistro()
    {
        return fechaRegistro;
    }

    public void setPuntajes(int nivel, PuntajeNivel puntajeNivel)
    {
        if(puntajeNivel!=null)
        {
            puntajes[nivel-1]= puntajeNivel;
        }

    }

    public int getPuntajeNivel(int nivel)
    {
        if (puntajes[nivel - 1]==null)
        {
            return 0;
        }
        return puntajes[nivel-1].getPuntaje();
    }

    public PuntajeNivel[] getPuntajeNiveles()
    {
        return puntajes;
    }
    public void agregarResultado(ResultadoPartida resultado)
    {
        historial.add(resultado);
    }

    public List<ResultadoPartida> getHistorialPartidas()
    {
        return historial;
    }

    public void setPreferenciasJuego(PreferenciasJuego preferenciasJuego)
    {
        this.preferenciasJuego= preferenciasJuego;
    }
}
