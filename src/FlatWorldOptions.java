import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlatWorldOptions {

	private JFrame frame;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatWorldOptions window = new FlatWorldOptions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//		while (true) {
//			System.out.println(foo);
//			try {
//	            Thread.sleep(200);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		}
	}

	// Constructor
	public FlatWorldOptions() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
//		frame.setBounds(100, 100, 300, 200);
		frame.setBounds(720, 0, 350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Titles
		JLabel lb2dTitle = new JLabel("2D Graphics");
		lb2dTitle.setBounds(50, 25, 100, 20);
		frame.getContentPane().add(lb2dTitle);
		
		JLabel lbMapTitle = new JLabel("Mini Map");
		lbMapTitle.setBounds(150, 25, 100, 20);
		frame.getContentPane().add(lbMapTitle);
		
		JLabel lbOrientTitle = new JLabel("Orientation");
		lbOrientTitle.setBounds(250, 25, 100, 20);
		frame.getContentPane().add(lbOrientTitle);
		
		JRadioButton show2dT = new JRadioButton("True");
		JRadioButton show2dF = new JRadioButton("False");
		JRadioButton showMapT = new JRadioButton("True");
		JRadioButton showMapF = new JRadioButton("False");
		JRadioButton showOrientT = new JRadioButton("True");
		JRadioButton showOrientF = new JRadioButton("False");
		
		show2dT.setSelected(true);
		showMapT.setSelected(true);
		showOrientT.setSelected(true);
		
		// 2D Options
		show2dT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show2dF.setSelected(false);
			}
		});
		show2dT.setBounds(50, 75, 80, 20);
		frame.getContentPane().add(show2dT);
		
		show2dF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show2dT.setSelected(false);
			}
		});
		show2dF.setBounds(50, 125, 80, 20);
		frame.getContentPane().add(show2dF);
		
		// Map Options
		showMapT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMapF.setSelected(false);
			}
		});
		showMapT.setBounds(150, 75, 80, 20);
		frame.getContentPane().add(showMapT);
		
		showMapF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMapT.setSelected(false);
			}
		});
		showMapF.setBounds(150, 125, 80, 20);
		frame.getContentPane().add(showMapF);
		
		// Orientation Options
		showOrientT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOrientF.setSelected(false);
			}
		});
		showOrientT.setBounds(250, 75, 80, 20);
		frame.getContentPane().add(showOrientT);
		
		showOrientF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOrientT.setSelected(false);
			}
		});
		showOrientF.setBounds(250, 125, 80, 20);
		frame.getContentPane().add(showOrientF);
	}
}
