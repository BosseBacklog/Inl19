package inprogress;

import java.time.*;
import java.time.format.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;

public class DigitalKlocka extends JLabel implements ActionListener {

	private ZoneId z = ZoneId.systemDefault();
	private DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public DigitalKlocka() {
		setHorizontalAlignment(JLabel.CENTER);
//		setVerticalAlignment(JLabel.NORTH);
	
		setOpaque(true);
		setBackground(Color.white);
		setFont(new Font("SansSerif", Font.BOLD, 72));
		Timer tim = new Timer(1000, this);
		tim.start();
	}
	
	public DigitalKlocka(String zon) {
		this();
		z = ZoneId.of(zon);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setText(ZonedDateTime.now(z).format(f));
		
	}
	
	
}
