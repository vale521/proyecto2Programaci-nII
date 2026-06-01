package com.cuttherope.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import juego.*;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    private MainGame game;
    private ShapeRenderer shape;
    private NivelCutTheRope nivel;
    private SpriteBatch batch;
    private Texture texturaOmNom;
    private Texture texturaCaramelo;
    private Texture texturaEstrella;
    public FirstScreen(MainGame game) {
        this.game = game;
        this.shape = new ShapeRenderer();
        this.nivel = new NivelCutTheRope(1,1);
        this.nivel.iniciarNivel();
        batch= new SpriteBatch();
        texturaOmNom= new Texture("omNomNormal.png");
        texturaCaramelo= new Texture("caramelo.png");
        texturaEstrella= new Texture("estrella.png");
    }

    @Override
    public void show() {
        System.out.println("Entro en show");
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
        Gdx.gl.glClearColor(1f, 0.8f, 0.86f, 1f);
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
            Cuerda cuerda = nivel.getCuerdas().get(0);
            float x1= cuerda.getAnclajeX();
            float y1= cuerda.getAnclajeY();
            float x2= nivel.getCaramelo().getX();
            float y2= nivel.getCaramelo().getY();
            float distancia= distanciaPuntoLinea(mouseX, mouseY, x1, y1, x2, y2);
            if(distancia<15)
            {
                cuerda.cortar();
            }
        }
        for(Cuerda cuerda: nivel.getCuerdas())
        {
            cuerda.actualizar();
        }
        nivel.getCaramelo().actualizar();
        verificarEstrellas();
        verificarOmNom();
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

        if (distancia < 60)
        {
            omNom.comerCaramelo(caramelo);
            System.out.println("GANASTE");
        }
    }

    private void dibujarJuego()
    {
        shape.begin(ShapeRenderer.ShapeType.Line);
        for(Cuerda cuerda: nivel.getCuerdas())
        {
            if(cuerda.estaCortada()==false)
            {
                shape.line(cuerda.getAnclajeX(), cuerda.getAnclajeY(), nivel.getCaramelo().getX(), nivel.getCaramelo().getY());
            }
        }
        shape.end();
        batch.begin();
//        shape.begin(ShapeRenderer.ShapeType.Filled);
        OmNom omNom= nivel.getOmNom();
//        shape.circle(omNom.getX(), omNom.getY(), 40);
        batch.draw(texturaOmNom, omNom.getX()-40, omNom.getY()-40, 80,80);
        Caramelo caramelo = nivel.getCaramelo();
//        shape.circle(caramelo.getX(), caramelo.getY(), 20);
        batch.draw(texturaCaramelo, caramelo.getX()-20, caramelo.getY()-20, 40,40);
        for(Estrella estrella: nivel.getEstrellas())
        {
            if(estrella.isRecolectada()==false)
            {
//                shape.circle(estrella.getX(), estrella.getY(), 15);
                batch.draw(texturaEstrella, estrella.getX()-15, estrella.getY()-15,30,30);
            }
        }
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
    }
}
