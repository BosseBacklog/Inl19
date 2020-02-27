package inl�mning19;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface Forsta {
	JPanel panel = new JPanel();
	JLabel bild1 = new JLabel(new ImageIcon("jag2.jpg"));
	JLabel bild2 = new JLabel(new ImageIcon("l�fbergs.jpg"));
	JLabel text = new JLabel("Programmet skapat av A. Ivansson");
	
	public default Component getForsta() {
		panel.setLayout(new BorderLayout());
		panel.add(bild1, BorderLayout.CENTER);
		panel.add(bild2, BorderLayout.NORTH);
		panel.add(text, BorderLayout.SOUTH);
		
		return panel;
	}
}
