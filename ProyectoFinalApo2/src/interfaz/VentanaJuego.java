package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import hilos.HiloCarretera;

public class VentanaJuego extends JFrame{
	
	private VentanaSeleccion ventanaSeleccion;
	private PanelCarreteraJuego panelCarreteraJuego;
	private PanelInformacionJuego paneInformacionJuego;
	private HiloCarretera hiloCarretera;
	
	public VentanaJuego(VentanaSeleccion v) {
		
		ventanaSeleccion=v;
		hiloCarretera=new HiloCarretera(this,ventanaSeleccion.darPrincipal().darModeloJuego());
		
		
		this.setSize(750,550);
		this.setTitle("Juego");
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		panelCarreteraJuego = new PanelCarreteraJuego(this);
		paneInformacionJuego = new PanelInformacionJuego();
		this.add(paneInformacionJuego, BorderLayout.EAST);
		this.add(panelCarreteraJuego,BorderLayout.CENTER);
		
		hiloCarretera.start();
		
		
	}
	public void refrescar() {
		panelCarreteraJuego.repaint();
		
	}
	public VentanaSeleccion darVentanaSeleccion() {
		return ventanaSeleccion;
	}

	public PanelCarreteraJuego darPanelCarreteraJuego() {
		return panelCarreteraJuego;
	}

	public PanelInformacionJuego darPaneInformacionJuego() {
		return paneInformacionJuego;
	}
	
}
