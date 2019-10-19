package dev.demian.sos;

import java.awt.Graphics;

public abstract class State {
	
	protected Game game;
	protected Handler handler;
	
	private static State currentState = null;
	
	public State(Handler handler) 
	{
		this.handler = handler;
		
	}
	
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
	
		return currentState;
	}
	
	//class
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
