package inprogress;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class Editor1 implements ActionListener {
	
	
	private String fnamn = null;
	public String getFnamn() {
		return fnamn;
	}


	public void setFnamn(String fnamn) {
		this.fnamn = fnamn;
	}

	private JPanel p = new JPanel();
	private JTextField namn = new JTextField();
	private JButton oppna = new JButton("�ppna");
	private JButton spara = new JButton("Spara");
	private JButton nyFil = new JButton("Ny fil");
	private JTextArea area = new JTextArea(37,80);
	private JScrollPane sp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, p);
	
	 JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//	 JFileChooser jf = new JFileChooser()

	
		public JPanel makePanel4(String h) {
		JPanel panel = new JPanel();
		
			namn.addActionListener(this);
			oppna.addActionListener(this);
			spara.addActionListener(this);
			nyFil.addActionListener(this);
			
		
			area.setFont(new Font("Monospaced", Font.PLAIN, 12));
			p.setLayout(new GridLayout(1,3));
			p.add(nyFil);p.add(oppna); p.add(spara);
			
			panel.add(split);
			panel.setVisible(true);

			return panel;
		}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == oppna) {
			läsInFil(filValjare());
		} else if (e.getSource() == spara) {
			sparaFil(getFnamn());
		} else if (e.getSource() == nyFil ) {
			sparaFil(sparaNyFil());
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
	
	public String filValjare(){
		int returnValue = jfc.showOpenDialog(null);
      	
      	 if(returnValue == JFileChooser.APPROVE_OPTION) {
      		 File selectedFile = jfc.getSelectedFile();
      		 setFnamn(selectedFile.getAbsolutePath());
      		return selectedFile.getAbsolutePath();
      	 } else {
      		 return null;
      	 }
      	 
	}
	
	
	public String sparaNyFil() {
		int returnValue = jfc.showSaveDialog(null);
      	
     	 if(returnValue == JFileChooser.APPROVE_OPTION) {
     		 File selectedFile = jfc.getSelectedFile();
     		 setFnamn(selectedFile.getAbsolutePath());
     		return selectedFile.getAbsolutePath();
     	 } else {
     		 return null;
     	 }
	}
	
}
	

