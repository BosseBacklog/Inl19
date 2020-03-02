package inprogress;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class Editor2 implements ActionListener {

	
	private String fnamn = null;
	public String getFnamn() {
		return fnamn;
	}


	public void setFnamn(String fnamn) {
		this.fnamn = fnamn;
	}

	private JPanel p = new JPanel();
	private JTextField namn = new JTextField();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("Arkiv");
	private JTextArea area = new JTextArea(30,80);
	private JScrollPane sp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, p, sp);
	private JMenuItem oppna = new JMenuItem("Öppna");
	private JMenuItem spara = new JMenuItem("Spara");
	private JMenuItem nyFil = new JMenuItem("Ny");
	
	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


		public JPanel makePanel5(String h) {
		JPanel panel = new JPanel();
			p.setLayout(new GridLayout(1,3));

			 
//		   	 nyFil.addActionListener(new Lyssnare());
		   	 fileMenu.add(nyFil);
		   	 
		   	
//		   	 spara.addActionListener(new Lyssnare());
		   	 fileMenu.add(spara);
		   	 
		  
		   	 fileMenu.add(oppna);
				oppna.addActionListener(this);
				spara.addActionListener(this);
				nyFil.addActionListener(this);
			
			
			p.add(menuBar);
			menuBar.add(fileMenu);
			menuBar.setVisible(true);
			area.setFont(new Font("Monospaced", Font.PLAIN, 12));
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
		} catch(NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Du måste spara filen som ny fil först");
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
