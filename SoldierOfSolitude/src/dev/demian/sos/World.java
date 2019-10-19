package dev.demian.sos;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class World {
	
	
	//Entity manager
	private EntityManager entityManager;
	//handler
	private Handler handler;
	// how big the world will be
	private int width;
	private int height;
	
	// where the character will spawn
	private static int spawnX;
	private static int spawnY;
	
	//will store the coordinates of the tiles in a two dimensional array
	private int[][] tiles;
	  private List<List<Integer>> tileCoordinates= new ArrayList<List<Integer>>();;
	
	public World(Handler handler, String path)
	{
		
		this.handler = handler;
		entityManager = new EntityManager(handler,new Player(handler, 32,32));
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick()
	{
		entityManager.tick();
		
	}
	//renders graphics to the screen
	public void render(Graphics g)
	{
		
		int xStart= (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH );
		int xEnd= (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILE_WIDTH+1) ;
		int yStart= (int) Math.max(0, handler.getGameCamera().getyOffset()/ Tile.TILE_WIDTH );
		int yEnd= (int) Math.min(height,(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_WIDTH+1);
		for(int y =yStart; y<yEnd; y++)
		{
			for(int x= xStart; x < xEnd; x++)
			{
				getTile(x,y).render(g,(int) (x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int) (y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
	}
	


	//gets the tiles and returns them if there are no tiles it will set the grass/floor tile as default
	public Tile getTile(int x, int y)
	{
		//if(x>0 ||  y> 0 || x>=height || y >= width)
		
			//return Tile.grassTile;
		
		
		
		
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		if(t == null)
			return Tile.grassTile;
			
		
		return t;
		
		
	}
	
	
	//loads world
	
	public void loadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		//"\\s+"
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		//System.out.println("this is token's length " + tokens.length);
		
		tiles = new int [width][height];
		
		for(int y =0; y<height; y++)
		{
			for(int x=0; x<width; x++)
			{
				//System.out.println("this is x:" + x);
				//System.out.println("this is y:" + y);
				//System.out.println("this is the width: " +width);
				//System.out.println("this is the height: " + height);
				//System.out.println("this is the index of token :" + ((x+y*width)+4));
				
				System.out.println("spawn X = " + spawnX);
				System.out.println("Spawn Y = " + spawnY);
				tiles[x] [y] = Utils.parseInt(tokens[(x+y*width+4)]);
			}
		}
		
		
		
		
		
				
	}
	

	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	
	public int getWidth() 
	{
		return width;
	}
	public int getHeight()
	{
		
		return height;
	}
}
