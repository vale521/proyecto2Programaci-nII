/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author valer
 */
public class PerfilJugador {
    private String avatar;

    private String idioma;

    private int volumen;

    private String configuracionControles;

    public PerfilJugador() {
        this.avatar = "default.png";
        this.idioma = "Español";
        this.volumen = 50;
    }

    public void cambiarAvatar(String avatar) {
        this.avatar = avatar;
    }
}
