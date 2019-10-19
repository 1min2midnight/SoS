package dev.demian.sos;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
	//stores a spritesheet into an object so that I can the crop what I need
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) 
	{	
		this.sheet =sheet;
		
		
	}
	
	//crops image so that a specific tile is used
	public BufferedImage crop (int x, int y, int width, int height) {
		
		return sheet.getSubimage(x, y, width,height);
	}
}
