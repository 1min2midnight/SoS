package dev.demian.sos;

public class WallTile extends Tile {
	
	//
	public WallTile(int id)
	{
		super(Assets.wall,id);
		
		
	}
	//overrides Tile's isSolid() Method
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
