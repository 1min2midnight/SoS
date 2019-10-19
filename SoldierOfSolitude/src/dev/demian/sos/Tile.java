package dev.demian.sos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	
	
	
	//tiles
	public static Tile[] tiles = new Tile [256];
	
	//polymorphism
	public static Tile grassTile = new GrassTile(0);
	public static Tile wallTile = new WallTile(1);
	public static Tile doorTile = new DoorTile(2);
	
	
	
	//tile properties + graphics
	public static final int TILE_WIDTH =32;
	public static final int TILE_HEIGHT =32;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id=id;
		
		tiles[id] =this;		
		
	}
	//images will only be defined by an integer ID
	public int getID()
	{
		return id;
		
		
	}
	public void tick()
	{
		
	}
	//will be used to determine collision later
	public boolean isSolid()
	{
		return false;
	}
	//renders graphics to screen
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture,x,y,TILE_WIDTH,TILE_HEIGHT, null);
		
	}
}
