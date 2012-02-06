package game.pong.core;

import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable {

	private final int B_WIDTH = 10;
	private final int B_HEIGHT = 10;
	
	private int xPos;
	private int yPos;
	private int randomPos;
	
	private Rectangle ball;
	
	public Ball(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		
		ball = new Rectangle(this.xPos, this.yPos, B_WIDTH, B_HEIGHT);
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos += xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos += yPos;
	}

	public int getB_WIDTH() {
		return B_WIDTH;
	}

	public int getB_HEIGHT() {
		return B_HEIGHT;
	}

	public Rectangle getBallRectangle() {
		return ball;
	}
	
	public void move() {
		collision();
		
		int xMove, yMove;
		Random rand = new Random();
		
		xMove = rand.nextInt(1);
		yMove = rand.nextInt(1);
		
		if (xMove == 0)
			setXPos(-1);
		else
			setXPos(1);
		
		if (yMove == 0)
			setYPos(-1);
		else
			setYPos(1);
	}
	
	public void collision() {
		if (this.getXPos() < 100) {
			setXPos(0);
		}
	}
	
	public void run() {
		try {
			while (true) {
				move();
				Thread.sleep(5);
			}
		}
		catch (Exception e) { System.err.print(e.getMessage()); }
	}
	
}
