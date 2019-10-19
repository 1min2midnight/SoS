package dev.demian.sos;

import java.awt.Graphics;

public class Cobweb extends StaticEntity {

	//constructor
	public Cobweb(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		
	}
	//tick

	@Override
	public void tick() {
		
		
	}
	
	//render

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.web,(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),null);
	}
	
	

}
