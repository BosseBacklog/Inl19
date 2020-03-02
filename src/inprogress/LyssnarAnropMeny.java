package inprogress;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class LyssnarAnropMeny {

    public static void main(String[] args) {
   	 JFrame frame = new JFrame("Menyexempel1");
   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 JMenuBar menuBar = new JMenuBar();
   	 
   	 JMenu fileMenu = new JMenu("Arkiv");
   	 menuBar.add(fileMenu);
   	 
   	 JMenu editMenu = new JMenu("Redigera");
   	 menuBar.add(editMenu);
   	 
   	 JMenuItem newMenuItem = new JMenuItem("Ny");
   	 newMenuItem.addActionListener(new Lyssnare());
   	 fileMenu.add(newMenuItem);
   	 
   	 JMenuItem saveMenuItem = new JMenuItem("Spara");
   	 saveMenuItem.addActionListener(new Lyssnare());
   	 fileMenu.add(saveMenuItem);
   	 
   	 JMenuItem exitMenuItem = new JMenuItem("Avsluta");
//   	 2.
   	 exitMenuItem.addActionListener(new Lyssnare());
   	 fileMenu.add(exitMenuItem);
   	 
   	 frame.setJMenuBar(menuBar);
   	 frame.setSize(350, 250);
   	 frame.setVisible(true);
   	 
    }
    
    
}


// 1.
class Lyssnare implements ActionListener {

    @Override
//    3.
    public void actionPerformed(ActionEvent e) {
//   	 System.out.println(e.getActionCommand());
   	 
   	 if(e.getActionCommand() == "Ny") {
   		 JOptionPane.showMessageDialog(null, "Du tryckte på " + e.getActionCommand());
   	 } else if (e.getActionCommand() == "Spara") {
//   		 System.out.println("Du tryckte på spara" + e.getActionCommand());
   		 JOptionPane.showMessageDialog(null, "Du tryckte på " + e.getActionCommand());
   	 } else {
   			 
   	 System.exit(0);
   	 }
   	 
    }
    
}

