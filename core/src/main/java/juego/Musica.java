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
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author admin
 */
public class Musica {
    private static Clip clip;
    private static boolean isMuted = false;

    public static void musicaDeFondo(String resourcePath) {
        try {
            URL soundURL = Musica.class.getResource(resourcePath);
            if (soundURL != null) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundURL);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } else {
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
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

    public static boolean mutearMusica() {
        return isMuted;
    }
}
