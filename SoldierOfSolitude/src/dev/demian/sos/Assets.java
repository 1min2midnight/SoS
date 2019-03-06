package dev.demian.sos;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width= 16;
	private static final int height =16;
	public static BufferedImage player, floor, wall, door;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Dungeon_Character.png"));
		player = sheet.crop(0, height, width, height);
	
		
	}

}
