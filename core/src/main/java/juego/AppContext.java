package juego;

public class AppContext {
    private static LanzadorJuego lanzador;
    private static com.cuttherope.game.MainGame mainGameActivo=null;
    public static void registrarLanzador(LanzadorJuego lanzadorr)
    {
        lanzador= lanzadorr;
    }
    public static LanzadorJuego getLanzador()
    {
        return lanzador;
    }

    public static void registrarMainGame(com.cuttherope.game.MainGame game)
    {
        mainGameActivo= game;
    }

    public static com.cuttherope.game.MainGame getMainGameActivo()
    {
        return mainGameActivo;
    }

    public static void limpiar()
    {
        mainGameActivo=null;
    }
}
