package dev.demian.sos;

//launches the game
public class Launcher {

	public static void main(String[] args) {
		
		Game game = new Game("title", 900,700);
		
		game.start();
	}

}
