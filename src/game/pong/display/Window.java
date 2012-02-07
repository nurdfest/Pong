package game.pong.display;

import game.pong.core.ArtificialIntel;
import game.pong.core.Ball;
import game.pong.core.Controls;
import game.pong.core.Paddle;
import game.pong.core.Pong;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JFrame;

/**
 * This Window class creates a JFrame window.
 * @author Nurdfest
 * @version Alpha 0.01 Built 02/05/2012
 */
public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// Sets the height and width of the window
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	/*
	 * Creates 2 Point objects. The Point objects hold the x and y coordinates
	 * for the starting position of the two paddles.
	 */
	private final Point p1start = new Point(20, 210);
	private final Point p2start = new Point(607, 210);
	
	private final Point centerOfWindow = new Point(320, 240);
	
	/*
	 * Creates and initializes two Paddle objects with the starting positions
	 * from the 2 Point objects that were just created.
	 */
	private Paddle p1 = new Paddle(p1start.x, p1start.y);
	private Paddle p2 = new Paddle(p2start.x, p2start.y);
	
	private Ball ball = new Ball(centerOfWindow.x, centerOfWindow.y, p1, p2);
	
	private ArtificialIntel ai = new ArtificialIntel(p2);
	
	/**
	 * Sole constructor. Initializes a new Window object.
	 */
	public Window() {
		
		setSize(WIDTH, HEIGHT);
		setTitle("Pong - v0.01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		/*
		 * Create and initialize a new Controls object. The Controls
		 * constructor takes a Paddle object as a parameter.
		 */
		Controls c = new Controls(p1);
		
		/*
		 * Add a Key Listener to this window.
		 */
		addKeyListener(c);
		
		Pong p = new Pong(ball, ai);
	}

	/* Creates an image of the current window based on the window's
	 * width and height.
	 * (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		
		// Needed for double buffer graphics
		Image dbImage = createImage(getWidth(), getHeight());
		Graphics dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	/** 
	 * Paints the paddles to the window based on their current x and y position
	 * @param A Graphics variable
	 */
	public void paintComponent(Graphics g) {
		super.paint(g);
		g.fillRect(p1.getXPos(), p1.getYPos(), p1.getPWidth(), p1.getPHeight());
		g.fillRect(p2.getXPos(), p2.getYPos(), p1.getPWidth(), p1.getPHeight());
		g.fillRect(ball.getXPos(), ball.getYPos(), ball.getB_WIDTH(), ball.getB_HEIGHT());
		repaint();
	}
	
	/**
	 * @return The value held by the HEIGHT variable for this object.
	 */
	public int getHeight() {
		return HEIGHT;
	}
	
	/**
	 * @return The value held by the WIDTH variable for this object.
	 */
	public int getWidth() {
		return WIDTH;
	}
}
