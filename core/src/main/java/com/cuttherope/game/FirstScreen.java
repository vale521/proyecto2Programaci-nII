package com.cuttherope.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import juego.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    private MainGame game;
    private ShapeRenderer shape;
    private SpriteBatch batch;
    private BitmapFont font;

    private Texture texturaOmNom;
    private Texture texturaCaramelo;
    private Texture texturaEstrella;
    private Texture texturaOrigenCuerda;
    private Texture texturaOmNomDulce;
    private Texture texturaEstrellaGanada;
    private Texture texturaEstrellaNoGanada;
    private Texture texturaBtnPausar;
    private Texture texturaBtnReiniciar;
    private Texture texturaFondo;
    private Texture texturabtnMenu;

    private float xBtnPausar=900;
    private float yBtnPausar=720;
    private float xBtnReiniciar=840;
    private float yBtnReiniciar=720;
    private float anchoBtn=50;
    private float altoBtn=50;
    private float xBtnMenu=40;
    private float yBtnMenu=720;

    private boolean pausado=false;
    private Jugador jugador;
    private GestorNiveles gestorNiveles;
    private PersistenciaJugador persistenciaJugador;
    private Nivel nivel;
    private int estrellasRecolectada;

    //caida libre caramelo
    private float velcidadCaidaX=0f;
    private float velocidadCaidaY=0f;
    private static final float GRAVEDAD_LIBRE=-18f;

    private boolean nivelCompletado=false;
    private float tiempoVictoria=0;
    private float tiempoNivel=0;

    private float mouseAnteriorX=-1;
    private float mouseAnteriorY=-1;
    private LocalDateTime fechaInicioPartida;
    private LocalDateTime fechaFinalPartida;
    private boolean cerrandoJuego=false;

    private static final Object LOCK_PROGRESO= new Object();
    //private int cantFallos=0;
    public FirstScreen(MainGame game) {
        this.game = game;
//        this.shape = new ShapeRenderer();
//
//        this.jugador= new Jugador();
//        this.persistenciaJugador= new PersistenciaJugador();
//        String username= jugador.getUsername();
//        PartidaProgreso progreso;
//        if(username!=null && username.isEmpty()==false)
//        {
//            progreso= persistenciaJugador.cargarProgreso(jugador.getUsername());
//        }
//        else
//        {
//            progreso= new PartidaProgreso();
//        }
//        this.gestorNiveles= new GestorNiveles(this.jugador);
//        this.nivel= gestorNiveles.obtenerNivelActual();
//        nivel.iniciarNivel();
//        fechaInicioPartida=LocalDateTime.now();
//        if(progreso.isHayPartidaGuardada())
//        {
//            tiempoNivel= progreso.getTiempoTranscurridoSegundos();
//            nivel.getCaramelo().setEstrellasRecolectadas(progreso.getEstrellasRecolectadas());
//            int estrellasRestaurar= progreso.getEstrellasRecolectadas();
//            int restauradas=0;
//            for (Estrella estrella: nivel.getEstrellas())
//            {
//                if(restauradas<estrellasRestaurar)
//                {
//                    estrella.recolectar();
//                    restauradas++;
//                }
//            }
//        }
//
//        batch= new SpriteBatch();
//        font= new BitmapFont();
//
//        texturaOmNom= new Texture("omNomNormal.png");
//        texturaCaramelo= new Texture("caramelo.png");
//        texturaEstrella= new Texture("estrella.png");
//        texturaOrigenCuerda= new Texture("origenCuerda.png");
//        texturaOmNomDulce= new Texture("omNomDulce.png");
//        texturaEstrellaGanada= new Texture("estrellaGanada2.png");
//        texturaEstrellaNoGanada= new Texture("estrellaNoGanada2.png");
//        texturaBtnPausar= new Texture("btnPausar2.png");
//        texturaBtnReiniciar= new Texture("btnReiniciar2.png");
//        texturabtnMenu= new Texture("btnMenu2.png");
//        texturaFondo= new Texture("fondoNiveles.png");
        inicializarComponentesComunes();
    }

    public FirstScreen(Jugador jugador, MainGame game) {
        this.game = game;
//        this.shape = new ShapeRenderer();
//
//        this.jugador= jugador;
//        this.persistenciaJugador= new PersistenciaJugador();
//        String username= jugador.getUsername();
//        PartidaProgreso progreso;
//        if(username!=null && username.isEmpty()==false)
//        {
//            progreso= persistenciaJugador.cargarProgreso(jugador.getUsername());
//        }
//        else
//        {
//            progreso= new PartidaProgreso();
//        }
//        this.gestorNiveles= new GestorNiveles(this.jugador);
//        this.nivel= gestorNiveles.obtenerNivelActual();
//        nivel.iniciarNivel();
//        fechaInicioPartida=LocalDateTime.now();
//        if(progreso.isHayPartidaGuardada())
//        {
//            tiempoNivel= progreso.getTiempoTranscurridoSegundos();
//            nivel.getCaramelo().setEstrellasRecolectadas(progreso.getEstrellasRecolectadas());
//            int estrellasRestaurar= progreso.getEstrellasRecolectadas();
//            int restauradas=0;
//            for (Estrella estrella: nivel.getEstrellas())
//            {
//                if(restauradas<estrellasRestaurar)
//                {
//                    estrella.recolectar();
//                    restauradas++;
//                }
//            }
//        }
//
//        batch= new SpriteBatch();
//        font= new BitmapFont();
//
//        texturaOmNom= new Texture("omNomNormal.png");
//        texturaCaramelo= new Texture("caramelo.png");
//        texturaEstrella= new Texture("estrella.png");
//        texturaOrigenCuerda= new Texture("origenCuerda.png");
//        texturaOmNomDulce= new Texture("omNomDulce.png");
//        texturaEstrellaGanada= new Texture("estrellaGanada2.png");
//        texturaEstrellaNoGanada= new Texture("estrellaNoGanada2.png");
//        texturaBtnPausar= new Texture("btnPausar2.png");
//        texturaBtnReiniciar= new Texture("btnReiniciar2.png");
//        texturabtnMenu= new Texture("btnMenu2.png");
//        texturaFondo= new Texture("fondoNiveles.png");
        this.jugador= jugador;
        inicializarComponentesComunes();
    }

    public FirstScreen(Jugador jugador, MainGame game, int numeroNivel) {
        this.game = game;
//        this.shape = new ShapeRenderer();
//
//        this.jugador= jugador;
//        this.persistenciaJugador= new PersistenciaJugador();
//        String username= jugador.getUsername();
//        PartidaProgreso progreso;
//        if(username!=null && username.isEmpty()==false)
//        {
//            progreso= persistenciaJugador.cargarProgreso(jugador.getUsername());
//        }
//        else
//        {
//            progreso= new PartidaProgreso();
//        }
//        this.gestorNiveles= new GestorNiveles(this.jugador);
//        this.gestorNiveles.setNivelActual(numeroNivel);
//        this.nivel= gestorNiveles.obtenerNivelActual();
//        nivel.iniciarNivel();

//        if(progreso.isHayPartidaGuardada())
//        {
//            tiempoNivel= progreso.getTiempoTranscurridoSegundos();
//            nivel.getCaramelo().setEstrellasRecolectadas(progreso.getEstrellasRecolectadas());
//            int estrellasRestaurar= progreso.getEstrellasRecolectadas();
//            int restauradas=0;
//            for (Estrella estrella: nivel.getEstrellas())
//            {
//                if(restauradas<estrellasRestaurar)
//                {
//                    estrella.recolectar();
//                    restauradas++;
//                }
//            }
//        }
//
//        batch= new SpriteBatch();
//        font= new BitmapFont();
//
//        texturaOmNom= new Texture("omNomNormal.png");
//        texturaCaramelo= new Texture("caramelo.png");
//        texturaEstrella= new Texture("estrella.png");
//        texturaOrigenCuerda= new Texture("origenCuerda.png");
//        texturaOmNomDulce= new Texture("omNomDulce.png");
//        texturaEstrellaGanada= new Texture("estrellaGanada2.png");
//        texturaEstrellaNoGanada= new Texture("estrellaNoGanada2.png");
//        texturaBtnPausar= new Texture("btnPausar2.png");
//        texturaBtnReiniciar= new Texture("btnReiniciar2.png");
//        texturabtnMenu= new Texture("btnMenu2.png");
//        texturaFondo= new Texture("fondoNiveles.png");
        this.jugador= jugador;
        this.shape= new ShapeRenderer();
        this.persistenciaJugador= new PersistenciaJugador();
        this.gestorNiveles= new GestorNiveles(this.jugador);
        this.gestorNiveles.setNivelActual(numeroNivel);
        this.nivel= gestorNiveles.obtenerNivelActual();
        nivel.iniciarNivel();
        batch=new SpriteBatch();
        font= new BitmapFont();
        cargarTexturas();
        procesarRestauracionProgreso();
    }

    public void inicializarComponentesComunes()
    {
        this.shape = new ShapeRenderer();
        if(this.jugador==null)
        {
            this.jugador= new Jugador();
        }
        this.persistenciaJugador= new PersistenciaJugador();
        this.gestorNiveles= new GestorNiveles(this.jugador);
        this.nivel= gestorNiveles.obtenerNivelActual();
        fechaInicioPartida= LocalDateTime.now();
        batch= new SpriteBatch();
        font = new BitmapFont();
        cargarTexturas();
        procesarRestauracionProgreso();

    }

    public void cargarTexturas()
    {
        texturaOmNom= new Texture("omNomNormal.png");
        texturaCaramelo= new Texture("caramelo.png");
        texturaEstrella= new Texture("estrella.png");
        texturaOrigenCuerda= new Texture("origenCuerda.png");
        texturaOmNomDulce= new Texture("omNomDulce.png");
        texturaEstrellaGanada= new Texture("estrellaGanada2.png");
        texturaEstrellaNoGanada= new Texture("estrellaNoGanada2.png");
        texturaBtnPausar= new Texture("btnPausar2.png");
        texturaBtnReiniciar= new Texture("btnReiniciar2.png");
        texturabtnMenu= new Texture("btnMenu2.png");
        texturaFondo= new Texture("fondoNiveles.png");
    }

    public void procesarRestauracionProgreso()
    {
        String username= jugador.getUsername();
        if(username!=null && !username.isEmpty())
        {
            PartidaProgreso progreso= persistenciaJugador.cargarProgreso((jugador.getUsername()));
            if(progreso.isHayPartidaGuardada()==true && progreso.getNivelActual()==gestorNiveles.getNivelActual())
            {
                if(progreso.isHayPartidaGuardada()==true && progreso.getNivelActual()==gestorNiveles.getNivelActual())
                {
                    tiempoNivel= progreso.getTiempoTranscurridoSegundos();
                    nivel.getCaramelo().setEstrellasRecolectadas(progreso.getEstrellasRecolectadas());
                    ArrayList<Boolean> cuerdasGuardadas= progreso.getEstadoCuerdasCortadas();
                    List<Cuerda> cuerdasActuales= nivel.getCuerdas();
                    for (int i = 0; i < cuerdasActuales.size(); i++)
                    {
                        if(cuerdasGuardadas.get(i))
                        {
                            cuerdasActuales.get(i).cortar();
                        }
                    }

                    ArrayList<Boolean> estrellasGuardadas= progreso.getEstadoCuerdasCortadas();
                    List<Estrella> estrellasActuales= nivel.getEstrellas();
                    for (int i = 0; i < cuerdasActuales.size(); i++)
                    {
                        if(estrellasGuardadas.get(i))
                        {
                            estrellasActuales.get(i).recolectar();
                        }
                    }
                }
            }
        }
    }
    @Override
    public void show() {
        System.out.println("Entro en show");
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
        //Gdx.gl.glClearColor(0.98f, 0.95f, 0.84f, 1f);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        actualizarJuego();
        dibujarJuego();
    }


    private void actualizarJuego()
    {
        if(cerrandoJuego==true)
        {
            return;
        }
        if(Gdx.input.justTouched()==true) {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (mouseX >= xBtnPausar && (mouseX <= xBtnPausar + anchoBtn) && mouseY >= yBtnPausar && (mouseY <= yBtnPausar + altoBtn)) {
                pausado = !pausado;
                guardarProgresoActual();
                javax.swing.SwingUtilities.invokeLater(() -> {new Pausado(jugador).setVisible(true);});
                return;
            }

            if (mouseX >= xBtnReiniciar && (mouseX <= xBtnReiniciar + anchoBtn) && mouseY >= yBtnReiniciar && (mouseY <= yBtnReiniciar + altoBtn)) {
                nivel.reiniciarNivel();
                tiempoNivel=0;
                pausado = false;
                //cantFallos++;
                int vidasRestantes= jugador.getVidas()-1;
                jugador.setVidas(vidasRestantes);
                if(vidasRestantes<=0)
                {
                    terminarPartidaPorDerrota();
                    return;
                }
                return;
            }
            if (mouseX >= xBtnMenu && (mouseX <= xBtnMenu + anchoBtn) && mouseY >= yBtnMenu && (mouseY <= yBtnMenu + altoBtn))
            {
                guardarProgresoActual();
                javax.swing.SwingUtilities.invokeLater(() -> {new Options().setVisible(true);});
                return;
            }
        }
        if (pausado == true)
        {
            mouseAnteriorX = -1;
            mouseAnteriorY = -1;
            return;
        }

        if(pausado==false && nivelCompletado==false)
        {
            tiempoNivel+= Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isTouched())
        {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
            if(mouseAnteriorX>=0 && mouseAnteriorY>=0)
            {
                float deslizarX= mouseX-mouseAnteriorX;
                float deslizarY= mouseY-mouseAnteriorY;
                float distDeslizar= (float) Math.sqrt(deslizarX*deslizarX+deslizarY*deslizarY);
                if(distDeslizar>5f)
                {
                    for (Cuerda cuerda : nivel.getCuerdas())
                    {
                        if(cuerda.estaCortada()==false)
                        {
                            boolean segmentoIntersecados=segmentosSeIntersecan(mouseAnteriorX, mouseAnteriorY, mouseX, mouseY, cuerda.getAnclajeX(), cuerda.getAnclajeY(), cuerda.getCaramelo().getX(), cuerda.getCaramelo().getY());
                            if(segmentoIntersecados==true)
                            {
                                cuerda.cortar();
                                break;
                            }

                        }


                    }
                }
            }
            mouseAnteriorX=mouseX;
            mouseAnteriorY= mouseY;
        }
        else
        {
            mouseAnteriorY=-1;
            mouseAnteriorX=-1;
        }

        for(Cuerda cuerda: nivel.getCuerdas())
        {
            cuerda.actualizar();
            //System.out.println("Posicion caramelo: "+cuerda.getCaramelo().getX()+", "+cuerda.getCaramelo().getY());
        }
        actualizarCarameloConCuerdas();
        nivel.getCaramelo().actualizar();
        verificarEstrellas();
        verificarOmNom();
    }

    private void terminarPartidaPorDerrota()
    {
        fechaFinalPartida = LocalDateTime.now();
        ResultadoPartida resultadoPartida = new ResultadoPartida();
        resultadoPartida.setNivelAlcanzado(nivel.getNumeroNivel());
        resultadoPartida.setVictoria(false);
        resultadoPartida.setFallos(3-jugador.getVidas());
        resultadoPartida.setVidasRestantes(0);
        resultadoPartida.setFechaHoraInicioPartida(fechaInicioPartida);
        resultadoPartida.setFechaHoraFinalPartida(fechaFinalPartida);
        resultadoPartida.setCantidadEstrellasRecolectadas(nivel.getCaramelo().getEstrellasRecolectadas());
        resultadoPartida.setTiempoSegundos(tiempoNivel);
        jugador.agregarResultado(resultadoPartida);
        PersistenciaPartidas persistenciaPartidas = new PersistenciaPartidas();
        persistenciaPartidas.agregarPartida(jugador.getUsername(), resultadoPartida);
        persistenciaJugador.guardarJugador(jugador);
        persistenciaJugador.borrarProgreso(jugador.getUsername());
        cerrandoJuego=true;
        // Volvemos a la pantalla de Niveles original
        javax.swing.SwingUtilities.invokeLater(() -> {
            new Niveles(jugador).setVisible(true);
        });
        Gdx.app.exit();

    }
    private void guardarProgresoActual()
    {
        String username= jugador.getUsername();
        if(username==null || username.isEmpty()==true)
        {
            return;
        }

        int nivelID= gestorNiveles.getNivelActual();
        int estrellas= nivel.getCaramelo().getEstrellasRecolectadas();
        float tiempo= tiempoNivel;
        ArrayList<Boolean> listaCuerdas= new ArrayList<>();
        for (Cuerda cuerda: nivel.getCuerdas())
        {
            listaCuerdas.add(cuerda.estaCortada());
        }
        ArrayList<Boolean> listaEstrellas= new ArrayList<>();
        for (Estrella estrella: nivel.getEstrellas())
        {
            listaEstrellas.add(estrella.isRecolectada());
        }

        new Thread (() -> {
            synchronized (LOCK_PROGRESO)
            {
                PartidaProgreso estado= new PartidaProgreso(nivelID, estrellas, tiempo);
                estado.setEstadoCuerdasCortadas(listaCuerdas);
                estado.setEstadoEstrellasRecolectadas(listaEstrellas);
                persistenciaJugador.guardarProgreso(username, estado);
                System.out.println("[Hilo-Progreso] Guardado en tiempo real completado para: "+username);
            }
        }, "Hilo-GuardarProgreso").start();

//        Thread hiloEscrituraProgreso = new Thread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                try
//                {
//                    PartidaProgreso estado = new PartidaProgreso(nivelID, estrellas, tiempo);
//                    estado.setEstadoCuerdasCortadas(listaCuerdas);
//                    estado.setEstadoEstrellasRecolectadas(listaEstrellas);
//                    persistenciaJugador.guardarProgreso(username, estado);
//                    System.out.println("[Hilo-Progreso] Guardado aincrono y seguro completado para: " + username);
//                }
//                catch (Exception e)
//                {
//                    System.out.println("Error en el hilo de persistencia asíncrona: " + e.getMessage());
//                }
//            }
//        }, "Hilo-GuardarProgreso");
//        hiloEscrituraProgreso.start();
    }
    private boolean segmentosSeIntersecan(float anteriorMouseX, float anteriorMouseY, float mouseX, float mouseY, float AnclajeX, float AnclajeY, float XCaramelo, float YCaramelo)
    {
        float distancia1x= mouseX-anteriorMouseX;
        float distancia1y= mouseY-anteriorMouseY;
        float distancia2x= XCaramelo-AnclajeX;
        float distancia2y= YCaramelo-AnclajeY;

        float cruce= distancia1x*distancia2y-distancia1y*distancia2x;
        if(Math.abs(cruce)<0.0001f)//->significa que son paralelos, no se cruzan
        {
            return false;
        }
        // t indica qué tan lejos sobre el segmento del MOUSE ocurre la intersección (0=inicio, 1=fin)
        float t = ((AnclajeX - anteriorMouseX) * distancia2y - (AnclajeY - anteriorMouseY) * distancia2x) / cruce;
        // u indica qué tan lejos sobre el segmento de la CUERDA ocurre la intersección (0=anclaje, 1=caramelo)
        float u = ((AnclajeX - anteriorMouseX) * distancia1y - (AnclajeY - anteriorMouseY) * distancia1x) / cruce;
        // solo hay intersección real si ambos valores están entre 0 y 1 (dentro de ambos segmentos)
        return t>=0f && t<=1f && u>=0f && u<=1f;
    }
    private void actualizarCarameloConCuerdas()
    {
        if(nivelCompletado==true)
        {
            tiempoVictoria-=Gdx.graphics.getDeltaTime();
            System.out.println("CAMBIANDO NIVEL");
//            if(tiempoVictoria<=0)
//            {
//                gestorNiveles.avanzarNivel();
//                if (gestorNiveles.ultimoNivelCompletado() == false) {
//                    nivel = gestorNiveles.obtenerNivelActual();
//                    nivel.iniciarNivel();
//                    tiempoNivel=0;
//                }
//                nivelCompletado=false;
//            }
            //cambie esto para que al terminar el nivel vuelva a niveles
            if(tiempoVictoria<=0 && cerrandoJuego==false)
            {
                cerrandoJuego=true;
                //nivelCompletado=false;
                javax.swing.SwingUtilities.invokeLater(() ->{
                    new Niveles(jugador).setVisible(true);
                });
//                Gdx.app.postRunnable(() -> {
//                    Gdx.app.exit();
//                });

            }
            return;
        }
        int activas=0;
        float sumaPesoX=0;
        float sumaPesoY=0;
        float sumaPesos=0;
        for(Cuerda cuerda: nivel.getCuerdas())
        {
            if(cuerda.estaCortada()==false)
            {
                float peso=1.0f/cuerda.getLongitud();
                sumaPesoX+=cuerda.getPosicionCarameloX()*peso;
                sumaPesoY+=cuerda.getPosicionCarameloY()*peso;
                sumaPesos+=peso;
                activas++;
            }
        }
        if(activas>0)
        {
            nivel.getCaramelo().setLibre(false);
            nivel.getCaramelo().setX(sumaPesoX/sumaPesos);
            nivel.getCaramelo().setY(sumaPesoY/sumaPesos);
        }
        else
        {
            System.out.println("sin cuerdas activas");
            nivel.getCaramelo().setLibre(true);
            //para que pierda la vida cuando el caramelo tiene caida libre
            if(nivel.getCaramelo().getY()<0 && nivelCompletado==false)
            {
                int vidasActuales= jugador.getVidas()-1;
                jugador.setVidas(vidasActuales);
                if(vidasActuales<=0)
                {
                    terminarPartidaPorDerrota();
                }
                else
                {
                    nivel.reiniciarNivel();
                    tiempoNivel=0;
                }
                return;
            }
        }
    }
    private float distanciaPuntoLinea(float px, float py, float x1, float y1, float x2, float y2)
    {
        float A= px-x1;
        float B= py-y1;
        float C= x2-x1;
        float D= y2-y1;
        float dot= A*C+B*D;
        float lenSq= C*C+D*D;

        if(lenSq==0)
        {
            return Float.MAX_VALUE;
        }
        float param=dot/lenSq;
        float xx;
        float yy;

        if(param<0)
        {
            xx=x1;
            yy=y1;
        }
        else if(param>1)
        {
            xx=x2;
            yy=y2;
        }
        else
        {
            xx=x1+param*C;
            yy=y1+param*D;
        }
        float dx= px-xx;
        float dy= py-yy;
        return (float) Math.sqrt(dx*dx+dy*dy);

    }
    private void verificarEstrellas()
    {
        Caramelo caramelo= nivel.getCaramelo();
        for(Estrella estrella: nivel.getEstrellas())
        {
            if(estrella.isRecolectada()==true)
            {
                continue;
            }
            float dx= caramelo.getX()-estrella.getX();
            float dy= caramelo.getY()-estrella.getY();
            double distancia= Math.sqrt(dx*dx+ dy*dy);
            if(distancia<35)
            {
                estrella.recolectar();
                caramelo.recolectarEstrella();
            }

        }
    }
    private void verificarOmNom()
    {
        Caramelo caramelo=nivel.getCaramelo();
        OmNom omNom= nivel.getOmNom();
        float dx = caramelo.getX() - omNom.getX();
        float dy = caramelo.getY() - omNom.getY();
        double distancia = Math.sqrt(dx * dx + dy * dy);

//        if (distancia < 60)
//        {
//            omNom.comerCaramelo(caramelo);
//            System.out.println("GANASTE");
//        }
        if (distancia < 60 && nivelCompletado==false)
        {
            omNom.comerCaramelo(caramelo);
            System.out.println("ESTA COMIENDO: "+omNom.estaComiendo());
            System.out.println("GANASTE");
//            if(nivel.getNumeroNivel()==1)
//            {
//                nivel= new Nivel(2,1, jugador);
//                nivel.iniciarNivel();
//                nivel.reiniciarNivel();
//            }
            if(nivel.verificarVictoria()==true && nivelCompletado==false)
            {
                fechaFinalPartida = LocalDateTime.now();
                ResultadoPartida resultadoPartida= new ResultadoPartida();
                resultadoPartida.setNivelAlcanzado(nivel.getNumeroNivel());
                resultadoPartida.setVictoria(true);
                resultadoPartida.setFallos(3-jugador.getVidas());
                resultadoPartida.setVidasRestantes(jugador.getVidas());
                resultadoPartida.setFechaHoraInicioPartida(fechaInicioPartida);
                resultadoPartida.setFechaHoraFinalPartida(fechaFinalPartida);
                resultadoPartida.setCantidadEstrellasRecolectadas(caramelo.getEstrellasRecolectadas());
                resultadoPartida.setTiempoSegundos(tiempoNivel);

                jugador.agregarResultado(resultadoPartida);
                //cambie esto para que agregue el archivo con ayuda de la clase PersistenciaPartidas
                PersistenciaPartidas persistenciaPartidas= new PersistenciaPartidas();
                persistenciaPartidas.agregarPartida(jugador.getUsername(), resultadoPartida);
                persistenciaJugador.borrarProgreso(jugador.getUsername());
                //cambie esto para que al terminar se aumente el nivel del jugador
                if(jugador.getNivelPartidaActual()<= nivel.getNumeroNivel())
                {
                    jugador.setNivelPartidaActual(nivel.getNumeroNivel()+1);
                }
                persistenciaJugador.guardarJugador(jugador);
                nivelCompletado=true;
                tiempoVictoria=1f;
            }

        }
    }

    private void dibujarJuego()
    {
        batch.begin();
        batch.draw(texturaFondo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch.end();
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(.35f,0.20f,0.08f, 1f);
        for(Cuerda cuerda: nivel.getCuerdas())
        {
            if(cuerda.estaCortada()==false)
            {
                float x1= cuerda.getAnclajeX();
                float y1= cuerda.getAnclajeY();
                float x2= nivel.getCaramelo().getX();
                float y2= nivel.getCaramelo().getY();
//                shape.line(cuerda.getAnclajeX(), cuerda.getAnclajeY(), nivel.getCaramelo().getX(), nivel.getCaramelo().getY());
                float dist= (float) Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
                float cuelgue= dist*0.25f;
                float ctrlX=(x1+x2)/2f;
                float ctrlY=(y1+y2)/2f-cuelgue;
                int segmentos=20;
                float prevX= x1;
                float prevY=y1;
                for (int i = 1; i <= segmentos; i++) {
                    float t=(float) i/segmentos;
                    float mt=1-t;
                    float bx=mt * mt * x1 + 2 * mt * t * ctrlX + t * t * x2;
                    float by=mt * mt * y1 + 2 * mt * t * ctrlY + t * t * y2;
                    shape.line(prevX, prevY, bx, by);
                    prevX= bx;
                    prevY=by;

                }
            }
        }
        shape.end();

        batch.begin();
        for(Cuerda cuerda: nivel.getCuerdas())
        {
            batch.draw(texturaOrigenCuerda, cuerda.getAnclajeX()-20, cuerda.getAnclajeY()-20, 40, 40);
        }

//        shape.begin(ShapeRenderer.ShapeType.Filled);
        OmNom omNom= nivel.getOmNom();
//        shape.circle(omNom.getX(), omNom.getY(), 40);
        if(omNom.estaComiendo()==true)
        {
            batch.draw(texturaOmNomDulce, omNom.getX()-40, omNom.getY()-40, 100,100);
        }
        else
        {
            batch.draw(texturaOmNom, omNom.getX()-40, omNom.getY()-40, 80,80);
        }
        Caramelo caramelo = nivel.getCaramelo();
        if(caramelo.isFueComido()==false)
        {
            batch.draw(texturaCaramelo, caramelo.getX()-20, caramelo.getY()-20, 40,40);
        }
        for(Estrella estrella: nivel.getEstrellas())
        {
            if(estrella.isRecolectada()==false)
            {
                batch.draw(texturaEstrella, estrella.getX()-15, estrella.getY()-15,30,30);
            }
        }
        int ganadas= caramelo.getEstrellasRecolectadas();
        float yMarcador=700;
        float tamañoEstrella=90;
        float separacion=100;
        float xInicial=350;
        for (int i = 0; i < 3; i++)
        {
            if(i<ganadas)
            {
                batch.draw(texturaEstrellaGanada, xInicial+i*separacion, yMarcador, tamañoEstrella, tamañoEstrella);
            }
            else
            {
                batch.draw(texturaEstrellaNoGanada, xInicial+i*separacion, yMarcador, tamañoEstrella,tamañoEstrella);
            }
        }
        batch.draw(texturaBtnReiniciar, xBtnReiniciar, yBtnReiniciar, anchoBtn, altoBtn);
        batch.draw(texturaBtnPausar, xBtnPausar, yBtnPausar, anchoBtn, altoBtn);
        batch.draw(texturabtnMenu, xBtnMenu, yBtnMenu, anchoBtn, altoBtn);
        font.draw(batch, "Vidas/Lives: "+jugador.getVidas(), 20,70);
        font.draw(batch, "Tiempo/Time: "+(int) tiempoNivel +" s", 20, 50);
        batch.end();
    }
    @Override
    public void resize(int width, int height)
    {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0)
        {
            return;
        }
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused
        guardarProgresoActual();
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
        guardarProgresoActual();
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        shape.dispose();
        batch.dispose();
        texturaCaramelo.dispose();
        texturaOmNom.dispose();
        texturaEstrella.dispose();
        texturaOrigenCuerda.dispose();
        texturaOmNomDulce.dispose();
        texturaEstrellaGanada.dispose();
        texturaEstrellaNoGanada.dispose();
        texturaFondo.dispose();
        texturabtnMenu.dispose();
    }
}
