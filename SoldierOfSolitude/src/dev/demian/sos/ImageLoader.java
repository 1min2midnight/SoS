package dev.demian.sos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//this class allows me to load all of my images to the Assets obj
public class ImageLoader {
	
	public static BufferedImage loadImage(String path)
	{
		try {
		return ImageIO.read(ImageLoader.class.getResource(path));
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
			
			System.out.println("perhaps its an invalid path");
			
		}
		return null;
	}

}
