package dev.demian.sos;

public class GameCamera {
	
	private float xOffset;
	private float yOffset;

	private Handler handler;
	
	//constructor
	public GameCamera(Handler handler,float xOffset, float yOffset)
	{
		this.xOffset=xOffset;
		this.yOffset=yOffset;
		this.handler = handler;
		
	}
	
	//checks for blank space and if there is it stops moving
	public void checkBlankSpace()
	{
		if(xOffset<0)
		{
			xOffset=0;
		}
		else if(xOffset > handler.getWorld().getWidth()*Tile.TILE_WIDTH -handler.getWidth())
		{
			xOffset = handler.getWorld().getWidth()*Tile.TILE_WIDTH -handler.getWidth();
		}
			
		if(yOffset<0)
		{
			yOffset=0;
		}
		else if(yOffset > handler.getWorld().getHeight()*Tile.TILE_HEIGHT - handler.getHeight())
		{
			yOffset=handler.getWorld().getHeight()*Tile.TILE_HEIGHT - handler.getHeight();
		}
	}
	// centres camera on the entity
	public void centreOnEntity(Entity e)
	{
		xOffset = e.getX() - handler.getWidth() /2 + e.getWidth()/2;
		
		yOffset = e.getY() - handler.getHeight() /2 + e.getHeight()/2;
		
		checkBlankSpace();
	}
	//moves with the character
	public void move(float xAmount, float yAmount)
	{
		xOffset += xAmount;
		yOffset += yAmount;
		checkBlankSpace();
		
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
