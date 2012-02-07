package game.pong.core;

import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable {

	private final int B_WIDTH = 10;
	private final int B_HEIGHT = 10;
	
	private int xPos;
	private int yPos;
	private int xDir;
	private int yDir;
	
	private Rectangle ball;
	
	private Paddle paddle;
	
	public Ball(int xPos, int yPos, Paddle p) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.paddle = p;
		
		int xMove, yMove;
		
		Random rand = new Random();
		
		xMove = rand.nextInt(1);
		
		if (xMove == 0)
			xMove--;
		
		setXDir(xMove);
		
		yMove = rand.nextInt(1);
		
		if (yMove == 0)
			yMove--;
		
		setYDir(yMove);
		
		ball = new Rectangle(this.xPos, this.yPos, B_WIDTH, B_HEIGHT);
	}
	
	public void move() {
		
		collision();
		this.xPos += this.xDir;
		this.yPos += this.yDir;
		updateBallRectangle(ball);
	}
	
	public void collision() {
				
		if (this.getXPos() <= 3) {
			this.setXDir(1);
		}
		if (this.getXPos() >= 630) {
			this.setXDir(-1);
		}
		
		if (this.getYPos() < 26) {
			this.setYDir(1);
		}
		if (this.getYPos() > 468) {
			this.setYDir(-1);
		}
		
		if (this.getBallRectangle().intersects(paddle.getPaddleRectangle())) {
			this.setXDir(1);
		}
		
		if (this.getBallRectangle().intersects(paddle.getPaddleRectangle())) {
			this.setXDir(-1);
		}
	}
	
	public void run() {
		try {
			while (true) {
				move();
				Thread.sleep(8);
			}
		}
		catch (Exception e) { System.err.print(e.getMessage()); }
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos += xPos;
		this.updateBallRectangle(ball);
		System.out.println(this.getXPos() + " " + this.getYPos());
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos += yPos;
		this.updateBallRectangle(ball);
	}

	public int getXDir() {
		return xDir;
	}

	public void setXDir(int xDir) {
		this.xDir = xDir;
	}

	public int getYDir() {
		return yDir;
	}

	public void setYDir(int yDir) {
		this.yDir = yDir;
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
	
	public void updateBallRectangle(Rectangle b) {
		b.x = this.getXPos();
		b.y = this.getYPos();
	}
}