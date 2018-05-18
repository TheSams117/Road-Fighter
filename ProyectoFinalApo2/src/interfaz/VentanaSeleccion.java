package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class VentanaSeleccion extends JFrame {

	
	private PanelCarros panelCarros;
	private PanelMapas panelMapas;
	private PanelBotonesAtras panelBotonesAtras;
	private VentanaPrincipal principal;
	
	public VentanaSeleccion(VentanaPrincipal v) {
		principal=v;
		this.setSize(750,550);
		this.setTitle("Nueva Partida");
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panelMapas= new PanelMapas(this);
		panelCarros= new PanelCarros(this);
		panelBotonesAtras= new PanelBotonesAtras(this);
		
		this.add(panelMapas,BorderLayout.NORTH);
		this.add(panelCarros, BorderLayout.CENTER);
		this.add(panelBotonesAtras, BorderLayout.SOUTH);
		
		
	}
	
	
	public PanelCarros darPanelCarros() {
		return panelCarros;
	}


	public PanelMapas darPanelMapas() {
		return panelMapas;
	}


	public PanelBotonesAtras darPanelBotonesAtras() {
		return panelBotonesAtras;
	}


	public VentanaPrincipal darPrincipal() {
		return principal;
	}


	public void atras() {
		this.setVisible(false);
		principal.setVisible(true);
		
	}
	
	public void siguiente() {
		VentanaJuego ventana= new VentanaJuego(this);
		ventana.setVisible(true);
		this.setVisible(false);
		
	}
	
	
	
	
	

	
	
	
	
}
