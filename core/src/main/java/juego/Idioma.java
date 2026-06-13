/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class Idioma {
    private static boolean esEspanol = true; // true = Español, false = Inglés
    private static final List<Runnable> escuchadores = new ArrayList<>();

    public static void suscribir(Runnable accionActualizar) {
        escuchadores.add(accionActualizar);
    }

    public static void cambiarIdiomaGlobal() {
        esEspanol = !esEspanol;
        for (Runnable actualizar : escuchadores) {
            actualizar.run();
        }
    }

    public static boolean isEspanol() {
        return esEspanol;
    }
}