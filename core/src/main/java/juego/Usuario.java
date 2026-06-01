/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author valer
 */
public class Usuario {
    private String username;
    private String password;

    private String nombreCompleto;

    private LocalDate fechaRegistro;
    private LocalDateTime ultimaSesion;

    private PerfilJugador perfil;
    private Estadisticas estadisticas;

    private ArrayList<ResultadoPartida> historial;

    private int rankingGlobal;

    public Usuario(String username,
                   String password,
                   String nombreCompleto) {

        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;

        this.fechaRegistro = LocalDate.now();

        this.historial = new ArrayList<>();

        this.perfil = new PerfilJugador();
        this.estadisticas = new Estadisticas();
    }

    public void iniciarSesion() {

    }

    public void cerrarSesion() {

    }

    public void actualizarEstadisticas() {

    }

    public void agregarPartida(ResultadoPartida partida) {
        historial.add(partida);
    }
}
