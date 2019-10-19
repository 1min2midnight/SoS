package dev.demian.sos;

public class DoorTile extends Tile {
	
	public DoorTile(int id)
	{
		super(Assets.door,id);
	}
	@Override
	
	//returns true or false  based on whether the player should collide with it or not
	public boolean isSolid()
	{
		return false;
	}

}
