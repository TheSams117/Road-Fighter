package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelInformacionJuego extends JPanel {
	public PanelInformacionJuego() {
		this.setPreferredSize(new Dimension(200,300));
		//this.setLayout(new BorderLayout());	
		this.setOpaque(true);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
	
	}
	
	public void paintComponent(Graphics g) {
		
	}
	

}
