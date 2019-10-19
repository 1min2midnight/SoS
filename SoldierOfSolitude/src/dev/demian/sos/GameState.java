package dev.demian.sos;

import java.awt.Graphics;

public class GameState extends State {
	
	
	private World world;
	
	
	//constructor
	public GameState(Handler handler)
	{
		super(handler);
		
		world = new World(handler,"res/worlds/world1.txt");
		
		handler.setWorld(world);
		
		
		
	}

	//keeps makes sure everything is synced up
	@Override
	public void tick() {
		
		world.tick();
		
		
		
	}

	//renders graphics to the screen
	@Override
	public void render(Graphics g) {
		
		world.render(g);
		
		
		//Tile.tiles[0].render(g, 0, 0);;
		
	}

	
}
