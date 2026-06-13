/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author admin
 */
public class Musica {

    private static Clip clip;
    private static FloatControl controlVolumen;
    private static int nivelVolumen = 2;
    private static boolean isMuted = false;

    public static void musicaDeFondo(String resourcePath) {
        try {
            URL soundURL = Musica.class.getResource(resourcePath);
            if (soundURL != null) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundURL);
                clip = AudioSystem.getClip();
                clip.open(audioInput);

                if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    aplicarVolumenGradual();
                }

                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void bajarVolumenGradual() {
        if (controlVolumen == null) {
            return;
        }

        nivelVolumen--;
        if (nivelVolumen < 0) {
            nivelVolumen = 2;
        }
        aplicarVolumenGradual();
    }

    public static void restaurarVolumenMaximo() {
        nivelVolumen = 2;
        aplicarVolumenGradual();
    }

    private static void aplicarVolumenGradual() {
        if (controlVolumen == null) {
            return;
        }

        if (nivelVolumen == 2) {
            controlVolumen.setValue(0.0f);
        } else if (nivelVolumen == 1) {
            controlVolumen.setValue(-12.0f);
        } else if (nivelVolumen == 0) {
            controlVolumen.setValue(controlVolumen.getMinimum());
        }
    }

    public static void pararMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isMuted = true;
        }
    }

    public static void playMusica() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            isMuted = false;
        }
    }

    public static int getNivelVolumen() {
        return nivelVolumen;
    }

    public static boolean mutearMusica() {
        return isMuted;
    }
}
