package inlämning19;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class BildVisare extends JFrame implements ActionListener {
	private List<JLabel> lirre = new ArrayList();

	private int raknare = 0;

	private JLabel l1 = new JLabel(new ImageIcon("dino.jpg"));
	private JLabel l2 = new JLabel(new ImageIcon("dog.jpg"));
	private JLabel l3 = new JLabel(new ImageIcon("code.jpg"));
	private JLabel l4 = new JLabel(new ImageIcon("dino.jpg"));

	private JScrollPane scroll = new JScrollPane(l1);
	private JPanel p = new JPanel();
	private JButton b1 = new JButton("Nästa");
	private JButton b2 = new JButton("Föregående");
	private JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p, scroll);

	public BildVisare() {
		add(split);
		scroll.setMinimumSize(new Dimension(100, 100));
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(b1);
		p.add(b2);
		b1.setBorderPainted(false);
		b1.addActionListener(this);
		b2.setBorderPainted(false);
		b2.addActionListener(this);
//		b3.setBorderPainted(false); b3.addActionListener(this);
		setSize(350, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lirre.add(l4);
		lirre.add(l2);
		lirre.add(l3);

	}



	public BildVisare(String a, String b, String c) {
		l2.setIcon(new ImageIcon(a));
		l3.setIcon(new ImageIcon(b));
		l4.setIcon(new ImageIcon(c));
		lirre.add(l4);
		lirre.add(l2);
		lirre.add(l3);
		p.add(b1);
		p.add(b2);
		setSize(350, 250);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

			if (raknare + 1 > lirre.size() - 1) {

			} else {
				raknare++;
				l1.setIcon(lirre.get(raknare).getIcon());
			}


		} else if (e.getSource() == b2) {
			if (raknare - 1 < 0) {

			} else {
				raknare--;
				l1.setIcon(lirre.get(raknare).getIcon());
			}
		}
	}



}
