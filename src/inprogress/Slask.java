package inprogress;

public class Slask {

//	private static JPanel makePanel3(String string) {
//	JPanel panel = new JPanel();
//	JPanel p = new JPanel();
//	JTextField namn = new JTextField();
//	JButton oppna = new JButton("Öppna");
//	JButton spara = new JButton("Spara");
//	JButton skriv = new JButton("Skriv ut");
//	JButton sluta = new JButton("Avsluta");
//	JTextArea area = new JTextArea(10,60);
//	
//	JScrollPane sp = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//	
//	
//		area.setFont(new Font("Monospaced", Font.PLAIN, 12));
//		p.setLayout(new GridLayout(1,6));
//		p.add(new JLabel("Filnamn: ", JLabel.RIGHT));
//		p.add(namn); p.add(oppna); p.add(spara);
//		p.add(skriv); p.add(sluta);
//		
////		namn.addActionListener(this);
////		oppna.addActionListener(this);
////		spara.addActionListener(this);
////		skriv.addActionListener(this);
////		sluta.addActionListener(this);
//		
////		placera ut panelen och textarean
//		panel.add(p, BorderLayout.NORTH);
//		panel.add(sp, BorderLayout.CENTER);
//		panel.setVisible(true);
//
//		oppna.addActionListener(e -> {{try{
//			FileReader r = new FileReader(namn.getText());
//			area.read(r, null);
//		}
//		catch(IOException e1) {
//			}
//		}});
//		
//		spara.addActionListener(e -> {{try{
//			FileWriter w =  new FileWriter(namn.getText());
//			area.write(w);
//		}
//		catch(IOException e1) {
//			}
//		}});
//		spara.addActionListener(e -> {{try{
//			FileWriter w =  new FileWriter(namn.getText());
//			area.write(w);
//		}
//		catch(IOException e1) {
//			}
//		}});
//		
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			if (e.getSource() == namn || e.getSource() == oppna) {
//				läsInFil(namn.getText());
//			} else if (e.getSource() == spara) {
//				sparaFil(namn.getText());
//			} else if (e.getSource() == skriv ) {
//				try {
//					area.print(); //Skriver ut texten
//				} catch (Exception ex) {
//					
//				} 
//			} else if (e.getSource() ==  sluta) {
//				System.exit(0);
//			}
//			
//		}		
//		
//		private void läsInFil(String filnamn) {
//			try {
//				FileReader r = new FileReader(filnamn);
//				area.read(r, null);
//			} catch (IOException e) {
//				
//			}
//		}
//		private void sparaFil(String filnamn) {
//			try {
//				FileWriter w =  new FileWriter(filnamn);
//				area.write(w);
//			} catch (IOException e) {
//				
//			}
//		}
//		
//
//		return panel;
//
//}
}
