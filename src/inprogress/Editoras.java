package inprogress;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Editoras extends JFrame implements ActionListener {

	private JPanel p = new JPanel();
	private JTextField namn = new JTextField();
	private JButton oppna = new JButton("�ppna");
	private JButton spara = new JButton("Spara");
	private JButton skriv = new JButton("Skriv ut");
	private JButton sluta = new JButton("Avsluta");
	private JTextArea area = new JTextArea(10, 60);

	private JScrollPane sp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	public Editoras() {
		area.setFont(new Font("Monospaced", Font.PLAIN, 12));
		p.setLayout(new GridLayout(1, 6));
		p.add(new JLabel("Filnamn: ", JLabel.RIGHT));
		p.add(namn);
		p.add(oppna);
		p.add(spara);
		p.add(skriv);
		p.add(sluta);

		namn.addActionListener(this);
		oppna.addActionListener(this);
		spara.addActionListener(this);
		skriv.addActionListener(this);
		sluta.addActionListener(this);

//		placera ut panelen och textarean
		add(p, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == namn || e.getSource() == oppna) {
			läsInFil(namn.getText());
		} else if (e.getSource() == spara) {
			sparaFil(namn.getText());
		} else if (e.getSource() == skriv) {
			try {
				area.print(); // Skriver ut texten
			} catch (Exception ex) {

			}
		} else if (e.getSource() == sluta) {
			System.exit(0);
		}

	}

	private void läsInFil(String filnamn) {
		try {
			FileReader r = new FileReader(filnamn);
			area.read(r, null);
		} catch (IOException e) {

		}
	}

	private void sparaFil(String filnamn) {
		try {
			FileWriter w = new FileWriter(filnamn);
			area.write(w);
		} catch (IOException e) {

		}
	}

	public static void main(String[] args) {
		Editoras e = new Editoras();
	}

}
