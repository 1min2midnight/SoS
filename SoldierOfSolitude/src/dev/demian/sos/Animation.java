package dev.demian.sos;

import java.awt.image.BufferedImage;

public class Animation {

	private int speed;
	private int index;
	private BufferedImage[] frames;
	private long lastTime;
	private long timer;
	// Animation constructor
	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed= speed;
		this.frames = frames;
		index =0;
		timer =0;
		lastTime = System.currentTimeMillis();
		
		
		
	}
	
	//fps
	public void tick()
	{
		timer+= System.currentTimeMillis()- lastTime;
		
		lastTime = System.currentTimeMillis();
		
		if(timer>speed)
		{
			index++;
			timer =0;
			if(index>=frames.length)
			{
				index=0;
			}
			
		}
			
		
	}
	//gets the frames per second at the specified indez
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
}
