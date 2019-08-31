import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

public class Swing1 {

	private JFrame frame;
	private JFormattedTextField frmtdtxtfldTextHere;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Swing1 window = new Swing1();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.update();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//		while (true) {
////			Swing1 window = new Swing1();
//			window.update();
//			window.frame.setVisible(true);
//			try {
//				Thread.sleep(1500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
	}

	/**
	 * Create the application.
	 */
	
	public Swing1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frmtdtxtfldTextHere = new JFormattedTextField();
		frmtdtxtfldTextHere.setText("text here");
		frmtdtxtfldTextHere.setBounds(155, 150, 136, 26);
		frame.getContentPane().add(frmtdtxtfldTextHere);
		
		lblNewLabel = new JLabel(frmtdtxtfldTextHere.getText());
		lblNewLabel.setBounds(184, 109, 85, 29);
		frame.getContentPane().add(lblNewLabel);
	}
	
	private void update() {
		JLabel lblNewLabel = new JLabel(frmtdtxtfldTextHere.getText());
		System.out.println(frmtdtxtfldTextHere.getText());
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(frmtdtxtfldTextHere);
	}
}
