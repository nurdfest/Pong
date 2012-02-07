package game.pong.core;

import java.awt.Rectangle;

/**
 * This class represents a paddle in the game of Pong
 * @author Nurdfest
 * @version Alpha 0.01 Built 02/05/2012
 *
 */
public class Paddle {
	
	// Creates and initialized the values for the paddle's height and width
	private final int P_WIDTH = 13;
	private final int P_HEIGHT = 80;
	
	// The current x and y position for a paddle
	private int xPos;
	private int yPos;
	
	// The rectangle drawn to the screen that represents a paddle.
	@SuppressWarnings("unused")
	private Rectangle paddle;
	
	
	/**
	 * Sole constructor. Initializes a new Paddle object.
	 */
	public Paddle(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		paddle = new Rectangle(xPos, yPos, P_WIDTH, P_HEIGHT);
	}
	
	public Rectangle getPaddleRectangle() {
		return paddle;
	}
	
	public void updateRectangle(Rectangle p) {
		p.x = this.getXPos();
		p.y = this.getYPos();
	}
	
	/**
	 * Gets the width of a paddle.
	 * @return The width of the paddle.
	 */
	public int getPWidth() {
		return P_WIDTH;
	}
	/**
	 * Gets the height of a paddle.
	 * @return The width of a paddle.
	 */
	public int getPHeight() {
		return P_HEIGHT;
	}

	/**
	 * Gets the x position of a paddle.
	 * @return The x position of a paddle.
	 */
	public int getXPos() {
		return xPos;
	}

	/**
	 * Sets the x position of a paddle.
	 * @param xPos The new x position of a paddle.
	 */
	public void setXPos(int xPos) {
		this.xPos += xPos;
	}

	/**
	 * Gets the y position of a paddle.
	 * @return The y position of a paddle.
	 */
	public int getYPos() {
		return yPos;
	}

	/**
	 * Increments the y position by the amount passed as a parameter.
	 * @param yPos How much to increment or decrement the y position.
	 */
	public void setYPos(int yPos) {
		this.yPos += yPos;
		this.updateRectangle(paddle);
	}
}
