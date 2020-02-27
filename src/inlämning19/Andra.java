package inlämning19;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public interface Andra  {
	Hej h = new Hej();
	List<JLabel> lirre = new ArrayList();

	JPanel p = new JPanel();
	JPanel o = new JPanel();
	JLabel l1 = new JLabel(new ImageIcon("dino.jpg"));
	JLabel l2 = new JLabel(new ImageIcon("dog.jpg"));
	JLabel l3 = new JLabel(new ImageIcon("code.jpg"));
	JLabel l4 = new JLabel(new ImageIcon("dino.jpg"));
	JScrollPane scroll = new JScrollPane(l1);	
	JButton b1 = new JButton("Nästa bild");
	JButton b2 = new JButton("Föregående bild");
	JLabel m = new JLabel("Bild nr " + h.bildnr);
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p, scroll);
	JSplitPane split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, o, split);
	

	public default Component getAndra() {
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

					if (h.raknare + 1 > lirre.size() - 1) {
						h.raknare = 0;
						h.bildnr = 1;
						m.setText("Bild nr " + h.bildnr);
						l1.setIcon(lirre.get(h.raknare).getIcon());
					} else {
						h.raknare++;
						h.bildnr++;
						m.setText("Bild nr " + h.bildnr);
						l1.setIcon(lirre.get(h.raknare).getIcon());
					}

				} 
			}
		});
		b2.setBorderPainted(false);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b2) {
					if (h.raknare - 1 < 0) {
						h.raknare = 2;
						h.bildnr = 3;
						m.setText("Bild nr " + h.bildnr);
						l1.setIcon(lirre.get(h.raknare).getIcon());
					} else {
						h.raknare--;
						h.bildnr--;
						m.setText("Bild nr " + h.bildnr);
						l1.setIcon(lirre.get(h.raknare).getIcon());
					}
				}
			}
		});

		return split2;
	}



	
}
