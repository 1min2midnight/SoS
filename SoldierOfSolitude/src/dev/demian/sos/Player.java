package dev.demian.sos;

import java.awt.Color;
import java.awt.Graphics;
// defines all of the attributes of the player

public class Player extends Creature {

	//animations
	private Animation animIdle;
	private EntityManager entity;
	
	
	//constructor takes in the positions of the player along with the size
	public Player(Handler handler,float x, float y) {
		super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x =0;
		bounds.y =0;
		bounds.width =32;
		bounds.height=32;
		
		animIdle = new Animation(500, Assets.player_idle);
		entity = new EntityManager(handler,this);
		
	}
	//updates player
	@Override
	public void tick() {
		//animation
		animIdle.tick();
		//input
		getInput();
		move();
		handler.getGameCamera().centreOnEntity(this);
		
		
	}
	//gets users key presses and passes the coordinates to the move() method
	private void getInput()
	{
		xMove=0;
		yMove=0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		
		if(handler.getKeyManager().left)
			xMove = -speed;
		
		if(handler.getKeyManager().right)
			xMove = speed;
		
		if(handler.getKeyManager().enter)
		{
			entity.addEntity(new Cobweb( handler,32*16,132));
		}
	}
	// renders the player to the screen
	@Override
	public void render(Graphics g) {
		
		g.drawImage(animIdle.getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width,height, null);
		
	//	g.setColor(Color.red);
		//g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y- handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

}
