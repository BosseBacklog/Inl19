package inlämning19;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class Testinterface implements Forsta, Andra {

	
	public void runTestinterface()  {
		
		JFrame frame = new JFrame("Program");
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		Component tab1 = getForsta();
		Component tab2 = getAndra();
		
		frame.setSize(1000, 900);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1,1));
		
		tab1.setName("Start");
		tab2.setName("Fotoalbum");
//		tab3.setName("Search Contact");
		
		tabs.add(tab1);
		tabs.add(tab2);
//		tabs.add(tab3);
		
		frame.getContentPane().add(tabs);
		
	}


}
