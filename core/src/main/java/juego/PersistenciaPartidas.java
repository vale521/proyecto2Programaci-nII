package juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersistenciaPartidas {

    public File crearArchivoHistorial(File carpeta) throws IOException
    {
        File historial= new File(carpeta, "historial.dat");
        if(historial.exists()==false)
        {
            historial.createNewFile();
        }
        return historial;
    }

    public File obtenerArchivoHistorial(File carpeta) throws IOException
    {
        File historial= new File(carpeta, "historial.dat");
        return historial;
    }

    public void agregarPartida(String username, ResultadoPartida partida)
    {
        //binarios
        //busca historial.dat de usuario, lee todas las partidas existentes, agrega la nueva partida a la lista, guarda la lista completa nuevamente
        ArrayList<ResultadoPartida> historial= obtenerPartidas(username);
        historial.add(partida);
        guardarHistorial(username, historial);
    }

    public ArrayList<ResultadoPartida> obtenerPartidas(String username)
    {
        //binarios
        //busca historial.dat de usuario, lee todas las partidas existentes, devolverlas en un arraylist
        try
        {
            PersistenciaJugador persistenciaJugador= new PersistenciaJugador();
            File folder = persistenciaJugador.obtenerCarpetaJugador(username);
            File file = obtenerArchivoHistorial(folder);
            if(file.exists()==false)
            {
                return new ArrayList<>();
            }
            FileInputStream fileInput= new FileInputStream(file);
            ObjectInputStream entrada= new ObjectInputStream(fileInput);
            ArrayList<ResultadoPartida> historial= (ArrayList<ResultadoPartida>) entrada.readObject();
            entrada.close();
            return historial;
        }
        catch(Exception e)
        {
            return new ArrayList<>();
        }
    }

    public void guardarHistorial(String username, ArrayList<ResultadoPartida> historial)
    {
        //busca historial.dat de usuario, borrar contenido anterior y guardar la lista recibida
        try
        {
            PersistenciaJugador persistenciaJugador= new PersistenciaJugador();
            File folder = persistenciaJugador.obtenerCarpetaJugador(username);
            File file = obtenerArchivoHistorial(folder);
            FileOutputStream fileOutput= new FileOutputStream(file);
            ObjectOutputStream salida= new ObjectOutputStream(fileOutput);
            salida.writeObject(historial);//convierte jugador en bytes y lo guarda como archivo binario
            salida.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
