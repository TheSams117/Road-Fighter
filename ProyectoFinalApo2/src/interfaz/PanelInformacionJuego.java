package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelInformacionJuego extends JPanel {
	private int puntaje;
	public PanelInformacionJuego() {
		this.setPreferredSize(new Dimension(200,300));
		puntaje=0;
	}
	public void cambiarPuntaje(int pPuntaje) {
		puntaje=pPuntaje;
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("System",1,20));
		g.drawString("JUEGO:", 20, 50);
		g.setFont(new Font("System",0,18));
		g.drawString("-Z: acelerar", 20, 80);
		g.drawString("-Flechas: movimiento", 20, 110);
		
		g.setFont(new Font("System",1,20));
		g.drawString("OPCIONES:", 20, 160);
		g.setFont(new Font("System",0,18));
		g.drawString("-P: pausar", 20, 190);
		g.drawString("-G: guardar y salir", 20, 220);
		
		g.setFont(new Font("System",1,20));
		g.drawString("INFORMACIÓN:", 20, 270);
		g.setFont(new Font("System",0,18));
		g.drawString("-Puntaje: ", 20, 300);
		g.drawString(""+puntaje, 20, 330);
		
	}
	

}
