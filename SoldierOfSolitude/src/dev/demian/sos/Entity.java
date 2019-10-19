package dev.demian.sos;

import java.awt.Graphics;
import java.awt.Rectangle;
// Every object that is not a tile will inherit from this class but there will be no instances of this class


public abstract class Entity {

	
	protected Handler handler;
	protected float x;
	protected float y;
	
	protected Rectangle bounds;
	
	protected int width;
	protected int height;
	
	// all entities will need a position
	public Entity(Handler handler,float x, float y, int width, int height)
	{
		this.x = x;
		this.y =y;
		this.width= width;
		this.height=height;
		this.handler =handler;
		
		bounds = new Rectangle(0,0,width,height);
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset)
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset)))
			{
				return true;
			}
			
		}
		return false;
	}
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle((int) (x +bounds.x + xOffset), (int) ( y + bounds.y + yOffset),bounds.width,bounds.height);
	}
	
	// all entities will need to keep synced and to be able to render to the screen
	public abstract void tick();
	public abstract void render(Graphics g);
	
	//getters and setters for positions and sizes
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
