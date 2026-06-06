package juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class PersistenciaJugador {
    private final File carpetaUsuarios;

//HOLA camaron sin cola
    public PersistenciaJugador() {
        this.carpetaUsuarios = new File("usuarios");
        if(!carpetaUsuarios.exists()==true)
        {
            carpetaUsuarios.mkdirs();
        }
    }

    public boolean existeJugador(String username)
    {
        File carpetaJugador= new File(carpetaUsuarios, username);//crea direccion
        return carpetaJugador.exists();//ve si existe
    }

    public File crearCarpetaJugador(String username)
    {
        File carpetaJugador= new File(carpetaUsuarios, username);//crea direccion
        if(carpetaJugador.exists()==false)
        {
            carpetaJugador.mkdirs();
        }
        return carpetaJugador;
    }

    public File obtenerCarpetaJugador(String username)
    {
        File file= new File(carpetaUsuarios, username);
        return file;
    }

    public File crearArchivoJugador(String username) throws IOException
    {
        File carpeta= crearCarpetaJugador(username);
        File archivo= new File(carpeta, "jugador.dat");
        if(archivo.exists()==false)
        {
            archivo.createNewFile();
        }
        return archivo;
    }

    public File obtenerArchivoJugador(String username)
    {
        File archivo= new File(obtenerCarpetaJugador(username), "jugador.dat");
        return archivo;
    }

    public void guardarJugador(Jugador jugador)
    {
        //busca carpeta, busca archivo y guarda todos los datos del objeto de clase jugador con OutputStream
        try
        {
            File archivo = crearArchivoJugador(jugador.getUsername());
            FileOutputStream fileOutput= new FileOutputStream(archivo);
            ObjectOutputStream salida= new ObjectOutputStream(fileOutput);
            salida.writeObject(jugador);//convierte jugador en bytes y lo guarda como archivo binario
            salida.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public Jugador cargarJugador(String username)
    {
        //busca archivo y reconstuye el objeto de clase jugador con objectInputSream
        try
        {
            File archivo = crearArchivoJugador(username);
            FileInputStream fileInput= new FileInputStream(archivo);
            ObjectInputStream entrada= new ObjectInputStream(fileInput);
            Jugador jugador = (Jugador) entrada.readObject();//convierte jugador en bytes y lo guarda como archivo binario
            entrada.close();
            return jugador;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void modificarJugador(Jugador jugador)
    {
        if(jugador!=null && existeJugador(jugador.getUsername())==true)
        {
            guardarJugador(jugador);
        }
        else
        {
            System.out.println("El jugador es nulo o no existe en carpeta");
        }

    }
}
