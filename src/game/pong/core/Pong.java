package game.pong.core;

import game.pong.display.Window;

/**
 * @author Nurdfest
 * @version Alpha 0.01 Built 02/05/2012
 */
public class Pong {
	
	private static Ball b;
	private static ArtificialIntel ai;
	
	public Pong(Ball b, ArtificialIntel ai) {
		Pong.b = b;
		Pong.ai = ai;
	}
	
	/**
	 * Main method creates a new Window object which
	 * begins the Pong game.
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		new Window();
		Thread t1 = new Thread(b);
		Thread t2 = new Thread(ai);
		
		t1.start();
		t2.start();
	}
}
