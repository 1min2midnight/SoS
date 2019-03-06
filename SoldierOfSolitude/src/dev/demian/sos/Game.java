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
	public int width;
	public int height;
	
	
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//test code:
	private BufferedImage testImage;
	
	private SpriteSheet sheet;
	
	public Game(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		
		
	}
	private void tick()
	{
		
		
	}
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
		
		//g.fillRect(3, 2, 50, 50);
		g.drawImage(sheet.crop(0, 16, 16, 16),20,20,null);
		
		//end of drawings
		bs.show();
		g.dispose();
	}
	private void init() 
	{
		display = new Display(title,width,height);
		testImage = ImageLoader.loadImage("/textures/Dungeon_Character.png");
		sheet = new SpriteSheet(testImage);
		
	}
	
	public void run()
	{
		init();
		while(running)
		{
			tick();
			render();
			
		}
		stop();
	}
	public synchronized void start()
	{
		if(running)
			return;
		running =true;
		thread = new Thread(this);
		thread.start();
	}
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
