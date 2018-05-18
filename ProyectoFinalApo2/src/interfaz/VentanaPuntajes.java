package interfaz;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPuntajes extends JFrame{

	private PanelListaPuntajes listaPuntajes;
	private PanelBotonesPuntajes botonesPuntajes;
	
	private VentanaPrincipal principal;
	
	public VentanaPuntajes(VentanaPrincipal v) {
		principal=v;
		this.setSize(400,600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("Puntajes");
		listaPuntajes= new PanelListaPuntajes();
		botonesPuntajes=new PanelBotonesPuntajes(this);
		this.add(botonesPuntajes,BorderLayout.SOUTH);
		this.add(listaPuntajes, BorderLayout.NORTH);
		JPanel panelAux= new JPanel();
		panelAux.setBackground(Color.BLACK);
		this.add(panelAux,BorderLayout.CENTER);
		
		
		
	}

	public void volver() {
		this.setVisible(false);
		principal.setVisible(true);
		
	}
	
	
	
	
	
}

