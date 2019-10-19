package dev.demian.sos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Game implements Runnable
{
	private Display display;
	
	public String title;
	private int width;
	private int height;
	
	
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	//input
	private KeyManager keyManager; 
	
	
	//camera
	
	private GameCamera gameCamera;
	
	//states
	
	private State gameState;
	private State menuState;
	
	//handler
	
	private Handler handler;
	
	//constructor
	public Game(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		keyManager = new KeyManager();
		
		
	}
	
	//this method ensures that all states are syncrhonized
	private void tick()
	{
		
		keyManager.tick();
		if(State.getState() != null)
		
			State.getState().tick();
		
		
		
	}
	public int getHeight()
	{
		return height;
	}
	public int getWidth()
	{
		
		return width;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
		
	}
	//renders all graphics to the screen
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs==null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		
		
		//clear screen
		g.clearRect(0, 0, width, height);
		//drawings:
		if(State.getState() != null)
			
			State.getState().render(g);
		
		
	
		
		//end of drawings
		
		bs.show();
		g.dispose();
	}
	
	
	//initializes the display and states needed for the game
	private void init() 
	{
		display = new Display(title,width,height);
		display.getJFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);
		
		//substitution principle
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		
		State.setState(gameState);
		
	}
	//required for the thread keeps everything synchronized
	public void run()
	{
		
		
		init();
		
		int fps =60;
		
		//one billion nano seconds in one second
		double timePerTick= 1000000000/fps;
		double delta =0;
		long now;
		
		
		long lastTime = System.nanoTime();
		
		long timer=0;
		int ticks=0;
		
		while(running)
		{
			now =System.nanoTime();
			
			//delta variable comes up with how much time has passed since the init method is called and divides it by the equivalent of 60 seconds in nano seconds 
			delta+=(now - lastTime)/timePerTick;
			
			timer+= now-lastTime;
			
			
			//last time then becomes now because one tick has passed
			lastTime =now;
			
			//if at any point delta reaches the same value as the equivalent of 60 seconds in 
			//nano seconds then tick and render
			if(delta>=1) 
			{
				tick();
				render();
				
				ticks++;
				delta--;
			}
			if(timer>=1000000000)
			{
				System.out.println("Ticks and Frames: "+ticks);
				ticks =0;
				timer=0;
				
			}
		}
		stop();
	}
	//key manager
	public KeyManager getKeyManager()
	{
		
		return keyManager;
	}
	//checks if thread is running 
	public synchronized void start()
	{
		if(running)
			return;
		running =true;
		thread = new Thread(this);
		thread.start();
	}
	//if the thread is not running then it will ensure that it stops
	public synchronized void stop() 
	{
		if(running == false)
			return;
		running = false;
		try {
		thread.join();
		}
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
