package com.cuttherope.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import juego.*;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    private MainGame game;
    private ShapeRenderer shape;
    private NivelCutTheRope nivel;
    private SpriteBatch batch;
    private int estrellasRecolectada;
    private Texture texturaOmNom;
    private Texture texturaCaramelo;
    private Texture texturaEstrella;
    private Texture texturaOrigenCuerda;
    private Texture texturaOmNomDulce;
    private Texture texturaEstrellaGanada;
    private Texture texturaEstrellaNoGanada;
    private Texture texturaBtnPausar;
    private Texture texturaBtnReiniciar;
    private float xBtnPausar=900;
    private float yBtnPausar=730;
    private float xBtnReiniciar=840;
    private float yBtnReiniciar=730;
    private float anchoBtn=50;
    private float altoBtn=50;
    private boolean pausado=false;

    public FirstScreen(MainGame game) {
        this.game = game;
        this.shape = new ShapeRenderer();
//        this.nivel = new NivelCutTheRope(1,1);
//probar nivel 2
        this.nivel = new NivelCutTheRope(1,1);
        this.nivel.iniciarNivel();
        batch= new SpriteBatch();
        texturaOmNom= new Texture("omNomNormal.png");
        texturaCaramelo= new Texture("caramelo.png");
        texturaEstrella= new Texture("estrella.png");
        texturaOrigenCuerda= new Texture("origenCuerda.png");
        texturaOmNomDulce= new Texture("omNomDulce.png");
        texturaEstrellaGanada= new Texture("estrellasGanadas.png");
        texturaEstrellaNoGanada= new Texture("estrellasNoGanadas.png");
        texturaBtnPausar= new Texture("btnPausa.png");
        texturaBtnReiniciar= new Texture("btnReiniciar.png");
    }

    @Override
    public void show() {
        System.out.println("Entro en show");
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
        Gdx.gl.glClearColor(0.98f, 0.95f, 0.84f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        actualizarJuego();
        dibujarJuego();
    }


    private void actualizarJuego()
    {

        if(Gdx.input.justTouched()==true)
        {
            float mouseX= Gdx.input.getX();
            float mouseY= Gdx.graphics.getHeight()-Gdx.input.getY();

            if(mouseX>= xBtnPausar && (mouseX<=xBtnPausar+anchoBtn )&& mouseY>=yBtnPausar && (mouseY<= yBtnPausar+altoBtn))
            {
                pausado= !pausado;
                return;
            }

            if(mouseX>= xBtnReiniciar && (mouseX<=xBtnReiniciar+anchoBtn )&& mouseY>=yBtnReiniciar && (mouseY<= yBtnReiniciar+altoBtn))
            {
                nivel.reiniciarNivel();
                pausado=false;
                return;
            }
//            modificacion para el nivel 2
//            Cuerda cuerda = nivel.getCuerdas().get(0);
//            float x1= cuerda.getAnclajeX();
//            float y1= cuerda.getAnclajeY();
//            float x2= nivel.getCaramelo().getX();
//            float y2= nivel.getCaramelo().getY();
//            float distancia= distanciaPuntoLinea(mouseX, mouseY, x1, y1, x2, y2);
//            if(distancia<15)
//            {
//                cuerda.cortar();
//            }
            for (Cuerda cuerda : nivel.getCuerdas()) 
            {
                float distancia= distanciaPuntoLinea(mouseX, mouseY, cuerda.getAnclajeX(), cuerda.getAnclajeY(), nivel.getCaramelo().getX(), nivel.getCaramelo().getY());
                if(distancia<15)
                {
                    cuerda.cortar();
                    break;
                }
            }
        }
        if(pausado==true)
        {
            return;
        }
        for(Cuerda cuerda: nivel.getCuerdas())
        {
            cuerda.actualizar();
            
        }
        actualizarCarameloConCuerdas();
        nivel.getCaramelo().actualizar();
        verificarEstrellas();
        verificarOmNom();
    }

    private void actualizarCarameloConCuerdas()
    {
        int activas=0;
        float sumaPesoX=0;
        float sumaPesoY=0;
        float sumaPesos=0;
        for(Cuerda cuerda: nivel.getCuerdas())
        {
            if(cuerda.estaCortada()==false)
            {
                float peso=1.0f/cuerda.getLongitud();
                sumaPesoX+=cuerda.getPosicionCarameloX();
                sumaPesoY+=cuerda.getPosicionCarameloY();
                sumaPesos+=peso;
                activas++;
            }
        }
        if(activas>0)
        {
            nivel.getCaramelo().setLibre(false);
            nivel.getCaramelo().setX(sumaPesoX/activas);
            nivel.getCaramelo().setY(sumaPesoY/activas);
        }
        else
        {
            System.out.println("sin cuerdas activas");
            nivel.getCaramelo().setLibre(true);
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
        if (distancia < 60)
        {
            omNom.comerCaramelo(caramelo);
            System.out.println("GANASTE");
            if(nivel.getNumeroNivel()==1)
            {
                nivel= new NivelCutTheRope(2,1);
                nivel.iniciarNivel();
            }
        }
    }

    private void dibujarJuego()
    {
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
//        shape.circle(caramelo.getX(), caramelo.getY(), 20);
        if(caramelo.isFueComido()==false)
        {
            batch.draw(texturaCaramelo, caramelo.getX()-20, caramelo.getY()-20, 40,40);
        }
        for(Estrella estrella: nivel.getEstrellas())
        {
            if(estrella.isRecolectada()==false)
            {
//                shape.circle(estrella.getX(), estrella.getY(), 15);
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
//        shape.end();
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
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
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
    }
}
