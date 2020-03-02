package inprogress;

import java.awt.*;
import javax.swing.*;

public class KlockDemo extends JFrame{
	
	
		private DigitalKlocka k1 = new DigitalKlocka();
		private DigitalKlocka k2 = new DigitalKlocka("America/New_York");
		
	
	
	public KlockDemo() {
		JLabel l1 = new JLabel("Loal tid", JLabel.CENTER);
		JLabel l2 = new JLabel("New York", JLabel.CENTER);
		l1.setFont(new Font("Serif", Font.BOLD, 18));
		l2.setFont(new Font("Serif", Font.BOLD, 18));
		setLayout(new GridLayout(2,2,5,5));
		add(k1); add(k2); add(l1); add(l2);
		setSize(250, 125); setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		KlockDemo kd = new KlockDemo();
	}
}
