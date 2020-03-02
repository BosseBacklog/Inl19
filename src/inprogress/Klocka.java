package inprogress;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;


public class Klocka implements ActionListener {
	private DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
//	private Timer tim = new Timer(1000, this);
	private JLabel bild1 = new JLabel(new ImageIcon("Clock.jpg"));
	
	private DigitalKlocka k1 = new DigitalKlocka(); 

//	public JPanel Demo() {
//		JLabel l1 = new JLabel("mjau", JLabel.CENTER);
//		return l1;
//	}
	

//	Bilden b = new Bilden();
//	ImagePanel panel = new ImagePanel(
//	        new ImageIcon("Clock.jpg").getImage());
	
	public JPanel Clock(String string) {
	
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
//		panel2.add(k1);
//		JFrame frame = new JFrame();
//		frame.setContentPane(panel);
//		Klocka k = new Klocka();
//		panel.setLayout(new BorderLayout());
//		Timer tim = new Timer(1000, this);
//		tim.start();
	
//		panel.add(panel2, BorderLayout.CENTER);
		JPanel backgroundPanel = new JPanel();
//		panel.setLayout(new BorderLayout());
//		panel.add(bild1, BorderLayout.EAST);
		panel.add(bild1);
//		panel2.add(k1);
	
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		
		backgroundPanel.add(panel);
		backgroundPanel.add(k1);
		
		

//		backgroundPanel.add(/* your panel with controls */);
//		backgroundPanel.add(/* image component */);


		return backgroundPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
	
}

