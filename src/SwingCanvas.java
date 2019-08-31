import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
//import javax.swing.event.*; // Pretty sure this is listers and whatnot but I forger

class SwingCanvas extends Canvas {
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("Hi");
		Canvas canvas = new SwingCanvas();
		frame.add(canvas);
		canvas.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);

		frame.repaint();
	}

	public void paint(Graphics g) {
		g.fillRect(100, 100, 20, 10);
	}
}