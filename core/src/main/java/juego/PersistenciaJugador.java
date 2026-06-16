package juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersistenciaJugador {
    private final File carpetaUsuarios;

//HOLA ...
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

    //TODO: cambiar nombre de carpeta a jugadores
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

    public void guardarProgreso(String username, PartidaProgreso estadoPartidaProgreso)
    {
        try
        {
            File carpeta = crearCarpetaJugador(username);
            File archivo= new File(carpeta, "progreso.dat");
            FileOutputStream archivoOutput= new FileOutputStream(archivo);
            ObjectOutputStream salida= new ObjectOutputStream(archivoOutput);
            salida.writeObject(estadoPartidaProgreso);
            salida.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public PartidaProgreso cargarProgreso(String username)
    {
        try
        {
            File archivo= new File(obtenerCarpetaJugador(username), "progreso.dat");
            if(archivo.exists()==false)
            {
                return new PartidaProgreso();
            }
            FileInputStream archivoInput= new FileInputStream(archivo);
            ObjectInputStream entrada= new ObjectInputStream(archivoInput);
            PartidaProgreso estadoPartidaProgreso= (PartidaProgreso) entrada.readObject();
            entrada.close();
            return estadoPartidaProgreso;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new PartidaProgreso();
        }
    }

    public void borrarProgreso(String username)
    {
        if(username == null || username.isEmpty())
        {
            System.out.println("No se puede borrar progreso: username nulo");
            return;
        }
        File archivo= new File(obtenerCarpetaJugador(username), "progreso.dat");
        if(archivo.exists()==true)
        {
            archivo.delete();
        }
    }

    public ArrayList<Jugador> obtenerTodosJugadores()
    {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        File[] carpetas= carpetaUsuarios.listFiles();
        if(carpetas==null)
        {
            return jugadores;
        }
        System.out.println("Carpetas encontradas: ");
        for(File carpeta: carpetas)
        {
            if(carpeta.isDirectory())
            {
                Jugador jugador= cargarJugador(carpeta.getName());
                if(jugador!=null)
                {
                    jugadores.add(jugador);
                    System.out.println("cargado -> "+jugador.getUsername());
                }
            }
        }
        return jugadores;
    }
}
