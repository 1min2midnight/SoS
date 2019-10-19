package dev.demian.sos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {
	
	private static final int width= 16;
	private static final int height =16;
	public static BufferedImage player, floor, wall, door,web;
	public static BufferedImage[] player_idle;
	
	//initializes assets
	public static void init()
	{
		SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Dungeon_Character.png"));
		player = charSheet.crop(width,0, width, height);
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Dungeon_Tileset copy.png"));
		wall = sheet.crop(0, 0, width, height);
		floor = sheet.crop(height,width*2,width,height);
		web = sheet.crop(4*width, 6*height, width, height);
		
		SpriteSheet charAnimSheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		
		
		player_idle = new BufferedImage[4];
		
		player_idle[0] = charAnimSheet.crop(0, 0, width,height);
		player_idle[1] = charAnimSheet.crop(width, 0, width, height);
		player_idle[2] = charAnimSheet.crop(0, height, width, height);
		player_idle[3] = charAnimSheet.crop(width, height, width, height);
		
		//(x position , y position, xcropsize,ycropsize)
		door = sheet.crop(6*height, 3*width, width, height);
		
		
	}

}
