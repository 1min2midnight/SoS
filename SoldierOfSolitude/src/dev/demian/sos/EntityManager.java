package dev.demian.sos;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	
	//array list that holds entities
	private ArrayList<Entity> entities;
	public EntityManager(Handler handler, Player player) 
	{
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		
		//add entities here
		
		addEntity(player);
		
		if(handler.getKeyManager().enter)
		{
			addEntity( new Cobweb( handler,32*16,132));
		}
		
		
		
		
		
	}

	//if enter is pressed then let the cobwebs pop up anywhere
	//addEntity(new Cobweb( handler,32*16,132));
	
	public void tick()
	{
		for(int i =0; i<entities.size(); i++)
		{
			Entity e = entities.get(i);
			e.tick();
		}
		
	}
	//render
	public void render(Graphics g)
	{
		for(int i =0; i<entities.size(); i++)
		{
			Entity e = entities.get(i);
			e.render(g);
			
		}
	
		
		
	}
	//adds entity to the arraylist
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	
	//getters and setters
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	

}
