package game.pong.core;

import java.util.Random;

public class ArtificialIntel implements Runnable {
	
	private Paddle p2;
	
	private boolean resting = false;
	private boolean needToMove = true;
	
	public ArtificialIntel(Paddle p) {
		this.p2 = p;
		//r = p.getPaddleRectangle();
	}

	// Choose random direction
	public int chooseRandomDirection() {
		Random rand = new Random();
		int[] randDirections = new int[3];
		
		randDirections[0] = 0;
		randDirections[1] = 1;
		randDirections[2] = -1;
		
		int randChoice = rand.nextInt(3);
		return randDirections[randChoice];
	}
	
	// Move to that position
	public void move(int m) {
		p2.setYPos(m);
	}
	
	@Override
	public void run() {
		int moveDirection = 0;
		
		try {
			while (true) {
				if (!resting) {
					
					if (needToMove) {
						moveDirection = chooseRandomDirection();
						move(moveDirection);
						needToMove = false;
					}
					
					long start = System.currentTimeMillis();
					long end = start + 1*1000;
					
					while (System.currentTimeMillis() < end) {
						move(moveDirection);
						Thread.sleep(10);
					}
					
					resting = true;
				}
				else {
					Thread.sleep(3000);
					needToMove = true;
					resting = false;
				}
			}
		} catch (Exception e) { System.err.println(e.getMessage());	}
	}
}
