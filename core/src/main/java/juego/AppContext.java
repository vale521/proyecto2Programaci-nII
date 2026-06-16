package juego;

public class AppContext {
    private static LanzadorJuego lanzador;
    public static void registrarLanzador(LanzadorJuego lanzadorr)
    {
        lanzador= lanzadorr;
    }
    public static LanzadorJuego getLanzador()
    {
        return lanzador;
    }
}
