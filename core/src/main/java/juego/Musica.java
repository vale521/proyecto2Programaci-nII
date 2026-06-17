/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.io.Serializable;
import javax.sound.sampled.Clip;

/**
 *
 * @author admin
 */
public class Musica implements Serializable{
        private boolean activada;

        public Musica(boolean activada) {
            this.activada = activada;
        }

        public boolean isActivada() {
            return activada;
        }

        public void setActivada(boolean activada) {
            this.activada = activada;

            if (PreferenciasJuego.clipActual != null) {
                if (activada) {
                    if (!PreferenciasJuego.clipActual.isRunning()) {
                        PreferenciasJuego.clipActual.start();
                        PreferenciasJuego.clipActual.loop(Clip.LOOP_CONTINUOUSLY);
                    }
                } else {
                    if (PreferenciasJuego.clipActual.isRunning()) {
                        PreferenciasJuego.clipActual.stop();
                    }
                }
            }
        }
    }
