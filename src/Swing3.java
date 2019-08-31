import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Swing3 {

	private JFrame frame;
	static String foo = "X";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing3 window = new Swing3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		while (true) {
			System.out.println(foo);
			try {
	            Thread.sleep(200);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}

	// Constructor
	public Swing3() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Default");
		lbl1.setBounds(50, 225, 110, 16);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Default");
		lbl2.setBounds(233, 225, 130, 16);
		frame.getContentPane().add(lbl2);
		
		JRadioButton rdbtn1 = new JRadioButton("Option A");
		JRadioButton rdbtn2 = new JRadioButton("Option B");
		JRadioButton rdbtn3 = new JRadioButton("Option C");
		JRadioButton rdbtn4 = new JRadioButton("Option D");
		
		rdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setText("Option A");
				foo = "A";
				rdbtn2.setSelected(false);
				rdbtn3.setSelected(false);
				rdbtn4.setSelected(false);
			}
		});
		rdbtn1.setBounds(50, 58, 141, 23);
		frame.getContentPane().add(rdbtn1);
		
		rdbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setText("Option B");
				foo = "B";
				rdbtn1.setSelected(false);
				rdbtn3.setSelected(false);
				rdbtn4.setSelected(false);
			}
		});
		rdbtn2.setBounds(50, 93, 141, 23);
		frame.getContentPane().add(rdbtn2);
		
		rdbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setText("Option C");
				rdbtn1.setSelected(false);
				rdbtn2.setSelected(false);
				rdbtn4.setSelected(false);
			}
		});
		rdbtn3.setBounds(50, 128, 141, 23);
		frame.getContentPane().add(rdbtn3);
		
		rdbtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setText("Option D");
				rdbtn1.setSelected(false);
				rdbtn2.setSelected(false);
				rdbtn3.setSelected(false);
			}
		});
		rdbtn4.setBounds(50, 163, 141, 23);
		frame.getContentPane().add(rdbtn4);
		
		String[] stuff = {"Option A", "Option B", "Option C", "Option D", "Option E"};
		
		JComboBox comboBox1 = new JComboBox(stuff);
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl2.setText((String) comboBox1.getSelectedItem()); 
			}
		});
		comboBox1.setBounds(233, 58, 141, 27);
		frame.getContentPane().add(comboBox1);
	}
}
