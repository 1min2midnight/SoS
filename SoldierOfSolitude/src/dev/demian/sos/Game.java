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
	

	
	public Game(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		
		
	}
	
	//temp code:
	int x=0;
	private void tick()
	{
		x+= 1;
		
		
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
		g.drawImage(Assets.player, x, 10, null);
		
		
	
		
		//end of drawings
		bs.show();
		g.dispose();
	}
	private void init() 
	{
		display = new Display(title,width,height);

		Assets.init();
	}
	
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
