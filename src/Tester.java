import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serial;

/**
 * @author RealTutsGML, Caleb Copeland
 */
public class Tester extends Canvas implements Runnable{

    @Serial
    private static final long serialVersionUID = -3944939127227443376L;

    public static final int WIDTH = 800;
    public static final int HEIGHT = WIDTH;
    public final Color BACKGROUND_COLOR = Color.black;
    public static final Color TERRAIN_COLOR = Color.white;


    private Thread thread;
    public volatile boolean running;


    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();

    }

    @SuppressWarnings("unused")
    public synchronized void stop()
    {
        try{
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Tester();
    }

    /**
     * Starts the game.
     */
    public Tester()
    {
        //this.addKeyListener(new KeyInput());
        final String TITLE = "Algologo";
        new Window(WIDTH, HEIGHT, TITLE, this);
        Handler.addObject(new Box(50,50,50,50,50,50));
        //LevelManager.loadLevel(LevelManager.LEVELS.BETA_LEVEL);
        running = true;
    }



    public void run()
    {
        while (!running) {
            Thread.onSpinWait();
            // wait for things to actually be set up
        }

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }

            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

    private void tick()
    {
        //Handler.tick();
        //hud.tick();
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0,0,WIDTH,HEIGHT);

        Handler.render(g);

        g.dispose();
        bs.show();
    }



}
