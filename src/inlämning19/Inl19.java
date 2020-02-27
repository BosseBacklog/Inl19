package inlämning19;

import java.awt.*;
import javax.swing.*;

public class Inl19 extends JFrame {
	
	private JButton b1 =  new JButton("1");
	private JButton b2 =  new JButton("2");
	private JButton b3 =  new JButton("3");
	private JButton b4 =  new JButton("4");
	
	private JTextArea a = new JTextArea("En arbetsyta");
	private JLabel bl = new JLabel(new ImageIcon("dino.jpg"));
	private JLabel bild1 = new JLabel(new ImageIcon("jag2.jpg"));
	private JLabel bild2 = new JLabel(new ImageIcon("löfbergs.jpg"));
	private JLabel text = new JLabel("Programmet skapat av A. Ivansson");
	
	public Inl19() {
		JTabbedPane tp = new JTabbedPane();
		add(tp);
//		Kort1
		JPanel kort1 = new JPanel();
		tp.addTab("Start", kort1);
		kort1.setLayout(new BorderLayout());
		kort1.add(bild1, BorderLayout.CENTER);
		kort1.add(bild2, BorderLayout.NORTH);
		kort1.add(text, BorderLayout.SOUTH);
		
//		kort1.add(b1); kort1.add(b2); kort1.add(b3); kort1.add(b4);
		
//		kort 2
		JScrollPane kort2 = new JScrollPane(a);
		tp.addTab("arbete", new ImageIcon(""), kort2);
		
//		kort 3
		JScrollPane kort3 = new JScrollPane(bl);
		tp.addTab("Blomma", null, kort3, "code.jpg");
		
		setSize(900, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		Inl19 i = new Inl19();
	}
	
	
}
