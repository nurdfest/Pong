package game.pong.core;

import game.pong.display.Window;

/**
 * @author Nurdfest
 * @version Alpha 0.01 Built 02/05/2012
 */
public class Pong {
	
	private static Ball b;
	
	public Pong(Ball b) {
		this.b = b;
	}
	
	/**
	 * Main method creates a new Window object which
	 * begins the Pong game.
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Window w = new Window();
		Thread t1 = new Thread(b);
		t1.start();
	}
}
