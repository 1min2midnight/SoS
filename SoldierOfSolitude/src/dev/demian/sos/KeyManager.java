package dev.demian.sos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	
	private boolean[] keys;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean enter;
	
	
	
	
	public KeyManager()
	{
		keys = new boolean[256];
		
		
	}
	// checks for which key is pressed
	public void tick()
	{
		enter = keys[KeyEvent.VK_L];
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	
	//may allow user to type later on
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}

	@Override
	//if a key is pressed it will print key pressed
	public void keyPressed(KeyEvent e) 
	{
		
		keys[e.getKeyCode()] = true;
		System.out.println("key pressed");
	}

	//if will check once the key is released
	@Override
	public void keyReleased(KeyEvent e) 
	{
		
		
		keys[e.getKeyCode()] = false;
	}
	

		
}
