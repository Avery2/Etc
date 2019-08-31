import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.event.KeyEvent;

class Oval {
	int x, y, width, height;
	
	Oval(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

class Rectangle {
	int x, y, width, height;
	
	Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

class Ball extends Driver {

	GameWindow g;
	private Oval ball;

	int ballWidth = 20;
	int ballHeight = 20;

	int xDir = -1;
	int yDir = 1;
	int currentSpeed;

	int x;
	int y;

	int bounceCounter;

	public Ball(int x, int y, GameWindow window) {
		this.x = x;
		this.y = y;
		ball = new Oval(x, y, ballWidth, ballHeight);
		ball.setBackground(Color.red);
		window.add(ball);
	}

	void move() {

		int ballX = ball.getX();
		int ballY = ball.getY();

		currentSpeed = getSpeed();

		ball.setLocation(ballX + xDir * currentSpeed, ballY + yDir * currentSpeed);

		if (ballX <= 0) {
			xDir = xDir * -1;

		} else if (ballY < 0) {
			yDir = yDir * -1;
		} else if (ballX >= 490) {
			xDir = xDir * -1;

		}

	}

	void checkBatHit(Bat b) {
		// TODO
	}

	public void getBounces() {
		// TODO
	}

	private int getSpeed() {
		currentSpeed = 4;
		return currentSpeed;
	}

	class Bat {
		GameWindow g;
		Rectangle bat;
		int batWidth = 100;
		int batHeight = 20;
		int x;
		int y;

		public Bat(int x, int y, GameWindow window) {
			this.x = x;
			this.y = y;
			bat = new Rectangle(x, y, batWidth, batHeight);
			bat.setBackground(Color.red);
			window.add(bat);
		}

		public int getWidth() {
			return batWidth;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		void move() {

		}

		public void setDirection(int dir) {

		}
	}

}

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements ActionListener, KeyListener {
	// Control constants.
	public final static int MOVE = 0;
	public final static int RIGHT = 1;
	public final static int LEFT = 2;
	public final static int STOP = 3;

	private Driver driver;
	private Timer timer;

	/**
	 * Creates game-play window.
	 *
	 * @param d Driver object to communicate with when keyboard and animation-timer actions occur.
	 */
	public GameWindow(Driver d) {
		super("Window");
		setLocation(0, 0);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addKeyListener(this);
		driver = d;
		timer = new Timer(5, this);
	}

	/**
	 * Starts the animating timer; changes the run/pause button to "Pause".
	 */
	public void startTimer() {
		timer.start();
	}

	/**
	 * Stops the animating timer; changes the run/pause button to "Run".
	 */
	public void stopTimer() {
		timer.stop();
	}

	/**
	 * Sets the background of the contained display-area.
	 */
	public void setBackground(java.awt.Color c) {
		getContentPane().setBackground(c);
	}

	/**
	 * @return The y-coordinate of the bottom of the window display area. NOTE: may be less than getHeight(), due to window insets.
	 */
	public int getBottomEdge() {
		return getHeight() - getInsets().bottom - getInsets().top;
	}

	/**
	 * Sets size of window display area.
	 *
	 * @param w Width of display area.
	 * @param h Height of display area.
	 */
	public void setSize(int w, int h) {
		super.setSize(w + getInsets().left + getInsets().right, h + getInsets().top + getInsets().bottom);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			driver.handleAction(MOVE);
		}
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();

		// 'J' == LEFT; 'K' == RIGHT
		if (key == KeyEvent.VK_J) {
			driver.handleAction(LEFT);
		} else if (key == KeyEvent.VK_K) {
			driver.handleAction(RIGHT);
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
		driver.handleAction(STOP);
	}

	@Override
	public void keyTyped(KeyEvent k) {
		// DOES NOTHING
	}
}

class Driver {
	private GameWindow window;
	private JLabel bounces, speed;
	private Bat blok;
	private Ball ball;

	/**
	 * post : Driver constructor run and game set-up performed
	 */
	public static void main(String[] args) {
		Driver d = new Driver();
		d.makeGame();
	}

	/**
	 * post: constructor sets up window and creates all needed objects
	 */
	private void makeGame() {
		// Create window with animating timer and keyboard input response.
		window = new GameWindow(this);
		window.setTitle("Bounce, bounce, bounce...");
		window.setLocation(50, 50);
		window.setSize(500, 500);
		window.setBackground(Color.white);

		// Add ball and bat to window.
		ball = new Ball(window.getWidth() / 2 - 10, window.getHeight() / 2 - 10, window);
		blok = new Bat(window.getWidth() / 2 - 50, window.getHeight() - 50, window);

		// add labels for speed and number of bounces
		// bounces = new JLabel( "Bounces: " + ball.getBounces() );
		// bounces.setBounds( 10, 10, 150, 20 );
		// window.add( bounces );
		// speed = new JLabel( "Speed: " + ball.getSpeed() );
		// speed.setBounds( 10, 30, 150, 20 );
		// window.add( speed );
		window.startTimer();
		window.repaint();
	}

	/**
	 * @param action : an integer describing the action taken post: the method corresponding to the appropriate action will be taken
	 */
	public void handleAction(int action) {
		if (action == GameWindow.MOVE) {
			ball.move();
			blok.move();
			ball.checkBatHit(blok);
			// bounces.setText( "Bounces: " + ball.getBounces() );
			// speed.setText( "Speed: " + ball.getSpeed() );
		} else {
			blok.setDirection(action);
		}
	}
}