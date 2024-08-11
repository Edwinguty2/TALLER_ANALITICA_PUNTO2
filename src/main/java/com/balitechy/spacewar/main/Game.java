package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Space War 2D";
    
    private boolean running = false;
    private Thread thread;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    
    private SpritesImageLoader sprites;
    
    // Game components
    private Player player;
    private BulletController bullets;
    private BackgroundRender backgRenderer;
    private PlayerRender playerRenderer;
    private BulletRender bulletRenderer;
    
    private RenderFactory rendererFactory;
    
    public Game(RenderFactory rendererFactory) {
        this.rendererFactory = rendererFactory;
    }
    
    public void init() {
        requestFocus();
        
        sprites = new SpritesImageLoader("/sprites.png");
        try {            
            sprites.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Add keyboard listener
        addKeyListener(new InputHandler(this));
        
        // Initialize game components
        player = new Player((WIDTH * SCALE - Player.WIDTH) / 2, HEIGHT * SCALE - 50, this);
        bullets = new BulletController();
        
        // Set up renderers
        backgRenderer = rendererFactory.createBackgroundRenderer();
        playerRenderer = rendererFactory.createPlayerRenderer();
        bulletRenderer = rendererFactory.createBulletRenderer();
    }

    public SpritesImageLoader getSprites() {
        return sprites;
    }
    
    public BulletController getBullets() {
        return bullets;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(5);
                break;
            case KeyEvent.VK_LEFT:
                player.setVelX(-5);
                break;
            case KeyEvent.VK_UP:
                player.setVelY(-5);
                break;
            case KeyEvent.VK_DOWN:
                player.setVelY(5);
                break;
            case KeyEvent.VK_SPACE:
                player.shoot();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(0);
                break;
            case KeyEvent.VK_LEFT:
                player.setVelX(0);
                break;
            case KeyEvent.VK_UP:
                player.setVelY(0);
                break;
            case KeyEvent.VK_DOWN:
                player.setVelY(0);
                break;
        }
    }
    
    private synchronized void start() {
        if (running) return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop() {
        if (!running) return;
        
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
    
    /*
    * Game thread runner. 
    */
    
    @Override
    public void run() {
        init();
        
        long lastTime = System.nanoTime();
        final double numOfTicks = 60.0;
        double ns = 1000000000 / numOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ticks, fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    /*
    * Run the ticks of all game components.
     */
    
    public void tick() {
        player.tick();
        bullets.tick();
    }
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        backgRenderer.render(g, this);
        playerRenderer.render(g, player.getX(), player.getY());
        for (Bullet bullet : bullets.getBullets()) {
            bulletRenderer.render(g, bullet.getX(), bullet.getY());
        }   
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args) {        
        String[] options = {"Colorful Vectorial Style", "Sprite Style"};
        int choice = -1;
        RenderFactory factory;
        SpritesImageLoader sprites = new SpritesImageLoader("/sprites.png");
        
        try {
            sprites.loadImage();
        } catch (IOException e) {
            return;
        }
        
       
        choice = JOptionPane.showOptionDialog(null,
                    "Seleccione el estilo de renderizado:",
                    "Seleccionar Estilo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[1]);

         switch (choice) {
            case -1:
                System.exit(0);
            case 0:
                factory = new VectorFactoryRender();
                break;
            case 1:
                factory = new SpriteRenderFactory(sprites);
                break;
            default:
                throw new IllegalStateException("Selección inválida: " + choice);
        }
        
        Game game = new Game(factory);
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }
}
