package dev.demian.sos;

public class GrassTile extends Tile{
	
	public GrassTile(int id)
	{
		super(Assets.floor,id);
		
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}

}
