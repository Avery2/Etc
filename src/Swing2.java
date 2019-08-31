import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Swing2 {

	private JFrame frame;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing2 window = new Swing2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing2() {
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
		
		textField1 = new JTextField();
		textField1.setBounds(154, 96, 130, 26);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		JLabel lbl1 = new JLabel("New label");
		lbl1.setBounds(190, 53, 61, 16);
		frame.getContentPane().add(lbl1);
		
		JButton btn1 = new JButton("Update");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setText(textField1.getText());
			}
		});
		btn1.setBounds(158, 148, 117, 29);
		frame.getContentPane().add(btn1);
	}
}
