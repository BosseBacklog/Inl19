package inprogress;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class Editor implements ActionListener {
	
	
	private String fnamn = "";
	public String getFnamn() {
		return fnamn;
	}


	public void setFnamn(String fnamn) {
		this.fnamn = fnamn;
	}

	private JPanel p = new JPanel();
	private JTextField namn = new JTextField();
	private JButton oppna = new JButton("Öppna");
	private JButton spara = new JButton("Spara");
	private JButton skriv = new JButton("Skriv ut");
	private JTextArea area = new JTextArea(10,60);
	
	private JScrollPane sp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	 JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


	
		public JPanel makePanel3(String h) {
		JPanel panel = new JPanel();
		
			namn.addActionListener(this);
			oppna.addActionListener(this);
			spara.addActionListener(this);
			skriv.addActionListener(this);
			
		
			area.setFont(new Font("Monospaced", Font.PLAIN, 12));
			p.setLayout(new GridLayout(1,6));
			p.add(new JLabel("Filsökväg: ", JLabel.RIGHT));
			p.add(namn); p.add(oppna); p.add(spara);
			p.add(skriv);
			
//			placera ut panelen och textarean
			panel.add(p, BorderLayout.NORTH);
			panel.add(sp, BorderLayout.CENTER);
			panel.setVisible(true);

			return panel;
		}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == namn || e.getSource() == oppna) {
			läsInFil(Fajlchoser());
		} else if (e.getSource() == spara) {
			sparaFil(namn.getText());
		} else if (e.getSource() == skriv ) {
			try {
				area.print(); //Skriver ut texten
			} catch (Exception ex) {
				
			} 
		}
		
	}		
	
	private void läsInFil(String filnamn) {
		try {
			FileReader r = new FileReader(filnamn);
			area.read(r, null);
			
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Ingen fil valdes");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void sparaFil(String filnamn) {
		try {
			FileWriter w =  new FileWriter(filnamn);
			area.write(w);
		} catch (IOException e) {
			
		}
	}
	
	public String Fajlchoser(){
		int returnValue = jfc.showOpenDialog(null);
      	
      	 if(returnValue == JFileChooser.APPROVE_OPTION) {
      		 File selectedFile = jfc.getSelectedFile();
      		 setFnamn(selectedFile.getAbsolutePath());
      		 namn.setText(selectedFile.getAbsolutePath());
      		return selectedFile.getAbsolutePath();
      	 } else {
      		 return null;
      	 }
      	 
	}
	
}
