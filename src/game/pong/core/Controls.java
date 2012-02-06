package game.pong.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The controls for the Pong game
 * @author Nurdfest
 * @version Alpha 0.01 Built 02/05/2012
 */
public class Controls implements KeyListener {

	// This Paddle object will be controlled by the user
	private Paddle p;
	
	private final int MIN_YPOS = 20;
	private final int MAX_YPOS = 400;
	
	/**
	 * Sole constructor.
	 * @param p The Paddle object to be affected by key presses.
	 */
	public Controls(Paddle p) {
		this.p = p;
	}
	
	/* The 'w' key moves the paddle up and the 's' key moves the paddle down.
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keyCode == KeyEvent.VK_W) {
			if (p.getYPos() <= MIN_YPOS)
				p.setYPos(0);
			else
				p.setYPos(-5);
		}
		
		if (keyCode == KeyEvent.VK_S) {
			if (p.getYPos() >= MAX_YPOS)
				p.setYPos(0);
			else
				p.setYPos(5);
		}
	}

	/* Does nothing currently. Only implemented because it is required
	 * if you implement the KeyListener class.
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
	}

	/* Does nothing currently. Only implemented because it is required
	 * if you implement the KeyListener class.
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent arg0) {
	}
}
