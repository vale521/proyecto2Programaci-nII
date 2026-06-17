package juego;

import java.io.Serializable;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PreferenciasJuego implements Serializable {

    private Musica musica;
    public static Clip clipActual;

    public PreferenciasJuego() {
        this.musica = new Musica(true);
    }

    public Musica getMusica() {
        return musica;
    }

    public static void reproducirMusicaDeFondo(String rutaRecurso, PreferenciasJuego instancias) {
        if (clipActual != null) {
            return;
        }

        try {
            URL url = PreferenciasJuego.class.getResource(rutaRecurso);
            if (url != null) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                clipActual = AudioSystem.getClip();
                clipActual.open(ais);

                if (instancias.getMusica().isActivada()) {
                    clipActual.start();
                    clipActual.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }
        } catch (Exception e) {
        }
    }
}
