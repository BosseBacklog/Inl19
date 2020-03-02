package inprogress;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LjraH extends JFrame {
	private static int raknare = 0;
	private static int bildnr = 1;

	private static JLabel l2 = new JLabel(new ImageIcon("bilderoo.jpg"));

	private static void createAndShowGUI() {

		// Create and set up the window.
		final JFrame frame = new JFrame("Nytt Fönster");

		// Display the window.
		frame.setSize(800, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set grid layout for the frame
//	    	frame.getContentPane().setLayout(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		Editor ed0 = new Editor();
		Editor1 ed1 = new Editor1();
		Editor2 ed2 = new Editor2();
		Klocka k = new Klocka();
//		ImageIcon i = new ImageIcon("Clock.jpg");
		tabbedPane.addTab("Start", makePanel1("Tab 1"));
		tabbedPane.addTab("Fotoalbum", makePanel2("Tab 2"));
		tabbedPane.addTab("Editor", ed0.makePanel3("Tab 3"));
	    tabbedPane.addTab("Editor1", ed1.makePanel4("Tab 4"));
	    tabbedPane.addTab("Editor2", ed2.makePanel5("Tab 5"));
	    tabbedPane.addTab("Klocka", k.Clock("Tab 6"));
//	    	 

		frame.getContentPane().add(tabbedPane);

	}

	private static JPanel makePanel1(String text) {
		JPanel panel = new JPanel();
		JLabel bild1 = new JLabel(new ImageIcon("jag2.jpg"));
		JLabel bild2 = new JLabel(new ImageIcon("löfbergs.jpg"));
		JLabel text2 = new JLabel("Programmet skapat av A. Ivansson");

		panel.setLayout(new BorderLayout());
		panel.add(bild1, BorderLayout.CENTER);
		panel.add(bild2, BorderLayout.NORTH);
		panel.add(text2, BorderLayout.SOUTH);

		return panel;
	}

	private static JSplitPane makePanel2(String text) {
		List<JLabel> lirre = new ArrayList();

		JPanel p = new JPanel();
		JPanel o = new JPanel();
		JLabel l1 = new JLabel(new ImageIcon("dino.jpg"));
		JLabel l2 = new JLabel(new ImageIcon("dog.jpg"));
		JLabel l3 = new JLabel(new ImageIcon("code.jpg"));
		JLabel l4 = new JLabel(new ImageIcon("dino.jpg"));
		JScrollPane scroll = new JScrollPane(l1);
		JButton b1 = new JButton("Nästa bild");
		JButton b2 = new JButton("Föregåendeende bild");
		JLabel m = new JLabel("Bild nr " + bildnr);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p, scroll);
		JSplitPane split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, o, split);

		scroll.setMinimumSize(new Dimension(100, 100));
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(b1);
		p.add(b2);
		o.add(m);
		lirre.add(l4);
		lirre.add(l2);
		lirre.add(l3);
		b1.setBorderPainted(false);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b1) {

					if (raknare + 1 > lirre.size() - 1) {
						raknare = 0;
						bildnr = 1;
						m.setText("Bild nr " + bildnr);
						l1.setIcon(lirre.get(raknare).getIcon());
					} else {
						raknare++;
						bildnr++;
						m.setText("Bild nr " + bildnr);
						l1.setIcon(lirre.get(raknare).getIcon());
					}

				}
			}
		});
		b2.setBorderPainted(false);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b2) {
					if (raknare - 1 < 0) {
						raknare = 2;
						bildnr = 3;
						m.setText("Bild nr " + bildnr);
						l1.setIcon(lirre.get(raknare).getIcon());
					} else {
						raknare--;
						bildnr--;
						m.setText("Bild nr " + bildnr);
						l1.setIcon(lirre.get(raknare).getIcon());
					}
				}
			}
		});

		return split2;
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				createAndShowGUI();

			}

		});

	}

}
